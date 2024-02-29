package Homework_JavaFC;

import static Homework_JavaFC.Position.*;

public class TestMain {
    public static void main(String[] args) {
        Player player1 = new Player("Marcello", 100, new Position[]{Position.FORWARD, Position.DEFENDER}, 83 );
        Player player2 = new Player("Jack", 100, new Position[]{GOALKEEPER, Position.DEFENDER}, 65 );
        Player player3 = new Player();
        System.out.println(player1.getPlayerName());
        System.out.println(player1.getPositions());
        System.out.println(player1.getStamina());
        System.out.println(player1.isTrainable());
        System.out.println(player1.preferredPosition());
        System.out.println("Player can play as " + player1.canPlayAs(FORWARD));
        System.out.println(player1.toString());
        Roster roster = new Roster(new Player[]{player1, player2});
        //roster.signPlayer(1, player3);
        roster.showBestPlayers(80);
        roster.trainAllPlayers();
        roster.play(1, GOALKEEPER);
        roster.play(0, GOALKEEPER);
        System.out.println(player1.getStamina());
        System.out.println(roster.toString());
    }
}
