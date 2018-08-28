package cn.jetclouds.aclibrary.color;

import java.awt.*;

public class SingleColorFactory implements ColorFactory {

	private Color color;
	
	public SingleColorFactory() {
		color = Color.BLACK;
	}

	public SingleColorFactory(Color color) {
		this.color = color;
	}
	
	public Color getColor(int index) {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
