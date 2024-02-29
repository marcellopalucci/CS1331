package Homework_JavaFC;

import java.util.Arrays;

public class Player {
    private String playerName;
    private int stamina;
    private Position [] positions;
    private int skillRating;
    public Player(String playerName, int stamina, Position [] positions, int skillRating){
        this.playerName = playerName;
        this.stamina = stamina <= 100 && stamina >= 0 ? stamina : 75;
        this.positions = positions.length != 0 ? positions : new Position[]{Position.MIDFIELDER};
        this.skillRating = skillRating <= 100 && skillRating >= 40? skillRating : 80;
        printSkillRating();
    }
    public Player (String playerName, Position [] positions){
        this.playerName = playerName;
        this.positions = positions.length != 0 ? positions : new Position[]{Position.MIDFIELDER};
        this.stamina = 75;
        this.skillRating = 80;
        printSkillRating();
    }
    public Player(){
        this.playerName = "Lionel Messi";
        this.stamina = 75;
        this.positions = new Position[]{Position.FORWARD};
        this.skillRating = 100;
        printSkillRating();
    }

    public boolean isTrainable(){
        if (this.skillRating >= 50 && this.skillRating <= 89){
            return true;
        } else {
            return false;
        }
    }
    public Position preferredPosition(){
        return this.positions[0];
    }
    public boolean canPlayAs(Position position){
        for(int i = 0; i < positions.length; i++){
            if (position == positions[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("<%s, %d, %s, %s, %b>", playerName, stamina, preferredPosition(), skillRating, isTrainable());
    }

    private void printSkillRating(){
        System.out.printf("Skill rating: ");
        if (this.skillRating >= 90 && this.skillRating <= 100){
            System.out.println("Excellent");
        } else if (this.skillRating >= 80 && this.skillRating <= 89) {
            System.out.println("Great");
        } else if (this.skillRating >= 70 && this.skillRating <= 79) {
            System.out.println("Very good");
        } else if (this.skillRating >= 60 && this.skillRating <= 69) {
            System.out.println("Good");
        } else if (this.skillRating >= 50 && this.skillRating <= 59){
            System.out.println("Fine");
        } else {
            System.out.println("Bad");
        }

    }
/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

    public void setSkillRating(int skillRating) {
        this.skillRating = skillRating;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getStamina() {
        return stamina;
    }

    public Position[] getPositions() {
        for (int i = 0; i < this.positions.length; i++){
            System.out.println(this.positions[i]);
        }
        return positions;
    }

    public int getSkillRating() {
        return skillRating;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
