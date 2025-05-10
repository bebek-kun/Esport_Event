package Sport;

public class FriendlyMatch extends EsportEvent {
    private String mode;
    private String difficulty;

    public FriendlyMatch(String eventName, String game, String date, String location, String mode, String difficulty) {
        super(eventName, game, date, location);
        this.mode = mode;
        this.difficulty = difficulty;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("=== Friendly Match Details ===");
        System.out.println("Event Name : " + getEventName());
        System.out.println("Game       : " + getGame());
        System.out.println("Date       : " + getDate());
        System.out.println("Location   : " + getLocation());
        System.out.println("Mode       : " + mode);
        System.out.println("Difficulty : " + difficulty);
        System.out.println("===============================");
    }
}
