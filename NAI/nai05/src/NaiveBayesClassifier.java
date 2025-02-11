import java.io.*;
import java.util.*;

public class NaiveBayesClassifier {

    public static void main(String[] args) {
        List<Iris> trainingData = readIrisData("iris_training.txt");
        List<Iris> testData = readIrisData("iris_test.txt");

        Map<String, List<Iris>> speciesMap = createSpeciesMap(trainingData);

        System.out.println("Dokładność: " + computeAccuracy(testData, speciesMap) + "%");

        printConfusionMatrix(testData, speciesMap);

        manualInput(speciesMap);
    }
    public static void manualInput(Map<String, List<Iris>> speciesMap){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj wektor atrybutów lub wpisz 'exit' aby zakończyć:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            String classifiedSpecies = classify(new Iris(input.split(" ")).arr, speciesMap);
            System.out.println("Klasyfikacja: " + classifiedSpecies);
        }
    }
    private static List<Iris> readIrisData(String name) {
        List<Iris> irisData = new ArrayList<>();
        try (Scanner s = new Scanner(new File(name))) {
            while (s.hasNext()) {
                irisData.add(new Iris(s.nextLine().split("\t")));
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return irisData;
    }

    private static Map<String, List<Iris>> createSpeciesMap(List<Iris> irisData) {
        Map<String, List<Iris>> speciesMap = new HashMap<>();
        for (Iris iris : irisData) {
            speciesMap.computeIfAbsent(iris.name, k -> new ArrayList<>()).add(iris);
        }
        return speciesMap;
    }

    private static double computeAccuracy(List<Iris> testData, Map<String, List<Iris>> speciesMap) {
        int correctCount = 0;
        for (Iris iris : testData) {
            String trueSpecies = iris.name;
            String classifiedSpecies = classify(iris.arr, speciesMap);
            if (trueSpecies.equals(classifiedSpecies)) {
                correctCount++;
            }
        }
        return (double) correctCount / testData.size() * 100;
    }

    private static void printConfusionMatrix(List<Iris> testData, Map<String, List<Iris>> speciesMap) {
        Map<String, Map<String, Integer>> confusionMatrix = new HashMap<>();
        for (Iris iris : testData) {
            String trueSpecies = iris.name;
            String classifiedSpecies = classify(iris.arr, speciesMap);

            confusionMatrix.putIfAbsent(trueSpecies, new HashMap<>());
            confusionMatrix.get(trueSpecies).put(classifiedSpecies, confusionMatrix.get(trueSpecies).getOrDefault(classifiedSpecies, 0) + 1);
        }

        System.out.println("Macierz omyłek:");
        for (String trueSpecies : confusionMatrix.keySet()) {
            System.out.print(trueSpecies + ": ");
            for (String classifiedSpecies : confusionMatrix.get(trueSpecies).keySet()) {
                System.out.print(classifiedSpecies + " - " + confusionMatrix.get(trueSpecies).get(classifiedSpecies) + ", ");
            }
            System.out.println();
        }
    }

    private static String classify(double[] attributes, Map<String, List<Iris>> speciesMap) {
        double maxProbability = Double.NEGATIVE_INFINITY;
        String bestSpecies = null;
        for (String species : speciesMap.keySet()) {
            double probability = computeProbability(attributes, species, speciesMap);
            if (probability > maxProbability) {
                maxProbability = probability;
                bestSpecies = species;
            }
        }

        return bestSpecies;
    }

    private static double computeProbability(double[] attributes, String species, Map<String, List<Iris>> speciesMap) {
        double probability = Math.log((double) speciesMap.get(species).size() / speciesMap.values().stream().mapToInt(List::size).sum());
        List<Iris> speciesData = speciesMap.get(species);
        for (int i = 0; i < attributes.length; i++) {
            int finalI = i;
            double mean = speciesData.stream().mapToDouble(iris -> iris.arr[finalI]).average().orElse(0);
            double stddev = Math.sqrt(speciesData.stream().mapToDouble(iris -> Math.pow(iris.arr[finalI] - mean, 2)).average().orElse(0));

            probability += Math.log((1 / (stddev * Math.sqrt(2 * Math.PI))) * Math.exp(-Math.pow(attributes[i] - mean, 2) / (2 * Math.pow(stddev, 2))));
        }

        return probability;
    }
}
