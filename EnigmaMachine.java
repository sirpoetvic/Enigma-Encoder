import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EnigmaMachine {

    //5 possible rotors, choose 3 of them to use
    static ArrayList<Rotor> rotors = new ArrayList(Arrays.asList(
                                new Rotor("JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray()),
                                new Rotor("NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray()),
                                new Rotor("JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray()),
                                new Rotor("QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray()),
                                new Rotor("QWERTZUIOASDFGHJKPYXCVBNML".toCharArray())));

    //stores the rotors that are used in the machine (at current time)
    //originally empty
    static ArrayList<Rotor> selectedRotors = new ArrayList<>();

    //Performs intro tasks
    //Enter rotor numbers, store in selectedRotors 
    public static void introduction(Scanner sc) {
        System.out.println("Hello! Welcome to the Enigma Machine simulator.");
        System.out.println("Please choose 3 of the following 5 rotors: ");
        System.out.println();

        selectRotors(sc);

        //prints alphabet for reference
        System.out.println("Alpha b: " + Arrays.toString("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()));

        System.out.println("Selected Rotors:");

        //prints out the 3 selected motors
        for (int i = 0; i < selectedRotors.size(); i++) {
            System.out.println(selectedRotors.get(i));
        }

        System.out.println("");

        setRotorPosition();
    }
    
    //encoding the message
    public static String encodeMessage(String message) {
        String encodedMessage = "";

        //for as long as the message is
        for (int i = 0; i < message.length(); i++) {
            //specific letter from word
            char letter = message.charAt(i);
            
            //in the case that the character is anything but a letter, just add
            //it to the encoded message string
            if (!Character.isLetter(letter))
                encodedMessage += letter;
            //in the case that the character is a letter, process it
            else
                encodedMessage += processChar(letter, selectedRotors.get(0), selectedRotors.get(1), selectedRotors.get(2));
        }

        return encodedMessage;
    }

    //processes the letter through all three
    public static char processChar(char convert, Rotor first, Rotor second, Rotor third) {
        char temp = first.getCharInPos(convert);
        temp = second.getCharInPos(temp);
        temp = third.getCharInPos(temp);
        //reflector here
        temp = second.getCharInPos(temp);
        temp = first.getCharInPos(temp);

        return temp;
    }

    //User selects rotors to use in the program
    //rotors go into size
    private static void selectRotors(Scanner sc) {
        while (selectedRotors.size() < 3) {
            System.out.println("Select one of the following rotors:");
            //prints available rotors
            for (int i = 0; i < rotors.size(); i++) {
                if(rotors.get(i).isAvailableCheck()) {
                    System.out.println(rotors.get(i));
                    rotors.get(i).setAvailability(false);
                }
            }

            int rotorNum = sc.nextInt();
            System.out.println();

            boolean needToRedo = false;
            for (int i = 0; i < selectedRotors.size(); i++) {
                //checks if the rotor is available, if not, then catch that
                if (!selectedRotors.get(i).isAvailableCheck) {
                    System.out.println("You've already selected that rotor, try again.");
                    needToRedo = true;
                    break;
                }
            }

            if (needToRedo) 
                continue;

            try {
                System.out.println("Selected " + rotors.get(rotorNum-1));
                selectedRotors.add(rotors.get(rotorNum-1));
                rotors.get(rotorNum-1).setAvailability(false);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("That's not a valid rotor! >:(");
                System.out.println("Try again.");
                continue;
            }

            System.out.println();
        }
    }
}