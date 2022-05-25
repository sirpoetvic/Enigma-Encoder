import java.util.Arrays;

public class Rotor {
    static int numberOfRotors = 0;
    static int rONECount = 0;
    static int rTWOCount = 0;
    static int rTHREECount = 0;
    //Number of passes that the word makes through all of the rotors
    static final int numPasses = 6;
    private char[] order = new char[26];
    private int position;
    private int rotorNumber;
    private boolean isAvailable;
    
    public Rotor(char[] order) {
        this.order = order;
        isAvailable = true;
        position = 0;
        numberOfRotors++;
        rotorNumber = numberOfRotors;
    }

    //checks if rotor is available for use
    public boolean isAvailableCheck() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        isAvailable = available;
    }

    //increment rotor by one
    public void incrementRotor(int pos) {
        char position = order[pos];
        for(int rotorPass = 0; rotorPass < numPasses; rotorPass++) {

        }
        

//take in a letter
//after that, find the letter's pos (on the a-z alphabet) on the rotor 1 and that is the new letter
//go through rotors 2, 3, 2, 1, and then that is the final letter




            order[(pos) % 26] =  order[i];
            pos++;

        order[0] = lastChar;
        position++;
        }

    }

    public void setRotorPosition(int setPosition) {
        position = setPosition;
    }

    public int getPosition() {
        return position;
    }

    public void setAndPrint(int setPosition) {
        setRotorPosition(setPosition);
        System.out.println(this);
    }

    public char convertChar(Character letter) {
        letter = Character.toLowerCase(letter);
        incrementRotor((int) letter - 97);
        return order[((int) letter) - 97];
    }

    public String toString() {
        return "Rotor " + rotorNumber + ": " + Arrays.toString(order);
    }

    public int getRotorNum() {
        return rotorNumber;
    }
}
