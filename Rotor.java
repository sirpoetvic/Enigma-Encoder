import java.util.Arrays;
public class Rotor {
    static int numberOfRotors = 0;
    private char[] order = new char[26];
    //Assigned 1-5, reference arraylist rotors in EngimaMachine.java
    private int position;
    private int rotorNumber;
    
    public Rotor(char[] order) {
        this.order = order;
        position = 0;
        numberOfRotors++;
        rotorNumber = numberOfRotors;
    }

    //increment rotor by one
    public void incrementRotor() {
        position++;
    }

    public int getRotorPos() {
        return position;
    }

    public void setRotorPosition(int pos) {
        position = pos;
    }

    public char convertCharForward(Character letter) {
        letter = Character.toUpperCase(letter);
        return order[((((int) letter) - 65) + position) % 26];
    }

    public char convertCharBackward(Character letter) {
        letter = Character.toUpperCase(letter);
        return (char) (((getLetterIndex(letter) + position) % 26) + 65);
    }

    public int getLetterIndex(char letter) {
        for (int i = 0; i < order.length; i++) {
            if (letter == order[i])
                return i;
        }
        return -1;
    }

    public String toString() {
        return "Rotor " + rotorNumber + ": " + Arrays.toString(order);
    }

    public int getRotorNum() {
        return rotorNumber;
    }
}
