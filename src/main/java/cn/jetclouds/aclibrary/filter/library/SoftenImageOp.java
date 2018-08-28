package cn.jetclouds.aclibrary.filter.library;

public class SoftenImageOp extends AbstractConvolveImageOp {

	private static final float[][] matrix = { { 0 / 16f, 1 / 16f, 0 / 16f },
			{ 1 / 16f, 12 / 16f, 1 / 16f }, { 0 / 16f, 1 / 16f, 0 / 16f } };

	public SoftenImageOp() {
		super(matrix);
	}

}
