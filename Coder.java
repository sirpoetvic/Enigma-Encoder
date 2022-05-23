import java.util.Arrays;

public class Coder {
    static char[] rotor0 = "JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray();
    static char[] rotor1 = "NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray();
    static char[] rotor2 = "JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray();
    static char[] rotor3 = "QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray();
    static char[] rotor4 = "QWERTZUIOASDFGHJKPYXCVBNML".toCharArray();

    static char[][] rotors = {rotor0, rotor1, rotor2, rotor3, rotor4};
    public static void main (String args[]) {
        System.out.println(Arrays.toString(rotor1));
        setRotorPosition(1, 2);
        System.out.println(Arrays.toString(rotor1));
    }


    public static void selectRotors() {
        System.out.println("Please select of the following rotors");                   
    }

    public static void incrementRotor(int rotorNum) {
        char lastChar = rotors[rotorNum][25];

        for (int i = 0; i < rotors[rotorNum].length - 1; i++) {
            rotors[rotorNum][i+1] =  rotors[rotorNum][i];
        }

        rotors[rotorNum][0] = lastChar;
    }

    public static void setRotorPosition(int rotorNum, int setPosition) {
        
        for (int i = 0; i < setPosition; i++) {
            incrementRotor(rotorNum);
        }
    }
}
