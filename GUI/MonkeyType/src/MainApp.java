import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp extends Application {
    int index;
    Napis napis;
    TextFlow textFlow;
    private ComboBox<String> languageComboBox;
    private ComboBox<Integer> timeComboBox;
    private List<String> wordList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        index = 0;
        primaryStage.setTitle("Monkeytype App");

        BorderPane root = new BorderPane();

        // Górny panel - Menu
        MenuBar menuBar = new MenuBar();

        // Menu - Opcje
        Menu optionsMenu = new Menu("Opcje");

        // Podmenu - Wybór języka
        Menu languageMenu = new Menu("Wybór języka");
        languageComboBox = new ComboBox<>();
        MenuItem languageMenuItem = new MenuItem();
        languageMenuItem.setGraphic(languageComboBox);

        MenuItem refreshLanguagesItem = new MenuItem("Odśwież");
        refreshLanguagesItem.setOnAction(e -> refreshLanguages());

        languageMenu.getItems().addAll(languageMenuItem, refreshLanguagesItem);

        // Podmenu - Wybór czasu testu
        Menu timeMenu = new Menu("Wybór czasu testu");
        timeComboBox = new ComboBox<>(FXCollections.observableArrayList(15, 20, 45, 60, 90, 120, 300));
        MenuItem timeMenuItem = new MenuItem();
        timeMenuItem.setGraphic(timeComboBox);

        timeMenu.getItems().addAll(timeMenuItem);

        optionsMenu.getItems().addAll(languageMenu, timeMenu);
        menuBar.getMenus().add(optionsMenu);

        // Środkowy panel - Gra

        textFlow = new TextFlow();
        textFlow.setPadding(new Insets(10));
        textFlow.setStyle("-fx-background-color: white;");
        VBox centerBox = new VBox(10, textFlow);
        centerBox.setPadding(new Insets(20));
        centerBox.setPrefWidth(800);

        // Dolny panel - Stopka
        Label shortcutLabel = new Label("Skróty klawiszowe: Tab+Enter - Restart, Ctrl+Shift+P - Pauza, Esc - Koniec");

        HBox footer = new HBox(shortcutLabel);
        footer.setPadding(new Insets(10));
        footer.setStyle("-fx-background-color: lightgray;");

        // Dodawanie elementów do głównego kontenera
        root.setTop(menuBar);
        root.setCenter(centerBox);
        root.setBottom(footer);

        Scene scene = new Scene(root, 800, 600);
        scene.setOnKeyPressed(this::handleKeyPressed);
        primaryStage.setScene(scene);
        primaryStage.show();

        refreshLanguages(); // Wczytanie języków przy uruchomieniu aplikacji

        timeComboBox.setOnAction(e -> startGame(timeComboBox.getValue()));
    }
    private void handleKeyPressed(KeyEvent event) {
        String input = event.getText();
        if (!input.isEmpty()) {
            checkInput(input.charAt(0));
        }else {
            if (event.getCode() == KeyCode.BACK_SPACE) {
                napis.deleteCharacter();
            }
        }
        refresh();
    }

    private void checkInput(char character) {
        System.out.println(character);
        napis.inputChar(character);
    }
    private void refresh(){
        textFlow.getChildren().clear();
        List<List<Color>> colors = napis.getKolory();
        List<String> napisy = napis.getNapisy();


        for (int i = 0; i < napisy.size(); i++) {
            for (int j = 0; j < napisy.get(i).length(); j++) {
                Text text = new Text(String.valueOf(napisy.get(i).charAt(j)));
                text.setFill(colors.get(i).get(j));
                textFlow.getChildren().add(text);
            }

            textFlow.getChildren().add(new Text(" "));
        }
        textFlow.getChildren().add(new Text(" "));
    }

    private void refreshLanguages() {
        List<String> languages = loadLanguages();
        languageComboBox.setItems(FXCollections.observableArrayList(languages));
    }

    private List<String> loadLanguages() {
        List<String> languages = new ArrayList<>();

        try {
            File dictionaryDir = new File("dictionary");
            if (dictionaryDir.exists() && dictionaryDir.isDirectory()) {
                File[] files = dictionaryDir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        String language = file.getName();
                        languages.add(language);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return languages;
    }

    private void startGame(int duration) {
        if (languageComboBox.getValue() == null) {
            showAlert("Błąd", "Nie wybrano języka.");
            return;
        }

        String language = languageComboBox.getValue();
        wordList = loadWords(language);

        if (wordList.isEmpty()) {
            showAlert("Błąd", "Brak słów dla wybranego języka.");
            return;
        }

        // Wyświetlanie początkowych 30 losowych słów
        StringBuilder initialText = new StringBuilder();
        Random random = new Random();
        List<String> words= new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int randomIndex = random.nextInt(wordList.size());
            String word = wordList.get(randomIndex);
            initialText.append(word).append(" ");
            words.add(word);
        }
        wordList = words;
        napis = new Napis(wordList);
        textFlow.setTextAlignment(TextAlignment.LEFT);
        textFlow.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        refresh();
        // Rozpoczęcie licznika czasu
        //startTimer(duration);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private List<String> loadWords(String language) {
        List<String> words = new ArrayList<>();

        try {
            File dictionaryDir = new File("dictionary");
            if (dictionaryDir.exists() && dictionaryDir.isDirectory()) {
                File languageFile = new File(dictionaryDir, language);
                if (languageFile.exists() && languageFile.isFile()) {
                    BufferedReader reader = new BufferedReader(new FileReader(languageFile));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        words.add(line.trim());
                    }
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }
}
