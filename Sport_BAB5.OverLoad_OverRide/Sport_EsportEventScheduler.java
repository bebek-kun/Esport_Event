package Sport;

public class Sport_EsportEventScheduler {
    public static void main(String[] args) {
        // Membuat objek event E-sport
        EsportEvent event1 = new EsportEvent("Valorant Championship", "Valorant", "25 Maret 2025", "Jakarta Convention Center");
        Tournament event2 = new Tournament("Dota 2 Battle", "Dota 2", "10 April 2025", "Bali Nusa Dua Hall", 16, "$500,000");
        FriendlyMatch event3 = new FriendlyMatch("FIFA Friendly Match", "FIFA 24", "5 Mei 2025", "Bandung Arena", "1v1", "Medium");

        // Menampilkan detail event
        event1.displayEventDetails();
        event2.displayEventDetails();
        event3.displayEventDetails();
    }
}
