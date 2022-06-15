import java.util.Arrays;

public class NewRotor {
    static int numberOfRotors = 0;
    private int rotorNumber;
    private char[] right;
    private char[] left;
    private char rotationChar;    
    
    public NewRotor (String wiring, char notch) {
        left = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        right = wiring.toCharArray();
        rotationChar = notch;
        numberOfRotors++;
        rotorNumber = numberOfRotors;
    }

    public int forward(int index) {
        char letter = right[index];
        return getLetterIndex(letter, left);
    }

    public int backward(int index) {
        char letter = left[index];
        return getLetterIndex(letter, right);
    }

    public void rotate() {
        char[] tempLeft = left.clone();
        for (int i = 1; i < left.length; i++) {
            tempLeft[i-1] = left[i];
        }
        tempLeft[25] = left[0];
        left = tempLeft;

        char[] tempRight = right.clone();
        for (int i = 1; i < right.length; i++) {
            tempRight[i-1] = right[i];
        }
        tempRight[25] = right[0];
        right = tempRight;
    }

    public void setPosition(int position) {
        for (int i = 0; i < position; i++) {
            this.rotate();
        }
    }

    private int getLetterIndex(char letter, char[] side) {
        for (int i = 0; i < side.length; i++) {
            if (letter == side[i])
                return i;
        }
        return -1;
    }

    public char[] getLeft() {
        return left;
    }

    public char[] getRight() {
        return right;
    }

    public char getNotch() {
        return rotationChar;
    }

    public int getRotorNum() {
        return rotorNumber;
    }

    public void printRotor() {
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(left));
    }

    public String toString() {
        return "Rotor " + rotorNumber + ": " + Arrays.toString(right);
    }
}
