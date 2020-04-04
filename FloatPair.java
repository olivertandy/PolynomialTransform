import processing.core.*;
import java.io.*;

public class FloatPair{
	float[] pair;

	FloatPair(float x, float y){
		pair = new float[2];
		pair[0] = x;
		pair[1] = y;
	}

	float get(int i){
		if(i == 0 || i == 1){
			return pair[i];
		}
		else{
			System.out.println("Not a valid index");
			return 0;
		}
	}
}


