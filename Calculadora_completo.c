#include <stdio.h>
#include <math.h>
int i, j, k;

	void suma(float *num1, float *num2){
		float res = *num1 + *num2;
		printf("\nLa suma entre %f y %f da %f.\n\n", *num1, *num2, res);
	}
	
	void resta(float *num1, float *num2){
		float res = *num1 - *num2;
		printf("\nLa resta entre %f y %f da %f.\n\n", *num1, *num2, res);
	}
	
	void multi(float *num1, float *num2){
		float res = *num1 * *num2;
		printf("\nLa multiplicacion entre %f y %f da %f.\n\n", *num1, *num2, res);
	}
	
	void divi(float *num1, float *num2){
		float res = *num1 / *num2;
		printf("\nLa division entre %f y %f da %f.\n\n", *num1, *num2, res);
	}
	
	void potencia(){
		float num1, num2;
		printf("\nIngrese un numero: ");
		scanf("%f",&num1);
		printf("Ingrese el exponente: ");
		scanf("%f",&num2);
		float res = pow(num1, num2);
		printf("\nLa potencia de %f de exponente %f da %f.\n\n", num1, num2, res);
	}
	
	void raiz(){
		float num1, num2;
		do{
			printf("\nIngrese un numero: ");
			scanf("%f",&num1);
			if(num1<0){
				printf("\nError: El numero no puede ser negativo.\n");
			}
		}while(num1<0);
		do{
			printf("Ingrese el indice: ");
			scanf("%f",&num2);
			if(num2==0){
				printf("\nError: El indice no puede ser 0.\n\n");
			}
		}while(num2==0);
		float res = pow(num1, (1 / num2));
		printf("\nLa raiz de %f de indice %f da %f.\n\n\n", num1, num2, res);
	}
	
	int mainNumeros(){
		int opcion;
		float num1, num2;
		do{
			printf("\n\n1: Suma | 2: Resta | 3: Multiplicacion | 4: Division | 5: Potencia | 6: Raiz | 7: Salir\n\nIngrese su opcion: ");
			scanf("%d",&opcion);
			if(opcion>=1 && opcion<=4){
				printf("\nIngrese un numero: ");
				scanf("%f",&num1);
				printf("Ingrese otro numero: ");
				scanf("%f",&num2);
			}
			switch(opcion){
				case 1:
					suma(&num1, &num2);
					break;
				case 2:
					resta(&num1, &num2);
					break;
				case 3:
					multi(&num1, &num2);
					break;
				case 4:
					divi(&num1, &num2);
					break;
				case 5:
					potencia();
					break;
				case 6:
					raiz();
					break;
				case 7:
					printf("\nSaliendo...\n\n\n\n");
					break;
				default:
					printf("\nOpcion invalida.\n\n");
					break;
			}
		}while(opcion!=7);
		return 0;
	}

	int validacionTamanio(int *tam1, int *tam2)
	{
		if(*tam1 != *tam2)
		{
			return 0;
		}else
		{
			return 1;
		}
	}
	
	void ingresoDosVectores(float *vector1, float *vector2, int *tam1, int *tam2)
	{
		do{
			printf("\nIngrese el tamanio del vector 1: ");
			scanf("%d",&*tam1);
			if(*tam1<=0)
			{
				printf("\nError: No puede haber un vector con un tamanio igual o menor a 0.\n");
	  		}
		}while(*tam1<=0);
		for(i=0;i<*tam1;i++)
		{
		printf("\nIngrese el valor %d del vector 1: ",i+1);
		scanf("%f",&vector1[i]);
		}
		do{
			printf("\nIngrese el tamanio del vector 2: ");
			scanf("%d",&*tam2);
			if(*tam2<=0)
			{
				printf("\nError: No puede haber un vector con un tamanio igual o menor a 0.\n");
	  		}
		}while(*tam2<=0);
		for(i=0;i<*tam2;i++)
		{
		printf("\nIngrese el valor %d del vector 2: \n",i+1);
		scanf("%f",&vector2[i]);
		}
	}
	
	void ingresoUnVector(float *vector,int *tam)
	{
		do{
			printf("\nIngrese el tamanio del vector: ");
			scanf("%d",&*tam);
			if(*tam<=0)
			{
				printf("\nError: No puede haber un vector con un tamanio igual o menor a 0.\n");
			}
		}while(*tam<=0);
		for(i=0;i<*tam;i++)
		{
			printf("\nIngrese el valor %d del vector: ",i+1);
			scanf("%f",&vector[i]);
		}
	}

	void ingresoDosVectores3N(float *vector1, float *vector2, int *tam)
	{
		*tam=3;
		for(i=0;i<*tam;i++)
		{
			printf("\nIngrese el valor %d del vector 1: ",i+1);
			scanf("%f",&vector1[i]);
		}
		for(i=0;i<*tam;i++)
		{
			printf("\nIngrese el valor %d del vector 2: ",i+1);
			scanf("%f",&vector2[i]);
		}		
	}

	void mostrarVectores(float vector1[], float vector2[], int tam)
	{
		printf("\nVector 1: ");
		for(i=0;i<tam;i++)
		{
			printf("|%f|",vector1[i]);	
		}	
		printf("\n\n");
		printf("\nVector 2: ");
		for(i=0;i<tam;i++)
		{
			printf("|%f|",vector2[i]);	
			}
		printf("\n");
		}
	
	void sumaVectores(float vector1[], float vector2[], int tam)
	{
		float res[tam];
		for(i=0;i<tam;i++)
		{
			res[i]=vector1[i]+vector2[i];
		}
		mostrarVectores(vector1,vector2,tam);
		printf("\n\nEl resultado de la suma de ambos vectores es:\n");
		for(i=0;i<tam;i++)
		{
			printf("|%f|",res[i]);
		}
		printf("\n\n");
	}
	
	void restaVectores(float vector1[], float vector2[], int tam)
	{
		float res[tam];
		for(i=0;i<tam;i++)
		{
			res[i]=vector1[i]-vector2[i];
		}
		mostrarVectores(vector1,vector2,tam);
		printf("\nEl resultado de la resta de ambos vectores es:\n");
		for(i=0;i<tam;i++)
		{
			printf("|%f|",res[i]);
		}	
		printf("\n\n");
	}
	
	void multiEscalar(float vector1[], int tam)
	{
		float escalar;
		float res[tam];
		printf("\nIngrese el valor del escalar: ");
		scanf("%f",&escalar);
		for(i=0;i<tam;i++)
		{
			res[i]=escalar * vector1[i];
		}
		printf("\nVector: ");
		for(i=0;i<tam;i++)
		{
			printf("|%f|",vector1[i]);	
		}
		printf("\n");
		printf("\nEl resultado de la multiplicacion entre el escalar y el vector es:\n");
		for(i=0;i<tam;i++)
		{
			printf("|%f|",res[i]);
		}
		printf("\n\n");
	}
	
	void productoEscalar(float vector1[], float vector2[], int tam)
	{
		float res=0;
		for(i=0;i<tam;i++)
		{
			res=res + (vector1[i]*vector2[i]);
		}
		mostrarVectores(vector1,vector2,tam);
		printf("\n\nEl resultado del producto escalar de ambos vectores es:\n%f\n\n",res);
	}
	
	void productoVectorial(float vector1[], float vector2[], int tam)
	{
		float ter1,ter2,ter3,res[3];
		ter1=vector1[1]*vector2[2] - vector1[2]*vector2[1];
		ter2=vector1[0]*vector2[2] - vector1[2]*vector2[0];
		ter3=vector1[0]*vector2[1] - vector1[1]*vector2[0];
		float terminos[3]={ter1,ter2,ter3};
		for(i=0;i<tam;i++)
		{
			int signo=1;
			if(i==1)
			{
				signo=-1;
			}
			res[i]=signo*terminos[i];
		}
		mostrarVectores(vector1,vector2,tam);
		printf("\nEl valor del producto vectorial de ambos vectores es:\n");
		printf("(%f;%f;%f)",res[0],res[1],res[2]);
		printf("\n\n");
	}
	
	int mainVectores()
	{
		int opcion,tam,tam1,tam2;
		float vector[100],vector1[100],vector2[100];
		do
		{
			printf("\n\n1: Suma | 2: Resta | 3: Multiplicacion por un escalar | 4: Producto escalar | 5: Producto vectorial (3 dimensiones) | 6: Salir\nIngrese su opcion: ");
			scanf("%d",&opcion);
			switch(opcion)
			{
				case 1:
					ingresoDosVectores(vector1,vector2,&tam1,&tam2);
					if(validacionTamanio(&tam1,&tam2)==1)
					{
						int tam=tam1;
						sumaVectores(vector1,vector2,tam);
					}else
					{
						printf("\nError: El tamanio de ambos vectores no es el mismo.\n");
					}
					break;		
				case 2:
					ingresoDosVectores(vector1,vector2,&tam1,&tam2);
					if(validacionTamanio(&tam1,&tam2)==1)
					{
						int tam=tam1;
						restaVectores(vector1,vector2,tam);
					}else
					{
						printf("\nError: El tamanio de ambos vectores no es el mismo.\n");
					}
					break;				
				case 3:
					ingresoUnVector(vector,&tam);
					multiEscalar(vector,tam);
					break;			
				case 4:
					ingresoDosVectores(vector1,vector2,&tam1,&tam2);
					if(validacionTamanio(&tam1,&tam2)==1)
					{
						int tam=tam1;
						productoEscalar(vector1,vector2,tam);
					}else
					{
						printf("\nError: El tamanio de ambos vectores no es el mismo.\n");
					}
					break;		
				case 5:
					ingresoDosVectores3N(vector1,vector2,&tam);
					productoVectorial(vector1,vector2,tam);
					break;
				case 6:
					printf("\nSaliendo...\n\n\n\n");
					break;
				default:
					printf("\nOpcion invalida.\n\n");
					break;
			}
		}while(opcion!=6);
	}

	void cargarMatriz(int matriz[4][4], int filas, int columnas, int numMatriz) {
	    printf("Cargar matriz %d (%dx%d):\n", numMatriz, filas, columnas);
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {
	            printf("Elemento [%d][%d]: ", i, j);
	            scanf("%d", &matriz[i][j]);
	        }
	    }
	}
	
	void mostrarMatriz(int matriz[4][4], int filas, int columnas) {
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {	
	            printf("%d ", matriz[i][j]);
	        }
	        printf("\n");
	    }
	}
	
	
	void sumarMatrices(int matriz1[4][4], int matriz2[4][4], int filas, int columnas, int resultado[4][4]) {
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz1[i][j] + matriz2[i][j];
	        }
	    }
	}
	
	
	void restarMatrices(int matriz1[4][4], int matriz2[4][4], int filas, int columnas, int resultado[4][4]) {
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz1[i][j] - matriz2[i][j];
	        }
	    }
	}
	
	
	void multiplicarEscalar(int matriz[4][4], int filas, int columnas, int escalar, int resultado[4][4]) {
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz[i][j] * escalar;
	        }
	    }
	}
	
	
	void multiplicarMatrices(int matriz1[4][4], int matriz2[4][4], int filas1, int columnas1, int filas2, int columnas2, int resultado[4][4]) {
	    if (columnas1 != filas2) {
	        printf("Error: Las columnas de la primer matriz tienen que ser iguales a las filas de la segunda.\n");
	        return;
	    }
	
	    for(i = 0; i < filas1; i++) {
	        for(j = 0; j < columnas2; j++) {
	            resultado[i][j] = 0;
	            for(k = 0; k < columnas1; k++) {
	               resultado[i][j] = resultado[i][j] + matriz1[i][k] * matriz2[k][j];
	            }
	        }
	    }
	}
	
	int determinante(int matriz[4][4], int n) {
	    if (n == 1)
	        return matriz[0][0];
	
	    int det = 0;  
	    int submatriz[4][4];  
	    int signo;
		int col;
	    for (col = 0; col < n; col++) {
	        int subi = 0;  
	
	        for (i = 1; i < n; i++) {
	            int subj = 0;  
	
	            for (j = 0; j < n; j++) {
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
	
	void cofactor(int matriz[4][4], int temp[4][4], int p, int q, int n) { // p = fila salteada q = columna salteada
	    int i = 0, j = 0;
	    int fila;
	    for (fila = 0; fila < n; fila++) {
	    	int col;
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
	}
	
	void adjunta(int matriz[4][4], int adj[4][4], int n) {
	    if (n == 1) {
	        adj[0][0] = 1;
	        return;
	    }
	    int temp[4][4];
	    int signo = 1;
	    for (i = 0; i < n; i++) {
	        for (j = 0; j < n; j++) {
	            cofactor(matriz, temp, i, j, n);
	            signo = ((i + j) % 2 == 0) ? 1 : -1;
	            adj[j][i] = signo * determinante(temp, n - 1);
	        }
	    }
	}
	
	int inversa(int matriz[4][4], int inversa[4][4], int n) {
	    int det = determinante(matriz, n);
	    if (det == 0) {
	        printf("Error: La matriz no tiene inversa.\n");
	        return 0;
	    }
	    int adj[4][4];
	    adjunta(matriz, adj, n);
	    for (i = 0; i < n; i++) {
	        for (j = 0; j < n; j++) {
	            inversa[i][j] = adj[i][j] / det; 
	        }
	    }
	    return 1;
	}
	
	void dividirMatrices(int matriz1[4][4], int matriz2[4][4], int filas, int columnas, int resultado[4][4]) {
	    int inversa2[4][4];
	    if (inversa(matriz2, inversa2, filas) == 0) {
	        printf("Error: No se puede dividir porque la segunda matriz no tiene inversa.\n");
	        return;
	    }
	    else{
		
	    multiplicarMatrices(matriz1, inversa2, filas, columnas, filas, columnas, resultado);
		}
	}
	
	
	
	int mainMatrices() {
	    int matriz1[4][4], matriz2[4][4], resultado[4][4];
	    int filas1, columnas1, filas2, columnas2;
	    int escalar;
	
	    int opcion;
	    do {
	        printf("\n\n1: Suma | 2: Resta matrices | 3: Multiplicacion por un escalar | 4: Multiplicacion de matrices\n5: Determinante | 6: Inversa | 7: Division | 8: Salir\nIngrese su opcion: ");
	        scanf("%d", &opcion);
	        
			if(opcion == 5 || opcion == 6){
		 		printf("Ingrese las filas de la matriz: ");
				scanf("%d", &filas1);
	  	 		printf("Ingrese las columnas de la matriz: ");
			   	scanf("%d", &columnas1);
	    		cargarMatriz(matriz1, filas1, columnas1, 1);
			}
			else if(opcion >= 1 && opcion <= 7){
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
	                    printf("Error: Las matrices deben tener el mismo tamanio para sumar.\n");
	                }
	                break;
	
	            case 2:
	                if (filas1 == filas2 && columnas1 == columnas2) {
	                    restarMatrices(matriz1, matriz2, filas1, columnas1, resultado);
	                    mostrarMatriz(resultado, filas1, columnas1);
	                } else {
	                    printf("Error: Las matrices deben tener el mismo tamanio para restar.\n");
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
	                    printf("Error: Las matrices no tienen las dimensiones correctas para multiplicar.\n");
	                }
	                break;
	            
	            case 5:
					mostrarMatriz(matriz1, filas1, columnas1);
		            	
	            	 if (filas1 == columnas1) {
						
	      				printf("El determinante de la matriz es: %d\n", determinante(matriz1, filas1));
	    			} else {
	        			printf("Error: La matriz debe ser del mismo tamaño el determinante.\n");
	                } 
	            	break;
	            
	            case 6: 
	                  if (filas1 == columnas1) {
	                    int inversaMatriz[4][4];
	                    if (inversa(matriz1, inversaMatriz, filas1)) {
	                        printf("La matriz inversa es:\n");
	                        mostrarMatriz(inversaMatriz, filas1, columnas1);
	                    }
	                } else {
	                    printf("Error: La matriz debe ser del mismo tamaño para calcular la inversa.\n");
	                }          
	            	break;
	            case 7:
	                if (filas1 == columnas1 && filas2 == columnas2 && filas1 == filas2) {
	                    dividirMatrices(matriz1, matriz2, filas1, columnas1, resultado);
	                    printf("Resultado de la division:\n");
	                    mostrarMatriz(resultado, filas1, columnas1);
	                } else {
	                    printf("Error: Ambas matrices deben ser del mismo tamaño para dividir.\n");
	                }
	                break;
	            case 8:
					printf("\nSaliendo...\n\n\n\n");
					break;
				default:
					printf("\nOpcion invalida.\n\n");
					break;
	        }
	    } while(opcion != 8);
	    return 0;
	}

	void sistema2(){
		int a1, b1, r1, a2, b2, r2;
		float resB, resR, y, x;
		printf("\nIngrese los coeficientes de la primer ecuacion (a1 b1 r1): ");
		scanf("%d %d %d", &a1, &b1, &r1);
		printf("\nIngrese los coeficientes de la segunda ecuacion (a2 b2 r2): ");
		scanf("%d %d %d", &a2, &b2, &r2);
		printf("\nLas ecuaciones son:\n%dx + %dy = %d\n%dx + %dy = %d", a1, b1, r1, a2, b2, r2);
		resB = (a2 * b1) - (a1 * b2);
		resR = (a2 * r1) - (a1 * r2);
		if(resB == 0 || a1 == 0){
	    	printf("\n\nEl sistema no tiene solucion unica o hay una division por cero.\n\n");
	    	return;
		}
		y = resR / resB;
		x = (r1 - (b1 * y)) / a1;
		printf("\n\nx es igual a %f.\ny es igual a %f.\n\n",x,y);
	}
	
	void sistema3(){
		int a1, b1, c1, r1, a2, b2, c2, r2, a3, b3, c3, r3;
		float resB1, resC1, resR1, resB2, resC2, resR2, finalB, finalC, finalR, z, y, x;
		printf("\nIngrese los coeficientes de la primer ecuacion (a1 b1 c1 r1): ");
		scanf("%d %d %d %d", &a1, &b1, &c1, &r1);
		printf("\nIngrese los coeficientes de la segunda ecuacion (a2 b2 c2 r2): ");
		scanf("%d %d %d %d", &a2, &b2, &c2, &r2);
		printf("\nIngrese los coeficientes de la tercer ecuacion (a3 b3 c3 r3): ");
		scanf("%d %d %d %d", &a3, &b3, &c3, &r3);
		printf("\nLas ecuaciones son:\n%dx + %dy + %dz = %d\n%dx + %dy + %dz = %d\n%dx + %dy + %dz = %d", a1, b1, c1, r1, a2, b2, c2, r2, a3, b3, c3, r3);
		resB1 = (a2 * b1) - (a1 * b2);
		resC1 = (a2 * c1) - (a1 * c2);
		resR1 = (a2 * r1) - (a1 * r2);
		resB2 = (a3 * b1) - (a1 * b3);
		resC2 = (a3 * c1) - (a1 * c3);
		resR2 = (a3 * r1) - (a1 * r3);
		finalC = (resB2 * resC1) - (resB1 * resC2);
		finalR = (resB2 * resR1) - (resB1 * resR2);
		if(finalC == 0 || resB1 == 0 || a1 == 0){
	    	printf("\n\nEl sistema no tiene solucion unica o hay una division por cero.\n\n\n");
	    	return;
		}
		z = finalR / finalC;
		y = (resR1 - (resC1 * z)) / resB1;
		x = (r1 - (b1 * y) - (c1 * z)) / a1;
		printf("\n\nx es igual a %f.\ny es igual a %f.\nz es igual a %f.\n\n",x,y,z);
	}
	
	int mainSistemas(){
		int opcion;
		do{
			printf("\n\n1: Sistema 2 por 2 | 2: Sistema 3 por 3 | 3: Salir\nIngrese su opcion: ");
			scanf("%d",&opcion);
			switch(opcion){
				case 1:
					sistema2();
					break;
				case 2:
					sistema3();
					break;
				case 3:
					printf("\nSaliendo...\n\n\n\n");
					break;
				default:
					printf("\nOpcion invalida.\n\n");
					break;
			}
		}while(opcion!=3);
	}

int main(){
		int opcion;
		do{
			printf("1: Numeros | 2: Vectores | 3: Matrices | 4: Sistemas de ecuaciones | 5: Terminar programa\nIngrese la opcion con la que desea trabajar: ");
			scanf("%d",&opcion);
			switch(opcion){
				case 1:
					mainNumeros();
					break;
				case 2:
					mainVectores();
					break;
				case 3:
					mainMatrices();
					break;
				case 4:
					mainSistemas();
					break;
				case 5:
					printf("\nTerminando programa...");
					break;
				default:
					printf("\nOpcion invalida.\n\n\n");
					break;
			}
		}while(opcion!=5);
	}
