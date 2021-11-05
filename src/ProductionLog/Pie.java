package ProductionLog;

public class Pie {

    private String Name;
    private String Manufacturer;
    private String Type;

    Pie(String name, String type, String manufacturer) {
        this.Name = name;
        this.Manufacturer = manufacturer;
        this.Type = type;
    }

    public String toString() {
        return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: " + Type;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public String getName() {
        return Name;
    }


    public String getType() {
        return Type;
    }
}
