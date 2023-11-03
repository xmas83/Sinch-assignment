import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Zookeeper {
    private String name;

    public Zookeeper(String name) {
        this.name = name;
    }

    public void feedAnimals(Zoo zoo) {
        List<Animal> animals = zoo.getCages();
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo to feed.");
            return;
        }

        System.out.println("Animals in the zoo:");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i).getName());
        }

        int choice = promptForAnimalChoice(animals.size());
        Animal chosenAnimal = animals.get(choice - 1);

        int foodAmount = promptForFoodAmount(chosenAnimal);
        chosenAnimal.eatFood(foodAmount);
    }

    public void healAnimals(Zoo zoo) {
        List<Animal> animals = zoo.getCages();
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo to heal.");
            return;
        }

        System.out.println("Sick animals in the zoo:");
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getHealthStatus() < 8) {
                System.out.println((i + 1) + ". " + animals.get(i).getName());
            }
        }

        int choice = promptForAnimalChoice(animals.size());
        Animal chosenAnimal = animals.get(choice - 1);

        int medicineAmount = promptForMedicineAmount(chosenAnimal);
        chosenAnimal.takeMedicine(medicineAmount);
    }

    private int promptForAnimalChoice(int max) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                System.out.print("Choose an animal (1-" + max + "): ");
                choice = scanner.nextInt();
                if (choice < 1 || choice > max) {
                    System.out.println("Error: Invalid choice. Please select a valid animal.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        } while (!validInput);

        return choice;
    }

    private int promptForFoodAmount(Animal animal) {
        int foodAmount = -1; // Initialize with a default value
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                System.out.print("Enter the food amount for " + animal.getName() + ": ");
                foodAmount = scanner.nextInt();
                if (foodAmount < 0) {
                    System.out.println("Error: Food amount must be non-negative.");
                } else if (foodAmount + animal.getHungerStatus() > 5) {
                    System.out.println("Error: Overfeeding! The total hunger status exceeds the maximum of 5.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        } while (!validInput);

        return foodAmount;
    }

    private int promptForMedicineAmount(Animal animal) {
        int medicineAmount = -1; // Initialize with a default value
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                System.out.print("Enter the medicine amount for " + animal.getName() + ": ");
                medicineAmount = scanner.nextInt();
                if (medicineAmount < 0) {
                    System.out.println("Error: Medicine amount must be non-negative.");
                } else if (medicineAmount + animal.getHealthStatus() > 10) {
                    System.out.println("Error: Overmedication! The total health status exceeds the maximum of 10.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        } while (!validInput);

        return medicineAmount;
    }
}
