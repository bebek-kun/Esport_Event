/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sport;

/**
 *
 * @author ACER
 */
public class Sport_EsportEventScheduler {
        public static void main(String[] args) {
        // Membuat objek event E-sport
        EsportEvent event1 = new EsportEvent("Valorant Championship", "Valorant", "25 Maret 2025", "Jakarta Convention Center");
        EsportEvent event2 = new EsportEvent("Dota 2 Battle", "Dota 2", "10 April 2025", "Bali Nusa Dua Hall");

        // Menampilkan detail event
        event1.displayEventDetails();
        event2.displayEventDetails();
    }
}
