import java.util.Arrays;

public class ElementArray extends Element {


    private String[] element = new String[3];
    public ElementArray(String symbol, int atomicNumber, double atomicWeight) {
        super(symbol, atomicNumber, (int) atomicWeight);
        element[0]=symbol;
        element[1]= String.valueOf(atomicNumber);
        element[2]=String.valueOf(atomicWeight);
    }

    @Override
    public String toString() {
        return Arrays.toString(element);
    }
    @Override
    void describeElement() {
        if (getAtomicNumber() == 3 || getAtomicNumber() == 4 ||
                (getAtomicNumber() >= 11 && getAtomicNumber() <= 13) ||
                (getAtomicNumber() >= 19 && getAtomicNumber() <= 31) ||
                (getAtomicNumber() >= 37 && getAtomicNumber() <= 50) ||
                (getAtomicNumber() >= 55 && getAtomicNumber() <= 83) ||
                (getAtomicNumber() >= 87 && getAtomicNumber() <= 115)){

            new MetalElement(super.getSymbol(), super.getAtomicNumber(), (int) super.getAtomicWeight()).describeElement();
        }
        else if (getAtomicNumber() == 5 || getAtomicNumber() ==14 ||
                 getAtomicNumber() == 32 || getAtomicNumber() ==33 ||
                 getAtomicNumber() == 51 || getAtomicNumber() == 52 ||
                 getAtomicNumber() == 84){

            new Metalloid(super.getSymbol(), super.getAtomicNumber(), (int) super.getAtomicWeight()).describeElement();
        }
        else {
            new NonMetalElement(super.getSymbol(), super.getAtomicNumber(), (int) super.getAtomicWeight()).describeElement();
        }


    }
}
