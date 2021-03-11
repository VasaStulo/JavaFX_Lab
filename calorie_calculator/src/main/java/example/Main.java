package example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    public static GridPane initRootLayout() {
        double kef = 3.01;
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25));

        Text sceneTitle = new Text("Калькулятор калорийности колбаски");
        Font fontBig = Font.font("Constantia", FontWeight.NORMAL,26);
        sceneTitle.setFont(fontBig);

        root.add(sceneTitle,0,0,2,1);
        //Метка
        Label weight = new Label("Вес (гр):");
        weight.setFont(fontBig);
        root.add(weight,0,1);

        TextField weightTextField = new TextField();
        weightTextField.setFont(fontBig);
        root.add(weightTextField,1,1);

        Text result = new Text("Результат");
        result.setFont(fontBig);
        root.add(result,0,6);

        Button btn = new Button("Расчет калорийности");
        btn.setFont(fontBig);
        btn.setOnAction(event -> {
            String weightSosiska = weightTextField.getText();
            if (weightSosiska.matches("[0-9]+")){
                double kkalori = Double.parseDouble(weightSosiska) * kef;
                result.setText(weightTextField.getText()+"грамм = "+ kkalori+" калорий");
            }
            else {
                result.setFill(Color.FIREBRICK);
                result.setText("Неправильный ввод веса!");
            }
        });
        root.add(btn,0,5);
        return root;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        GridPane root = initRootLayout();
        Scene scene = new Scene(root,700,700);
        primaryStage.setTitle("Калькулятор каллорий");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void  main(String[] args){
        launch();
    }
}
