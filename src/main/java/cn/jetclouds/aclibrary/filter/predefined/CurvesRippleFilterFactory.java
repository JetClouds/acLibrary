package cn.jetclouds.aclibrary.filter.predefined;

import cn.jetclouds.aclibrary.color.ColorFactory;
import cn.jetclouds.aclibrary.filter.library.CurvesImageOp;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

public class CurvesRippleFilterFactory extends RippleFilterFactory {

	protected CurvesImageOp curves = new CurvesImageOp();

	public CurvesRippleFilterFactory() {
	}

	public CurvesRippleFilterFactory(ColorFactory colorFactory) {
		setColorFactory(colorFactory);
	}

	protected List<BufferedImageOp> getPreRippleFilters() {
		List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
		list.add(curves);
		return list;
	}

	public void setStrokeMin(float strokeMin) {
		curves.setStrokeMin(strokeMin);
	}

	public void setStrokeMax(float strokeMax) {
		curves.setStrokeMax(strokeMax);
	}

	public void setColorFactory(ColorFactory colorFactory) {
		curves.setColorFactory(colorFactory);
	}

}
