package tareaentrevista;

import java.util.Scanner;

/**
 *
 * Maryelis Ordaz
 */
public class TareaEntrevista {

    public static void main(String[] args) {
        //declarar el scanner que permite leer infomacion ingresada por teclado
        Scanner sc = new Scanner(System.in);
        //declaración de las variables, double para que no haya errores con ningun tipo de medida
        double anchoPanel, alturaPanel, anchoTecho, alturaTecho, areaTecho, areaPanel;

        // Solicitar al usuario el ancho y la altura del techo
        System.out.println("Ingrese el ancho del techo:");
        //validamos que los datos ingresados sean correcto y acorde a lo que se necesita
        anchoTecho = validarDimensiones(sc);

        System.out.println("Ingrese el altura del techo:");
        alturaTecho = validarDimensiones(sc);

        System.out.println("Ingrese el ancho del panel:");
        anchoPanel = validarDimensiones(sc);

        System.out.println("Ingrese la altura del panel:");
        alturaPanel = validarDimensiones(sc);

        areaTecho = calcularArea(alturaTecho, anchoTecho);
        areaPanel = calcularArea(anchoPanel, alturaPanel);

        System.out.println("La cantidad de panales que caben en el techo con area de: "
                + areaTecho + " es de: " + cantidadPaneles((int) anchoPanel, (int) anchoTecho, (int) alturaTecho, (int) alturaPanel, (int) areaTecho, (int) areaPanel));

    }

    public static double validarDimensiones(Scanner sc) {
        double dimension;
        while (true) {
            if (sc.hasNextDouble()) {
                dimension = sc.nextDouble();
                if (dimension <= 0) {
                    System.out.println("Error: Por favor ingrese un valor válido (mayor que cero):");
                } else {
                    break; // Salir del bucle si el valor es válido
                }
            } else {
                System.out.println("Error: Por favor ingrese un número válido:");
                sc.next(); // Descartar la lectura no valida
            }
        }
        return dimension;

    }

    public static double calcularArea(double altura, double ancho) {
        return (altura * ancho);
    }

    public static int cantidadPaneles(int anchoPanel, int anchoTecho, int altoTecho, int altoPanel, int areaTecho, int areaPanel) {
        // Calcula el número máximo de paneles que caben horizontalmente
        double panelesHorizontales = (anchoTecho / anchoPanel);
        // Calcula el número máximo de paneles que caben verticalmente
        double panelesVerticales = (altoTecho / altoPanel);
        // Verifica si los paneles caben completamente en el techo en su posicion actual
        if (panelesHorizontales == 0 || panelesVerticales == 0) {
            // Calcula la cantidad de paneles que caben horizontalmente al rotarlos
            int panelesHorizontalesRotados = anchoTecho / altoPanel;
            // Calcula la cantidad de paneles que caben verticalmente al rotarlos
            int panelesVerticalesRotados = altoTecho / anchoPanel;
            //verificamos si no cabe ningun panel al rotarlos
            if (panelesHorizontalesRotados == 0 || panelesVerticalesRotados == 0) {
                //en caso de que no quepan devolvemos 0
                return 0;

            } else {
                //si caben rotados devolvemos la cantidad que caben
                return areaTecho / areaPanel;
            }

        } else {
            //devolvemos la cantidad que cabe sin necesidad de rotarlos
            return areaTecho / areaPanel;

        }
    }
}
