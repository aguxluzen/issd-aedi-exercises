import bo.CalculadorDeSueldo;

import java.util.Scanner;


public class Exercise15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Float sueldo = scanner.nextFloat();
        int antiguedad = scanner.nextInt();

        CalculadorDeSueldo calculadorDeSueldo = new CalculadorDeSueldo();
        Float sueldoFinal = calculadorDeSueldo.apply(sueldo, antiguedad);

        System.out.println(String.format("El sueldo a cobrar es %s", sueldoFinal));
    }

}