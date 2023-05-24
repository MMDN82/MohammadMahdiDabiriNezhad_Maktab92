import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DeductionTest {
    static Deduction deduction1;
    static Deduction deduction2;
    static Deduction deduction3;
    @BeforeAll
    static void setup(){
        deduction1 = new Deduction(2,4);
        deduction2 = new Deduction(3,9);
        deduction3 = new Deduction(2,10);

    }
    @Test
    void simplify (){
        assertTrue(deduction1.getTheNumerator()==1 &&deduction1.getDenominator()==2 );
        assertTrue(deduction2.getTheNumerator()==1 &&deduction2.getDenominator()==3 );
        assertTrue(deduction3.getTheNumerator()==1 &&deduction3.getDenominator()==5 );
    }
    @Test
    void printTest(){
        assertEquals("1/2", deduction1.toString());
        assertEquals("1/3", deduction2.toString());
        assertEquals("1/5", deduction3.toString());
    }
  @Test
    void addTest(){
      assertEquals("5/6", deduction1.add(deduction2));
      assertEquals("5/6", deduction2.add(deduction1));
      assertEquals("7/10", deduction1.add(deduction3));
      assertEquals("7/10", deduction3.add(deduction1));
      assertEquals("8/15", deduction2.add(deduction3));
      assertEquals("8/15", deduction3.add(deduction2));
    }
    @Test
    void subTest(){
        assertEquals("1/6", deduction1.sub(deduction2));
        assertEquals("-1/6", deduction2.sub(deduction1));
        assertEquals("3/10", deduction1.sub(deduction3));
        assertEquals("-3/10", deduction3.sub(deduction1));
        assertEquals("2/15", deduction2.sub(deduction3));
        assertEquals("-2/15", deduction3.sub(deduction2));
    }
    @Test
    void mulTest(){
        assertEquals("1/6", deduction1.mul(deduction2));
        assertEquals("1/6", deduction2.mul(deduction1));
        assertEquals("1/10", deduction1.mul(deduction3));
        assertEquals("1/10", deduction3.mul(deduction1));
        assertEquals("1/15", deduction2.mul(deduction3));
        assertEquals("1/15", deduction3.mul(deduction2));
    }
    @Test
    void divTest(){
        assertEquals("3/2", deduction1.div(deduction2));
        assertEquals("2/3", deduction2.div(deduction1));
        assertEquals("5/2", deduction1.div(deduction3));
        assertEquals("2/5", deduction3.div(deduction1));
        assertEquals("5/3", deduction2.div(deduction3));
        assertEquals("3/5", deduction3.div(deduction2));
    }

    @Test
    void floatingTest(){
        assertEquals(0.5, deduction1.floatingPoint());
    }

}