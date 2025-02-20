package juego;

import java.util.Random;
import java.util.Scanner;

/**
 * Juego de adivinar el número generado por la máquina.
 *
 * @author Ricardo
 */
public class AdivinaNumero {

    private int numeroSecreto;
    private int intentos;

    /**
     * Constructor quye genera un número aleatorio del 1 al 100.
     */
    public AdivinaNumero() {
        Random random = new Random();
        this.numeroSecreto = random.nextInt(100) + 1;
        this.intentos = 0;
    }

    /**
     * Verifica si el número ingresado por el usuario es correcto.
     *
     * @param numero Recoge el número ingresado por el usuario.
     * @return Muestra mensaje indicando si el número es correcto, mayor o menor.
     */
    public String verificarNumero(int numero) {
        intentos++;
        if (numero == numeroSecreto) {
            return "¡Felicidades! Has adivinado el número en " + intentos + " intentos.";
        } else if (numero < numeroSecreto) {
            return "El número es mayor. Intenta de nuevo.";
        } else {
            return "El número es menor. Intenta de nuevo.";
        }
    }

    /**
     * Obtiene el número de intentos realizados.
     *
     * @return devuelve el Número de intentos.
     */
    public int getIntentos() {
        return intentos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdivinaNumero juego = new AdivinaNumero();
        int numero;
        String mensaje;

        System.out.println("¡Bienvenido al juego de adivinanza!");
        System.out.println("Intenta adivinar el número entre 1 y 100.");

        do {
            System.out.print("Ingresa un número: ");
            numero = scanner.nextInt();
            mensaje = juego.verificarNumero(numero);
            System.out.println(mensaje);
        } while (!mensaje.contains("¡Felicidades!"));

        scanner.close();
    }
}
