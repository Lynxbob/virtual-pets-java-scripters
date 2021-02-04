package virtual_pet;

public class OrganicVirtualDog extends OrganicVirtualPet implements Walkable{
    private int walkModifier;

    public OrganicVirtualDog(String name) {
        super(name);
        walkModifier=1;

    }

    //walkModifier to increase dog cage cleanliness when taken on a walk
    @Override
    public void walk() {
       boredom -=50;
       if (boredom<0){
           boredom=0;
       }
       walkModifier=2;
    }
    @Override
    public void clean() {
        super.clean();
        System.out.println("You cleaned " + name + "'s cage.");
    }

    @Override
    public void isDeadCheck() {
        super.isDeadCheck();
        if(cageCleanliness > 40) {
            deathModifier = 1;
        }
        else if(cageCleanliness <= 40 && cageCleanliness > 0) {
            System.out.println("Your dog " + name + "'s cage is starting to become very dirty.");
            deathModifier = 2;
        }
        else if(cageCleanliness <= 0) {
            System.out.println("Your dog " + name + "'s cage is filthy and needs cleaned immediately.");
            deathModifier = 5;
            cageCleanliness = 0;
        }

    }

    @Override
    public void status() {
        super.status();
        cageStatus();
    }

    public void cageStatus() {
        if (cageCleanliness <= 100 && cageCleanliness >= 80) {
            System.out.println(name + "'s cage is in good condition.");
        } else if (cageCleanliness < 80 && cageCleanliness >= 50) {
            System.out.println(name + "'s cage is relatively clean.");
        } else if (cageCleanliness < 50 && cageCleanliness >= 30) {
            System.out.println(name + "'s cage is starting to become very dirty.");
        } else {
            System.out.println(name + "'s cage is filthy and needs cleaned immediately.");
        }

    }
    @Override
    public void tick() {
        health -= 4 * deathModifier;
        hunger += 4 * deathModifier;
        thirst += 4 * deathModifier;
        boredom += 4 * deathModifier;
        cageCleanliness -= 10 / walkModifier;
        isDeadCheck();
        walkModifier=1;

    }
    @Override
    public String toString() {
        return "Dog: " + name;
    }


}
