package cn.jetclouds.aclibrary.filter.predefined;

import cn.jetclouds.aclibrary.filter.AbstractFilterFactory;
import cn.jetclouds.aclibrary.filter.library.RippleImageOp;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;


public class RippleFilterFactory extends AbstractFilterFactory {

	protected List<BufferedImageOp> filters;
	protected RippleImageOp ripple;

	public RippleFilterFactory() {
		ripple = new RippleImageOp();
	}

	protected List<BufferedImageOp> getPreRippleFilters() {
		return new ArrayList<BufferedImageOp>();
	}

	protected List<BufferedImageOp> getPostRippleFilters() {
		return new ArrayList<BufferedImageOp>();
		
	}
	
	@Override
	public List<BufferedImageOp> getFilters() {
		if (filters == null) {
			filters = new ArrayList<BufferedImageOp>();
			filters.addAll(getPreRippleFilters());
			filters.add(ripple);
			filters.addAll(getPostRippleFilters());
		}
		return filters;
	}

	
}
