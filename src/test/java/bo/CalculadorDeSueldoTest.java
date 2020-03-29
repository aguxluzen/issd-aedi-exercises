package bo;

import bo.CalculadorDeSueldo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuiteDisplayName("Ejercicio 15")
class CalculadorDeSueldoTest {

    public static final Float SUELDO_MENOR_4500 = 4499f;
    public static final Float SUELDO_MAYOR_4500 = 4501f;
    public static final Float SUELDO_IGUAL_4500 = 4500F;
    public static final Integer ANTIGUEDAD_10_ANIOS = 10;
    public static final Integer ANTIGUEDAD_11_ANIOS = 11;
    public static final Integer ANTIGUEDAD_9_ANIOS = 9;



    @DisplayName("Si el sueldo es menor a 4500 y su antiguedad es mayor o igual a 10 años otorgarle un aumento del 10%")
    @ParameterizedTest
    @MethodSource("argumentosParaAumentoDelDiezPorciento")
    void cuando_sueldo_es_menor_a_4500_y_antiguedad_mayor_o_igual_a_10_entonces_aumento_10(Float sueldo, Integer antiguedad) {
        CalculadorDeSueldo sut = new CalculadorDeSueldo();
        Float sueldoCalculado = sut.apply(sueldo, antiguedad);

        assertThat(sueldoCalculado).isEqualTo(4948.90f);
    }


    @DisplayName("Si el sueldo es menor a 4500 y su antiguedad es menor a 10 años otorgarle un aumento del 5%")
    @Test
    void cuando_sueldo_es_menor_a_4500_y_antiguedad_menor_a_10_entonces_aumento_5() {
        CalculadorDeSueldo sut = new CalculadorDeSueldo();

        Float sueldoCalculado = sut.apply(SUELDO_MENOR_4500, ANTIGUEDAD_9_ANIOS);

        assertThat(sueldoCalculado).isEqualTo(4723.9497f);
    }

    @DisplayName("Si el sueldo es mayor o igual a 4500 no realizarle ningun aumento")
    @ParameterizedTest
    @MethodSource("argumentosSueldoMayorOIgual4500")
    void cuando_el_sueldo_es_mayor_o_igual_a_4500_no_realizarle_ningun_aumento(Float sueldo, Integer antiguedad) {
        CalculadorDeSueldo sut = new CalculadorDeSueldo();

        Float sueldoCalculado = sut.apply(sueldo, antiguedad);

        assertThat(sueldoCalculado).isEqualTo(sueldo);
    }


    private static Stream<Arguments> argumentosParaAumentoDelDiezPorciento() {
        return Stream.of(
                Arguments.of(SUELDO_MENOR_4500, ANTIGUEDAD_10_ANIOS),
                Arguments.of(SUELDO_MENOR_4500, ANTIGUEDAD_11_ANIOS)
        );
    }

    private static Stream<Arguments> argumentosSueldoMayorOIgual4500() {
        return Stream.of(
                Arguments.of(SUELDO_MAYOR_4500, ANTIGUEDAD_10_ANIOS),
                Arguments.of(SUELDO_MAYOR_4500, ANTIGUEDAD_11_ANIOS),
                Arguments.of(SUELDO_MAYOR_4500, ANTIGUEDAD_9_ANIOS),
                Arguments.of(SUELDO_IGUAL_4500, ANTIGUEDAD_10_ANIOS),
                Arguments.of(SUELDO_IGUAL_4500, ANTIGUEDAD_11_ANIOS),
                Arguments.of(SUELDO_IGUAL_4500, ANTIGUEDAD_9_ANIOS)
        );
    }




}