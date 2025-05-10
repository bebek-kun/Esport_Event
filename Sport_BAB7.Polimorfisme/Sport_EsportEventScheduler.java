package Sport;

public class Sport_EsportEventScheduler {
    public static void main(String[] args) { 
        EsportEvent[] events = new EsportEvent[3];

        events[0] = new PublicEvent("Valorant Championship", "Valorant", "25 Maret 2025", "Jakarta Convention Center");
        events[1] = new Tournament("Dota 2 Battle", "Dota 2", "10 April 2025", "Bali Nusa Dua Hall", 16, "$500,000");
        events[2] = new FriendlyMatch("FIFA Friendly Match", "FIFA 24", "5 Mei 2025", "Bandung Arena", "1v1", "Medium");

        for (EsportEvent e : events) {
            e.displayEventDetails();  // Dynamic Polymorphism
        }

        // Static Polymorphism (Overloading)
        System.out.println("\n=== Overloaded Display with Note ===");
        events[1].displayEventDetails("This is a major event with international teams.");

        if (events[1] instanceof Tournament) {
            ((Tournament) events[1]).displayEventDetails(3); // overload dengan int
        }
    }
}
