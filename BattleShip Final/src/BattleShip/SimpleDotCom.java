/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleShip;

/**
 *
 * @author Spectra
 */
public class SimpleDotCom {
     String[] locationCells;
    int numOfHits = 0;
    
    public void setLocationCells(String[] locs)
    {
        locationCells = locs;
    }
    
    public String checkYourself(String stringGuess) {
        String guess = stringGuess;
        String result = "miss";
        for (String cell: locationCells)
        {
            if (guess.equals(cell)) {
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length)
        {
            result = "killed";
            numOfHits++;
        }
        else if (numOfHits == locationCells.length+1)
        {
            result="miss";
        }
        
        return result;
    }
}
