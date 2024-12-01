/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_9_gato;

import java.util.Scanner;

/**
 *
 * @author flac3
 */
public class EVA3_9_gato {

    /**
     * @param args the command line arguments
     */
   static char[][] tablero = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};   
    public static char jugdor = 'X';
    
    public static void main(String[] args) {
        boolean juegoActivo = true;

        while (juegoActivo) {
            imprimirTablero();
            realizarMovimiento();
            if (verificarGanador()) {
                imprimirTablero();
                System.out.println("¡El jugador " + jugdor + " ha ganado!");
                juegoActivo = false;
            } else if (tableroLleno()) {
                imprimirTablero();
                System.out.println("¡Es un empate!");
                juegoActivo = false;
            } else {
                cambiarJugador();
            }
        }
    }

    private static void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]+ " ");
                
            }
            System.out.println();
            if (i < 2) System.out.println("|___|___|___|");
        }
    }

    private static void realizarMovimiento() {
        Scanner scanner = new Scanner(System.in);
        boolean movimientoValido = false;

        while (!movimientoValido) {
            System.out.println("Jugador " + jugdor + ", ingresa tu movimiento (fila y columna): ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                tablero[fila][columna] = jugdor;
                movimientoValido = true;
            } else {
                System.out.println("Movimiento inválido. Intenta nuevamente.");
            }
        }
    }

    private static void cambiarJugador() {
        jugdor = (jugdor == 'X') ? 'O' : 'X';
    }

    private static boolean verificarGanador() {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugdor && tablero[i][1] == jugdor && tablero[i][2] == jugdor)
                return true;
            if (tablero[0][i] == jugdor && tablero[1][i] == jugdor && tablero[2][i] == jugdor)
                return true;
        }
        if (tablero[0][0] == jugdor && tablero[1][1] == jugdor && tablero[2][2] == jugdor)
            return true;
        if (tablero[0][2] == jugdor && tablero[1][1] == jugdor && tablero[2][0] == jugdor)
            return true;

        return false;
    }

    private static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
