package Operaciones;

import java.util.Scanner;
public class Vectores {
	
	public static boolean validacionTamanio(int tam1, int tam2) {
        return tam1 == tam2;
    }

    public static void ingresoDosVectores(float[] vector1, float[] vector2, int[] tam1, int[] tam2, Scanner sc) {
        do {
            System.out.print("\n\nIngrese el tamaño del vector 1: ");
            tam1[0] = sc.nextInt();
            if (tam1[0] <= 0) {
                System.out.print("\nError: No puede haber un vector con un tamaño igual o menor a 0.\n");
            }
        } while (tam1[0] <= 0);

        for (int i = 0; i < tam1[0]; i++) {
            System.out.print("Ingrese el valor " + (i + 1) + " del vector 1: ");
            vector1[i] = sc.nextFloat();
        }

        do {
            System.out.print("\nIngrese el tamaño del vector 2: ");
            tam2[0] = sc.nextInt();
            if (tam2[0] <= 0) {
                System.out.print("\nError: No puede haber un vector con un tamaño igual o menor a 0.\n");
            }
        } while (tam2[0] <= 0);

        for (int i = 0; i < tam2[0]; i++) {
            System.out.print("Ingrese el valor " + (i + 1) + " del vector 2: ");
            vector2[i] = sc.nextFloat();
        }
    }

    public static int ingresoUnVector(float[] vector, Scanner sc) {
        int[] tam = new int[1];
        do {
            System.out.print("\n\nIngrese el tamaño del vector: ");
            tam[0] = sc.nextInt();
            if (tam[0] <= 0) {
                System.out.print("\nError: No puede haber un vector con un tamaño igual o menor a 0.\n");
            }
        } while (tam[0] <= 0);

        for (int i = 0; i < tam[0]; i++) {
            System.out.print("Ingrese el valor " + (i + 1) + " del vector: ");
            vector[i] = sc.nextFloat();
        }

        return tam[0];
    }

    public static void ingresoDosVectores3N(float[] vector1, float[] vector2, Scanner sc) {
        int tam = 3;
        System.out.print("\n\n");

        for (int i = 0; i < tam; i++) {
            System.out.print("Ingrese el valor " + (i + 1) + " del vector 1: ");
            vector1[i] = sc.nextFloat();
        }

        System.out.print("\n");

        for (int i = 0; i < tam; i++) {
            System.out.print("Ingrese el valor " + (i + 1) + " del vector 2: ");
            vector2[i] = sc.nextFloat();
        }
    }

    public static void mostrarVectores(float[] vector1, float[] vector2, int tam) {
        System.out.print("\nVector 1: |");
        for (int i = 0; i < tam; i++) {
            System.out.print(" " + vector1[i]);
        }

        System.out.print(" |\nVector 2: |");
        for (int i = 0; i < tam; i++) {
            System.out.print(" " + vector2[i]);
        }
        System.out.print(" |\n");
    }

    public static void sumaVectores(float[] vector1, float[] vector2, int tam) {
        float[] res = new float[tam];
        for (int i = 0; i < tam; i++) {
            res[i] = vector1[i] + vector2[i];
        }
        mostrarVectores(vector1, vector2, tam);
        System.out.print("\n\nEl resultado de la suma entre ambos vectores es: |");
        for (int i = 0; i < tam; i++) {
            System.out.print(" " + res[i]);
        }
        System.out.print(" |\n\n");
    }

    public static void restaVectores(float[] vector1, float[] vector2, int tam) {
        float[] res = new float[tam];
        for (int i = 0; i < tam; i++) {
            res[i] = vector1[i] - vector2[i];
        }
        mostrarVectores(vector1, vector2, tam);
        System.out.print("\n\nEl resultado de la resta entre ambos vectores es: |");
        for (int i = 0; i < tam; i++) {
            System.out.print(" " + res[i]);
        }
        System.out.print(" |\n\n");
    }

    public static void multiEscalar(float[] vector, int tam, Scanner sc) {
        float[] res = new float[tam];
        System.out.print("\nIngrese el valor del escalar: ");
        float escalar = sc.nextFloat();
        for (int i = 0; i < tam; i++) {
            res[i] = escalar * vector[i];
        }

        System.out.print("\nVector: |");
        for (int i = 0; i < tam; i++) {
            System.out.print(" " + vector[i]);
        }
        System.out.print(" |\n");

        System.out.print("\n\nEl resultado de la multiplicación entre el escalar y el vector es: |");
        for (int i = 0; i < tam; i++) {
            System.out.print(" " + res[i]);
        }
        System.out.print(" |\n\n");
    }

    public static void productoEscalar(float[] vector1, float[] vector2, int tam) {
        float res = 0;
        for (int i = 0; i < tam; i++) {
            res += vector1[i] * vector2[i];
        }
        mostrarVectores(vector1, vector2, tam);
        System.out.print("\n\nEl resultado del producto escalar entre ambos vectores es: " + res + "\n\n");
    }

    public static void productoVectorial(float[] vector1, float[] vector2) {
        float[] res = new float[3];
        res[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        res[1] = -(vector1[0] * vector2[2] - vector1[2] * vector2[0]);
        res[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];
        mostrarVectores(vector1, vector2, 3);
        System.out.print("\n\nEl resultado del producto vectorial entre ambos vectores es: ( "
                + res[0] + ", " + res[1] + ", " + res[2] + " )\n\n");
    }

    public static void main(String[] args) {
        int opcion, tam = 0;
        int[] tam1 = new int[1];
        int[] tam2 = new int[1];
        Scanner sc = new Scanner(System.in);
        float[] vector = new float[100];
        float[] vector1 = new float[100];
        float[] vector2 = new float[100];

        do {
            System.out.print("\n\n1: Suma | 2: Resta | 3: Multiplicación por escalar | 4: Producto escalar | 5: Producto vectorial (3 dimensiones) | 6: Salir\n\nIngrese su opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresoDosVectores(vector1, vector2, tam1, tam2, sc);
                    if (validacionTamanio(tam1[0], tam2[0])) {
                        tam = tam1[0];
                        sumaVectores(vector1, vector2, tam);
                    } else {
                        System.out.print("\nError: Los tamaños de los vectores son distintos.\n");
                    }
                    break;

                case 2:
                    ingresoDosVectores(vector1, vector2, tam1, tam2, sc);
                    if (validacionTamanio(tam1[0], tam2[0])) {
                        tam = tam1[0];
                        restaVectores(vector1, vector2, tam);
                    } else {
                        System.out.print("\nError: Los tamaños de los vectores son distintos.\n");
                    }
                    break;

                case 3:
                    tam = ingresoUnVector(vector, sc);
                    multiEscalar(vector, tam, sc);
                    break;

                case 4:
                    ingresoDosVectores(vector1, vector2, tam1, tam2, sc);
                    if (validacionTamanio(tam1[0], tam2[0])) {
                        tam = tam1[0];
                        productoEscalar(vector1, vector2, tam);
                    } else {
                        System.out.print("\nError: Los tamaños de los vectores son distintos.\n");
                    }
                    break;

                case 5:
                    ingresoDosVectores3N(vector1, vector2, sc);
                    productoVectorial(vector1, vector2);
                    break;

                case 6:
                    System.out.print("\n\nSaliendo de Vectores...\n\n\n\n");
                    break;

                default:
                    System.out.print("\n\nError: Opción inválida.\n");
                    break;
            }

        } while (opcion != 6);
    }
}
