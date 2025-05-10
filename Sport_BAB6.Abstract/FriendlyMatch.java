package Sport;

public class FriendlyMatch extends EsportEvent {
    private String matchType;
    private String difficultyLevel;

    public FriendlyMatch(String eventName, String game, String date, String location, String matchType, String difficultyLevel) {
        super(eventName, game, date, location);
        this.matchType = matchType;
        this.difficultyLevel = difficultyLevel;
    }

    // Overloaded constructor
    public FriendlyMatch(String eventName, String game, String matchType) {
        super(eventName, game);
        this.matchType = matchType;
        this.difficultyLevel = "Normal";
    }

    // Getter dan Setter
    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    // Override method
    @Override
    public void displayEventDetails() {
    System.out.println("===== Friendly Match Details =====");
    System.out.println("Event Name      : " + getEventName());
    System.out.println("Game            : " + getGame());
    System.out.println("Date            : " + getDate());
    System.out.println("Location        : " + getLocation());
    System.out.println("Match Type      : " + matchType);
    System.out.println("Difficulty Level: " + difficultyLevel);
    System.out.println("==================================");
    }

    // Overloaded method
    public void displayEventDetails(String sponsor) {
        displayEventDetails();
        System.out.println("Sponsored By    : " + sponsor);
        System.out.println("===============================");
    }
}
