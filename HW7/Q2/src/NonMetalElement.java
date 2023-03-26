public class NonMetalElement extends Element{

    public NonMetalElement(String symbol, int atomicNumber, int atomicWeight) {
        super(symbol, atomicNumber, atomicWeight);
    }

    @Override
    void describeElement() {
        System.out.println("In their solid form, they are opaque and brittle, do not have" +
                " a metallic luster, are not malleable, and do not have hammering properties." +
                " They usually have a lower bulk mass or density than metals. They have" +
                " significantly lower melting and boiling temperatures than metals. Nonmetals" +
                " have a higher electronegativity.");

    }
}
