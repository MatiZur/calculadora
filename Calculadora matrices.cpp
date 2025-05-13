#include <stdio.h>

void cargarMatriz(float matriz[4][4], int filas, int columnas, int numMatriz) {
    printf("Cargar matriz %d (%dx%d):\n", numMatriz, filas, columnas);
    for(int i = 0; i < filas; i++) {
        for(int j = 0; j < columnas; j++) {
            printf("Elemento [%d][%d]: ", i, j);
            scanf("%f", &matriz[i][j]);
        }
    }
}

void mostrarMatriz(float matriz[4][4], int filas, int columnas) {
    for(int i = 0; i < filas; i++) {
        for(int j = 0; j < columnas; j++) {	
            printf("|%.2f|", matriz[i][j]);
        }
        printf("\n");
    }
}


void sumarMatrices(float matriz1[4][4], float matriz2[4][4], int filas, int columnas, float resultado[4][4]) {
    for(int i = 0; i < filas; i++) {
        for(int j = 0; j < columnas; j++) {
            resultado[i][j] = matriz1[i][j] + matriz2[i][j];
        }
    }
}


void restarMatrices(float matriz1[4][4], float matriz2[4][4], int filas, int columnas, float resultado[4][4]) {
    for(int i = 0; i < filas; i++) {
        for(int j = 0; j < columnas; j++) {
            resultado[i][j] = matriz1[i][j] - matriz2[i][j];
        }
    }
}


void multiplicarEscalar(float matriz[4][4], int filas, int columnas, int escalar, float resultado[4][4]) {
    for(int i = 0; i < filas; i++) {
        for(int j = 0; j < columnas; j++) {
            resultado[i][j] = matriz[i][j] * escalar;
        }
    }
}


void multiplicarMatrices(float matriz1[4][4], float matriz2[4][4], int filas1, int columnas1, int filas2, int columnas2, float resultado[4][4]) {
    if (columnas1 != filas2) {
        printf("Error, las columnas de la primer matriz tienen que ser iguales a las filas de la segunda \n");
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
}

float determinante(float matriz[4][4], float n) {
    if (n == 1)
        return matriz[0][0];

    int det = 0;  
    float submatriz[4][4];  
    int signo;

    for (int col = 0; col < n; col++) {
        int subi = 0;  

        for (int i = 1; i < n; i++) {
            int subj = 0;  

            for (int j = 0; j < n; j++) {
                if (j != col) {
                    submatriz[subi][subj] = matriz[i][j];
                    subj++;  
                }
            }
            subi++; 
        }
        if (col % 2 == 0) {
            signo = 1;
        } else {
            signo = -1;
        }

        det += signo * matriz[0][col] * determinante(submatriz, n - 1);
    }

    return det; 
}

void cofactor(float matriz[4][4], float temp[4][4], int p, int q, int n) { // p = fila salteada q = columna salteada
    int i = 0, j = 0;
    for (int fila = 0; fila < n; fila++) {
        for (int col = 0; col < n; col++) {
            if (fila != p && col != q) {
                temp[i][j++] = matriz[fila][col];
                if (j == n - 1) {
                    j = 0;
                    i++;
                }
            }
        }
    }
}

void adjunta(float matriz[4][4], float adj[4][4], float n) {
    if (n == 1) {
        adj[0][0] = 1;
        return;
    }
    float temp[4][4];
    int signo = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cofactor(matriz, temp, i, j, n);
            signo = ((i + j) % 2 == 0) ? 1 : -1;
            adj[j][i] = signo * determinante(temp, n - 1);
        }
    }
}

float inversa(float matriz[4][4], float inversa[4][4], float n) {
    float det = determinante(matriz, n);
    if (det == 0) {
        printf("La matriz no tiene inversa\n");
        return 0;
    }
    float adj[4][4];
    adjunta(matriz, adj, n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            inversa[i][j] = adj[i][j] / det; 
        }
    }
    return 1;
}

void dividirMatrices(float matriz1[4][4], float matriz2[4][4], int filas, int columnas, float resultado[4][4]) {
    float inversa2[4][4];
    if (inversa(matriz2, inversa2, filas) == 0) {
        printf("No se puede dividir porque la segunda matriz no tiene inversa\n");
        return;
    }
    else{
	
    multiplicarMatrices(matriz1, inversa2, filas, columnas, filas, columnas, resultado);
	}
}



int main() {
    float matriz1[4][4], matriz2[4][4], resultado[4][4];
    int filas1, columnas1, filas2, columnas2;
    float escalar;

    int opcion;
    do {
        printf("1. Sumar matrices\n");
        printf("2. Restar matrices\n");
        printf("3. Multiplicar una matriz por un escalar\n");
        printf("4. Multiplicar matrices\n");
        printf("5. Determinante de una matriz\n");
        printf("6. Inversa de una matriz\n");
        printf("7. Division de matrices\n");
        printf("0. Salir\n");
        printf("Ingrese su opcion: ");
        scanf("%d", &opcion);
        
		if(opcion == 5 || opcion == 6){
	 		printf("Ingrese las filas de la matriz: ");
			scanf("%d", &filas1);
  	 		printf("Ingrese las columnas de la matriz: ");
		   	scanf("%d", &columnas1);
    		cargarMatriz(matriz1, filas1, columnas1, 1);
		}
		else{
 		  	printf("Ingrese las filas de la matriz 1: ");
			scanf("%d", &filas1);
  	 		printf("Ingrese las columnas de la matriz 1: ");
		   	scanf("%d", &columnas1);
    		cargarMatriz(matriz1, filas1, columnas1, 1);
    		printf("Ingrese las filas de la matriz 2: ");
   			scanf("%d", &filas2);
   			printf("Ingrese las columnas de la matriz 2: ");
    		scanf("%d", &columnas2);
    		cargarMatriz(matriz2, filas2, columnas2, 2);			
		}
        switch(opcion) {
            case 1:
                if (filas1 == filas2 && columnas1 == columnas2) {
                    sumarMatrices(matriz1, matriz2, filas1, columnas1, resultado);
                    mostrarMatriz(resultado, filas1, columnas1);
                } else {
                    printf("Error, las matrices deben tener el mismo tamaño para sumar\n");
                }
                break;

            case 2:
                if (filas1 == filas2 && columnas1 == columnas2) {
                    restarMatrices(matriz1, matriz2, filas1, columnas1, resultado);
                    mostrarMatriz(resultado, filas1, columnas1);
                } else {
                    printf("Error, las matrices deben tener el mismo tamaño para restar\n");
                }
                break;

            case 3:
                printf("Ingrese el escalar: ");
                scanf("%d", &escalar);
                int opcionMatriz;
                printf("Elija la matriz para multiplicar por el escalar: ");
                scanf("%d", &opcionMatriz);
                if (opcionMatriz == 1) {
                    multiplicarEscalar(matriz1, filas1, columnas1, escalar, resultado);
                    mostrarMatriz(resultado, filas1, columnas1);
                } else if (opcionMatriz == 2) {
                    multiplicarEscalar(matriz2, filas2, columnas2, escalar, resultado);
                    mostrarMatriz(resultado, filas2, columnas2);
                } 
                break;

            case 4:
                if (columnas1 == filas2) {
                    multiplicarMatrices(matriz1, matriz2, filas1, columnas1, filas2, columnas2, resultado);
                    mostrarMatriz(resultado, filas1, columnas2);
                } else {
                    printf("Error, las matrices no tienen las dimensiones correctas para multiplicar\n");
                }
                break;
            
            case 5:
				mostrarMatriz(matriz1, filas1, columnas1);
	            	
            	 if (filas1 == columnas1) {
					
      				printf("El determinante de la matriz es: %d\n", determinante(matriz1, filas1));
    			} else {
        			printf("Error, la matriz debe ser del mismo tama?o el determinante\n");
                } 
            	break;
            
            case 6: 
                  if (filas1 == columnas1) {
                    float inversaMatriz[4][4];
                    if (inversa(matriz1, inversaMatriz, filas1)) {
                        printf("La matriz inversa es:\n");
                        mostrarMatriz(inversaMatriz, filas1, columnas1);
                    }
                } else {
                    printf("Error, la matriz debe ser del mismo tama?o para calcular la inversa\n");
                }          
            	break;
            case 7:
                if (filas1 == columnas1 && filas2 == columnas2 && filas1 == filas2) {
                    dividirMatrices(matriz1, matriz2, filas1, columnas1, resultado);
                    printf("Resultado de la division:\n");
                    mostrarMatriz(resultado, filas1, columnas1);
                } else {
                    printf("Error, ambas matrices deben ser del mismo tama?o para dividir\n");
                }
                break;
            case 0:
            	printf("Sali\n");
                break;
        }
    } while(opcion != 0);

    return 0;
}
