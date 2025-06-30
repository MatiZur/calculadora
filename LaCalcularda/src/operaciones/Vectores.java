package Operaciones;

public class Vectores {
	
    public static float[] sumaVectores(float[] vector1, float[] vector2, int tam) {
        float[] res = new float[tam];
        for (int i = 0; i < tam; i++) {
            res[i] = vector1[i] + vector2[i];
        }
        return res;
    }

    public static float[] restaVectores(float[] vector1, float[] vector2, int tam) {
        float[] res = new float[tam];
        for (int i = 0; i < tam; i++) {
            res[i] = vector1[i] - vector2[i];
        }
        return res;
    }

    public static float[] multiEscalar(float[] vector, int tam, float escalar) {
        float[] res = new float[tam];
        for (int i = 0; i < tam; i++) {
            res[i] = escalar * vector[i];
        }
        return res;
    }

    public static float productoEscalar(float[] vector1, float[] vector2, int tam) {
        float res = 0;
        for (int i = 0; i < tam; i++) {
            res += vector1[i] * vector2[i];
        }
        return res;
    }

    public static float[] productoVectorial(float[] vector1, float[] vector2) {
        float[] res = new float[3];
        res[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        res[1] = -(vector1[0] * vector2[2] - vector1[2] * vector2[0]);
        res[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];
        return res;
    }
}
