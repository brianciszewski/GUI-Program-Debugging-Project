package ProductionLog;

import java.sql.Timestamp;

public class ProductionRecord {

    Timestamp dateProduced;
    int productionNumber;
    int productID;
    public static String serialNumber = "0";




    public ProductionRecord(int productionNumber, int id, String serialNumber, Timestamp date) {
        this.productionNumber = productionNumber;
        this.productID = id;
        this.serialNumber = serialNumber;
        this.dateProduced = date;

    }
// https://stackoverflow.com/questions/473282/how-can-i-pad-an-integer-with-zeros-on-the-left

    public ProductionRecord(Product productProduced, int i) {
        String part1 = productProduced.getManufacturer().substring(0, 3);
        String part2 = productProduced.getType().itemType();
        String part3 = String.format("%05d", i);
        this.serialNumber = part1 + part2 + part3;
    }


    public ProductionRecord(Widget productProduced, int counter) {

            String part1 = productProduced.getManufacturer().substring(0, 3);
            String part2 = productProduced.getType().itemType();
            int i2 = Integer.parseInt(String.valueOf(counter));
            String part3 = String.format("%05d", i2);
            this.serialNumber = part1 + part2 + part3;
    }


    public String toString() {
        return "Prod. Num: "
                + productionNumber
                + " Product ID: "
                + productID
                + " Serial Num: "
                + serialNumber
                + " Date: "
                + dateProduced;
    }

    public void setProductionNum(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    public int getProductionNum() {
        return productionNumber;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public static String getSerialNum() {
        return serialNumber;
    }

    public void setSerialNum(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Timestamp getProdDate() {
        return dateProduced;
    }

    public void setProdDate(Timestamp dateProduced) {
        this.dateProduced = dateProduced;
    }
}
