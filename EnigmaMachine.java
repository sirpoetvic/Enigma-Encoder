import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EnigmaMachine {

    //5 possible rotors, choose 3 of them to use
    static Rotor[] rotors = { new Rotor("JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray()),
                                new Rotor("NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray()),
                                new Rotor("JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray()),
                                new Rotor("QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray()),
                                new Rotor("QWERTZUIOASDFGHJKPYXCVBNML".toCharArray())
                            };

    static NewRotor[] newRotors = { new NewRotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q'),
                                    new NewRotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'),
                                    new NewRotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V'),
                                    new NewRotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 'J'),
                                    new NewRotor("VZBRGITYUPSDNHLXAWMJQOFECK", 'Z')
                                };

    static Reflector selectedReflector = new Reflector("EJMZALYXVBWFCRQUONTSPIKHGD");

    //stores the rotors that are used in the machine (at current time)
    //originally empty
    static ArrayList<NewRotor> selectedRotors = new ArrayList<>();

    static PlugBoard pBoard = new PlugBoard(new String[] {
        "AU",
        "BL",
        "OF",
        "QD",
        "NY",
        "RI",
        "XP",
        "EV",
        "SK",
        "ZM"
    });

    public static void setDefaultSettings() {
        for (int i = 0; i < 3; i++) {
            selectedRotors.add(newRotors[i]);
        }
    }

    //Performs intro tasks 
    //Enter rotor numbers, store in selectedRotors     
    public static void introduction(Scanner sc) {
        System.out.println("Hello! Welcome to the Enigma Machine simulator.");
        System.out.println("Please choose 3 of the following 5 rotors: ");
        System.out.println();

        selectRotors(sc);

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
            // encodedMessage += selectedRotors.get(0).getRotorPos();
        }
        System.out.println();
        return encodedMessage;
    }

    public static void motorIncrementations() {
        // if(selectedRotors.get(0).getRotorPos() > 25) {
        //     selectedRotors.get(1).incrementRotor();
        //     selectedRotors.get(0).setRotorPosition(0);
        // }

        // //increment rotor 3 if rotor 2 goes 1 full revolution keeps rotor 2 position under 26
        // if(selectedRotors.get(1).getRotorPos() > 25) {
        //     selectedRotors.get(2).incrementRotor();
        //     selectedRotors.get(1).setRotorPosition(0);
        // }

        // //keeps rotor 3 position under 26
        // if(selectedRotors.get(2).getRotorPos() > 25)
        //     selectedRotors.get(2).setRotorPosition(0);
        
        // selectedRotors.get(0).incrementRotor();

        if (selectedRotors.get(0).getLeft()[0] == selectedRotors.get(0).getNotch()
            && selectedRotors.get(1).getLeft()[0] == selectedRotors.get(1).getNotch()) {
            
            selectedRotors.get(0).rotate(); 
            selectedRotors.get(1).rotate();
            selectedRotors.get(2).rotate();

        } else if (selectedRotors.get(1).getLeft()[0] == selectedRotors.get(1).getNotch()) {
            // double skip anomaly, weird edge case situation in the real enigma machine, i learned about it while researching
            selectedRotors.get(0).rotate();
            selectedRotors.get(1).rotate();
            selectedRotors.get(2).rotate();

        } else if (selectedRotors.get(0).getLeft()[0] == selectedRotors.get(0).getNotch()) {
            
            selectedRotors.get(0).rotate();
            selectedRotors.get(1).rotate();
            
        } else {
            selectedRotors.get(0).rotate();
        }
    }

    //processes the letter through all three
    public static char processChar(int input) {
        motorIncrementations();

        // System.out.println("initial input:" + (char) input);
        
        input = pBoard.swapChar((char) (input)) - 65;
        // System.out.println("start plug:" + (char) (input + 65));

        input = newRotors[2].forward(input);
        // System.out.println("first rotor forward:" + (char) (input + 65));

        input = newRotors[1].forward(input);
        // System.out.println("second rotor forward:" + (char) (input + 65));

        input = newRotors[0].forward(input);
        // System.out.println("third rotor forward:" + (char) (input + 65));

        input = selectedReflector.reflect((char) (input + 65)) - 65;
        // System.out.println("reflection:" + (char) (input + 65));

        input = newRotors[0].backward(input);
        // System.out.println("third rotor backward:" + (char) (input + 65));

        input = newRotors[1].backward(input);
        // System.out.println("second rotor backward:" + (char) (input + 65));

        input = newRotors[2].backward(input);
        // System.out.println("first rotor backward:" + (char) (input + 65));

        input = pBoard.swapChar((char) (input + 65));
        // System.out.println("final plug:" + (char) (input));
        
        // char temp = pBoard.swapChar(letter);
        // System.out.print(temp);

        // temp = (char) selectedRotors.get(0).forward((char) temp);
        // System.out.println(temp);

        // temp = selectedRotors.get(1).convertCharForward(temp);
        // System.out.println(temp);

        // temp = selectedRotors.get(2).convertCharForward(temp);
        // System.out.println(temp);
        
        // temp = reflector.reflect(temp);
        // System.out.println(temp);

        // temp = selectedRotors.get(2).convertCharBackward(temp);
        // System.out.println(temp);
        // temp = selectedRotors.get(1).convertCharBackward(temp);
        // System.out.println(temp);
        // temp = selectedRotors.get(0).convertCharBackward(temp);
        // System.out.println(temp);

        // temp = pBoard.swapChar(temp);
        return (char) input;
    }

    //Manually sets rotor position
    public static void setRotorPositions(Scanner sc) {
        System.out.println("The default values are 0, 0, 0");
        System.out.println("Would you like to set the rotor positions? (yes or no, y/n)");
        sc.nextLine();
        String response = sc.nextLine().toLowerCase();
        if(response.startsWith("y")) {
            for (int i = 0; i < selectedRotors.size(); i++) {
                System.out.println("Enter the position for rotor " + selectedRotors.get(i).getRotorNum() + "(between 0 & 25) :");
                selectedRotors.get(0).setPosition(sc.nextInt() % 26);
                sc.nextLine();
            }
        }
        else
            //defaulting to 0 for all position values
            System.out.println("Alright, the default values are 0, 0, 0");
    }

    //User selects rotors to use in the program
    //rotors go into selectedRotors arrayList
    private static void selectRotors(Scanner sc) {

        for (int i = 0; i < newRotors.length; i++) {
            System.out.println(newRotors[i]);
        }

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
                System.out.println("Selected " + newRotors[rotorNum-1]);
                selectedRotors.add(newRotors[rotorNum-1]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("That's not a valid rotor! >:(");
                continue;
            }

            System.out.println();
        }
    }

    public static void printMachineSettings() {

        System.out.println();
        System.out.println("***** MACHINE SETTINGS *****");
        System.out.println();

        System.out.println("Rotors:");
        for (NewRotor rotor : selectedRotors) {
            System.err.println(rotor);
        }

        System.out.println();

        System.out.println("Plug Board:");
        pBoard.printPlugBoard();

        System.out.println("Reflector:");
        System.out.println(selectedReflector);;

    }
}