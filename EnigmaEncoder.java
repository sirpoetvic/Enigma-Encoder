import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class EnigmaEncoder {
    static Scanner sc = new Scanner(System.in);

    static Rotor rotor0 = new Rotor("JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray());
    static Rotor rotor1 = new Rotor("NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray());
    static Rotor rotor2 = new Rotor("JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray());
    static Rotor rotor3 = new Rotor("QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray());
    static Rotor rotor4 = new Rotor("QWERTZUIOASDFGHJKPYXCVBNML".toCharArray());

    static Rotor[] rotors = {rotor0, rotor1, rotor2, rotor3, rotor4};
    public static void main (String args[]) {
        System.out.println(rotor1);
        
        String encodedMessage = "";

        System.out.println("Give a message to be encoded");
        String message = sc.nextLine();

        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            if (letter == ' ')
                encodedMessage += " ";
            else
                encodedMessage += rotor1.convertChar(letter);
        }

        System.out.println(encodedMessage);
    }

    
}
