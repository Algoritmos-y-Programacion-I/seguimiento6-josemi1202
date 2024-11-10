package model;

/**
 * Controller class for managing the species catalog.
 * Handles all CRUD operations for both flora and fauna species.
 */
public class SpeciesController {
	private Species[] speciesList;
	private int speciesCount;
	private static final int MAX_SPECIES = 80;

	/**
	 * Creates a new species controller with an empty catalog.
	 * Initializes the species array with the maximum capacity.
	 */
	public SpeciesController() {
		this.speciesList = new Species[MAX_SPECIES];
		this.speciesCount = 0;
	}

	/**
	 * Registers a new flora species in the catalog.
	 * 
	 * @param name           The common name of the flora species
	 * @param scientificName The scientific name in binomial nomenclature
	 * @param hasFlowers     Whether the plant produces flowers
	 * @param hasFruits      Whether the plant produces fruits
	 * @param maxHeight      The maximum height the plant can reach in meters
	 * @return true if the registration was successful, false if the catalog is full
	 */
	public boolean registerFlora(String name, String scientificName,
			SpeciesType type, boolean hasFlowers,
			boolean hasFruits, double maxHeight) {
		if (speciesCount < MAX_SPECIES) {
			try {
				speciesList[speciesCount] = new Flora(name, scientificName, type,
						hasFlowers, hasFruits, maxHeight);
				speciesCount++;
				return true;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
				return false;
			}
		}
		return false;
	}

	/**
	 * Registers a new fauna species in the catalog.
	 * 
	 * @param name           The common name of the fauna species
	 * @param scientificName The scientific name in binomial nomenclature
	 * @param isMigratory    Whether the animal is migratory
	 * @param maxWeight      The maximum weight the animal can reach in kilograms
	 * @return true if the registration was successful, false if the catalog is full
	 */
	public boolean registerFauna(String name, String scientificName,
			SpeciesType type, boolean isMigratory,
			double maxWeight) {
		if (speciesCount < MAX_SPECIES) {
			try {
				speciesList[speciesCount] = new Fauna(name, scientificName, type,
						isMigratory, maxWeight);
				speciesCount++;
				return true;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
				return false;
			}
		}
		return false;
	}

	/**
	 * Edits the basic information of an existing species.
	 * 
	 * @param index          The index of the species to edit
	 * @param name           The new common name
	 * @param scientificName The new scientific name
	 * @return true if the edit was successful, false if the index is invalid
	 */
	public boolean editSpecies(int index, String name, String scientificName) {
		if (index >= 0 && index < speciesCount) {
			speciesList[index].setName(name);
			speciesList[index].setScientificName(scientificName);
			return true;
		}
		return false;
	}

	/**
	 * Deletes a species from the catalog.
	 * 
	 * @param index The index of the species to delete
	 * @return true if the deletion was successful, false if the index is invalid
	 */
	public boolean deleteSpecies(int index) {
		if (index >= 0 && index < speciesCount) {
			for (int i = index; i < speciesCount - 1; i++) {
				speciesList[i] = speciesList[i + 1];
			}
			speciesList[speciesCount - 1] = null;
			speciesCount--;
			return true;
		}
		return false;
	}

	/**
	 * Gets detailed information about a specific species.
	 * 
	 * @param index The index of the species to get information about
	 * @return A formatted string with all species information, or an error message
	 *         if the index is invalid
	 */
	public String getSpeciesInfo(int index) {
		if (index >= 0 && index < speciesCount) {
			return speciesList[index].getSpeciesInfo();
		}
		return "Species not found";
	}

	/**
	 * Gets a list of all species in the catalog.
	 * 
	 * @return A formatted string containing all species names with their indices,
	 *         or an empty string if the catalog is empty
	 */
	public String showSpeciesList() {
		if (speciesCount == 0) {
			return "";
		}

		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < speciesCount; i++) {
			msg.append("\n").append(i + 1).append(". ")
					.append(speciesList[i].getName());
		}
		return msg.toString();
	}

	/**
	 * Gets the scientific name of a species at the specified index.
	 * 
	 * @param index The index of the species
	 * @return The scientific name of the species, or null if the index is invalid
	 */
	public String getSpeciesScientificName(int index) {
		if (index >= 0 && index < speciesCount && speciesList[index] != null) {
			return speciesList[index].getScientificName();
		}
		return null;
	}

	/**
	 * Gets the name of a species at the specified index.
	 * 
	 * @param index The index of the species
	 * @return The name of the species, or null if the index is invalid
	 */
	public String getSpeciesName(int index) {
		if (index >= 0 && index < speciesCount && speciesList[index] != null) {
			return speciesList[index].getName();
		}
		return null;
	}
}