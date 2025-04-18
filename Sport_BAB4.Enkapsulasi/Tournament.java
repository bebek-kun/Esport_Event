/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sport;

/**
 *
 * @author ACER
 */
public class Tournament extends EsportEvent {
    private int numberOfTeams;
    private String prizePool;

    public Tournament(String eventName, String game, String date, String location, int numberOfTeams, String prizePool) {
        super(eventName, game, date, location);
        this.numberOfTeams = numberOfTeams;
        this.prizePool = prizePool;
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

    // Override method untuk menampilkan detail event
    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Number of Teams : " + numberOfTeams);
        System.out.println("Prize Pool      : " + prizePool);
        System.out.println("===============================");
    }
}
