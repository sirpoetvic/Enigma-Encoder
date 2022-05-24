import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EnigmaMachine {

    static ArrayList<Rotor> rotors = new ArrayList(Arrays.asList(
                                new Rotor("JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray()),
                                new Rotor("NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray()),
                                new Rotor("JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray()),
                                new Rotor("QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray()),
                                new Rotor("QWERTZUIOASDFGHJKPYXCVBNML".toCharArray())));

    static Rotor[] selectedRotors = new Rotor[3];

    public static void introduction(Scanner sc) {
        System.out.println("Hello! Please choose 3 of the following 5 rotors");
        System.out.println();

        for (int i = 0; i < rotors.size(); i++) {
            System.out.println("Rotor " + (i+1) + ": " + rotors.get(i));
        }

        System.out.println();
        
        int counter = 1;
        while (counter < 4) {
            System.out.println("enter a number 1 - 5 that hasn't already been chosen");
            System.out.println("Rotor " + counter + ":");
            int rotorNum = sc.nextInt();
            selectedRotors[counter - 1] = rotors.get(rotorNum-1);
            counter++;
        }

        System.out.println("Selected Rotors:");

        for (int i = 0; i < selectedRotors.length; i++) {
            System.out.println(selectedRotors[i]);
        }

        System.out.println("");
    }
    
    public static String encodeMessage(String message) {
        String encodedMessage = "";

        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            if (letter == ' ')
                encodedMessage += letter;
            else
                encodedMessage += processChar(letter);
        }

        return encodedMessage;
    }

    public static char processChar(char letter) {
        for (int i = 0; i < selectedRotors.length; i++) {
            letter = selectedRotors[i].convertChar(letter);
        }
        return letter;
    }
}
