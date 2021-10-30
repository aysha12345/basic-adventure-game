package uoa.assignment1.character;

import java.util.Random;

public class Monster extends GameCharacter {
    
    private Random rand = new Random();

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
        if (Monster.successfulDefense() == false) {
            character.setHealth(character.getHealth() - 20);
        }
	}

	
	public boolean successfulDefense() {
        int chance = rand.nextInt(2);
        if(chance == 0) {
            return false;
        } else {
            return true;
        }		  
	}


	
	public String decideMove () {
		
		return "move";
	}

}

