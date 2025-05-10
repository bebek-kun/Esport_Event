package Sport;

public abstract class EsportEvent {
    private String eventName;
    private String game;
    private String date;
    private String location;

    // Constructor
    public EsportEvent(String eventName, String game, String date, String location) {
        this.eventName = eventName;
        this.game = game;
        this.date = date;
        this.location = location;
    }

    // Overloading Constructor
    public EsportEvent(String eventName, String game) {
        this(eventName, game, "TBA", "TBA");
    }

    // Getter dan Setter
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Abstract Method (wajib di-override oleh subclass)
    public abstract void displayEventDetails();

    // Overloaded method
    public void displayEventDetails(String additionalInfo) {
        displayEventDetails();
        System.out.println("Note        : " + additionalInfo);
        System.out.println("=================================");
    }
}
