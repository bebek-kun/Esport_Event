package Sport;

public abstract class EsportEvent {
    private String eventName;
    private String game;
    private String date;
    private String location;

    // Constructor
    public EsportEvent(String eventName, String game, String date, String location) {
        setEventName(eventName);
        setGame(game);
        setDate(date);
        setLocation(location);
    }

    // Overloaded Constructor
    public EsportEvent(String eventName, String game) {
        this(eventName, game, "TBA", "TBA");
    }

    // Getter dan Setter
    public String getEventName() { return eventName; }

    public void setEventName(String eventName) {
        if (eventName == null || eventName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama event tidak boleh kosong.");
        }
        this.eventName = eventName;
    }

    public String getGame() { return game; }

    public void setGame(String game) {
        if (game == null || game.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama game tidak boleh kosong.");
        }
        this.game = game;
    }

    public String getDate() { return date; }

    public void setDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Tanggal tidak boleh kosong.");
        }
        this.date = date;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Lokasi tidak boleh kosong.");
        }
        this.location = location;
    }

    // Abstract Method
    public abstract void displayEventDetails();

    // Overloaded method
    public void displayEventDetails(String additionalInfo) {
        displayEventDetails();
        System.out.println("Note        : " + additionalInfo);
        System.out.println("=================================");
    }
}
