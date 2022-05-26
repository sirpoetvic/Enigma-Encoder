import java.util.Arrays;

public class Rotor {
    static int numberOfRotors = 0;
    //Number of passes that the word makes through all of the rotors
    static final int numPasses = 6;
    private char[] order = new char[26];
    //Assigned 1-5, reference arraylist rotors in EngimaMachine.java
    private int position;
    private int rotorNumber;
    
    public Rotor(char[] order, int position) {
        this.order = order;
        this.position = position;
        numberOfRotors++;
        rotorNumber = numberOfRotors;
    }

    //increment rotor by one, checks if the other rotors need turning (every 26)
    public void incrementRotor() {
        position++;
    }

    public int getRotorPos() {
        return position;
    }

    public void setRotorPosition(int pos) {
        position = pos;
    }

    public char getCharInPos(Character letter) {
        letter = Character.toLowerCase(letter);
        return order[((((int) letter) - 97) + position) % 26];
    }

    public String toString() {
        return "Rotor " + rotorNumber + ": " + Arrays.toString(order);
    }

    public int getRotorNum() {
        return rotorNumber;
    }
}
