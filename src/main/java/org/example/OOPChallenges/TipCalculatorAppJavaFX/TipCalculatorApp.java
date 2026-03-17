package org.example.OOPChallenges.TipCalculatorAppJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class TipCalculatorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tip Calculator");

        Label billLabel = new Label("Bill Amount:");
        TextField billTextField = new TextField();

        Label tipLabel = new Label("Tip Percentage %:");
        Slider slider = new Slider(0, 30, 15);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(5);
        slider.setMinorTickCount(4);
        slider.setBlockIncrement(1);

        Label tipPercentLabel = new Label("15%");
        Label tipAmountLabel = new Label("Tip Amount: $0.00");
        Label totalAmountLabel = new Label("Total Amount: $0.00");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(billLabel, 0, 0);
        grid.add(billTextField, 1, 0);

        grid.add(tipLabel, 0, 1);
        grid.add(slider, 1, 1);
        grid.add(tipPercentLabel, 2, 1);

        grid.add(tipAmountLabel, 0, 2, 2, 1);
        grid.add(totalAmountLabel, 0, 3, 2, 1);

        // Event handling
        slider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int tipPercent = newVal.intValue();
            tipPercentLabel.setText(tipPercent + "%");
            calculateTip(billTextField, tipPercent, tipAmountLabel, totalAmountLabel);
        });
        billTextField.textProperty().addListener((obs, oldText, newText) -> {
            int tipPercent = (int) slider.getValue();
            calculateTip(billTextField, tipPercent, tipAmountLabel, totalAmountLabel);
        });

        // Scene and stage
        Scene scene = new Scene(grid, 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void calculateTip(TextField billTextField, int tipPercent, Label tipAmountLabel, Label totalAmountLabel) {
        try {
            double billAmount = Double.parseDouble(billTextField.getText());
            if (billAmount < 0) {
                tipAmountLabel.setText("Tip Amount: $0.00");
                totalAmountLabel.setText("Total Amount: $0.00");
                return;
            }
            double tipAmount = billAmount * tipPercent / 100.0;
            double totalAmount = billAmount + tipAmount;

            tipAmountLabel.setText(String.format("Tip Amount: $%.2f", tipAmount));
            totalAmountLabel.setText(String.format("Total Amount: $%.2f", totalAmount));
        } catch (NumberFormatException e) {
            tipAmountLabel.setText("Tip Amount: $0.00");
            totalAmountLabel.setText("Total Amount: $0.00");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}



