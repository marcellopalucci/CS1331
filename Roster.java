package Homework_JavaFC;
import java.util.Arrays;
import java.util.Random;

public class Roster {
    private Player[] players;
    private int size;
    public Roster(Player[] players){
        this.players = players;
        int playerCounter = 0;
        for (int i = 0; i < players.length; i++){
            if (players[i] != null){
                playerCounter++;
            }
        }
        this.size = playerCounter;
    }
    public Roster(){
        this.players = new Player[4];
    }
    public void signPlayer(int index, Player player){
        if (this.players[index] != null){
            System.out.printf("Replaced: %s \n", players[index].getPlayerName());
            this.players[index] = player;
            System.out.printf("Signed: %s \n", players[index].getPlayerName());
        } else if (index < 0 || index >= players.length || player == null) {
            System.out.println("Cannot add a player to this spot on the roster");
        }
    }

    public void transferPlayer(int index){
        System.out.println("Transferred: " + players[index].getPlayerName());

    }
    public void showBestPlayers(int skillRatingCheck){
        for(int i = 0; i < this.players.length; i ++){
            if (this.players[i].getSkillRating() > skillRatingCheck) {
                System.out.println(this.players[i]);
            }
        }
    }
    public void trainAllPlayers(){
        Random rand = new Random();
        boolean newlyTrainedPlayers = false;
        for (int i = 0; i < this.players.length; i++){
            if (players[i].isTrainable()){
                players[i].setSkillRating(players[i].getSkillRating() + (rand.nextInt(10) + 1));
                System.out.println("Trained to " + players[i].getSkillRating() + ": " + this.players[i].getPlayerName());
                newlyTrainedPlayers = true;
            }
        }
        if (newlyTrainedPlayers = false)
            System.out.println("There were no new players to train");
    }
    public void play(int index, Position position){
        Random rand = new Random();
        if (this.players[index].preferredPosition().equals(position)){
            this.players[index].setStamina(this.players[index].getStamina() - (rand.nextInt(5) + 1));
        } else if (this.players[index].canPlayAs(position)){
            this.players[index].setStamina(this.players[index].getStamina() - (rand.nextInt(6) + 5));
        } else if (!this.players[index].canPlayAs(position)) {
            System.out.println("This player cannot be played in position " + position);
            return;
        }
        if (this.players[index].getStamina() < 0)
            this.players[index].setStamina(0);
        System.out.println("Played: " + players[index].getPlayerName());

        if (index < 0 || index > players.length || players[index] == null)
            System.out.println("Cannot play the player in this spot");
    }

    @Override
    public String toString() {
        if (this.players.length == 0)
            return "The team has no players";

        String rosterString = String.format("There are %d players on Java FC.\n", size);
        for (int i = 0; i < players.length; i ++){
            rosterString += String.format("%s\n", players[i]);
        }
        return rosterString;
    }

    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    public void printRoster(){
        for(int i = 0; i < this.players.length; i++){
            System.out.println(this.players[i].getPlayerName());
        }

    }
}
