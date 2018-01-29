package assignment1.anmol.servingsizecalculator;

/**
 * Store information about a single pot
 */

public class Pot {

    private String namePot;
    private int weightInGPot;

    // Set member data based on parameters.
    Pot(String name, int weightInG) {
        namePot = name;
        weightInGPot = weightInG;
    }

    // Return the weight
    int getWeightInG() {
        return weightInGPot;
    }

    // Set the weight. Throws IllegalArgumentException if weight is less than 0.
    public void setWeightInG(int weightInG) {
        if (weightInG < 0) {
            throw new IllegalArgumentException();
        } else {
            weightInGPot = weightInG;
        }
    }

    // Return the name.
    public String getName() {
        return namePot;
    }

    // Set the name. Throws IllegalArgumentException if name is an empty string (length 0),
    // or if name is a null-reference.
    public void setName(String name) {
        //No point in using name == null since null is always 'false'
        if (name.equals("")  || name.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            namePot = name;
        }
    }
}