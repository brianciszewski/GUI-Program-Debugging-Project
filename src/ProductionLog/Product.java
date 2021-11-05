package ProductionLog;

abstract class Product extends Main implements Item {

    private ItemType Type;
    public String Manufacturer;
    private String Name;
    Integer Id;

    Product(String name, String manufacturer, ItemType type, Integer id) {
        this.Name = name;
        this.Manufacturer = manufacturer;
        this.Type = type;
        this.Id= id;
    }

    public Product(String name, String manufacturer, ItemType type) {
        this.Name = name;
        this.Manufacturer = manufacturer;
        this.Type = type;
    }

    Product(ItemType type) {
        this.Type = type;
    }

    protected Product() {
    }

    public String toString() {
        return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: " + Type;
    }


    public Integer getId() {
        return Id;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ItemType getType() {
        return Type;
    }

}
