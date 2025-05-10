package Sport;

public class PublicEvent extends EsportEvent {

    public PublicEvent(String eventName, String game, String date, String location) {
        super(eventName, game, date, location);
    }

    @Override
    public void displayEventDetails() {
        System.out.println("=== Public E-sport Event ===");
        System.out.println("Event Name : " + getEventName());
        System.out.println("Game       : " + getGame());
        System.out.println("Date       : " + getDate());
        System.out.println("Location   : " + getLocation());
        System.out.println("=============================");
    }
}

