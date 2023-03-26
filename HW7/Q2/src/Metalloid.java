public class Metalloid extends Element{
    public Metalloid(String symbol, int atomicNumber, int atomicWeight) {
        super(symbol, atomicNumber, atomicWeight);
    }

    @Override
    void describeElement() {
        System.out.println("A metalloid is an element that has" +
                " properties that are intermediate  between those" +
                " of metals and nonmetals. Metalloids can also be" +
                " called semimetals. On the periodic table, the " +
                "elements colored yellow, which generally border " +
                "the stair-step line, are considered to be " +
                "metalloids.");
    }
}
