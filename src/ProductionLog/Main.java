/*
Author: Brian Ciszewski
Last Update: 9/26/19
 */

package ProductionLog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
// https://stackoverflow.com/questions/19065464/how-to-populate-a-list-values-to-a-combobox-in-javafx
    // set values of comboBox from FXML file, can't manipulate/ use methods/functions? (see 2nd link)
// https://coderanch.com/t/697820/java/Adding-values-ComboBox-SceneBuilder
    // set values of comboBox from controller file

    // comment
    // Sets the primary stage with a windowed scene. Attaches to 'Title.fxml' file for GUI elements.
    @Override
    public void start(Stage primaryStage) throws Exception {
        //testMultimedia();
        //testProductionLog();
        //testEmployeeLogin();

        Parent root = FXMLLoader.load(getClass().getResource("Title.fxml"));
        primaryStage.setTitle("Product Line");
        primaryStage.setScene(new Scene(root, 750, 750));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    // https://medium.com/@keeptoo/adding-data-to-javafx-tableview-stepwise-df582acbae4f


    public static void testMultimedia() {
        AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
                "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
        Screen newScreen = new Screen("720x480", 40, 22);
        MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
                MonitorType.LCD);
        ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
        productList.add(newAudioProduct);
        productList.add(newMovieProduct);
        for (MultimediaControl p : productList) {
            System.out.println(p);
            p.play();
            p.stop();
            p.next();
            p.previous();
        }
    }

    public static void testProductionLog() {

        Product productProduced = new Widget("iPod", "Apple", ItemType.AUDIO);

        // test constructor used when creating production records from user interface
        int numProduced = 3;  // this will come from the combobox in the UI
        int itemCount = 0;

        for (int productionRunProduct = 0; productionRunProduct < numProduced; productionRunProduct++) {
            ProductionRecord pr = new ProductionRecord(productProduced, itemCount++);
            // using the iterator as the product id for testing
            System.out.println(pr.toString());
        }
    }
    public static void testEmployeeLogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Employee Name (first last)");
        String name = scan.nextLine();
        System.out.println("Enter Employee password");
        String password = scan.nextLine();
        Employee employee = new Employee(name, password);
        System.out.println(employee);
    }
}

