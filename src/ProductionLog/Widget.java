package ProductionLog;

public class Widget<Manufacturer, Type, Name> extends Product {

    Widget(String name, String manufacturer, ItemType type, Integer id) {
        super(name, manufacturer, type,id);
    }
    Widget(String name,String manufacturer, ItemType type) {super(name,manufacturer,type);}

}