package model;

/**
 * Represents a flora species in the biodiversity catalog.
 * Extends the abstract Species class with specific attributes for plant life.
 */
public class Flora extends Species {
    private boolean hasFlowers;
    private boolean hasFruits;
    private double maxHeight;

    /**
     * Creates a new flora species with all its specific characteristics.
     * 
     * @param name           The common name of the flora species
     * @param scientificName The scientific name in binomial nomenclature
     * @param hasFlowers     Whether the plant produces flowers
     * @param hasFruits      Whether the plant produces fruits
     * @param maxHeight      The maximum height the plant can reach in meters
     */
    public Flora(String name, String scientificName, SpeciesType type,
            boolean hasFlowers, boolean hasFruits, double maxHeight) {
        super(name, scientificName, type);
        if (type != SpeciesType.LAND_FLORA && type != SpeciesType.AQUATIC_FLORA) {
            throw new IllegalArgumentException("Invalid type for Flora. Must be LAND_FLORA or AQUATIC_FLORA");
        }
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
    }

    /**
     * Checks if the plant produces flowers.
     * 
     * @return true if the plant has flowers, false otherwise
     */
    public boolean isHasFlowers() {
        return hasFlowers;
    }

    /**
     * Updates whether the plant produces flowers.
     * 
     * @param hasFlowers true if the plant has flowers, false otherwise
     */
    public void setHasFlowers(boolean hasFlowers) {
        this.hasFlowers = hasFlowers;
    }

    /**
     * Checks if the plant produces fruits.
     * 
     * @return true if the plant has fruits, false otherwise
     */
    public boolean isHasFruits() {
        return hasFruits;
    }

    /**
     * Updates whether the plant produces fruits.
     * 
     * @param hasFruits true if the plant has fruits, false otherwise
     */
    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    /**
     * Gets the maximum height the plant can reach.
     * 
     * @return The maximum height in meters
     */
    public double getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the maximum height the plant can reach.
     * 
     * @param maxHeight The maximum height in meters
     */
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * Provides a formatted string with all information about the flora species.
     * 
     * @return A string containing the name, scientific name, and all flora-specific
     *         attributes
     */
    @Override
    public String getSpeciesInfo() {
        return String.format("Flora - Type: %s\nName: %s\nScientific Name: %s\n" +
                "Has Flowers: %b\nHas Fruits: %b\nMax Height: %.2f meters",
                getType(), getName(), getScientificName(),
                hasFlowers, hasFruits, maxHeight);
    }
}