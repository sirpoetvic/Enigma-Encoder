import java.sql.Ref;

public class Reflector {
    private char[] order = new char[26];

    public Reflector(char[] order) {
        this.order = order;
    }

    public char[] getOrder() {
        return order;
    }
    
}