/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sport;

/**
 *
 * @author ACER
 */
public class FriendlyMatch extends EsportEvent {
    private String matchType;
    private String difficultyLevel;

    public FriendlyMatch(String eventName, String game, String date, String location, String matchType, String difficultyLevel) {
        super(eventName, game, date, location);
        this.matchType = matchType;
        this.difficultyLevel = difficultyLevel;
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

    // Override method untuk menampilkan detail event
    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Match Type      : " + matchType);
        System.out.println("Difficulty Level: " + difficultyLevel);
        System.out.println("===============================");
    }
}
