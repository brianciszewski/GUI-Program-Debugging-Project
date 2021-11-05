package ProductionLog;

import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;


public class DataBase {


    private static final java.lang.String JDBC_DRIVER = "org.h2.Driver";
    private static final java.lang.String DB_URL = "jdbc:h2:./res/dataBase1";
    private static final java.lang.String USER = "";


    private static Connection conn;
    private static Statement stmt;

    public DataBase() throws FileNotFoundException {
    }


    public static void getDB(ObservableList<Widget> ListViewProductList) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/ProductionLog/properties.txt"));
        String pass = scanner.nextLine();
        pass = reverseString(pass);
        final java.lang.String PASS = pass;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("Select * from PRODUCT");
            while (rs.next()) {

                //ListViewProduct.add(rs.getString(-1));
                String nameID = rs.getString(1);
                String name1 = rs.getString(2);
                String name3 = rs.getString(3);
                String name2 = rs.getString(4);
                ItemType name4 = null;

                int nameId = Integer.parseInt(nameID);
                //ListViewProductList.add(new Pie(name1, name2, name3));
                if (name3.equals("AUDIO")) {
                    name4 = ItemType.AUDIO;
                }
                if (name3.equals("VISUAL")) {
                    name4 = ItemType.VISUAL;
                }
                if (name3.equals("AUDIO_MOBILE")) {
                    name4 = ItemType.AUDIO_MOBILE;
                }
                if (name3.equals("VISUAL_MOBILE")) {
                    name4 = ItemType.VISUAL_MOBILE;
                }

                ListViewProductList.add(new Widget(name1, name2, name4,nameId));
            }
        } catch (SQLException | IllegalStateException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void setDB(ItemType choiceItemType1, String txtManufacturer1, String txtProductName1,
                             ObservableList<Product> productLine) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/ProductionLog/properties.txt"));
        String pass = scanner.nextLine();
        pass = reverseString(pass);
        final java.lang.String PASS = pass;
        try {
            // connects to the dataBase and inserts 3 elements into a row on the 'Product' table.
            // exceptions are caught to prevent immature termination of program.
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // A security Bug is flagged for having a blank username and password.
            java.lang.String sql = "INSERT INTO Product(type, MANUFACTURER, NAME) VALUES('" + choiceItemType1 +
                    "','" + txtManufacturer1 + "','" + txtProductName1 + "')";


            productLine.add(new Widget(txtProductName1, txtManufacturer1, choiceItemType1));


            stmt.executeUpdate(sql);

            conn.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException | IllegalStateException e) {
            e.printStackTrace();
        }
    }


    public static void setDBProductionRecord(int production_number, int production_id, String serialNum, Timestamp date) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/ProductionLog/properties.txt"));
        String pass = scanner.nextLine();
        pass = reverseString(pass);
        final java.lang.String PASS = pass;
        try {
            // connects to the dataBase and inserts 3 elements into a row on the 'Product' table.
            // exceptions are caught to prevent immature termination of program.
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();



            // A security Bug is flagged for having a blank username and password.
            java.lang.String sql = "INSERT INTO Productionrecord(" +
                    "production_num, product_id, serial_num,date_produced) VALUES('" + production_number +
                    "','" + production_id + "','" + serialNum + "','" + date + "')";


            stmt.executeUpdate(sql);

            conn.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException | IllegalStateException e) {
            e.printStackTrace();
        }

    }

    public static void getDBProductionRecord(TextArea productionLogText) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/ProductionLog/properties.txt"));
        String pass = scanner.nextLine();
        pass = reverseString(pass);
        final java.lang.String PASS = pass;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("Select * from PRODUCTIONRECORD");
            while (rs.next()) {

                //ListViewProduct.add(rs.getString(-1));
                String string1 = rs.getString(1);
                String string2 = rs.getString(2);
                String string3 = rs.getString(3);
                String string4 = rs.getString(4);

                String string5 = "Prod. Num: " + string1 + " Product ID: " + string2 + " " + string3 + " " + string4;
                productionLogText.appendText(string5 + "\n");
            }
        } catch (SQLException | IllegalStateException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public static String reverseString(String id) {
        // Paste the code for your reverseString method here.

        if (id.isEmpty())
            return "pw";

        String pw = reverseString(id.substring(1)) + id.charAt(0);
        return pw.replace("pw", "");
    }


}
