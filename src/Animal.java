import java.util.Random;

// Abstract class to represent animals
abstract class Animal {
    private String species;
    private String name;
    private int age;
    private int hungerStatus;
    private int healthStatus;

    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.hungerStatus = new Random().nextInt(6); // Initialize hunger randomly between 0-5
        this.healthStatus = new Random().nextInt(11); // Initialize health randomly between 0-10
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHungerStatus() {
        return hungerStatus;
    }

    public int getHealthStatus() {
        return healthStatus;
    }

    // Abstract method to make the animal speak
    public abstract void speak();

    public void eatFood(int amount) {
        if (amount < 0) {
            System.out.println("Error: Food amount must be non-negative.");
        } else {
            hungerStatus = Math.max(0, hungerStatus - amount);
        }
    }

    public void takeMedicine(int amount) {
        if (amount < 0) {
            System.out.println("Error: Medicine amount must be non-negative.");
        } else {
            healthStatus = Math.min(10, healthStatus + amount);
        }
    }
}
