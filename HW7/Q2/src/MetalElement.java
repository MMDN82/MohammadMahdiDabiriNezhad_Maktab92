public class MetalElement extends Element{

    public MetalElement(String symbol, int atomicNumber, int atomicWeight) {
        super(symbol, atomicNumber, atomicWeight);
    }

    @Override
    void describeElement() {
        System.out.println("Metal or metals are a group of non-transparent, fusible," +
                " flexible and usually shiny materials that also have good electrical and " +
                "thermal conductivity. In chemistry, metals are substances that readily form" +
                " cations by losing their electrons, producing basic oxides and hydroxides.");
    }

}
