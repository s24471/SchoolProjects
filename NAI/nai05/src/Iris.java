public class Iris {
    double[] arr;
    String name;

    public Iris(String[] s) {
        arr = new double[s.length-1];
        for (int i = 0; i < s.length - 1; i++) {
            arr[i] = Double.parseDouble(s[i].replace(',', '.').strip());
        }
        name = s[s.length - 1].strip();
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        for (Double d : arr) {
            ans.append(d.toString()).append("\t");
        }
        ans.append(name);
        return ans.toString();
    }
}