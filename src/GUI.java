import java.awt.*;

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


    //button
    private static JButton addModeButton;
    private static JButton compareModeButton;
    private static JButton deleteModeButton;


    private static Database myDatabase = new Database();



    public  static void main(String[] args){

        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setTitle("Our GUI");
        mainframe.setSize(500,500);
        mainframe.setLayout(null);

        //panel
        panel.setBackground(Color.gray);
        panel.setBounds(0,0,500,500);
        panel.setLayout(null);
        mainframe.add(panel);

        //Gold Compare Mode vs Add on Mode (admin)

        compareModeButton = new JButton("Compare Mode");
        compareModeButton.setBounds(10,0,150,50);
        compareModeButton.addActionListener(new GUI());
        panel.add(compareModeButton);

        addModeButton = new JButton("Add / Update Mode");
        addModeButton.setBounds(170,0,150,50);
        addModeButton.addActionListener(new GUI());
        panel.add(addModeButton);

        deleteModeButton = new JButton("Delete Mode");
        deleteModeButton.setBounds(330,0,150,50);
        deleteModeButton.addActionListener(new GUI());
        panel.add(deleteModeButton);



        mainframe.setVisible(true);
    }

    //button action on click
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==compareModeButton){
            panel.removeAll();
            panel.add(addModeButton);
            panel.add(compareModeButton);
            panel.add(deleteModeButton);
            CreateGUI myGUI = new CreateGUI(this.panel, this.myDatabase);
            myGUI.compareGUI();
            panel.revalidate();
            panel.repaint();
        }


        if (e.getSource()==addModeButton){
            panel.removeAll();
            panel.add(addModeButton);
            panel.add(compareModeButton);
            panel.add(deleteModeButton);
            CreateGUI myGUI = new CreateGUI(this.panel, this.myDatabase);
            myGUI.addGUI();
            panel.revalidate();
            panel.repaint();

        }

        if (e.getSource()==deleteModeButton){
            panel.removeAll();
            panel.add(addModeButton);
            panel.add(compareModeButton);
            panel.add(deleteModeButton);
            CreateGUI myGUI = new CreateGUI(this.panel, this.myDatabase);
            myGUI.deleteGUI();
            panel.revalidate();
            panel.repaint();
        }


    }

}

