package H5;

public class TemperaturTest {
    public static void main(String[] args) {
        Temperatur tc = null;
        Temperatur tk = null;

        Temperatur tc_m = null;
        Temperatur tk_i = null;

        Temperatur tcc = null;
        Temperatur tkk = null;

        try {
            tcc = new Temperatur("Kelvin", 0);
            System.out.println(tcc);
            tcc.convertToCelsius();
            System.out.println(tcc);

            tkk = new Temperatur("Celsius", 200);
            System.out.println(tkk);
            tkk.convertToKelvin();
            System.out.println(tkk);
            tkk.convertToCelsius();
            System.out.println(tkk);




            tc = new Temperatur("Celsius", 100);
            System.out.println(tc);

            tk = new Temperatur("Kelvin", 200);
            System.out.println(tk);

            tc_m = new Temperatur("Celsius", 1);
            tc.reduceTemperature(tc_m);
            System.out.println(tc);

            tk_i = new Temperatur("Kelvin", 20);
            tk.increaseTemperature(tk_i);
            System.out.println(tk);

        } catch (InvalidTemperaturException iv) {
            System.out.println(iv.getMessage());
        } catch (IncompatibleTemperaturException ic) {
            System.out.println(ic.getMessage());
        }



    }
}
