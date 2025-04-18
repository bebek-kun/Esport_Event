package Sport;

public class EsportEvent {
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

    // Method untuk menampilkan detail event
    public void displayEventDetails() {
        System.out.println("===== E-Sport Event Details =====");
        System.out.println("Event Name  : " + eventName);
        System.out.println("Game        : " + game);
        System.out.println("Date        : " + date);
        System.out.println("Location    : " + location);
        System.out.println("=================================");
    }
}


