import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EnigmaMachine {

    //5 possible rotors, choose 3 of them to use
    static ArrayList<Rotor> rotors = new ArrayList<Rotor>(Arrays.asList(
                                new Rotor("JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray(), 0),
                                new Rotor("NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray(), 0),
                                new Rotor("JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray(), 0),
                                new Rotor("QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray(), 0),
                                new Rotor("QWERTZUIOASDFGHJKPYXCVBNML".toCharArray(), 0)));

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

        setRotorPositions(sc);
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
                encodedMessage += processChar(letter);
                encodedMessage += selectedRotors.get(0).getRotorPos();
        }

        return encodedMessage;
    }

    //processes the letter through all three
    public static char processChar(char convert) {
        char temp = selectedRotors.get(0).getCharInPos(convert);
        selectedRotors.get(0).incrementRotor();
        if(selectedRotors.get(0).getRotorPos() > 26) {
            selectedRotors.get(1).incrementRotor();
            selectedRotors.get(0).setRotorPosition(selectedRotors.get(0).getRotorPos() % 26);
        }

        //increment rotor 3 if rotor 2 goes 1 full revolution keeps rotor 2 position under 26
        if(selectedRotors.get(1).getRotorPos() > 26) {
            selectedRotors.get(2).incrementRotor();
            selectedRotors.get(1).setRotorPosition(selectedRotors.get(1).getRotorPos() % 26);
        }

        //keeps rotor 3 position under 26
        if(selectedRotors.get(2).getRotorPos() > 26)
        selectedRotors.get(2).setRotorPosition(selectedRotors.get(2).getRotorPos() % 26);
        temp = selectedRotors.get(1).getCharInPos(temp);
        temp = selectedRotors.get(2).getCharInPos(temp);
        //reflector here
        temp = selectedRotors.get(1).getCharInPos(temp);
        temp = selectedRotors.get(0).getCharInPos(temp);

        return selectedRotors.get(0).getCharInPos(temp);
    }

    //Manually sets rotor position
    public static void setRotorPositions(Scanner sc) {
        System.out.println("The default values are 0, 0, 0");
        System.out.println("Would you like to set the rotor positions? (yes or no, y/n)");
        sc.nextLine();
        String response = sc.nextLine().toLowerCase();
        if(response.startsWith("y")) {
            System.out.println("Enter the first rotor position: ");
            int rotorPos = Integer.parseInt(sc.nextLine());
            selectedRotors.get(0).setRotorPosition(rotorPos);
            System.out.println("Enter the second rotor position: ");
            rotorPos = Integer.parseInt(sc.nextLine());
            selectedRotors.get(1).setRotorPosition(rotorPos);
            System.out.println("Enter the third rotor position: ");
            rotorPos = Integer.parseInt(sc.nextLine());
            selectedRotors.get(2).setRotorPosition(rotorPos);
        }
        else {
            //defaulting to 0 for all position values
            System.out.println("Alright, the default values are 0, 0, 0");
            sc.nextLine();
        }
    }

    //User selects rotors to use in the program
    //rotors go into selectedRotors arrayList
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