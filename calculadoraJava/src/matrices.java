import java.util.Scanner;

public class matrices {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Menu
	        System.out.println("Seleccione una operación:");
	        System.out.println("1 - Sumar matrices");
	        System.out.println("2 - Restar matrices");
	        System.out.println("3 - Multiplicar por escalar");
	        System.out.println("4 - Multiplicar matrices");
	        int opcion = scanner.nextInt();

	        int filas, columnas;

	        switch (opcion) {
	            case 1: // Sumar
	            case 2: // Restar
	                System.out.print("Ingrese filas: ");
	                filas = scanner.nextInt();
	                System.out.print("Ingrese columnas: ");
	                columnas = scanner.nextInt();

	                float[][] m1 = new float[filas][columnas];
	                float[][] m2 = new float[filas][columnas];
	                float[][] resultado = new float[filas][columnas];

	                cargarMatriz(m1, filas, columnas, 1);
	                cargarMatriz(m2, filas, columnas, 2);

	                if (opcion == 1) {
	                    sumarMatriz(m1, m2, filas, columnas, resultado);
	                } else {
	                    restarMatriz(m1, m2, filas, columnas, resultado);
	                }
	                mostrarMatriz(resultado, filas, columnas);
	                break;

	            case 3: // Multiplicar por escalar
	                System.out.print("Ingrese filas: ");
	                filas = scanner.nextInt();
	                System.out.print("Ingrese columnas: ");
	                columnas = scanner.nextInt();

	                float[][] m3 = new float[filas][columnas];
	                float[][] resultadoEscalar = new float[filas][columnas];

	                cargarMatriz(m3, filas, columnas, 1);

	                System.out.print("Ingrese el escalar: ");
	                float escalar = scanner.nextFloat();

	                multiplicarEscalar(m3, filas, columnas, escalar, resultadoEscalar);
	                mostrarMatriz(resultadoEscalar, filas, columnas);
	                break;

	            case 4: // Multiplicacion de matrices
	                System.out.print("Ingrese filas de la matriz 1: ");
	                int filas1 = scanner.nextInt();
	                System.out.print("Ingrese columnas de la matriz 1: ");
	                int columnas1 = scanner.nextInt();

	                System.out.print("Ingrese filas de la matriz 2: ");
	                int filas2 = scanner.nextInt();
	                System.out.print("Ingrese columnas de la matriz 2: ");
	                int columnas2 = scanner.nextInt();

	                if (columnas1 != filas2) {
	                    System.out.println("ERROR: Las columnas de la primera matriz deben coincidir con las filas de la segunda.");
	                    break;
	                }

	                float[][] mA = new float[filas1][columnas1];
	                float[][] mB = new float[filas2][columnas2];
	                float[][] resultadoMult = new float[filas1][columnas2];

	                cargarMatriz(mA, filas1, columnas1, 1);
	                cargarMatriz(mB, filas2, columnas2, 2);

	                multiplicarMatrices(mA, mB, filas1, columnas1, filas2, columnas2, resultadoMult, 4);
	                mostrarMatriz(resultadoMult, filas1, columnas2);
	                break;

	            default:
	                System.out.println("Opción inválida.");
	        }

	        scanner.close();
	    }

    //cargarMatriz
    public static void cargarMatriz(float[][] matriz, int filas, int columnas, int numMatriz) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Carga de la matriz " + numMatriz + " (" + filas + "x" + columnas + "):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + (i+ 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = sc.nextFloat();
            }
        }
    }
    
    //mostrarMatriz 
    
    public static void mostrarMatriz(float matriz[][], int filas, int columnas) {
    	for(int i = 0; i < filas; i++) {
	    	System.out.print("| ");
	        for(int j = 0; j < columnas; j++) {	
	            System.out.printf("%.2f ",  matriz[i][j]);
	        }
	        System.out.println("|");
	    }
	   
	    return;
    }
    
    //sumarMatrices
    public static void sumarMatriz(float matriz1[][], float matriz2[][], int filas, int columnas, float resultado[][]) {
    	for(int i = 0; i < filas; i++) {
	        for(int j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz1[i][j] + matriz2[i][j];
	        }
	    }
	    System.out.println("\n\nEl resultado de la suma entre las matrices es:\n");
	    return;
    }
    
    //restarMatriz
    
    public static void restarMatriz(float matriz1[][], float matriz2[][], int filas, int columnas, float resultado[][]) {
    	for(int i = 0; i < filas; i++) {
	        for(int j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz1[i][j] - matriz2[i][j];
	        }
	    }
	    System.out.println("\n\nEl resultado de la resta entre las matrices es:\n");
	    return;
    }
    
    //multiplicarEscalar
    
    public static void multiplicarEscalar(float matriz[][], int filas, int columnas, float escalar, float resultado[][]) {
    	for(int i = 0; i < filas; i++) {
	        for(int j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz[i][j] * escalar;
	        }
	    }
	    System.out.println("\n\nEl resultado de la multiplicacion entre la matriz y el escalar es:\n");
	    return;
    }
    
    //multiplicarMatrices
    
    public static void multiplicarMatrices(float matriz1[][], float matriz2[][], int filas1, int columnas1, int filas2, int columnas2, float resultado[][], int opcion) {
    	if (columnas1 != filas2) {
	        System.out.println("Error: Las columnas de la primer matriz tienen que ser iguales a las filas de la segunda.");
	        return;
	    }
	    for(int i = 0; i < filas1; i++) {
	        for(int j = 0; j < columnas2; j++) {
	            resultado[i][j] = 0;
	            for(int k = 0; k < columnas1; k++) {
	               resultado[i][j] = resultado[i][j] + matriz1[i][k] * matriz2[k][j];
	            }
	        }
	    }
	    if(opcion==4){
	    	System.out.println("El resultado de la multiplicacion entre las matrices es:");
		}
	    return;
    }
}
