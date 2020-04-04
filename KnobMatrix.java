import processing.core.PVector;
import controlP5.*;

import java.util.List;
import java.lang.Integer;
import java.lang.Math;

class KnobMatrix{
	ControlP5 cp5;
	//int[][] controlID;
	
	//ensuring uniqueness of ID is responsibilty of this class
	String[][] names;
	int n;
	
	float k;
	
	public KnobMatrix(ControlP5 cp5,
		String uniqueID,
		int n, float size, PVector offset){
		this.cp5 = cp5;
		
		names = new String[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				/*
				String name = uniqueID 
					+ "Knob" 
					+ Integer.toString(i)
					+ Integer.toString(j);
				*/
				
				String si = Integer.toString(i);
				String sj = Integer.toString(j);
				String name = uniqueID + ":x" + si + "*y" + sj;
				
				float range = (float)Math.exp(-1.1*Math.pow((i+j), 2));
					
				//set initial values so that x' = x, y' = y
				float initialValue;
				boolean isX = (uniqueID == "x" && (i == 1 && j == 0));
				boolean isY = (uniqueID == "y" && (i == 0 && j == 1));
				if (isX ^ isY) initialValue = 1.0f;
				else initialValue = 0.0f;
				
				this.cp5.addKnob(name)
					//TEMP SCALE DOWN - COULD LEAD TO INFINITIES
					.setRange(-range, range)
					.setValue(initialValue)
					.setPosition(offset.x + i*size, offset.y + j*size)
					.setRadius(size/3.0f);
				
				names[i][j] = name;
			}
		}
	}
	
	public float getValue(int i, int j){
		try{
			return this.cp5.getController(names[i][j]).getValue();
		}
		catch(NullPointerException e){
			System.out.println("ID not found.");
			return 0.0f;
		}
	}
	
	public float[][] getValueArray(){
		float[][] values = new float[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				values[i][j] = this.getValue(i, j);
				System.out.printf(this.getValue(i, j) + ", ");
			}
		}
		
		return values;
	}
}