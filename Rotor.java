import java.util.Arrays;

public class Rotor extends Reflector{
    private int incrementation;

    public Rotor(char[] order) {
        super(order);
        incrementation = 0;
    }

    public void incrementRotor() {
        char lastChar = getOrder()[25];

        for (int i = getOrder().length - 2; i >= 0 ; i--) {
            getOrder()[(i+1) % 26] =  getOrder()[i];
        }

        getOrder()[0] = lastChar;
        incrementation++;
    }

    public void setRotorPosition(int setPosition) {
        setPosition -= incrementation;

        if (setPosition < 0) {
            setPosition += 26;
        }

        for (int i = 0; i < setPosition; i++) {
            incrementRotor();
        }
    }

    public int getIncrementation() {
        return incrementation;
    }

    public  void setAndPrint(int setPosition) {
        setRotorPosition(setPosition);
        System.out.println(this);
    }

    public String toString() {
        return Arrays.toString(getOrder());
    }
}
