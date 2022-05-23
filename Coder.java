import java.util.Arrays;

public class Coder {
    static char[] rotor1 = "JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray();
    static char[] rotor2 = "NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray();
    static char[] rotor3 = "JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray();
    static char[] rotor4 = "QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray();
    static char[] rotor5 = "QWERTZUIOASDFGHJKPYXCVBNML".toCharArray();

    static char[][] rotors = {rotor1, rotor2, rotor3, rotor4, rotor5};
    public static void main (String args[]) {
        System.out.println(Arrays.toString(rotor1));
        setRotor(1, 2);
        System.out.println(Arrays.toString(rotor1));
    }


    public static void selectRotors() {
        System.out.println("Please select of the following rotors");                   
    }

    public static void incrementRotor() {
        
    }

    public static void setRotor(int rotorNum, int setPosition) {
        char[] temp = new char[26];
    
        for (int i = 0; i < 26; i++) {
            temp[(i+setPosition) % 26] = rotors[rotorNum][i];
        }
        System.out.println(temp);
        rotors[rotorNum] = temp;
    }
}
