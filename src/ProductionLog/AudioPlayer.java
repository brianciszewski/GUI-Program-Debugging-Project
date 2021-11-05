package ProductionLog;

public class AudioPlayer extends Product implements MultimediaControl {

    String SupportedAudioFormats;
    String SupportedPlaylistFormats;

    String Name;
    String Manufacturer;
    String Type;
    String type = "AUDIO";

    /**
     *
     * @param name
     * @param manufacturer
     * @param supportedAudioFormats
     * @param supportedPlaylistFormats
     */
    public AudioPlayer(
            String name,
            String manufacturer,
            String supportedAudioFormats,
            String supportedPlaylistFormats) {

        this.Name = name;
        this.Manufacturer = manufacturer;
        this.Type = type;
        this.SupportedAudioFormats = supportedAudioFormats;
        this.SupportedPlaylistFormats = supportedPlaylistFormats;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "Name: "
                + Name
                + "\n"
                + "Manufacturer: "
                + Manufacturer
                + "\n"
                + "Type: "
                + Type
                + "\n"
                + "Supported Audio Formats: "
                + SupportedAudioFormats
                + "\n"
                + "Supported Playlist Formats: "
                + SupportedPlaylistFormats;
    }


    /**
     *
     */
    public void play() {
        System.out.println("Playing");
    }

    /**
     *
     */
    public void stop() {
        System.out.println("Stopping");
    }

    /**
     *
     */
    public void next() {
        System.out.println("Next");
    }

    /**
     *
     */
    public void previous() {
        System.out.println("Previous");
    }
}
