package cn.jetclouds.aclibrary.color;

import java.awt.*;
import java.util.Random;

public class RandomColorFactory implements ColorFactory {

	private Color min;
	private Color max;
	private Color color;

	public RandomColorFactory() {
		min = new Color(20,40,80);
		max = new Color(21,50,140);
	}
	
	public void setMin(Color min) {
		this.min = min;
	}

	public void setMax(Color max) {
		this.max = max;
	}

	public Color getColor(int index) {
		if (color == null) {
			Random r = new Random();
			color = new Color( min.getRed() + r.nextInt((max.getRed() - min.getRed())),
					min.getGreen() + r.nextInt((max.getGreen() - min.getGreen())),
					min.getBlue() + r.nextInt((max.getBlue() - min.getBlue())));
		}
		return color;
	}

}
