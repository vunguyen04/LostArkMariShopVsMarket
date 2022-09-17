import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CreateGUI implements ActionListener{
    private static JPanel panel;
    private static Database myDatabase;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CreateGUI(JPanel panel, Database myDatabase){
        this.panel = panel;
        this.myDatabase = myDatabase;
    }
    private static JButton addModeButton;
    private static JButton compareModeButton;
    private static JButton compareSubmitButton;
    private static JButton compareClearButton;

    //input variable for compare mode
    //input variables

    //labels
    private static JLabel goldPer95Label;
    private static JLabel itemLabel;
    private static JLabel inputErrorLabel1;
    private static JLabel inputErrorLabel2;
    private static JLabel marketCostLabel;

    //Text Field
    private static JTextField amountGoldText;
    private static JTextField marketCostText;

    //Combo box
    private static JComboBox itemList;

    //output variables for compare mode
    private static JLabel outputItemName;
    private static JLabel outputItemCost;
    private static JLabel outputItemCompare;

    //calculation stuff
    int inputGoldPer95Crystal = 0;
    int inputGoldPerMarketItem = 0;
    String inputItem;


    //Add Mode Button
    private static JLabel addItemNameLabel;
    private static JLabel addItemAmountLabel;
    private static JLabel addItemCostMariLabel;

    private static JTextField addItemNameText;
    private static JTextField addItemAmountText;
    private static JTextField addItemCostMariText;

    private static JButton addSubmitButton;
    private static JButton addClearButton;

    private static JLabel errorItemAmount;
    private static JLabel errorItemCost;
    private static JLabel errorInputItem;

    //add mode little stuff
    String addItemNameInput;
    int addItemAmountInput;
    int addItemCostInput;


    //DELETE MODE

    private static JLabel deleteItemNameLabel;

    private static JTextField deleteItemNameText   ;
    private static JLabel deleteItemPrompt;

    private static JButton deleteSubmitButton;
    private static JButton deleteClearButton;

    //delete little stuff
    String deleteItemInput;

    public void compareGUI() {

        //label for gold per 100 crystal
        goldPer95Label = new JLabel("Gold per 100 crystal");
        goldPer95Label.setBounds(10, 60, 150, 25);
        panel.add(goldPer95Label);

        //create input field for gold per 100 crystal
        amountGoldText = new JTextField(20);
        amountGoldText.setBounds(170, 60, 100, 25);
        panel.add(amountGoldText);

        //create error warning when input is not integer
        inputErrorLabel1 = new JLabel();
        inputErrorLabel1.setBounds(300, 60, 200, 25);
        panel.add(inputErrorLabel1);

        //create label for input item
        itemLabel = new JLabel("Item name?");
        itemLabel.setBounds(10, 105, 100, 25);
        panel.add(itemLabel);

        //create list of item for picking
        itemList = new JComboBox();
        itemList.setBounds(170, 105, 300, 25);
        myDatabase.putItemIntoDropBox(itemList);
        panel.add(itemList);

        //create market gold per item
        marketCostLabel = new JLabel("Cost per item on Market");
        marketCostLabel.setBounds(10, 150, 150, 25);
        panel.add(marketCostLabel);

        //input field for gold per item on mark
        marketCostText = new JTextField(20);
        marketCostText.setBounds(170, 150, 100, 25);
        panel.add(marketCostText);

        //input for market cost has to be number or error display
        inputErrorLabel2 = new JLabel();
        inputErrorLabel2.setBounds(300, 100, 200, 25);
        panel.add(inputErrorLabel2);


        //submit button
        compareSubmitButton = new JButton("Submit");
        compareSubmitButton.setBounds(50, 200, 100, 25);
        compareSubmitButton.addActionListener(this);
        panel.add(compareSubmitButton);


        //clear button
        compareClearButton = new JButton("Clear");
        compareClearButton.setBounds(200, 200, 100, 25);
        compareClearButton.addActionListener(this);
        panel.add(compareClearButton);

        //output
        outputItemName = new JLabel("");
        outputItemName.setBounds(10, 250, 500, 25);
        panel.add(outputItemName);

        outputItemCost = new JLabel("");
        outputItemCost.setBounds(10, 280, 500, 25);
        panel.add(outputItemCost);

        outputItemCompare = new JLabel("");
        outputItemCompare.setBounds(10, 310, 500, 25);
        panel.add(outputItemCompare);
    }

    public void addGUI(){
        //add mode
        addItemNameLabel = new JLabel("Item Name");
        addItemNameLabel.setBounds(10,60,100,25);
        panel.add(addItemNameLabel);

        addItemNameText = new JTextField("");
        addItemNameText.setBounds(130,60,150,25);
        panel.add(addItemNameText);

        addItemAmountLabel = new JLabel("Item Amount");
        addItemAmountLabel.setBounds(10,105,100,25);
        panel.add(addItemAmountLabel);

        addItemAmountText = new JTextField("");
        addItemAmountText.setBounds(130,105,150,25);
        panel.add(addItemAmountText);

        addItemCostMariLabel = new JLabel("Item Cost on Mari");
        addItemCostMariLabel.setBounds(10,150,100,25);
        panel.add(addItemCostMariLabel);

        addItemCostMariText = new JTextField("");
        addItemCostMariText.setBounds(130,150,150,25);
        panel.add(addItemCostMariText);

        //input error
        errorItemAmount = new JLabel("");
        errorItemAmount.setBounds(300, 105, 200, 25);
        panel.add(errorItemAmount);

        errorItemCost = new JLabel("");
        errorItemCost.setBounds(300, 150, 200, 25);
        panel.add(errorItemCost);

        errorInputItem = new JLabel("");
        errorInputItem.setBounds(10,190,500,25);
        panel.add(errorInputItem);

        //submit button
        addSubmitButton = new JButton("Submit");
        addSubmitButton.setBounds(50, 220,100,25);
        addSubmitButton.addActionListener(this);
        panel.add(addSubmitButton);


        //clear button
        addClearButton = new JButton("Clear");
        addClearButton.setBounds(200, 220,100,25);
        addClearButton.addActionListener(this);
        panel.add(addClearButton);
    }

    public void deleteGUI(){
        //add mode
        deleteItemNameLabel = new JLabel("Item Name");
        deleteItemNameLabel.setBounds(10,60,100,25);
        panel.add(deleteItemNameLabel);

        deleteItemNameText = new JTextField("");
        deleteItemNameText.setBounds(130,60,150,25);
        panel.add(deleteItemNameText);


        //input error
        deleteItemPrompt = new JLabel("");
        deleteItemPrompt.setBounds(10, 90, 300, 25);
        panel.add(deleteItemPrompt);

        //submit button
        deleteSubmitButton = new JButton("Submit");
        deleteSubmitButton.setBounds(50, 140,100,25);
        deleteSubmitButton.addActionListener(this);
        panel.add(deleteSubmitButton);


        //clear button
        deleteClearButton = new JButton("Clear");
        deleteClearButton.setBounds(200, 140,100,25);
        deleteClearButton.addActionListener(this);
        panel.add(deleteClearButton);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        //compare function
        if (e.getSource()==compareSubmitButton) {
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
                outputItemCost.setText("Cost of Gold per Item On Mari Shop "+df.format(costOfMariByGold)+" Gold");
                if (costOfMariByGold == inputGoldPerMarketItem)
                    outputItemCompare.setText("They are same price!!!");
                else if (costOfMariByGold > inputGoldPerMarketItem)
                    outputItemCompare.setText("You should buy on Market!!!");
                else
                    outputItemCompare.setText("You should buy on Mari Shop!!!");

            }
            panel.revalidate();
            panel.repaint();
        }
        if (e.getSource()==compareClearButton){
            inputErrorLabel1.setText("");
            inputErrorLabel2.setText("");
            amountGoldText.setText("");
            marketCostText.setText("");
            outputItemName.setText("");
            outputItemCost.setText("");
            outputItemCompare.setText("");
        }

        //add function
        if (e.getSource()==addSubmitButton){
            if (isInt(addItemAmountText) == true){
                errorItemAmount.setText("");
                addItemAmountInput = Integer.parseInt(addItemAmountText.getText());

            }
            else
                errorItemAmount.setText("Amount of item is not a number");

            if (isInt(addItemCostMariText) == true){
                errorItemCost.setText("");
                addItemCostInput = Integer.parseInt(addItemCostMariText.getText());

            }
            else
                errorItemCost.setText("Cost of item is not a number");

            if (isInt(addItemAmountText) == true && isInt(addItemCostMariText) == true){
                addItemNameInput =addItemNameText.getText();
                int valid = myDatabase.putItemIntoDatabase(addItemNameInput, addItemAmountInput, addItemCostInput);
                if (valid == 1)
                    errorInputItem.setText("New item "+addItemNameInput+" has been added to database");
                else if (valid == 2)
                    errorInputItem.setText("Item "+addItemNameInput+" has been updated to database");
                else
                    errorInputItem.setText("Invalid input");
            }

            panel.revalidate();
            panel.repaint();

        }
        if (e.getSource()==addClearButton){
            addItemNameText.setText("");
            addItemAmountText.setText("");;
            addItemCostMariText.setText("");
            errorItemAmount.setText("");
            errorItemCost.setText("");
            errorInputItem.setText("");
        }

        //delete function
        if (e.getSource()==deleteSubmitButton){
            deleteItemInput = deleteItemNameText.getText();
            boolean valid = myDatabase.deleteItemFromDatabase(deleteItemInput);
            if (valid == true){
                deleteItemPrompt.setText("Item "+deleteItemInput+" is deleted from database");
            }
            else
                deleteItemPrompt.setText("Unable to delte item "+deleteItemInput);
        }
        if (e.getSource()==deleteClearButton){
            deleteItemNameText.setText("");
            deleteItemPrompt.setText("");

        }
    }

    private boolean isInt(JTextField input){
        try{
            Integer.parseInt((input.getText()));
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
