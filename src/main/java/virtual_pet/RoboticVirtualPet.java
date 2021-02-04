package virtual_pet;

public abstract class RoboticVirtualPet extends VirtualPet {
    protected int oilLevel;


    public RoboticVirtualPet(String name) {
        super(name);
        oilLevel = getRandomValueForStat();
    }

    public void setOilLevel(int oilLevel) {
        this.oilLevel = oilLevel;
    }

    public void oil() {
        oilLevel += 40;
        if (oilLevel > 100) {
            oilLevel = 100;
        }

    }

    @Override
    public void tick() {
        oilLevel -= 4;
        health -= 4;
        hunger += 4;
        thirst += 4;
        boredom += 4;
        isDeadCheck();
    }

    @Override
    public void isDeadCheck() {
        super.isDeadCheck();
        if (oilLevel <= 0) {
            System.out.println("Your pet " + name + " exploded due to running out of oil.");
            isDead = true;
        }
    }
    @Override
    public void status() {
        super.status();
        oilStatus();
    }

    public void oilStatus() {
        if (oilLevel <= 100 && oilLevel >= 80) {
            System.out.println(name + "'s oil level is high.");
        } else if (oilLevel < 80 && oilLevel >= 50) {
            System.out.println(name + "'s oil level is average.");
        } else if (oilLevel < 50 && oilLevel >= 30) {
            System.out.println(name + "'s oil level is low.");
        } else {
            System.out.println(name + "'s oil level is very low.");
        }
    }
}

