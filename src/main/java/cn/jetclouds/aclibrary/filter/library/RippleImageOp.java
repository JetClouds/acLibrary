package cn.jetclouds.aclibrary.filter.library;

public class RippleImageOp extends AbstractTransformImageOp {

	protected double xWavelength;
	protected double yWavelength;
	protected double xAmplitude;
	protected double yAmplitude;
	protected double xRandom;
	protected double yRandom;

	public RippleImageOp() {
		xWavelength = 20;
		yWavelength = 10;
		xAmplitude = 5;
		yAmplitude = 5;
		xRandom = 5 * Math.random();
		yRandom = 5 * Math.random();
	}

	public double getxWavelength() {
		return xWavelength;
	}

	public void setxWavelength(double xWavelength) {
		this.xWavelength = xWavelength;
	}

	public double getyWavelength() {
		return yWavelength;
	}

	public void setyWavelength(double yWavelength) {
		this.yWavelength = yWavelength;
	}

	public double getxAmplitude() {
		return xAmplitude;
	}

	public void setxAmplitude(double xAmplitude) {
		this.xAmplitude = xAmplitude;
	}

	public double getyAmplitude() {
		return yAmplitude;
	}

	public void setyAmplitude(double yAmplitude) {
		this.yAmplitude = yAmplitude;
	}

	@Override
	protected void transform(int x, int y, double[] t) {
		double tx = Math.sin((double) y / yWavelength + yRandom);
		double ty = Math.cos((double) x / xWavelength + xRandom);
		t[0] = x + xAmplitude * tx;
		t[1] = y + yAmplitude * ty;
	}

}
