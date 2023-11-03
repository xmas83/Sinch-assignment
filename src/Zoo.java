import java.util.ArrayList;

// Zoo class to manage and display animals
class Zoo {
    private ArrayList<Animal> cages;

    public Zoo() {
        cages = new ArrayList<>();
    }

    // Add an animal to the zoo
    public void addAnimal(Animal animal) {
        cages.add(animal);
    }

    // Display details about each animal in the zoo
    public void showAnimals() {
        if (cages.isEmpty()) {
            System.out.println("No animals in the zoo.");
        } else {
            for (int i = 0; i < cages.size(); i++) {
                Animal animal = cages.get(i);
                System.out.println("Animal #" + (i + 1));
                System.out.println("Species: " + animal.getSpecies());
                System.out.println("Name: " + animal.getName());
                System.out.println("Age: " + animal.getAge());
                System.out.println("Hunger Status: " + animal.getHungerStatus());
                System.out.println("Health Status: " + animal.getHealthStatus());
                animal.speak();
                System.out.println();
            }
        }
    }

    // Get an animal by its index in the zoo
    public Animal getAnimal(int index) {
        if (index >= 0 && index < cages.size()) {
            return cages.get(index);
        } else {
            return null; // Handle the case of an invalid index
        }
    }

    // Get the list of animals in the zoo
    public ArrayList<Animal> getCages() {
        return cages;
    }
}
