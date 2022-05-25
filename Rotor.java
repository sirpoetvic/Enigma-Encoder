import java.util.Arrays;

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
    
    public Rotor(char[] order) {
        this.order = order;
        isAvailable = true;
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

    //Manually sets rotor position
    public void setRotorPosition() {
        System.out.println("Would you like to set the rotor positions?");
        System.out.println("The default values are 0, 0, 0");
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
