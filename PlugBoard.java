public class PlugBoard {
    private char swap;
    private char swapper;
    public PlugBoard(char swap, char swapper) {
        this.swap = swapper;
        this.swapper = swap;
    }

    public char printSwapper() {
        return swap;
    }

    public char printSwap() {
        return swapper;
    }

    
}
