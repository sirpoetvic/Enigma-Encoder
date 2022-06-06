import java.util.HashMap;

public class PlugBoard {
    private HashMap<Character,Character> board = new HashMap<>();
    private char[][] inputArray;

    public PlugBoard(String[] swaps) {
        inputArray = new char[swaps.length][2];

        for (int i = 0; i < swaps.length; i++) {
            inputArray[i] = swaps[i].toCharArray();
        }

        for (int i = 0; i < swaps.length; i++) {
            board.put(inputArray[i][0], inputArray[i][1]);
            board.put(inputArray[i][1], inputArray[i][0]);
        }
    }

    public void printPlugBoard() {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i][0] + " <--> " + board.get(inputArray[i][0]));
        }
    }

    public char swapChar(Character letter) {
        letter = Character.toUpperCase(letter);
        return board.containsKey(letter) ? board.get(letter) : letter;
    }
    
}
