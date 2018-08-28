package cn.jetclouds.aclibrary.filter.predefined;

import cn.jetclouds.aclibrary.filter.library.DiffuseImageOp;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;


public class DiffuseRippleFilterFactory extends RippleFilterFactory {

	protected DiffuseImageOp diffuse = new DiffuseImageOp();

	@Override
	protected List<BufferedImageOp> getPreRippleFilters() {
		List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
		list.add(diffuse);
		return list;
	}
}
