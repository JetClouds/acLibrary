package cn.jetclouds.aclibrary.filter.predefined;

import cn.jetclouds.aclibrary.filter.library.WobbleImageOp;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;


public class WobbleRippleFilterFactory extends RippleFilterFactory {

	protected WobbleImageOp wobble;
	
	public WobbleRippleFilterFactory() {
		wobble = new WobbleImageOp();
	}
	@Override
	protected List<BufferedImageOp> getPreRippleFilters() {
		List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
		list.add(wobble);
		return list;
	}

}
