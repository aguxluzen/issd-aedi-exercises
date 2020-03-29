import java.util.Scanner;

public class Exercise15v2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float sueldo = scanner.nextFloat();
        int antiguedad = scanner.nextInt();
        float sueldoFinal = sueldo;

        if(sueldo < 4500 && antiguedad >= 10) {
            sueldoFinal = sueldo * 1.1f;
        } else if(sueldo < 4500 && antiguedad < 10) {
            sueldoFinal = sueldo * 1.05f;
        }

        System.out.println(String.format("El sueldo a cobrar es %s", sueldoFinal));
    }

}