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
        System.out.println("---- GESTOR DE PISTOLAS IMPERIAL ----");
        System.out.println("1. Agregar Pistola.\n2. Quitar Pistola. \n3. Generar Listado. \n4. Buscar Pistola. \n5. Salir del sistema.");
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
            case 1 -> System.out.println("Función 1");
            case 2 -> System.out.println("Función 2");
            case 3 -> System.out.println("Función 3");
            case 4 -> System.out.println("Función 4");
            case 5 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no reconocida.");
        }
    }
}
