package uoa.assignment1.game;

import java.util.Scanner;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Player;
import uoa.assignment1.character.Monster;

public class GameLogic {
    

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
        //code for input.equals from:https://coderanch.com/t/572326/java/Testing-string-scanner-input-statement
        if (input.equals("up")) {
            moveUp(character, gameMap);
        }
        
        else if (input.equals("down")) {
            moveDown(character, gameMap);
        }
        
        else if (input.equals("left")) {
            moveLeft(character, gameMap);
        }
        
        else if (input.equals("right")) {
            moveRight(character, gameMap);
        }
        
        else {
            System.out.println("Use only keywords up, down, left, right");            
        }
        if (character == gameMap.characters[3]) {
            gameMap.printLayout();
        }        
	}
    
    private static void moveUp(GameCharacter character, Map gameMap) {
        if (character.row == 0) {
            System.out.println("You can't go up. You lose a move.");
        }
        else {
            gameMap.getArray();
            //code to prevent NullPointerException from: https://en.wikibooks.org/wiki/Java_Programming/Preventing_NullPointerException#:~:text=NullPointerException%20is%20a%20RuntimeException%20.,referred%20by%20a%20null%20reference.
            if ("%".equals(gameMap.layout[character.row][character.column]) && "%".equals(gameMap.layout[character.row - 1][character.column])) {
                System.out.println("Monster already there so can't move");
            }
            else {
                if ("*".equals(gameMap.layout[character.row][character.column]) && "%".equals(gameMap.layout[character.row - 1][character.column])) {
                    character.hurtCharacter(gameMap.characters[]);
                }
                character.row -= 1;
                gameMap.getArray(); 
            }          
        }
    }       
     
    private static void moveDown(GameCharacter character, Map gameMap) {
        if (character.row == gameMap.layout.length - 1) {
            System.out.println("You can't go down. You lose a move.");
        }
        else {
            gameMap.getArray();
            if ("%".equals(gameMap.layout[character.row][character.column]) && "%".equals(gameMap.layout[character.row + 1][character.column])) {
                System.out.println("Monster already there so can't move");
            }
            else {
                character.row += 1;
                gameMap.getArray();
            }
        }
    }                      
    
     private static void moveRight(GameCharacter character, Map gameMap) {
         if (character.column == gameMap.layout[0].length - 1) {
             System.out.println("You can't go right. You lose a move.");
         }
         else {
             gameMap.getArray();
             if ("%".equals(gameMap.layout[character.row][character.column]) && "%".equals(gameMap.layout[character.row][character.column + 1])) {
                 System.out.println("Monster already there so can't move");
             }
             else {
                 character.column += 1;
                 gameMap.getArray(); 
             }
         }
     }                           
   
    private static void moveLeft(GameCharacter character, Map gameMap) {
        if (character.column == 0) {
            System.out.println("You can't go left. You lose a move.");
        }
        else {
            gameMap.getArray();
            if ("%".equals(gameMap.layout[character.row][character.column]) && "%".equals(gameMap.layout[character.row][character.column - 1])) {
                System.out.println("Monster already there so can't move");
            }
            else {
                character.column -= 1;
                gameMap.getArray();
            }
        }
    }
}

