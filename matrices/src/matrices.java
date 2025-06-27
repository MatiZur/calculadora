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
		        System.out.println("5 - Determinante");
		        System.out.println("6 - Transpuesta de una matriz");
		        System.out.println("7 - Inversa de una matriz");
		        System.out.println("8 - Division de matrices");
	
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
		            case 5:
		                System.out.print("Ingrese filas: ");
		                filas = scanner.nextInt();
		                System.out.print("Ingrese columnas: ");
		                columnas = scanner.nextInt();
	
		                if (filas != columnas) {
		                    System.out.println("\n\nError: La matriz debe ser cuadrada para calcular el determinante.\n\n");
		                    break;
		                }
	
		                else {
			            float[][] matriz = new float[filas][columnas];
			            cargarMatriz(matriz, filas, columnas, 1);
			            mostrarMatriz(matriz, filas, columnas);
		                float det = determinante(matriz, filas);
		                System.out.printf("\nEl determinante de la matriz es %.2f.\n\n", det);	
		                }
		                break;
		            case 6:
		                System.out.print("Ingrese filas: ");
		                filas = scanner.nextInt();
		                System.out.print("Ingrese columnas: ");
		                columnas = scanner.nextInt();
		            
		                float[][] matriz = new float[filas][columnas];
			            cargarMatriz(matriz, filas, columnas, 1);
			            float[][] mT = transpuesta(matriz, filas, columnas);
			            System.out.println("\nMatriz transpuesta:");
			            mostrarMatriz(mT, columnas, filas);
		            	break;
		            case 7:
		                System.out.print("Ingrese filas: ");
		                filas = scanner.nextInt();
		                System.out.print("Ingrese columnas: ");
		                columnas = scanner.nextInt();
		                if(filas != columnas){
		                    System.out.println("\n\nError: La matriz debe ser cuadrada para calcular la inversa.\n\n");
		                    break;}
	
		                if(filas > 4){
		                    System.out.println("\n\nError: Solo se permiten matrices de hasta 4x4 para esta operación.\n\n");
		                    break;}
	
		                float[][] matrizInv = new float[filas][columnas];
		                cargarMatriz(matrizInv, filas, columnas, 1);
	
		                System.out.println("\nMatriz original:");
		                mostrarMatriz(matrizInv, filas, columnas);
	
		                float[][] inversa = new float[filas][columnas];
	
		                if(inversa(matrizInv, inversa, filas)!= 0){
		                    System.out.println("\nLa inversa de la matriz es:");
		                    mostrarMatriz(inversa, filas, columnas);} 
		                else{
		                    System.out.println("\n\nError: La matriz no tiene inversa.\n\n");}
		                break;
		            case 8:
		                System.out.print("Ingrese filas de la matriz 1: ");
		                filas1 = scanner.nextInt();
		                System.out.print("Ingrese columnas de la matriz 1: ");
		                columnas1 = scanner.nextInt();

		                System.out.print("Ingrese filas de la matriz 2: ");
		                filas2 = scanner.nextInt();
		                System.out.print("Ingrese columnas de la matriz 2: ");
		                columnas2 = scanner.nextInt();

		                if(filas2 != columnas2){
		                    System.out.println("\n\nError: La matriz 2 debe ser cuadrada.\n\n");
		                    break;
		                }

		                if(columnas1 != filas2){
		                    System.out.println("\n\nError: Las columnas de la matriz 1 deben coincidir con las filas de la matriz 2.\n\n");
		                    break;
		                }

		                if(filas2 > 4){
		                    System.out.println("\n\nError: Solo se permiten matrices de hasta 4x4 para esta operación.\n\n");
		                    break;
		                }

		                float[][] m1Div= new float[filas1][columnas1];
		                float[][] m2Div = new float[filas2][columnas2];
		                float[][] resultadoDiv = new float[filas1][columnas2];

		                cargarMatriz(m1Div, filas1, columnas1, 1);
		                cargarMatriz(m2Div, filas2, columnas2, 2);

		                dividirMatrices(m1Div, m2Div, filas1, columnas1, filas2, columnas2, resultadoDiv);
		                break;
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
	    
	    //cofactor
	    public static void cofactor(float matriz[][], float temp[][], int p, int q, int n) {
	    	 int i = 0, j = 0;
	 	    int fila, col;
	 	    for (fila = 0; fila < n; fila++) {
	 	        for (col = 0; col < n; col++) {
	 	            if (fila != p && col != q) {
	 	                temp[i][j++] = matriz[fila][col];
	 	                if (j == n - 1) {
	 	                    j = 0;
	 	                    i++;
	 	                }
	 	            }
	 	        }
	 	    }
	 	    return;
	    } // p = fila salteada q = columna salteada
	    
	    
	    //determinante
	    public static float determinante(float[][] matriz, int n) {
	        if(n == 1){
	            return matriz[0][0];
	        }
	
	        float det = 0;
	        float[][] submatriz = new float[n][n]; 
	        int signo;
	
	        for(int col = 0; col < n; col++){
	            cofactor(matriz, submatriz, 0, col, n);
	
	            signo = (col % 2 == 0) ? 1 : -1;
	
	            det += signo * matriz[0][col] * determinante(submatriz, n - 1);
	        }
	
	        return det;
	    }
	    //transpuesta
	    public static float[][] transpuesta(float[][] matriz, int filas, int columnas) {
	    	 float[][] nMatriz = new float[columnas][filas]; 
	
	    	    for(int i = 0; i < filas; i++){
	    	        for(int j = 0; j < columnas; j++){
	    	            nMatriz[j][i] = matriz[i][j];
	    	        }
	    	    }
	
	    	    return nMatriz;
	    }
	
	    //adjinta
	    public static void adjunta(float[][] matriz, float[][] adj, int n) {
	        if(n == 1){
	            adj[0][0] = 1;
	            return;
	        }
	
	        float[][] temp = new float[n][n];
	        int signo;
	
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < n; j++){
	                cofactor(matriz, temp, i, j, n);
	                signo = ((i + j) % 2 == 0) ? 1 : -1;
	
	                adj[j][i] = signo * determinante(temp, n - 1); 
	            }
	        }
	    }
	    
	    //inversa
	    public static int inversa(float[][] matriz, float[][] inversa, int n) {
	        float det = determinante(matriz, n);
	        if(det == 0){	        	
	            return 0; 
	        }
	
	        float[][] adj = new float[n][n];
	        adjunta(matriz, adj, n);
	
	        for(int i = 0; i < n; i++){
	            for (int j = 0; j < n; j++) {
	                inversa[i][j] = adj[i][j] / det;
	            }
	        }
	
	        return 1;
	    } 
	    
	
	//division de matrices	
    public static void dividirMatrices(float[][] matriz1, float[][] matriz2, int filas1, int columnas1, int filas2, int columnas2, float[][] resultado) {
        float[][] inversa2 = new float[filas2][columnas2];

        if(inversa(matriz2, inversa2, filas2) == 0){
            System.out.println("\n\nError: La segunda matriz no tiene inversa, no se puede dividir.\n\n");
            return;
        }

        multiplicarMatrices(matriz1, inversa2, filas1, columnas1, filas2, columnas2, resultado, 8);

        System.out.println("\nEl resultado de la división entre las matrices es:");
        mostrarMatriz(resultado, filas1, columnas2);
    }
    }