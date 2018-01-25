/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleShip;


import java.util.ArrayList;


/**
 *
 * @author Spectra
 */
public class Game {

    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        SimpleDotCom google = new SimpleDotCom();
        SimpleDotCom bing = new SimpleDotCom();
        SimpleDotCom youtube = new SimpleDotCom();
        SimpleDotCom netflix = new SimpleDotCom();
        SimpleDotCom yahoo = new SimpleDotCom();

        google.setLocationCells(helper.placeDotCom(4).toArray(new String[0]));
        bing.setLocationCells(helper.placeDotCom(4).toArray(new String[0]));
        youtube.setLocationCells(helper.placeDotCom(4).toArray(new String[0]));
        netflix.setLocationCells(helper.placeDotCom(4).toArray(new String[0]));
        yahoo.setLocationCells(helper.placeDotCom(4).toArray(new String[0]));
        ArrayList<String> guesses = new ArrayList<String>();
        //SimpleDotCom theDotCom = new SimpleDotCom();
        //int randomNum = (int) (Math.random() * 5);

        helper.placeDotCom(4);
        System.out.println("Your goal is th sink the 5 .COM's.\nDo it in as few guesses as possible.");
        System.out.println("Board layout:");
        System.out.println("   A  B  C  D  E  F  G  H  I  J");
        System.out.println("1  *  *  *  *  *  *  *  *  *  *");
        System.out.println("2  *  *  *  *  *  *  *  *  *  *");
        System.out.println("3  *  *  *  *  *  *  *  *  *  *");
        System.out.println("4  *  *  *  *  *  *  *  *  *  *");
        System.out.println("5  *  *  *  *  *  *  *  *  *  *");
        System.out.println("6  *  *  *  *  *  *  *  *  *  *");
        System.out.println("7  *  *  *  *  *  *  *  *  *  *");
        System.out.println("8  *  *  *  *  *  *  *  *  *  *");
        System.out.println("9  *  *  *  *  *  *  *  *  *  *");
        System.out.println("10 *  *  *  *  *  *  *  *  *  *\n");

        boolean isAlive = true;
        while (isAlive == true) {
            boolean step = false;
            String dotcom = "";
            String result = "miss";
            String guess = helper.getUserInput("enter a number");
            for (String g : guesses) {
                if (g.equals(guess)) {
                    System.out.println("You have already guessed that...");
                    step = true;
                }
            }
            if (step == false) {
                guesses.add(guess);
                if (result.equals("miss")) {
                    result = google.checkYourself(guess);
                    dotcom = "Google ";
                }
                if (result.equals("miss")) {
                    result = bing.checkYourself(guess);
                    dotcom = "Bing ";
                }
                if (result.equals("miss")) {
                    result = youtube.checkYourself(guess);
                    dotcom = "Youtube ";
                }
                if (result.equals("miss")) {
                    result = netflix.checkYourself(guess);
                    dotcom = "Netflix ";
                }
                if (result.equals("miss")) {
                    result = yahoo.checkYourself(guess);
                    dotcom = "Yahoo ";
                }
                if (result.equals("miss")) {
                    System.out.println(result);
                } else {
                    System.out.println(dotcom + result);
                }
                numOfGuesses++;
                int kills = 0;
                if (result.equals("killed")) {
                    kills++;
                }
                if (kills == 5) {
                    isAlive = false;
                    System.out.println("You Win!\nYou took " + numOfGuesses + " guesses");
                }
            }
        }
    }
}
