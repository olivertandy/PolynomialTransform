import processing.core.*;
import controlP5.*;

public class control extends PApplet{
	ControlP5 cp5;
	
	KnobMatrix xMatrix;
	KnobMatrix yMatrix;
	
	TaylorSeries2D x;
	TaylorSeries2D y;
	
	int n;
	IntPair limits = new IntPair(-30, 30);
	int frames;
	
	public static void main(String[] args){
		PApplet.main("control");
	}

	public void settings(){
		size(1024, 768);
	}

	public void setup(){
		background(0);
		stroke(0, 255, 0);
		
		n = 4;
		frames = 0;
		
		cp5 = new ControlP5(this);
		xMatrix = new KnobMatrix(this.cp5, "x", n, 50, new PVector(0, 0));
		yMatrix = new KnobMatrix(this.cp5, "y", n, 50, new PVector(400, 0));
		
		
		x = new TaylorSeries2D(
			//must be new array - if same array is passed to
			//both, both coords will be the same
			TaylorSeries2D.randomFloatArray(this, n, 1.0f), n);
		y = new TaylorSeries2D(
			TaylorSeries2D.randomFloatArray(this, n, 1.0f), n);
	}

	public void draw(){
		background(0);
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				x.setConstant(i, j, xMatrix.getValue(i, j));
				y.setConstant(i, j, yMatrix.getValue(i, j));
			}
		}
		
		/*
		if(frames%100 == 0){
			x.printConstants();
			System.out.println("X^");
			y.printConstants();
			System.out.println("Y^");
		}
		frames++;
		*/
		
		pushMatrix();
		translate(this.width/2, this.height/2);
		TaylorSeries2D.drawGrid(this, x, y, limits, limits, 25.0f);
		popMatrix();
		
		if(keyPressed){
			if(key == '0'){
				for(Knob k: cp5.getAll(Knob.class)){
					k.setValue(0.0f);
				}
			}
			if(key == 's'){
				saveFrame("output-####.png");
			}
		}
	}
}
