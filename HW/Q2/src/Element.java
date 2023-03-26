abstract class Element {
    private  String symbol;
    private int atomicNumber;
    private double atomicWeight;

    public Element(String symbol, int atomicNumber, int atomicWeight) {
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }
    abstract void describeElement();
}
