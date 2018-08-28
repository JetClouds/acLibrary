package cn.jetclouds.aclibrary.filter.library;

public abstract class AbstractConvolveImageOp extends AbstractImageOp {

	private float[][] matrix; 
	
	protected AbstractConvolveImageOp(float[][] matrix) {
		this.matrix = matrix;
	}

	@Override
	protected void filter(int[] inPixels, int[] outPixels, int width, int height) {
		long time1 = System.currentTimeMillis();
		int matrixWidth = matrix[0].length;
		int matrixHeight = matrix.length;
		int mattrixLeft = - matrixWidth / 2; 
		int matrixTop = - matrixHeight / 2;
		for (int y = 0; y < height; y++) {
			int ytop = y + matrixTop;
			int ybottom = y + matrixTop + matrixHeight; 
			for (int x = 0; x < width; x++) {
				float[] sum = {0.5f, 0.5f, 0.5f, 0.5f};
				int xleft = x + mattrixLeft;
				int xright = x + mattrixLeft + matrixWidth;
				int matrixY = 0;
				for (int my = ytop; my < ybottom; my ++, matrixY++) {
					int matrixX = 0;
					for (int mx = xleft; mx < xright; mx ++, matrixX ++) {
						int pixel = getPixel(inPixels, mx, my, width, height, EDGE_ZERO);
						float m = matrix[matrixY][matrixX];
						sum[0] += m * ((pixel >> 24) & 0xff);
						sum[1] += m * ((pixel >> 16) & 0xff);
						sum[2] += m * ((pixel >> 8) & 0xff);
						sum[3] += m * (pixel & 0xff);
					}
				}
				outPixels[x + y * width] = (limitByte((int)sum[0]) << 24) | (limitByte((int)sum[1]) << 16) | (limitByte((int)sum[2]) << 8) | (limitByte((int)sum[3]));				
			}
		}
		long time2 = System.currentTimeMillis() - time1;
		//System.out.println("AbstractConvolveImageOp " + time2);
		
	}

	
}
