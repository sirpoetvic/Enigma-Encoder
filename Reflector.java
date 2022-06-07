public class Reflector {
    
    char[] order;

    public Reflector (String order) {
        this.order = order.toCharArray();
    }

    public char reflect(Character letter) {
        letter = Character.toUpperCase(letter);
        return (char) order[letter - 65];
    } 

    public void printReflector() {
        for (int i = 65; i < 91; i++) {
            System.out.println(((char) i) + "->" + reflect((char) i));
        }
    }
}
