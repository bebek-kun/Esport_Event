package Sport;

public class Tournament extends EsportEvent {
    private int numberOfTeams;
    private String prizePool;

    public Tournament(String eventName, String game, String date, String location, int numberOfTeams, String prizePool) {
        super(eventName, game, date, location);
        this.numberOfTeams = numberOfTeams;
        this.prizePool = prizePool;
    }

    // Overloaded constructor
    public Tournament(String eventName, String game, int numberOfTeams) {
        super(eventName, game);
        this.numberOfTeams = numberOfTeams;
        this.prizePool = "TBA";
    }

    // Getter dan Setter
    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(String prizePool) {
        this.prizePool = prizePool;
    }

    // Override method
    @Override
    public void displayEventDetails() {
    System.out.println("===== Tournament Event Details =====");
    System.out.println("Event Name     : " + getEventName());
    System.out.println("Game           : " + getGame());
    System.out.println("Date           : " + getDate());
    System.out.println("Location       : " + getLocation());
    System.out.println("Number of Teams: " + numberOfTeams);
    System.out.println("Prize Pool     : " + prizePool);
    System.out.println("====================================");
    }

    // Overloaded method
    public void displayEventDetails(boolean showPrizeOnly) {
        if (showPrizeOnly) {
            System.out.println("Prize Pool Only : " + prizePool);
        } else {
            displayEventDetails();
        }
    }
}
