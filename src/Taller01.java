import java.util.Random;
import java.util.Scanner;

public class Taller01 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] matriz;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        }
        while (opcion != 6);

    }

    private static void mostrarOpciones() {
        System.out.println("=== Gestor de Matrices MxN ====");
        System.out.println("1. Generar Matriz.\n2. Llenar Matriz. \n3. Ver Matriz. \n4. Verificar Matriz 0. \n5. Eliminar Matriz. \n6. Salir.");
    }

    private static int obtenerOpcion() {
        int opcion = -1;
        while (opcion < 1 || opcion > 6) {
            System.out.println("Ingrese un comando: ");
            try {
                String entrada = scanner.nextLine();
                opcion = Integer.parseInt(entrada);
                if (opcion < 1 || opcion > 6) {
                    System.out.println("Opción no validada. Reintentar");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no validada. Reintentar.");
            }
        }
        return opcion;
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> generarMatriz();
            case 2 -> llenarMatriz(matriz);
            case 3 -> System.out.println("Ver Matriz");
            case 4 -> System.out.println("Verificar Matriz 0");
            case 5 -> System.out.println("Eliminar Matriz:");
            case 6 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no reconocida.");
        }
    }

    private static void generarMatriz(){
        if (verificarMatrizCreada()) {
            System.out.println("Ya hay una matriz generada, ¿Desea reemplazarla? (s/n)");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                System.out.println("Operación cancelada.");
                return;
            }
        }
        int m = verificarEnteroPositivo("Ingresar N° filas: ");
        int n = verificarEnteroPositivo("Ingresar N° columnas: ");

        if (validarDimensiones(m, n)) {
            matriz = new int[m][n];
            System.out.println("Matriz de " + m + " X " + n + " generada con éxito.\n");
        } else {
            System.out.println("Dimensiones ingresadas no válidas.");
        }
    }

    private static boolean validarDimensiones(int m, int n){
        return m > 0 && n > 0;
    }

    private static boolean verificarMatrizCreada() {
        return matriz != null;
    }

    private static int verificarEnteroPositivo(String msg) {
        int numero = -1;
        while (numero <= 0) {
            System.out.println(msg);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero <= 0) {
                    System.out.println("El número debe ser mayor que cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida.");
            }
        }
        return numero;
    }

    private static void llenarMatriz(int[][] matriz) {
        if (!verificarMatrizCreada()) {
            System.out.println("No hay matriz ingresada. No se puede acceder.\n");
            return;
        }
        Random random = new Random();
        for(int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(10);
            }
        }
        System.out.println("Matriz rellenada con éxito.\n");
    }
}
