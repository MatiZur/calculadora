package operaciones;

public class Operaciones {
	public static float[][] sumar(float[][] a, float[][] b) {
        int filas = a.length;
        int columnas = a[0].length;
        float[][] resultado = new float[filas][columnas];

        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                resultado[i][j] = a[i][j] + b[i][j];

        return resultado;
    }

    public static float[][] restar(float[][] a, float[][] b) {
        int filas = a.length;
        int columnas = a[0].length;
        float[][] resultado = new float[filas][columnas];

        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                resultado[i][j] = a[i][j] - b[i][j];

        return resultado;
    }

    public static float[][] multiplicarEscalar(float[][] matriz, float escalar) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        float[][] resultado = new float[filas][columnas];

        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                resultado[i][j] = matriz[i][j] * escalar;

        return resultado;
    }

    public static float[][] multiplicarMatrices(float[][] a, float[][] b) {
        int filas1 = a.length;
        int columnas1 = a[0].length;
        int columnas2 = b[0].length;

        float[][] resultado = new float[filas1][columnas2];

        for (int i = 0; i < filas1; i++)
            for (int j = 0; j < columnas2; j++)
                for (int k = 0; k < columnas1; k++)
                    resultado[i][j] += a[i][k] * b[k][j];

        return resultado;
    }

    public static float determinante(float[][] matriz, int n) {
        if (n == 1) return matriz[0][0];

        float det = 0;
        float[][] submatriz = new float[n][n];
        int signo;

        for (int col = 0; col < n; col++) {
            cofactor(matriz, submatriz, 0, col, n);
            signo = (col % 2 == 0) ? 1 : -1;
            det += signo * matriz[0][col] * determinante(submatriz, n - 1);
        }

        return det;
    }

    private static void cofactor(float[][] matriz, float[][] temp, int p, int q, int n) {
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

    public static float[][] transpuesta(float[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        float[][] transpuesta = new float[columnas][filas];

        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                transpuesta[j][i] = matriz[i][j];

        return transpuesta;
    }

    public static float[][] inversa(float[][] matriz) {
        int n = matriz.length;
        float det = determinante(matriz, n);
        if (det == 0) return null;

        float[][] adj = new float[n][n];
        adjunta(matriz, adj, n);

        float[][] inv = new float[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                inv[i][j] = adj[i][j] / det;

        return inv;
    }

    private static void adjunta(float[][] matriz, float[][] adj, int n) {
        if (n == 1) {
            adj[0][0] = 1;
            return;
        }

        float[][] temp = new float[n][n];
        int signo;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                cofactor(matriz, temp, i, j, n);
                signo = ((i + j) % 2 == 0) ? 1 : -1;
                adj[j][i] = signo * determinante(temp, n - 1);
            }
    }

    public static float[][] dividirMatrices(float[][] a, float[][] b) {
        float[][] invB = inversa(b);
        if (invB == null) return null;

        return multiplicarMatrices(a, invB);
    }

    public static String mostrarMatriz(float[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (float[] fila : matriz) {
            sb.append("| ");
            for (float val : fila)
                sb.append(String.format("%.2f ", val));
            sb.append("|\n");
        }
        return sb.toString();
    }
    
    public static float[] sistema2(int x1, int y1, int r1, int x2, int y2, int r2){
		float resY, resR, y, x;
		resY = (x2 * y1) - (x1 * y2);
		resR = (x2 * r1) - (x1 * r2);
		if(resY == 0 || x1 == 0){
			// Error
		}
		y = resR / resY;
		x = (r1 - (y1 * y)) / x1;
		float[] variables = {x, y};
		return variables;
	}
	
	public static float[] sistema3(int x1, int y1, int z1, int r1, int x2, int y2, int z2, int r2, int x3, int y3, int z3, int r3){
		float resY1, resZ1, resR1, resY2, resZ2, resR2, finalZ, finalR, z, y, x;
		resY1 = (x2 * y1) - (x1 * y2);
		resZ1 = (x2 * z1) - (x1 * z2);
		resR1 = (x2 * r1) - (x1 * r2);
		resY2 = (x3 * y1) - (x1 * y3);
		resZ2 = (x3 * z1) - (x1 * z3);
		resR2 = (x3 * r1) - (x1 * r3);
		finalZ = (resY2 * resZ1) - (resY1 * resZ2);
		finalR = (resY2 * resR1) - (resY1 * resR2);
		if(finalZ == 0 || resY1 == 0 || x1 == 0){
			// Error
		}
		z = finalR / finalZ;
		y = (resR1 - (resZ1 * z)) / resY1;
		x = (r1 - (y1 * y) - (z1 * z)) / x1;
		float[] variables = {x, y, z};
		return variables;
	}
}
