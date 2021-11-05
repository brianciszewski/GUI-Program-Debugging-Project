package ProductionLog;

public class Screen extends Main implements ScreenSpec {

  String resolution;
  int refreshrate;
  int responsetime;

  public Screen(String s, int i, int i1) {
    this.resolution = s;
    this.refreshrate = i;
    this.responsetime = i1;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshrate;
  }

  @Override
  public int getResponseTime() {
    return responsetime;
  }

  public String toString() {
    return "Resolution: "
        + resolution
        + "\n"
        + "Refresh rate: "
        + refreshrate
        + "\n"
        + "Response time: "
        + responsetime;
  }
}
