public class Deduction {

    private int TheNumerator;
    private int Denominator;

    public Deduction() {
    }

    public Deduction(int theNumerator, int denominator) {
        TheNumerator = theNumerator;
        Denominator = denominator;

        for (int i = 2; i < denominator ; i++) {
            if (theNumerator % i ==0 && denominator % i ==0){
             this.TheNumerator/=i;
             this.Denominator/=i;
            }
        }
    }

    @Override
    public String toString() {
        return this.TheNumerator + "/"+ this.Denominator;
    }

    public String add(Deduction deduction){
        Deduction deduction1 = new Deduction();
        deduction1.TheNumerator=(this.TheNumerator * deduction.Denominator) + (deduction.TheNumerator*this.Denominator);
        deduction1.Denominator = this.Denominator*deduction.Denominator;
        for (int i = 2; i < deduction1.Denominator ; i++) {
            if (deduction1.TheNumerator % i ==0 && deduction1.Denominator % i ==0){
                deduction1.TheNumerator/=i;
                deduction1.Denominator/=i;
            }
        }
       return deduction1.toString();
    }
    public String sub(Deduction deduction){
        Deduction deduction1 = new Deduction();
        deduction1.TheNumerator=(this.TheNumerator * deduction.Denominator) - (deduction.TheNumerator*this.Denominator);
        deduction1.Denominator = this.Denominator * deduction.Denominator;
        for (int i = 2; i < deduction1.Denominator ; i++) {
            if (deduction1.TheNumerator % i ==0 && deduction1.Denominator % i ==0){
                deduction1.TheNumerator/=i;
                deduction1.Denominator/=i;
            }
        }
        return deduction1.toString();
    }
    public String mul(Deduction deduction){
        Deduction deduction1 = new Deduction();
        deduction1.TheNumerator=this.TheNumerator * deduction.TheNumerator;
        deduction1.Denominator = this.Denominator * deduction.Denominator;
        for (int i = 2; i < deduction1.Denominator ; i++) {
            if (deduction1.TheNumerator % i ==0 && deduction1.Denominator % i ==0){
                deduction1.TheNumerator/=i;
                deduction1.Denominator/=i;
            }
        }
        return deduction1.toString();
    }
    public String div(Deduction deduction){
        Deduction deduction1 = new Deduction();
        deduction1.TheNumerator=this.TheNumerator * deduction.Denominator;
        deduction1.Denominator = this.Denominator * deduction.TheNumerator;
        for (int i = 2; i < deduction1.Denominator ; i++) {
            if (deduction1.TheNumerator % i ==0 && deduction1.Denominator % i ==0){
                deduction1.TheNumerator/=i;
                deduction1.Denominator/=i;
            }
        }
        return deduction1.toString();
    }
    public float floatingPoint(){
        float n = this.TheNumerator;
        float d = this.Denominator;
        float ans = n/d;
        return ans;
    }

    public int getTheNumerator() {
        return TheNumerator;
    }

    public void setTheNumerator(int theNumerator) {
        TheNumerator = theNumerator;
    }

    public int getDenominator() {
        return Denominator;
    }

    public void setDenominator(int denominator) {
        Denominator = denominator;
    }
}
