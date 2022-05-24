import java.security.CryptoPrimitive;
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

    static ArrayList<Rotor> selectedRotors = new ArrayList<>();

    public static void introduction(Scanner sc) {
        System.out.println("Hello! Please choose 3 of the following 5 rotors");
        System.out.println();

        for (int i = 0; i < rotors.size(); i++) {
            System.out.println(rotors.get(i));
        }

        System.out.println();

        selectRotors(sc);

        System.out.println("Selected Rotors:");

        for (int i = 0; i < selectedRotors.size(); i++) {
            System.out.println(selectedRotors.get(i));
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
        for (int i = 0; i < selectedRotors.size(); i++) {
            letter = selectedRotors.get(i).convertChar(letter);
        }
        return letter;
    }

    private static void selectRotors(Scanner sc) {
        while (selectedRotors.size() < 3) {
            System.out.println("enter a number 1 - 5 that hasn't already been chosen");
            int rotorNum = sc.nextInt();
            System.out.println();

            boolean needToRedo = false;
            for (int i = 0; i < selectedRotors.size(); i++) {
                if (rotorNum == selectedRotors.get(i).getRotorNum()) {
                    System.out.println("You've already selected that rotor, try again");
                    needToRedo = true;
                    break;
                }
            }

            if (needToRedo) 
                continue;

            try {
                System.out.println("Selected " + rotors.get(rotorNum-1));
                selectedRotors.add(rotors.get(rotorNum-1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("That's not a valid rotor! >:(");
                continue;
            }

            System.out.println();
        }
    }
}