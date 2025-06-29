package matrices;

public class Matrices {
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
}
