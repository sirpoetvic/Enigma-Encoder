import java.util.Arrays;
import java.util.Set;

public class EnigmaEncoder {
    static Rotor rotor0 = new Rotor("JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray());
    static Rotor rotor1 = new Rotor("NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray());
    static Rotor rotor2 = new Rotor("JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray());
    static Rotor rotor3 = new Rotor("QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray());
    static Rotor rotor4 = new Rotor("QWERTZUIOASDFGHJKPYXCVBNML".toCharArray());

    static Rotor[] rotors = {rotor0, rotor1, rotor2, rotor3, rotor4};
    public static void main (String args[]) {
        System.out.println(rotor1);
        rotor1.setAndPrint(1);
        rotor1.setAndPrint(5);
        rotor1.setAndPrint(10);
        rotor1.setAndPrint(2);
        rotor1.setAndPrint(2);
    }

    
}
