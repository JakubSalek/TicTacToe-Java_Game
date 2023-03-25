package com.example.kolkoikrzyzyk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

public class HelloController {
    private char symbol = 'X';
    private Boolean win = false;
    private int i;

    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button playAgainButton;
    @FXML
    private Label textLabel;
    @FXML
    private Line line0;
    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Line line5;
    @FXML
    private Line line6;
    @FXML
    private Line line7;

   @FXML
    private void onClick0(){
       onClick(button0);
    }

    @FXML
    private void onClick1(){
        onClick(button1);
    }

    @FXML
    private void onClick2(){
        onClick(button2);
    }

    @FXML
    private void onClick3(){
        onClick(button3);
    }

    @FXML
    private void onClick4(){
        onClick(button4);
    }

    @FXML
    private void onClick5(){
        onClick(button5);
    }

    @FXML
    private void onClick6(){
        onClick(button6);
    }

    @FXML
    private void onClick7(){
        onClick(button7);
    }

    @FXML
    private void onClick8(){
        onClick(button8);
    }

    @FXML
    private void clickPlayAgain(){
        changeDisable(false);
        button0.setText("");
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        playAgainButton.setVisible(false);
        win = false;
        changeSymbol();
        drawLine(false);
    }

    private void onClick(Button button){
        button.setText(String.valueOf(symbol));
        changeSymbol();
        button.setDisable(true);
        checkWin();
    }

    private void checkWin(){
        String line = "";
        String[] buttonsTexts = {button0.getText(), button1.getText(), button2.getText(), button3.getText(), button4.getText(), button5.getText(), button6.getText(), button7.getText(), button8.getText()};
        for(i=0; i<8; i++){
            switch(i){
                case 0 -> line = buttonsTexts[0] + buttonsTexts[1] + buttonsTexts[2];
                case 1 -> line = buttonsTexts[3] + buttonsTexts[4] + buttonsTexts[5];
                case 2 -> line = buttonsTexts[6] + buttonsTexts[7] + buttonsTexts[8];
                case 3 -> line = buttonsTexts[0] + buttonsTexts[3] + buttonsTexts[6];
                case 4 -> line = buttonsTexts[1] + buttonsTexts[4] + buttonsTexts[7];
                case 5 -> line = buttonsTexts[2] + buttonsTexts[5] + buttonsTexts[8];
                case 6 -> line = buttonsTexts[0] + buttonsTexts[4] + buttonsTexts[8];
                case 7 -> line = buttonsTexts[2] + buttonsTexts[4] + buttonsTexts[6];
            }
            if(line.equals("XXX")){
                symbol = 'X';
                win = true;
                break;
            }else if(line.equals("OOO")){
                symbol = 'O';
                win = true;
                break;
            }
        }
        if(button0.isDisable() && button1.isDisable() && button2.isDisable() && button3.isDisable() && button4.isDisable() && button5.isDisable() && button6.isDisable() && button7.isDisable() && button8.isDisable()){
            textLabel.setText("Draw!");
            playAgainButton.setVisible(true);
        }
        if(win){
            changeDisable(true);
            drawLine(true);
            textLabel.setText(symbol + " wins!!!");
            playAgainButton.setVisible(true);
        }

    }

    private void drawLine(Boolean bool){
       switch(i){
           case 0 -> line0.setVisible(bool);
           case 1 -> line1.setVisible(bool);
           case 2 -> line2.setVisible(bool);
           case 3 -> line3.setVisible(bool);
           case 4 -> line4.setVisible(bool);
           case 5 -> line5.setVisible(bool);
           case 6 -> line6.setVisible(bool);
           case 7 -> line7.setVisible(bool);
       }
    }

    private void changeSymbol(){
        if(symbol == 'X'){
            symbol = 'O';
        }
        else{
            symbol = 'X';
        }
        textLabel.setText(symbol+" turn!");
    }

    private void changeDisable(Boolean bool){
            button0.setDisable(bool);
            button1.setDisable(bool);
            button2.setDisable(bool);
            button3.setDisable(bool);
            button4.setDisable(bool);
            button5.setDisable(bool);
            button6.setDisable(bool);
            button7.setDisable(bool);
            button8.setDisable(bool);
    }
}