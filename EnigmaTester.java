import java.util.Scanner;

public class EnigmaTester {
    
    static Scanner sc = new Scanner(System.in);
    public static void main (String args[]) {
        EnigmaMachine.introduction(sc);
        sc.nextLine();

        System.out.println("Give a message to be encoded");
        
        String message = sc.nextLine();

        System.out.println(EnigmaMachine.encodeMessage(message));
    }

}
