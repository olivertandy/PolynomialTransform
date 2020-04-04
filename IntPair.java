import processing.core.*;
import java.io.*;

public class IntPair{
	int[] pair;

	IntPair(int x, int y){
		pair = new int[2];
		pair[0] = x;
		pair[1] = y;
	}

	int get(int i){
		if(i == 0 || i == 1){
			return pair[i];
		}
		else{
			System.out.println("Not a valid index");
			return 0;
		}
	}
}