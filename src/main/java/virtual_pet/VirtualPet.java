package virtual_pet;

public class VirtualPet {

    protected String name;
    protected int health, hunger, thirst, boredom;
    protected boolean isDead;

    public VirtualPet(String name) {
        this.name = name;
        this.hunger = getRandomValueForStat();
        this.health = getRandomValueForStat();
        this.thirst = getRandomValueForStat();
        this.boredom = getRandomValueForStat();
        this.isDead = false;

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public boolean isDead() {
        return isDead;
    }

    //this would never be used anywhere except here so set to private
    //generates random values for the stats so they dont default to max
    protected int getRandomValueForStat() {
       return (int)(Math.random() * (80) + 10);
    }
    public void isDeadCheck() {
        if (health <= 0) {
            System.out.println("Your pet " + name + " died of sickness.");
            isDead = true;
        } else if (hunger >= 100) {
            System.out.println("Your pet " + name + " died of starvation.");
            isDead = true;
        } else if (thirst >= 100) {
            System.out.println("Your pet " + name + " died of dehydration.");
            isDead = true;
        } else if (boredom >= 100) {
            System.out.println("Your pet " + name + " ran away because of boredom!");
            isDead = true;
        }
    }


    public void tick() {
        health -= 10;
        hunger += 10;
        thirst += 10;
        boredom += 10;
        isDeadCheck();
    }





    public void eat() {
        hunger -= 30;
        if( hunger < 0 ) {
            hunger = 0;
        }
    }

    public void play() {
        boredom -= 30;
        if( boredom < 0 ) {
            boredom = 0;
        }
    }

    public void bath() {
        health += 30;
        if( health > 100 ) {
            health = 100;
        }
    }

    public void drink() {
        thirst -= 30;
        if( thirst < 0 ) {
            thirst = 0;
        }

    }

    public void status() {
        healthStatus();
        hungerStatus();
        thirstStatus();
        boredomStatus();
    }

    public void healthStatus() {
        if (health <= 100 && health >= 80) {
            System.out.println(name + " is feeling healthy.");
        } else if (health < 80 && health >= 50) {
            System.out.println(name + " is feeling okay.");
        } else if (health < 50 && health >= 30) {
            System.out.println(name + " is feeling sick.");
        } else {
            System.out.println(name + " needs medical attention.");
        }
    }
    public void hungerStatus() {
        if (hunger >= 80) {
            System.out.println(name + " is starving.");
        } else if (hunger < 80 && hunger >= 50) {
            System.out.println(name + " is hungry.");
        } else if (hunger < 50 && hunger >= 30) {
            System.out.println(name + " is not very hungry.");
        } else {
            System.out.println(name + " is full.");
        }

    }
    public void thirstStatus() {
        if (thirst >= 80) {
            System.out.println(name + " is very dehydrated.");
        } else if (thirst < 80 && thirst >= 50) {
            System.out.println(name + " is thirsty.");
        } else if (thirst < 50 && thirst >= 30) {
            System.out.println(name + " is not very thirsty.");
        } else {
            System.out.println(name + " is hydrated.");
        }
    }
    public void boredomStatus() {
        if (boredom >= 80) {
            System.out.println(name + " is very bored at home.");
        } else if (boredom < 80 && boredom >= 50) {
            System.out.println(name + " wants to go outside.");
        } else if (boredom < 50 && boredom >= 30) {
            System.out.println(name + " enjoys playing with you.");
        } else {
            System.out.println(name + " is feeling super excited.");
        }

    }

    //defaults pet name as the toString
    @Override
    public String toString() {
        return name;
    }
}



