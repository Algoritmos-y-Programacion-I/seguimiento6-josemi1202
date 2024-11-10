package model;

/**
 * Abstract class representing a species in the Icesi University biodiversity
 * catalog.
 * This class serves as the base for both flora and fauna species.
 */
public abstract class Species {

	private String name;
	private String scientificName;
	private SpeciesType type;

	/**
	 * Creates a new species with the specified name and scientific name.
	 * 
	 * @param name           The common name of the species
	 * @param scientificName The scientific name of the species in binomial
	 *                       nomenclature
	 */
	public Species(String name, String scientificName, SpeciesType type) {
		this.name = name;
		this.scientificName = scientificName;
		this.type = type;
	}

	/**
	 * Gets the common name of the species.
	 * 
	 * @return The species' common name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets or updates the common name of the species.
	 * 
	 * @param name The new common name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the scientific name of the species.
	 * 
	 * @return The species' scientific name
	 */
	public String getScientificName() {
		return scientificName;
	}

	/**
	 * Sets or updates the scientific name of the species.
	 * 
	 * @param scientificName The new scientific name to set
	 */
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	/**
	 * Abstract method to get detailed information about the species.
	 * Each subclass must implement this method to provide specific details.
	 * 
	 * @return A formatted string containing all relevant information about the
	 *         species
	 */
	public SpeciesType getType() {
		return type;
	}

	public void setType(SpeciesType type) {
		this.type = type;
	}

	public abstract String getSpeciesInfo();
}