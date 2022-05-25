import java.util.Arrays;
import java.util.Scanner;

public class Rotor {
    static int numberOfRotors = 0;
    static int rONECount = 0;
    static int rTWOCount = 0;
    static int rTHREECount = 0;
    //Number of passes that the word makes through all of the rotors
    static final int numPasses = 6;
    private char[] order = new char[26];
    //Assigned 1-5, reference arraylist rotors in EngimaMachine.java
    private int rotorNumber;
    private boolean isAvailable;
    
    public Rotor(char[] order, boolean isAvailable) {
        this.order = order;
        this.isAvailable = isAvailable;
        numberOfRotors++;
        rotorNumber = numberOfRotors;
    }

    //checks if rotor is available for use
    public boolean isAvailableCheck() {
        return isAvailable;
    }

    //
    public void setAvailability(boolean available) {
        isAvailable = available;
    }

    //increment rotor by one, checks if the other rotors need turning (every 26)
    private void incrementRotor() {
        //Increment rotor 1
        rONECount++;

        //increment rotor 2 if rotor 1 goes 1 full revolution and keeps rotor 1 position under 26
        if(rONECount > 26) {
            rTWOCount++;
            rONECount %= 26;
        }

        //increment rotor 3 if rotor 2 goes 1 full revolution keeps rotor 2 position under 26
        if(rTWOCount > 26) {
            rTHREECount++;
            rTWOCount %= 26;
        }

        //keeps rotor 3 position under 26
        if(rTHREECount > 26)
            rTHREECount %= 26;
    }

    //Manually sets rotor position
    public static void setRotorPositions(Scanner sc) {
        System.out.println("Would you like to set the rotor positions? (yes or no, y/n");
        System.out.println("The default values are 0, 0, 0");
        sc.nextLine();
        String response = sc.nextLine().toLowerCase();
        if(response.startsWith("y")) {
            System.out.println("Enter the first rotor position: ");
            int rotorPos = Integer.parseInt(sc.nextLine());
            rONECount = rotorPos;
            System.out.println("Enter the second rotor position: ");
            rotorPos = Integer.parseInt(sc.nextLine());
            rTWOCount = rotorPos;
            System.out.println("Enter the third rotor position: ");
            rotorPos = Integer.parseInt(sc.nextLine());
            rTHREECount = rotorPos;
        }
        else {
            //defaulting to 0 for all position values
            System.out.println("Alright, the default values are 0, 0, 0");
            rONECount = 0;
            rTWOCount = 0;
            rTHREECount = 0;
        }
    }

    public int getRotorPosition(int rotorNum) {
        if(rotorNum == 1)
            return rONECount;

        else if(rotorNum == 2)
            return rTWOCount;

        else if(rotorNum == 3)
            return rTHREECount;
        else 
            return -1;
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
