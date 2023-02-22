/*
Helper For Lab 8
*/
import processing.core.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class drawPoints extends PApplet {

	private static String fileName;


	public void settings() {
    size(500, 500);
	}
  
	public void setup() {
    	background(180);
    	noLoop();
  	}

  	public void draw() {
		List<Point> points = new ArrayList<>();
		double x, y, z;

		String[] lines = loadStrings(fileName);
		//println("there are " + lines.length);
		for (String line : lines) {
			if (line.length() > 0) {
				String[] words = line.split(",");
				x = Double.parseDouble(words[0]);
				y = Double.parseDouble(words[1]);
				z = Double.parseDouble(words[2]);
				points.add(new Point(x, y, z));
				//println("xy: " + x + " " + y);
				//ellipse((int) x, (int) y, 1, 1);
			}
		}

		points = points.stream().filter(p -> p.z <= 2.0)
				.map(p -> new Point(p.x * 0.5, p.y * 0.5, p.z))
				.map(p -> new Point(p.x - 150, p.y - 37, p.z)).collect(Collectors.toList());

		//ADD VALID POINTS TO THE NEWLINES LIST OF STRINGS
		List<String> newLines = new ArrayList<>();
		for (Point p: points){
			newLines.add(p.toString());
			ellipse((float)p.x, (float)p.y, 1, 1);
		}

		//ADD NEWLINES TO THE NEW DRAW ME FILE
		Path file = Paths.get("drawMe.txt");
		try{
			Files.write(file, newLines);

		} catch (IOException e){
			throw new RuntimeException(e);

		}

  	}

  	public static void main(String args[]) {
      PApplet.main("drawPoints");
	  fileName = args[0];
   }
}
