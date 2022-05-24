import java.util.Arrays;

public class Rotor {
    static int numberOfRotors = 0;
    private char[] order = new char[26];
    private int incrementation;
    private int rotorNumber;
    

    public Rotor(char[] order) {
        this.order = order;
        incrementation = 0;
        numberOfRotors++;
        rotorNumber = numberOfRotors;
    }

    public void incrementRotor() {
        char lastChar = order[25];

        for (int i = order.length - 2; i >= 0 ; i--)
            order[(i+1) % 26] =  order[i];

        order[0] = lastChar;
        incrementation++;
    }

    public void setRotorPosition(int setPosition) {
        setPosition -= incrementation;

        if (setPosition < 0) {
            setPosition += 26;
        }

        for (int i = 0; i < setPosition; i++) {
            incrementRotor();
        }
    }

    public int getIncrementation() {
        return incrementation;
    }

    public void setAndPrint(int setPosition) {
        setRotorPosition(setPosition);
        System.out.println(this);
    }

    public char convertChar(Character letter) {
        letter = Character.toLowerCase(letter);
        incrementRotor();
        return order[((int) letter) - 97];
    }

    public String toString() {
        return "Rotor " + rotorNumber + ": " + Arrays.toString(order);
    }
}
