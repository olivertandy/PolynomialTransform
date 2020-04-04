import processing.core.*;
import java.lang.Math;
import java.lang.Float;

public class TaylorSeries2D{
	private float[][] constants;
	private int order;

	public TaylorSeries2D(float[][] constants, int order){
		this.constants = constants;
		if(this.constants == null) System.out.println("Null constants");
		this.order = order;
	}
	
	void printConstants(){
		for(int i = 0; i < order; i++){
			for(int j = 0; j < order; j++){
				System.out.printf(constants[i][j] + ", ");
			}
		}
	}

	void setConstant(int i, int j, float value){
		constants[i][j] = value;
	}

	float getConstant(int i, int j){
		return constants[i][j];
	}
	
	void setConstants(float[][] constants){
		this.constants = constants;
		printArray(this.constants, order, order);
	}

	float valueAt(float u, float v){
		float sum = 0;
		for(int i = 0; i < order; i++){
			for(int j = 0; j < order; j++){
				sum += constants[i][j]
					*Math.pow(u, i)
					*Math.pow(v, j);
			}
		}
		return sum;
	}
	
	public static float[][] randomFloatArray(PApplet p, int n, float range){
		float[][] array = new float[n][n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				array[i][j] = range*p.random(-1, 1);
			}
		}

		return array;
	}

	public static void drawGrid(
		PApplet surface,
		TaylorSeries2D x, TaylorSeries2D y,
		IntPair uLimits, IntPair vLimits,
		float a){
		
		int uMin = uLimits.get(0);
		int uMax = uLimits.get(1);
		int vMin = vLimits.get(0);
		int vMax = vLimits.get(1);
		
		for(int i = uMin; i < uMax - 1; i++){
			for(int j = vMin; j < vMax - 1; j++){
				float u0 = (float)i*a;
				float u1 = (float)(i + 1.0f)*a;
				float v0 = (float)j*a;
				float v1 = (float)(j + 1.0f)*a;

				PVector p00 = new PVector(x.valueAt(u0, v0), y.valueAt(u0, v0));
				PVector p01 = new PVector(x.valueAt(u0, v1), y.valueAt(u0, v1));
				PVector p10 = new PVector(x.valueAt(u1, v0), y.valueAt(u1, v0));

				surface.line(p00.x, p00.y, p10.x, p10.y);
				surface.line(p00.x, p00.y, p01.x, p01.y);
			}
		}
	}
	
	void printArray(float[][] array, int w, int h){
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				System.out.printf(Float.toString(array[i][j]) + " ");
			}
			System.out.printf("\n");
		}
	}
}