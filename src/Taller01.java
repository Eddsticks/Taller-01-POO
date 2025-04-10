import java.util.Scanner;

public class Taller01 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        mostrarOpciones();
        int opcion = obtenerOpcion();
        ejecutarOpcion(opcion);

    }

    private static void mostrarOpciones() {
        System.out.println("=== Gestor de Matrices MxN ====");
        System.out.println("1. Generar Matriz.\n2. Llenar Matriz. \n3. Ver Matriz. \n4. Verificar Matriz 0. \n5. Salir del sistema.");
    }

    private static int obtenerOpcion() {
        int opcion = -1;
        while (opcion < 1 || opcion > 5) {
            System.out.println("Ingrese un comando: ");
            try {
                String entrada = scanner.nextLine();
                opcion = Integer.parseInt(entrada);
                if (opcion < 1 || opcion > 5) {
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
            case 1 -> System.out.println("Generar Matriz");
            case 2 -> System.out.println("Llenar Matriz");
            case 3 -> System.out.println("Ver Matriz");
            case 4 -> System.out.println("Verificar Matriz 0");
            case 5 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no reconocida.");
        }
    }

    private static int[][] generarMatriz(int m, int n){

    }

    private static boolean validarDimensiones(int m, int n){
        return m > 0 && n > 0;

    }
}
