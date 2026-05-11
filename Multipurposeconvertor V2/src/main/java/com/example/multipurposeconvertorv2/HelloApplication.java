package com.example.multipurposeconvertorv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        // 1. Create the UI Components
        Label label = new Label("Select Conversion");
        ComboBox<String> unitChoices = new ComboBox<>();
        unitChoices.getItems().addAll("Celsius to Fahrenheit","Fahrenheit to Celcius","Kelvin to Celsius","Inches to Centimeters","Feet to Meters", "Kg to Lbs", "Lbs to Kg","Liters to Cups","Cups to Liters","Km to Miles","Miles to km","naira to dollar","dollar to naira","naira to pound","pounds to naira","naira to euro","euro to naira");
        unitChoices.setValue("Celsius to Fahrenheit");

        TextField input = new TextField();
        input.setPromptText("Enter value here");

        Button convertBtn = new Button("Convert");
        Label resultLabel = new Label("Answer: ");

        // 2. Logic (The "Brain" of your app)
        convertBtn.setOnAction(e -> {
            try {
                double val = Double.parseDouble(input.getText());
                String choice = unitChoices.getValue();
                double result = 0;
                String unitsymbol = "";

                if (choice.equals("Celsius to Fahrenheit")) {
                    result = (val * 9 / 5) + 32;
                    unitsymbol = "°F";
                } else if (choice.equals("Fahrenheit to Celcius")) {
                    result = (val - 32) * 5 / 9;
                    unitsymbol = "°C";

                } else if (choice.equals("Kg to Lbs")) {
                    result = val * 2.20462;
                    unitsymbol = "lbs";

                } else if (choice.equals("Km to Miles")) {
                    result = val * 0.621371;
                    unitsymbol = "ml";
                } else if (choice.equals("Lbs to Kg")){
                    result = val * 0.45359237;
                    unitsymbol = "kg";
                }else if (choice.equals("miles to km")){
                    result = val * 1.60934 ;
                    unitsymbol = "km";
                }else if (choice.equals("Inches to Centimeters")){
                    result = val * 2.54;
                    unitsymbol = "cm";
                }else if (choice.equals("Feet to Meters")){
                    result = val * 0.3048;
                    unitsymbol = "m";
                }else if (choice.equals("Liters to Cups")){
                    result = val * 4.22675;
                    unitsymbol = "cups";
                }else if (choice.equals("Cups to Liters")){
                    result = val /4.22675;
                    unitsymbol = "L";
                }else if (choice.equals("Kelvin to Celsius")){
                    result = val - 273.15;
                    unitsymbol = "ºC";
                }else if (choice.equals("naira to dollar")){
                    result = val *0.00070;
                    unitsymbol = "$";
                }else if (choice.equals("dollar to naira")){
                    result = val * 14422.15;
                    unitsymbol = "₦";
                }else if (choice.equals("naira to pound")){
                    result = val * 0.00052;
                    unitsymbol = "£";
                }else if (choice.equals("pounds to naira")){
                    result = val * 1909.36;
                    unitsymbol = "₦";
                }else if (choice.equals("naira to euro")){
                    result = val * 0.00060;
                    unitsymbol = "€";
                }else if (choice.equals("euro to naira")){
                    result = val * 1664.30;
                    unitsymbol = "₦";
                }



                resultLabel.setText(String.format("Answer: %.2f", result));

            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Enter a valid number!");
            }
        });

        // 3. Layout: Arrange everything in a vertical column (VBox)
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, unitChoices, input, convertBtn, resultLabel);

        // 4. Scene and Stage: Put the layout in a scene and show the window
        Scene scene = new Scene(layout,320,300);
        stage.setTitle("Mini Converter ");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
