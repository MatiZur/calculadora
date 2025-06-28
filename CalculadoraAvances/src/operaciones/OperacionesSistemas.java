package operaciones;
public class OperacionesSistemas{
	public float[] sistema2(int x1, int y1, int r1, int x2, int y2, int r2){
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