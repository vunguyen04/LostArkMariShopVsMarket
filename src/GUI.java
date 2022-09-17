import java.awt.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class GUI implements ActionListener {

    private static JFrame mainframe = new JFrame();
    private static JPanel panel = new JPanel();
    //input variables
    private static JTextField amountGoldText;
    private static JTextField marketCostText;

    private static JLabel inputErrorLabel1;
    private static JLabel inputErrorLabel2;
    private static JComboBox itemList;

    private static JButton submitButton;
    private static JButton clearButton;

    //output variables
    private static JLabel outputItemName;
    private static JLabel outputItemCost;
    private static JLabel outputItemCompare;


    //calculation stuff
    int inputGoldPer95Crystal = 0;
    int inputGoldPerMarketItem = 0;
    String inputItem;

    private static final DecimalFormat df = new DecimalFormat("0.00");

   private static Database myDatabase = new Database();



    public  static void main(String[] args){

        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setTitle("Our GUI");
        mainframe.setSize(500,500);
        mainframe.setLayout(null);

        //panel
        panel.setBackground(Color.red);
        panel.setBounds(0,0,500,500);
        panel.setLayout(null);
        mainframe.add(panel);

        //label for gold per 100 crystal
        JLabel goldPer95Label = new JLabel("Gold per 100 crystal");
        goldPer95Label.setBounds(10,10,150,25);
        panel.add(goldPer95Label);

        //create input field for gold per 100 crystal
        amountGoldText = new JTextField(20);
        amountGoldText.setBounds(170,10,100,25);
        panel.add(amountGoldText);

        //create error warning when input is not integer
        inputErrorLabel1 = new JLabel();
        inputErrorLabel1.setBounds(300,10,200,25);
        panel.add(inputErrorLabel1);

        //create label for input item
        JLabel itemLabel = new JLabel("Item name?");
        itemLabel.setBounds(10,50,100,25);
        panel.add(itemLabel);

        //create list of item for picking
        itemList = new JComboBox();
        itemList.setBounds(170,50,300,25);
        addDataToList(itemList);
        panel.add(itemList);

        //create market gold per item
        JLabel marketCostLabel = new JLabel("Cost per item on Market");
        marketCostLabel.setBounds(10,100,150,25);
        panel.add(marketCostLabel);

        //input field for gold per item on mark
        marketCostText = new JTextField(20);
        marketCostText.setBounds(170,100,100,25);
        panel.add(marketCostText);

        //input for market cost has to be number or error display
        inputErrorLabel2 = new JLabel();
        inputErrorLabel2.setBounds(300,100,200,25);
        panel.add(inputErrorLabel2);


        //submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 150,100,25);
        submitButton.addActionListener(new GUI());
        panel.add(submitButton);


        //clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(200, 150,100,25);
        clearButton.addActionListener(new GUI());
        panel.add(clearButton);

        //output
        outputItemName = new JLabel("");
        outputItemName.setBounds(10,200,200,25);
        panel.add(outputItemName);

        outputItemCost = new JLabel("");
        outputItemCost.setBounds(10,230,200,25);
        panel.add(outputItemCost);

        outputItemCompare = new JLabel("");
        outputItemCompare.setBounds(10,260,200,25);
        panel.add(outputItemCompare);



        mainframe.setVisible(true);
    }

    //button action on click
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submitButton) {

            //make sure gold per 95 crystal is int number
            if (isInt(amountGoldText) == true) {
                inputGoldPer95Crystal = Integer.parseInt(amountGoldText.getText()); //input Gold per 95 crystal
                inputErrorLabel1.setText("");
            }
            else
                inputErrorLabel1.setText("Amount of gold is not a number");

            //make sure gold per item on market is int number
            if (isInt(marketCostText) == true){
                inputErrorLabel2.setText("");
                inputGoldPerMarketItem = Integer.parseInt(marketCostText.getText());
            }else
                inputErrorLabel2.setText("Amount of gold is not a number");

            if (isInt(amountGoldText) == true && isInt(marketCostText) == true){
                inputItem = itemList.getSelectedItem().toString();
                int amountOfItemData = myDatabase.getAmountOfItemMari(inputItem);
                int costOfItemOnMari = myDatabase.getCostOfItemMari(inputItem);
                Calculation goldCostOnMari = new Calculation();
                float costOfMariByGold =goldCostOnMari.goldPerItem(inputGoldPer95Crystal,amountOfItemData,costOfItemOnMari);

                outputItemName.setText(inputItem);
                outputItemCost.setText("Cost of Gold per Item "+df.format(costOfMariByGold)+" Gold");
                if (costOfMariByGold == inputGoldPerMarketItem)
                    outputItemCompare.setText("They are same price!!!");
                else if (costOfMariByGold > inputGoldPerMarketItem)
                    outputItemCompare.setText("You should buy on Market!!!");
                else
                    outputItemCompare.setText("You should buy on Mari Shop!!!");

            }
        }
        if (e.getSource()==clearButton){
            inputErrorLabel1.setText("");
            inputErrorLabel2.setText("");
            amountGoldText.setText("");
            marketCostText.setText("");
            outputItemName.setText("");
            outputItemCost.setText("");
            outputItemCompare.setText("");
        }
    }



    //check if input is integer
    private boolean isInt(JTextField input){
        try{
            Integer.parseInt((input.getText()));
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }


    public static void addDataToList(JComboBox list){
        myDatabase.query(list);

    }
}

