import javax.swing.*;
import java.sql.*;

public class Database{


    String databaseUrl="jdbc:mysql://localhost:3306/lostarkmari";
    String databaseUsername = "root";
    String databasePass = "quangvu0430";
    private Connection connection;
    private Statement stat;
    public Database(){
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePass);
            stat = connection.createStatement();
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
            e.printStackTrace();
        }

    }


    public void query(JComboBox list) {
        try {

            String selectItemName = "SELECT item_name FROM lostarkmari";
            ResultSet rs = stat.executeQuery(selectItemName);
            while(rs.next()){
                list.addItem(rs.getString("item_name"));
            }

        }catch(SQLException e){
            System.out.println("Unable to create statement");
            e.printStackTrace();
        }
    }

    public int getAmountOfItemMari(String inputItem){
        try {
            String selectAmountByName = "SELECT item_amount FROM lostarkmari WHERE item_name =\'"+inputItem+"\'";
            ResultSet rs = stat.executeQuery(selectAmountByName);
            rs.next();
            int amountOfItem = rs.getInt("item_amount");
            return amountOfItem;

        }catch(SQLException e){
            System.out.println("Unable to create statement Amount");
            e.printStackTrace();
        }
        return 1;
    }

    public int getCostOfItemMari(String inputItem){
        try {
            String selectAmountByName = "SELECT item_crystal_cost FROM lostarkmari WHERE item_name =\'"+inputItem+"\'";
            ResultSet rs = stat.executeQuery(selectAmountByName);
            rs.next();
            int costOfCrystal = rs.getInt("item_crystal_cost");
            return costOfCrystal;

        }catch(SQLException e){
            System.out.println("Unable to create statement Amount");
            e.printStackTrace();
        }
        return 1;
    }
}