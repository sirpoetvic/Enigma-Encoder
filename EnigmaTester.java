import java.util.Scanner;

public class EnigmaTester {
    
    static Scanner sc = new Scanner(System.in);
    public static void main (String args[]) {


        // int input = sc.nextLine().charAt(0) - 65;

        // input = EnigmaMachine.pBoard.swapChar((char) (input + 65));

        // input = EnigmaMachine.newRotors[2].forward(input - 65);

        // input = EnigmaMachine.newRotors[1].forward(input);

        // input = EnigmaMachine.newRotors[0].forward(input);

        // input = EnigmaMachine.reflectors[0].reflect((char) (input + 65));

        // input = EnigmaMachine.newRotors[0].backward(input - 65);

        // input = EnigmaMachine.newRotors[1].backward(input);

        // input = EnigmaMachine.newRotors[2].backward(input);

        // input = EnigmaMachine.pBoard.swapChar((char) (input + 65));

        // System.out.println((char) input);


        // EnigmaMachine.setDefaultSettings();

        EnigmaMachine.introduction(sc);

        EnigmaMachine.printMachineSettings();
        
        System.out.println("Give a message to be encoded");
        
        String message = sc.nextLine().toUpperCase();

        System.out.println(EnigmaMachine.encodeMessage(message));

        // String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // System.out.println(alpha);
        // System.out.println(EnigmaMachine.encodeMessage(alpha));

    }

}
