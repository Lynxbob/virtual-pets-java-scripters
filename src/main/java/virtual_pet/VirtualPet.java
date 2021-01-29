package virtual_pet;

public class VirtualPet {

    private String name;
    private int age;
    private int health, hunger, thirst, boredom;
    private boolean isDead;

    public VirtualPet(String name) {
        this.name = name;
        this.age = 0;
        this.hunger = 0;
        this.health = 100;
        this.thirst = 0;
        this.boredom = 0;
        this.isDead = false;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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

//Altenative code
// hunger-= 30;
// if(hunger<0){
// hunger=0;


    public void eat() {
        if (hunger < 30) {
            hunger -= hunger;
        } else {
            hunger -= 30;
        }
    }

    public void play() {
        if (boredom < 30) {
            boredom -= boredom;
        } else {
            boredom -= 30;
        }

    }

    public void bath() {
        if (health > 70) {
            health = 100;
        } else {
            health += 30;
        }

    }

    public void drink() {
        if (thirst < 30) {
            thirst -= thirst;
        } else {
            thirst -= 30;
        }

    }

    public void status() {
        if (health <= 100 && health >= 80) {
            System.out.println(name + " is feeling healthy");
        } else if (health < 80 && health >= 50) {
            System.out.println(name + " is feeling okay");
        } else if (health < 50 && health >= 30) {
            System.out.println(name + " is feeling sick");
        } else {
            System.out.println(name + " need medical attention");
        }
        if (boredom >= 80) {
            System.out.println(name + " is very bored at home");
        } else if (boredom < 80 && boredom >= 50) {
            System.out.println(name + " wants to go outside");
        } else if (boredom < 50 && boredom >= 30) {
            System.out.println(name + " enjoys playing with you");
        } else {
            System.out.println(name + " is feeling super excited");
        }
        if (hunger >= 80) {
            System.out.println(name + " is starving");
        } else if (hunger < 80 && hunger >= 50) {
            System.out.println(name + " is hungry");
        } else if (hunger < 50 && hunger >= 30) {
            System.out.println(name + " is not very hungry");
        } else {
            System.out.println(name + " is full");
        }
        if (thirst >= 80) {
            System.out.println(name + " is very dehydrated");
        } else if (thirst < 80 && thirst >= 50) {
            System.out.println(name + " is thirsty");
        } else if (thirst < 50 && thirst >= 30) {
            System.out.println(name + " is not very thirsty");
        } else {
            System.out.println(name + " is hydrated");


        }
    }
}



