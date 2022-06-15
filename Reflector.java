import java.util.Arrays;

public class Reflector {
    char[] order;

    public Reflector (String order) {
        this.order = order.toCharArray();
    }

    public char reflect(Character letter) {
        letter = Character.toUpperCase(letter);
        return (char) order[letter - 65];
    } 

    public String toString() {
        return "Reflector: " + Arrays.toString(order);
    }
}
