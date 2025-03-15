/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sport;

/**
 *
 * @author ACER
 */
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

    // Method untuk menampilkan detail event
    public void displayEventDetails() {
        System.out.println("===== E-Sport Event Details =====");
        System.out.println("Event Name  : " + eventName);
        System.out.println("Game        : " + game);
        System.out.println("Date        : " + date);
        System.out.println("Location    : " + location);
        System.out.println("===============================");
    }
}
