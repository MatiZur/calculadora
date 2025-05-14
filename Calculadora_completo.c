#include <stdio.h>
#include <math.h>
int i, j, k;

// Numeros
	void suma(float *num1, float *num2){
		float res = *num1 + *num2;
		printf("\nEl resultado de la suma entre %.2f y %.2f es %.2f.\n\n", *num1, *num2, res);
		return;
	}
	
	void resta(float *num1, float *num2){
		float res = *num1 - *num2;
		printf("\nEl resultado de la resta entre %.2f y %.2f es %.2f.\n\n", *num1, *num2, res);
		return;
	}
	
	void multi(float *num1, float *num2){
		float res = *num1 * *num2;
		printf("\nEl resultado de la multiplicaci%cn entre %.2f y %.2f es %.2f.\n\n", 162, *num1, *num2, res);
		return;
	}
	
	void divi(float *num1, float *num2){
		if(*num2 == 0){
			printf("\nError: No se puede dividir por cero.\n\n", 163);
			return;
		}
		float res = *num1 / *num2;
		printf("\nEl resultado de la divisi%cn entre %.2f y %.2f es %.2f.\n\n", 162, *num1, *num2, res);
		return;
	}
	
	void potencia(){
		float num1, num2;
		printf("\n\nIngrese un n%cmero: ", 163);
		scanf("%f",&num1);
		printf("Ingrese el exponente: ");
		scanf("%f",&num2);
		float res = pow(num1, num2);
		printf("\nEl resultado de la potencia de %.2f de exponente %.2f es %.2f.\n\n", num1, num2, res);
		return;
	}
	
	void raiz(){
		float num1, num2;
		printf("\n\nIngrese un n%cmero: ", 163);
		scanf("%f",&num1);
		if(num1<0){
			printf("\nError: El n%cmero no puede ser negativo.\n\n", 163);
			return;
		}
		printf("Ingrese el %cndice: ", 161);
		scanf("%f",&num2);
		if(num2==0){
			printf("\nError: El %cndice no puede ser 0.\n\n", 161);
			return;
		}
		float res = pow(num1, (1 / num2));
		printf("\nEl resultado de la ra%cz de %.2f de %cndice %.2f es %.2f.\n\n\n", 161, num1, 161, num2, res);
		return;
	}
	
	int mainNumeros(){
		int opcion;
		float num1, num2;
		do{
			printf("\n\n1: Suma | 2: Resta | 3: Multiplicaci%cn | 4: Divisi%cn | 5: Potencia | 6: Ra%cz | 7: Salir\n\nIngrese su opci%cn: ", 162, 162, 161, 162);
			scanf("%d",&opcion);
			if(opcion>=1 && opcion<=4){
				printf("\n\nIngrese un n%cmero: ", 163);
				scanf("%f",&num1);
				printf("Ingrese otro n%cmero: ", 163);
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
					printf("\n\nSaliendo de N%cmeros...\n\n\n\n", 163);
					break;
				default:
					printf("\n\nError: Opcion inv%clida.\n", 160);
					break;
			}
		}while(opcion!=7);
		return 0;
	}
// Numeros

// Vectores
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
			printf("\n\nIngrese el tama%co del vector 1: ", 164);
			scanf("%d",&*tam1);
			if(*tam1<=0)
			{
				printf("\nError: No puede haber un vector con un tama%co igual o menor a 0.\n", 164);
			}
		}while(*tam1<=0);
		for(i=0;i<*tam1;i++)
		{
		printf("Ingrese el valor %d del vector 1: ",i+1);
		scanf("%f",&vector1[i]);
		}
		do{
			printf("\nIngrese el tama%co del vector 2: ", 164);
			scanf("%d",&*tam2);
			if(*tam2<=0)
			{
				printf("\nError: No puede haber un vector con un tama%co igual o menor a 0.\n", 164);
			}
		}while(*tam2<=0);
		for(i=0;i<*tam2;i++)
		{
		printf("Ingrese el valor %d del vector 2: ",i+1);
		scanf("%f",&vector2[i]);
		}
		return;
	}
	
	void ingresoUnVector(float *vector,int *tam)
	{
		do{
			printf("\n\nIngrese el tama%co del vector: ", 164);
			scanf("%d",&*tam);
			if(*tam<=0)
			{
				printf("\nError: No puede haber un vector con un tama%co igual o menor a 0.\n", 164);
			}
		}while(*tam<=0);
		for(i=0;i<*tam;i++)
		{
			printf("Ingrese el valor %d del vector: ",i+1);
			scanf("%f",&vector[i]);
		}
		return;
	}

	void ingresoDosVectores3N(float *vector1, float *vector2, int *tam)
	{
		*tam=3;
		printf("\n\n");
		for(i=0;i<*tam;i++)
		{
			printf("Ingrese el valor %d del vector 1: ",i+1);
			scanf("%f",&vector1[i]);
		}
		printf("\n");
		for(i=0;i<*tam;i++)
		{
			printf("Ingrese el valor %d del vector 2: ",i+1);
			scanf("%f",&vector2[i]);
		}
		return;
	}

	void mostrarVectores(float vector1[], float vector2[], int tam)
	{
		printf("\nVector 1: |");
		for(i=0;i<tam;i++)
		{
			printf(" %.2f",vector1[i]);	
		}
		printf(" |\nVector 2: |");
		for(i=0;i<tam;i++)
		{
			printf(" %.2f",vector2[i]);	
			}
		printf(" |\n");
		return;
	}
	
	void sumaVectores(float vector1[], float vector2[], int tam)
	{
		float res[tam];
		for(i=0;i<tam;i++)
		{
			res[i]=vector1[i]+vector2[i];
		}
		mostrarVectores(vector1,vector2,tam);
		printf("\n\nEl resultado de la suma entre ambos vectores es: |");
		for(i=0;i<tam;i++)
		{
			printf(" %.2f",res[i]);
		}
		printf(" |\n\n");
		return;
	}
	
	void restaVectores(float vector1[], float vector2[], int tam)
	{
		float res[tam];
		for(i=0;i<tam;i++)
		{
			res[i]=vector1[i]-vector2[i];
		}
		mostrarVectores(vector1,vector2,tam);
		printf("\n\nEl resultado de la resta entre ambos vectores es: |");
		for(i=0;i<tam;i++)
		{
			printf(" %.2f",res[i]);
		}	
		printf(" |\n\n");
		return;
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
		printf("\nVector: |");
		for(i=0;i<tam;i++)
		{
			printf(" %.2f",vector1[i]);	
		}
		printf(" |\n");
		printf("\n\nEl resultado de la multiplicaci%cn entre el escalar y el vector es: |", 162);
		for(i=0;i<tam;i++)
		{
			printf(" %.2f",res[i]);
		}
		printf(" |\n\n");
		return;
	}
	
	void productoEscalar(float vector1[], float vector2[], int tam)
	{
		float res=0;
		for(i=0;i<tam;i++)
		{
			res=res + (vector1[i]*vector2[i]);
		}
		mostrarVectores(vector1,vector2,tam);
		printf("\n\nEl resultado del producto escalar entre ambos vectores es %.2f\n\n",res);
		return;
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
		printf("\n\nEl resultado del producto vectorial entre ambos vectores es: ( %.2f , %.2f , %.2f )\n\n",res[0],res[1],res[2]);
		return;
	}
	
	int mainVectores()
	{
		int opcion,tam,tam1,tam2;
		float vector[100],vector1[100],vector2[100];
		do
		{
			printf("\n\n1: Suma | 2: Resta | 3: Multiplicaci%cn por un escalar | 4: Producto escalar | 5: Producto vectorial (3 dimensiones) | 6: Salir\n\nIngrese su opci%cn: ", 162, 162);
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
						printf("\nError: Los tama%cos de los vectores son distintos.\n", 164);
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
						printf("\nError: Los tama%cos de los vectores son distintos.\n", 164);
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
						printf("\nError: Los tama%cos de los vectores son distintos.\n", 164);
					}
					break;		
				case 5:
					ingresoDosVectores3N(vector1,vector2,&tam);
					productoVectorial(vector1,vector2,tam);
					break;
				case 6:
					printf("\n\nSaliendo de Vectores...\n\n\n\n");
					break;
				default:
					printf("\n\nError: Opcion inv%clida.\n", 160);
					break;
			}
		}while(opcion!=6);
		return 0;
	}
// Vectores

// Matrices
	void cargarMatriz(float matriz[4][4], int filas, int columnas, int numMatriz) {
	    printf("\nCarga de la matriz %d (%dx%d):\n", numMatriz, filas, columnas);
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {
	            printf("Elemento [%d][%d]: ", i, j);	
	            scanf("%f", &matriz[i][j]);
	        }
	    }
	    return;
	}
	
	void mostrarMatriz(float matriz[4][4], int filas, int columnas) {
	    for(i = 0; i < filas; i++) {
	    	printf("|");
	        for(j = 0; j < columnas; j++) {	
	            printf(" %.2f", matriz[i][j]);
	        }
	        printf(" |\n");
	    }
	    printf("\n");
	    return;
	}
	
	
	void sumarMatrices(float matriz1[4][4], float matriz2[4][4], int filas, int columnas, float resultado[4][4]) {
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz1[i][j] + matriz2[i][j];
	        }
	    }
	    printf("\n\nEl resultado de la suma entre las matrices es:\n");
	    return;
	}
	
	
	void restarMatrices(float matriz1[4][4], float matriz2[4][4], int filas, int columnas, float resultado[4][4]) {
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz1[i][j] - matriz2[i][j];
	        }
	    }
	    printf("\n\nEl resultado de la resta entre las matrices es:\n");
	    return;
	}
	
	
	void multiplicarEscalar(float matriz[4][4], int filas, int columnas, float escalar, float resultado[4][4]) {
	    for(i = 0; i < filas; i++) {
	        for(j = 0; j < columnas; j++) {
	            resultado[i][j] = matriz[i][j] * escalar;
	        }
	    }
	    printf("\n\nEl resultado de la multiplicaci%cn entre la matriz y el escalar es:\n", 162);
	    return;
	}
	
	
	void multiplicarMatrices(float matriz1[4][4], float matriz2[4][4], int filas1, int columnas1, int filas2, int columnas2, float resultado[4][4], int opcion) {
	    if (columnas1 != filas2) {
	        printf("\n\nError: Las columnas de la primer matriz tienen que ser iguales a las filas de la segunda.\n\n");
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
	    if(opcion==4){
	    	printf("\n\nEl resultado de la multiplicaci%cn entre las matrices es:\n", 162);
		}
	    return;
	}
	
	float determinante(float matriz[4][4], float n) {
	    if (n == 1) {
	    	return matriz[0][0];
		}
	    int det = 0;  
	    float submatriz[4][4];  
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
	
	void cofactor(float matriz[4][4], float temp[4][4], int p, int q, int n) { // p = fila salteada q = columna salteada
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
	}
	
	void adjunta(float matriz[4][4], float adj[4][4], float n) {
	    if (n == 1) {
	        adj[0][0] = 1;
	        return;
	    }
	    float temp[4][4];
	    int signo = 1;
	    for (i = 0; i < n; i++) {
	        for (j = 0; j < n; j++) {
	            cofactor(matriz, temp, i, j, n);
	            signo = ((i + j) % 2 == 0) ? 1 : -1;
	            adj[j][i] = signo * determinante(temp, n - 1);
	        }
	    }
	    return;
	}
	
	float inversa(float matriz[4][4], float inversa[4][4], float n) {
	    float det = determinante(matriz, n);
	    if (det == 0) {
	        printf("\n\nError: La matriz no tiene inversa.\n\n");
	        return 0;
	    }
	    float adj[4][4];
	    adjunta(matriz, adj, n);
	    for (i = 0; i < n; i++) {
	        for (j = 0; j < n; j++) {
	            inversa[i][j] = adj[i][j] / det; 
	        }
	    }
	    return 1;
	}
	
	void dividirMatrices(float matriz1[4][4], float matriz2[4][4], int filas, int columnas, float resultado[4][4], int opcion) {
	    float inversa2[4][4];
	    if (inversa(matriz2, inversa2, filas) == 0) {
	        printf("\n\nError: No se puede dividir porque la segunda matriz no tiene inversa.\n\n");
	        return;
	    }
	    else{
	    multiplicarMatrices(matriz1, inversa2, filas, columnas, filas, columnas, resultado, opcion);
		}
		return;
	}
	
	int mainMatrices() {
	    float matriz1[4][4], matriz2[4][4], resultado[4][4];
	    int filas1, columnas1, filas2, columnas2;
	    float escalar;
	    int opcion;
	    do {
	        printf("\n\n1: Suma | 2: Resta | 3: Multiplicaci%cn por un escalar | 4: Multiplicaci%cn de matrices\n", 162, 162);
	        printf("           5: Determinante | 6: Inversa | 7: Divisi%cn | 8: Salir\n\nIngrese su opci%cn: ", 162, 162);
	        scanf("%d", &opcion);
			if(opcion == 3 || opcion == 5 || opcion == 6){
				printf("\n\nIngrese las filas de la matriz: ");
				scanf("%d", &filas1);
				printf("Ingrese las columnas de la matriz: ");
				scanf("%d", &columnas1);
	    		cargarMatriz(matriz1, filas1, columnas1, 1);
			}
			else if(opcion >= 1 && opcion <= 7){
				printf("\n\nIngrese las filas de la matriz 1: ");
				scanf("%d", &filas1);
				printf("Ingrese las columnas de la matriz 1: ");
				scanf("%d", &columnas1);
	    		cargarMatriz(matriz1, filas1, columnas1, 1);
	    		printf("\nIngrese las filas de la matriz 2: ");
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
	                    printf("\n\nError: Las matrices deben tener el mismo tama%co.\n\n", 164);
	                }
	                break;
	            case 2:
	                if (filas1 == filas2 && columnas1 == columnas2) {
	                    restarMatrices(matriz1, matriz2, filas1, columnas1, resultado);
	                    mostrarMatriz(resultado, filas1, columnas1);
	                } else {
	                    printf("\n\nError: Las matrices deben tener el mismo tama%co.\n\n", 164);
	                }
	                break;
	            case 3:
	                printf("\nIngrese el escalar: ");
	                scanf("%f", &escalar);
	                    multiplicarEscalar(matriz1, filas1, columnas1, escalar, resultado);
	                    mostrarMatriz(resultado, filas1, columnas1);
	                break;
	            case 4:
	                if (columnas1 == filas2) {
	                    multiplicarMatrices(matriz1, matriz2, filas1, columnas1, filas2, columnas2, resultado, opcion);
	                    mostrarMatriz(resultado, filas1, columnas2);
	                } else {
	                    printf("\n\nError: Las matrices no tienen las dimensiones correctas para multiplicar.\n\n");
	                }
	                break;
	            case 5:
	            	printf("\nMatriz:\n", determinante(matriz1, filas1));
					mostrarMatriz(matriz1, filas1, columnas1);
		            	
	            	 if (filas1 == columnas1) {
						printf("\nEl determinante de la matriz es %.2f.\n\n", determinante(matriz1, filas1));
	    			} else {
	        			printf("\n\nError: La matriz debe ser del mismo tama%co que el determinante.\n\n", 164);
	                } 
	            	break;
	            case 6: 
	                  if (filas1 == columnas1) {
	                    float inversaMatriz[4][4];
	                    if (inversa(matriz1, inversaMatriz, filas1)) {
	                        printf("\n\nLa inversa de la matriz es:\n");
	                        mostrarMatriz(inversaMatriz, filas1, columnas1);
	                    }
	                } else {
	                    printf("\n\nError: La matriz debe ser del mismo tama%co para calcular la inversa.\n\n", 164);
	                }          
	            	break;
	            case 7:
	                if (filas1 == columnas1 && filas2 == columnas2 && filas1 == filas2) {
	                    dividirMatrices(matriz1, matriz2, filas1, columnas1, resultado, opcion);
	                    printf("\n\nEl resultado de la divisi%cn entre las matrices es:\n", 162);
	                    mostrarMatriz(resultado, filas1, columnas1);
	                } else {
	                    printf("\n\nError: Ambas matrices deben ser del mismo tama%co.\n\n", 164);
	                }
	                break;
	            case 8:
					printf("\n\nSaliendo de Matrices...\n\n\n\n");
					break;
				default:
					printf("\n\nError: Opcion inv%clida.\n", 160);
					break;
	        }
	    } while(opcion != 8);
	    return 0;
	}
// Matrices

// Sistemas
	void sistema2(){
		int a1, b1, r1, a2, b2, r2;
		float resB, resR, y, x;
		printf("\n\nIngrese los coeficientes de la primer ecuaci%cn (a1 b1 r1): ", 162);
		scanf("%d %d %d", &a1, &b1, &r1);
		printf("\nIngrese los coeficientes de la segunda ecuaci%cn (a2 b2 r2): ", 162);
		scanf("%d %d %d", &a2, &b2, &r2);
		printf("\nLas ecuaciones son:\n%dx + %dy = %d\n%dx + %dy = %d", a1, b1, r1, a2, b2, r2);
		resB = (a2 * b1) - (a1 * b2);
		resR = (a2 * r1) - (a1 * r2);
		if(resB == 0 || a1 == 0){
	    	printf("\n\n\nError: El sistema no tiene soluci%cn %cnica o hay una divisi%cn por cero.\n\n", 162, 163, 162);
	    	return;
		}
		y = resR / resB;
		x = (r1 - (b1 * y)) / a1;
		printf("\n\n\nx es igual a %.2f.\ny es igual a %.2f.\n\n",x,y);
		return;
	}
	
	void sistema3(){
		int a1, b1, c1, r1, a2, b2, c2, r2, a3, b3, c3, r3;
		float resB1, resC1, resR1, resB2, resC2, resR2, finalB, finalC, finalR, z, y, x;
		printf("\n\nIngrese los coeficientes de la primer ecuaci%cn (a1 b1 c1 r1): ", 162);
		scanf("%d %d %d %d", &a1, &b1, &c1, &r1);
		printf("\nIngrese los coeficientes de la segunda ecuaci%cn (a2 b2 c2 r2): ", 162);
		scanf("%d %d %d %d", &a2, &b2, &c2, &r2);
		printf("\nIngrese los coeficientes de la tercer ecuaci%cn (a3 b3 c3 r3): ", 162);
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
	    	printf("\n\n\nError: El sistema no tiene soluci%cn %cnica o hay una divisi%cn por cero.\n\n", 162, 163, 162);
	    	return;
		}
		z = finalR / finalC;
		y = (resR1 - (resC1 * z)) / resB1;
		x = (r1 - (b1 * y) - (c1 * z)) / a1;
		printf("\n\n\nx es igual a %.2f.\ny es igual a %.2f.\nz es igual a %.2f.\n\n",x,y,z);
		return;
	}
	
	int mainSistemas(){
		int opcion;
		do{
			printf("\n\n1: Sistema 2 por 2 | 2: Sistema 3 por 3 | 3: Salir\n\nIngrese su opci%cn: ", 162);
			scanf("%d",&opcion);
			switch(opcion){
				case 1:
					sistema2();
					break;
				case 2:
					sistema3();
					break;
				case 3:
					printf("\n\nSaliendo de Sistemas de ecuaciones...\n\n\n\n");
					break;
				default:
					printf("\n\nError: Opcion inv%clida.\n", 160);
					break;
			}
		}while(opcion!=3);
		return 0;
	}
// Sistemas

int main(){
	printf("                     - Bienvenido al programa Calculadora -\n");
	printf("Desarrollado por Santiago Papale, Octavio Romero, Leandro Zelaya y Matias Zurita\n");
	printf("            Materia: Laboratorio de Programaci%cn Orientada a Objetos\n", 162);
	printf("                           Profesor: Juan Manuel Moya\n\n\n\n");
	int opcion;
	do{
		printf("1: N%cmeros | 2: Vectores | 3: Matrices | 4: Sistemas de ecuaciones | 5: Terminar programa\n\nIngrese la opci%cn con la que desea trabajar: ", 163, 162);
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
				printf("\n\n%cEsperamos que te haya gustado!\nTerminando programa...\n", 173);
				break;
			default:
				printf("\n\nError: Opcion inv%clida.\n", 160);
				break;
		}
	}while(opcion!=5);
	return 0;
}
