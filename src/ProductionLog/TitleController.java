/*
Author: Brian Ciszewski
Last Update: 9/26/19
 */
package ProductionLog;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;


// 'main' class for controller file, implements 'initializable' for everything to function.
public class TitleController<String> implements Initializable {


    // grabs the fx:id of the comboBox from the FXML file and declares it here to manipulate
    @FXML
    private ComboBox<java.lang.String> ComboBoxQuantity;
    @FXML
    private ChoiceBox<ItemType> choiceType;
    @FXML
    private ObservableList<Product> productLine = FXCollections.observableArrayList();
    @FXML
    private Label lblNoEntry;
    @FXML
    private Label lblNoSelection;
    @FXML private Label lblBadInput;
    @FXML private Label lblInvalidPasswords;
    @FXML
    private TableColumn ProductTableViewColumn;
    @FXML
    private TableColumn ManufacturerTableViewColumn;
    @FXML
    private TableColumn TypeTableViewColumn;

    @FXML
    private TableView<Product> TableView1;
    @FXML
    private TextField txtProductName;
    @FXML
    private TextField txtManufacturer;
    @FXML
    private ListView ListViewProduct;
    @FXML
    private TextArea ProductionLogText;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfConfirmPassword;
    @FXML
    private TextField tfEmail;


    private ObservableList<Widget> ListViewProductList = FXCollections.observableArrayList();
    private ObservableList<java.lang.String> comboBox1_List = FXCollections
            .observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    private ObservableList<ItemType> ItemTypeList = FXCollections.observableArrayList(
            ItemType.AUDIO,
            ItemType.VISUAL,
            ItemType.AUDIO_MOBILE,
            ItemType.VISUAL_MOBILE);

    private java.lang.String txtManufacturer1 = null;
    private java.lang.String txtProductName1 = null;
    private ItemType choiceItemType1;

    public TitleController() throws FileNotFoundException {
    }


    // sets properties of the comboBox
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ComboBoxQuantity.setItems(comboBox1_List);
        ComboBoxQuantity.setEditable(true);
        ComboBoxQuantity.getSelectionModel().selectFirst();

        lblBadInput.setVisible(false);

        // fills the choice Box "Item Type" with proper elements.
        choiceType.setItems(ItemTypeList);
        choiceType.getSelectionModel().selectFirst();


        ProductTableViewColumn.setCellValueFactory(new PropertyValueFactory("name"));
        ManufacturerTableViewColumn.setCellValueFactory(new PropertyValueFactory("manufacturer"));
        TypeTableViewColumn.setCellValueFactory(new PropertyValueFactory("type"));

        lblInvalidPasswords.setVisible(false);


        try {
            DataBase.getDB(ListViewProductList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ListViewProduct.setItems(ListViewProductList);
        setupProductLineTable(ListViewProductList);
        try {
            loadProductList(ListViewProduct);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //loadProductionLog(ProductionLogText);

        // input -> DataBase -> observable list -> table view
    }

    // allows functionality of the comboBox
    public void comboBoxList(Event event) {
    }


    // refreshes the TableView with all elements in the database when the Produce-Tab is entered.
    public void produceTab() throws FileNotFoundException {

        ProductTableViewColumn.setCellValueFactory(new PropertyValueFactory("name"));
        ManufacturerTableViewColumn.setCellValueFactory(new PropertyValueFactory("manufacturer"));
        TypeTableViewColumn.setCellValueFactory(new PropertyValueFactory("type"));

        ListViewProduct.getItems().clear();
        DataBase.getDB(ListViewProductList);
        setupProductLineTable(ListViewProductList);

    }

    Scanner scanner = new Scanner(new File("src/ProductionLog/123.txt"));
    int counter = scanner.nextInt();


    private void loadProductList(ListView ListViewProduct) throws IOException {
        if (ListViewProduct.getSelectionModel().getSelectedItem() != null) {
            if (ComboBoxQuantity.getValue().matches("-?\\d+(\\.\\d+)?")) {
                for (int p = 0; p < Integer.valueOf(ComboBoxQuantity.getValue()); p++) {
                    int i = ListViewProduct.getSelectionModel().getSelectedIndex();
                    Widget whyMustThisHappen = ListViewProductList.get(i);
                    ProductionRecord obj = new ProductionRecord(whyMustThisHappen, counter);
                    java.lang.String serialNum = obj.getSerialNum();


                    File temp = new File("src/ProductionLog/456.txt");
                    if (temp.exists()) {
                        RandomAccessFile raf = new RandomAccessFile(temp, "rw");
                        raf.setLength(0);
                    }

                    Writer wr = new FileWriter("src/ProductionLog/456.txt");
                    wr.write(java.lang.String.valueOf(counter));
                    wr.close();

                    Scanner scanner = new Scanner(new File("src/ProductionLog/456.txt"));
                    int productionNumber = scanner.nextInt();


                    int id = whyMustThisHappen.getId();
                    Timestamp date = new Timestamp(new Date().getTime());

                    DataBase.setDBProductionRecord(productionNumber, id, serialNum, date);
                    counter++;


                    File temp2 = new File("src/ProductionLog/123.txt");
                    if (temp2.exists()) {
                        RandomAccessFile raf = new RandomAccessFile(temp2, "rw");
                        raf.setLength(0);
                    }

                    Writer wr2 = new FileWriter("src/ProductionLog/123.txt");
                    wr2.write(java.lang.String.valueOf(counter));
                    wr2.close();
                }
            }
            else {
                lblBadInput.setVisible(true);
                displayInavlid(lblBadInput,"Bad Input.");
            }
        }
    }

    private void setupProductLineTable(ObservableList<Widget> ListViewProductList) {
        ListViewProduct.setItems(ListViewProductList);
    }


    ////////////////////////// 'Product Line' Tab, 'Add Product' Button///////////////////////////
    public void btnAddProductClicked(ActionEvent actionEvent) throws FileNotFoundException {
        // gets user input
        txtManufacturer1 = txtManufacturer.getText();
        txtProductName1 = txtProductName.getText();
        choiceItemType1 = choiceType.getValue();

        if (txtManufacturer1 == null || txtProductName1 == null || choiceItemType1 == null) {
            displayInavlid(lblNoEntry, "Please fill out information.");
        } else {

            // fills database with user input
            DataBase.setDB(choiceItemType1, txtManufacturer1, txtProductName1, productLine);

            // sets table to observableList
            TableView1.setItems(productLine);
        }
    }

    ////////////////////////// 'Record' Tab, 'Record Product' Button///////////////////////////
    public void btnRecordProductionClicked() throws IOException {
        if (ListViewProduct.getSelectionModel().getSelectedItem() == null) {
            displayInavlid(lblNoSelection, "Please select a product.");
        } else {
            loadProductList(ListViewProduct);
        }
    }


    private static void displayInavlid(Label lblInvalidDate, java.lang.String message) {
        lblInvalidDate.setText(message);
        lblInvalidDate.setTextFill(Color.RED);
        Timeline timeline =
                new Timeline(
                        new KeyFrame(Duration.seconds(0.75), evt -> lblInvalidDate.setVisible(false)),
                        new KeyFrame(Duration.seconds(0.35), evt -> lblInvalidDate.setVisible(true)));
        timeline.setCycleCount(2);
        timeline.play();
    }


    public void productionLogTab(Event event) throws FileNotFoundException {
        ProductionLogText.clear();
        DataBase.getDBProductionRecord(ProductionLogText);
    }

    public void btnCreateEmployeeClicked(ActionEvent actionEvent) {
        boolean blankEntry = false;
        if (tfName.getText().length() == 0 || tfUsername.getText().length() == 0 ||
                tfPassword.getText().equals(tfConfirmPassword.getText()) == true ||
                tfEmail.getText().length() == 0) {
            Employee bob = new Employee(tfName.getText(), tfUsername.getText(), tfPassword.getText(), tfEmail.getText());


            bob.checkName(bob.getName());
            bob.isValidPassword(bob.getPassword());

            System.out.println(bob.toString());
        } else {
            System.out.println("Passwords do not match");
            lblInvalidPasswords.setVisible(true);
            fadeOut(lblInvalidPasswords);

        }
    }

    private static void fadeOut(Object x) {
        // https://docs.oracle.com/javafx/2/api/javafx/animation/FadeTransition.html
        FadeTransition ft = new FadeTransition(Duration.millis(2200), (Node) x);
        ft.setToValue(0);
        ft.setFromValue(1);
        // ft.setCycleCount(4);
        // ft.setAutoReverse(true);
        ft.play();
    }

}