package cn.jetclouds.aclibrary.filter.predefined;

import cn.jetclouds.aclibrary.filter.AbstractFilterFactory;
import cn.jetclouds.aclibrary.filter.library.DoubleRippleImageOp;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;


public class DoubleRippleFilterFactory extends AbstractFilterFactory {

	protected List<BufferedImageOp> filters;
	protected DoubleRippleImageOp ripple;
	
	public DoubleRippleFilterFactory() {
		ripple = new DoubleRippleImageOp();
	}

	@Override
	public List<BufferedImageOp> getFilters() {
		if (filters == null) {
			filters = new ArrayList<BufferedImageOp>();
			filters.add(ripple);
		}
		return filters;
	}
	
}
