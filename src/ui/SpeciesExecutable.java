package ui;

import java.util.Scanner;
import model.SpeciesController;
import model.SpeciesType;

/**
 * Main executable class for the Species Management System.
 * Provides a command-line interface for interacting with the system.
 */
public class SpeciesExecutable {
	private Scanner reader;
	private SpeciesController speciesController;

	/**
	 * Main method to start the application.
	 * 
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	/**
	 * Constructor initializes the scanner and species controller.
	 */
	public SpeciesExecutable() {
		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	/**
	 * Displays and handles the main menu of the application.
	 * Provides options for all major operations.
	 */
	public void showMainMenu() {
		System.out.println("Welcome to Icesi Species Management System");

		boolean stopFlag = false;

		while (!stopFlag) {
			System.out.println("\nPlease select an option:");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("4. Show Species Information");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {
				case 1:
					registerSpecies();
					break;
				case 2:
					editSpecies();
					break;
				case 3:
					deleteSpecies();
					break;
				case 4:
					showSpecies();
					break;
				case 0:
					System.out.println("Thank you for using the Species Management System");
					stopFlag = true;
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			}
		}
	}

	/**
	 * Handles the species registration process.
	 * Allows users to register either flora or fauna species.
	 */
	public void registerSpecies() {
        System.out.println("\nSelect species type:");
        System.out.println("Flora Types:");
        System.out.println("1. Land Flora");
        System.out.println("2. Aquatic Flora");
        System.out.println("\nFauna Types:");
        System.out.println("3. Bird");
        System.out.println("4. Mammal");
        System.out.println("5. Aquatic Fauna");
        
        int typeChoice = reader.nextInt();
        reader.nextLine(); // Consume newline

        System.out.println("Enter species name:");
        String name = reader.nextLine();

        System.out.println("Enter scientific name:");
        String scientificName = reader.nextLine();

        boolean success = false;
        SpeciesType type;

        switch (typeChoice) {
            case 1: // Land Flora
            case 2: // Aquatic Flora
                type = (typeChoice == 1) ? SpeciesType.LAND_FLORA : SpeciesType.AQUATIC_FLORA;
                
                System.out.println("Does it have flowers? (true/false):");
                boolean hasFlowers = reader.nextBoolean();

                System.out.println("Does it have fruits? (true/false):");
                boolean hasFruits = reader.nextBoolean();

                System.out.println("Enter maximum height (in meters):");
                double maxHeight = reader.nextDouble();

                success = speciesController.registerFlora(name, scientificName, type,
                                                        hasFlowers, hasFruits, maxHeight);
                break;

            case 3: // Bird
            case 4: // Mammal
            case 5: // Aquatic Fauna
                switch (typeChoice) {
                    case 3: type = SpeciesType.BIRD; break;
                    case 4: type = SpeciesType.MAMMAL; break;
                    default: type = SpeciesType.AQUATIC_FAUNA;
                }

                System.out.println("Is it migratory? (true/false):");
                boolean isMigratory = reader.nextBoolean();

                System.out.println("Enter maximum weight (in kg):");
                double maxWeight = reader.nextDouble();

                success = speciesController.registerFauna(name, scientificName, type,
                                                        isMigratory, maxWeight);
                break;

            default:
                System.out.println("Invalid species type selected.");
                return;
        }

        if (success) {
            System.out.println("Species registered successfully!");
        } else {
            System.out.println("Error: Could not register species. The catalog might be full.");
        }
    }
	/**
	 * Handles the species editing process.
	 * Allows users to modify basic information of existing species.
	 */
	public void editSpecies() {
		String speciesList = speciesController.showSpeciesList();

		if (speciesList.isEmpty()) {
			System.out.println("No species registered yet.");
			return;
		}

		System.out.println("Current species list:");
		System.out.println(speciesList);

		System.out.println("\nEnter the number of the species to edit:");
		int index = reader.nextInt();
		reader.nextLine(); // Consume newline

		// Validate index before proceeding
		int actualIndex = index - 1;
		String currentName = speciesController.getSpeciesName(actualIndex);
		String currentScientificName = speciesController.getSpeciesScientificName(actualIndex);

		if (currentName == null || currentScientificName == null) {
			System.out.println("Error: Invalid species index selected.");
			return;
		}

		System.out.println("Current name: " + currentName);
		System.out.println("Enter new name (or press Enter to keep current):");
		String newName = reader.nextLine();

		System.out.println("Current scientific name: " + currentScientificName);
		System.out.println("Enter new scientific name (or press Enter to keep current):");
		String newScientificName = reader.nextLine();

		// Use the current values if no new input is provided
		String finalName = newName.isEmpty() ? currentName : newName;
		String finalScientificName = newScientificName.isEmpty() ? currentScientificName : newScientificName;

		if (speciesController.editSpecies(actualIndex, finalName, finalScientificName)) {
			System.out.println("Species updated successfully!");
		} else {
			System.out.println("Error: Could not update species. Please try again.");
		}
	}

	/**
	 * Handles the species deletion process.
	 * Allows users to remove species from the catalog.
	 */
	public void deleteSpecies() {
		String speciesList = speciesController.showSpeciesList();

		if (speciesList.isEmpty()) {
			System.out.println("No species registered yet.");
			return;
		}

		System.out.println("Current species list:");
		System.out.println(speciesList);

		System.out.println("\nEnter the number of the species to delete:");
		int index = reader.nextInt();

		if (speciesController.deleteSpecies(index - 1)) {
			System.out.println("Species deleted successfully!");
		} else {
			System.out.println("Error: Could not delete species. Invalid index.");
		}
	}

	/**
	 * Displays detailed information about a selected species.
	 */
	public void showSpecies() {
		String speciesList = speciesController.showSpeciesList();

		if (speciesList.isEmpty()) {
			System.out.println("No species registered yet.");
			return;
		}

		System.out.println("Current species list:");
		System.out.println(speciesList);

		System.out.println("\nEnter the number of the species to view:");
		int index = reader.nextInt();

		String speciesInfo = speciesController.getSpeciesInfo(index - 1);
		System.out.println("\nSpecies Information:");
		System.out.println(speciesInfo);
	}
}