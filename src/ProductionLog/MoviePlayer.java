package ProductionLog;

public class MoviePlayer extends Product implements MultimediaControl {

  MonitorType MonitorType;
  String Name;
  String screen;
  String monitorType;
  Screen newScreen = new Screen("720x480", 40, 22);
  ItemType itemType;

  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.MonitorType = monitorType;
    this.itemType = ItemType.VISUAL;
  }

  public String toString() {

    return "Name: "
        + Name
        + "\n"
        + "Manufacturer: "
        + Manufacturer
        + "\n"
        + "Type: "
        + itemType
        + "\n"
        + newScreen.toString()
        + "\n"
        + "Monitor type: "
        + MonitorType;
  }


  @Override
  public void play() {
    System.out.println("Playing Movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping Movie");
  }

  @Override
  public void next() {
    System.out.println("Next Movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous Movie");
  }
}
