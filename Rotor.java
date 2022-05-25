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

    //increment rotor by one, checks if the other rotors need turning (every 26)
    private void incrementRotor() {
        //Increment rotor 1
        if(rotorNumber == 1) 
            rONECount++;

        //increment rotor 2 if rotor 1 goes 1 full revolution
        if(rONECount > 26)
            rTWOCount++;

        //increment rtor 3 if rotor 2 goes 1 full revolution
        if(rTWOCount > 26)
            rTHREECount++;


        //In the case that any of the counts go over 26, 
        //bring them back to 1
        if(rONECount > 26)
            rONECount = rONECount % 26;

        if(rTWOCount > 26)
            rTWOCount = rTWOCount % 26;

        if(rTHREECount > 26)
            rTHREECount = rTHREECount % 26;


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

    public char getCharInPos(Character letter) {
        letter = Character.toLowerCase(letter);
        incrementRotor();
        return order[((int) letter) - 97];
    }

    public String toString() {
        return "Rotor " + rotorNumber + ": " + Arrays.toString(order);
    }

    public int getRotorNum() {
        return rotorNumber;
    }
}
