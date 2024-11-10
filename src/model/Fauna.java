package model;

/**
 * Represents a fauna species in the biodiversity catalog.
 * Extends the abstract Species class with specific attributes for animal life.
 */
public class Fauna extends Species {
    private boolean isMigratory;
    private double maxWeight;

    /**
     * Creates a new fauna species with all its specific characteristics.
     * 
     * @param name           The common name of the fauna species
     * @param scientificName The scientific name in binomial nomenclature
     * @param isMigratory    Whether the animal is migratory
     * @param maxWeight      The maximum weight the animal can reach in kilograms
     */
    public Fauna(String name, String scientificName, SpeciesType type,
            boolean isMigratory, double maxWeight) {
        super(name, scientificName, type);
        if (type != SpeciesType.BIRD && type != SpeciesType.MAMMAL &&
                type != SpeciesType.AQUATIC_FAUNA) {
            throw new IllegalArgumentException(
                    "Invalid type for Fauna. Must be BIRD, MAMMAL, or AQUATIC_FAUNA");
        }
        this.isMigratory = isMigratory;
        this.maxWeight = maxWeight;
    }

    /**
     * Checks if the animal is migratory.
     * 
     * @return true if the animal is migratory, false otherwise
     */
    public boolean isMigratory() {
        return isMigratory;
    }

    /**
     * Updates whether the animal is migratory.
     * 
     * @param isMigratory true if the animal is migratory, false otherwise
     */
    public void setMigratory(boolean isMigratory) {
        this.isMigratory = isMigratory;
    }

    /**
     * Gets the maximum weight the animal can reach.
     * 
     * @return The maximum weight in kilograms
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Sets the maximum weight the animal can reach.
     * 
     * @param maxWeight The maximum weight in kilograms
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Provides a formatted string with all information about the fauna species.
     * 
     * @return A string containing the name, scientific name, and all fauna-specific
     *         attributes
     */
    @Override
    public String getSpeciesInfo() {
        return "Fauna - Name: " + getName() +
                "\nScientific Name: " + getScientificName() +
                "\nIs Migratory: " + isMigratory +
                "\nMax Weight: " + maxWeight + " kg";
    }
}