package H5;

/**
 * @author myry
 * @date 2024-35-27 23:35
 */

public class Temperatur {
    private String type = "";
    private double wert;

    public Temperatur(){}
    public Temperatur(String type, double wert) throws IncompatibleTemperaturException, InvalidTemperaturException {
        if (!(type.equals("Celsius") || type.equals("Kelvin"))) {
            throw new IncompatibleTemperaturException("Type nur Celsius oder Kelvin");
        }
        this.type = type;

        if (type.equals("Celsius")) {
            if (wert < -273.15) {
                throw new InvalidTemperaturException("falsche Werte");
            }else {
                this.wert = wert;
            }
        }

        if (type.equals("Kelvin")) {
            if (wert < 0) {
                throw new InvalidTemperaturException("falsche Werte");
            } else {
                this.wert = wert;
            }
        }
    }

    void convertToCelsius() {
        this.type = "Celsius";
        this.wert -= 273.15;
    }

    void convertToKelvin() {
        this.type = "Kelvin";
        this.wert += 273.15;
    }

    //温度升高
    void increaseTemperature(Temperatur diff) throws IncompatibleTemperaturException {
        if (!(diff.getType().equals(this.type))) {
            throw new IncompatibleTemperaturException("falsche Type");
        }

        this.wert += diff.getWert();
    }

    void reduceTemperature(Temperatur diff) throws InvalidTemperaturException, IncompatibleTemperaturException {
        if (!(diff.getType().equals(this.type))) {
            throw new IncompatibleTemperaturException("falsche Type");
        }

        if (this.type.equals("Celsius")) {
            if (this.wert - diff.getWert() < -273.15) {
                throw new InvalidTemperaturException("falsche Werte");
            }else {
                this.wert -= diff.getWert();
            }
        }

        if (this.type.equals("Kelvin")) {
            if (this.wert - diff.getWert() < 0) {
                throw new InvalidTemperaturException("falsche Werte");
            } else {
                this.wert -= diff.getWert();
            }
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }

    public String toString() {
        return "Temperature " + this.type + " is " + this.wert;
    }
}
