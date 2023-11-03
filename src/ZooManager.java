import java.util.InputMismatchException;
import java.util.Scanner;

// ZooManager class to drive the program
public class ZooManager {
    public static void main(String[] args) {
        System.out.println("Welcome to the Zookeeper Program!");

        Scanner scanner = new Scanner(System.in);
        String zookeeperName = getZookeeperName(scanner);
        Zoo zoo = new Zoo();
        Zookeeper zookeeper = new Zookeeper(zookeeperName);

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    addAnimalToZoo(scanner, zoo);
                    break;
                case 2:
                    zoo.showAnimals();
                    break;
                case 3:
                    zookeeper.feedAnimals(zoo);
                    break;
                case 4:
                    zookeeper.healAnimals(zoo);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    // Get the name of the zookeeper
    private static String getZookeeperName(Scanner scanner) {
        System.out.print("Enter the zookeeper's name: ");
        return scanner.nextLine();
    }

    // Display the program menu
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add animal to the zoo");
        System.out.println("2. View all animals in the zoo");
        System.out.println("3. Feed animals");
        System.out.println("4. Heal animals");
        System.out.println("5. Exit");
    }

    // Get the user's choice from the menu
    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice. Please enter a valid option (1-5).");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }

        return choice;
    }

    // Add an animal to the zoo
    private static void addAnimalToZoo(Scanner scanner, Zoo zoo) {
        System.out.print("Enter the species (Tiger, Lion, Peacock, Horse, Elephant): ");
        String species = scanner.next();
        System.out.print("Enter the name: ");
        String name = scanner.next();
        System.out.print("Enter the age: ");
        int age = getUserChoice(scanner);

        Animal newAnimal = createAnimal(species, name, age);

        if (newAnimal != null) {
            zoo.addAnimal(newAnimal);
            System.out.println(name + " the " + species + " has been added to the zoo.");
        }
    }

    // Create an animal based on species
    private static Animal createAnimal(String species, String name, int age) {
        Animal newAnimal = null;

        switch (species.toLowerCase()) {
            case "tiger":
                newAnimal = new Tiger(name, age);
                break;
            case "lion":
                newAnimal = new Lion(name, age);
                break;
            case "peacock":
                newAnimal = new Peacock(name, age);
                break;
            case "horse":
                newAnimal = new Horse(name, age);
                break;
            case "elephant":
                newAnimal = new Elephant(name, age);
                break;
            default:
                System.out.println("Error: Invalid species. Animal species must be one of: Tiger, Lion, Peacock, Horse, Elephant.");
        }

        return newAnimal;
    }
}
