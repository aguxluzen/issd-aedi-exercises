package bo;

import java.util.function.BiFunction;

public class CalculadorDeSueldo implements BiFunction<Float,Integer,Float> {

    @Override
    public Float apply(Float sueldo, Integer antiguedad) {
        if(sueldo < 4500 && antiguedad >= 10) {
            return sueldo * 1.1f;
        } else if(sueldo < 4500 && antiguedad < 10) {
            return sueldo * 1.05f;
        }
        return sueldo;
    }
}