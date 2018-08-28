package cn.jetclouds.aclibrary.text.renderer;

public class BestFitTextRenderer extends AbstractTextRenderer {

	@Override
	protected void arrangeCharacters(int width, int height, TextString ts) {
		double widthRemaining = (width - ts.getWidth() - leftMargin - rightMargin) / ts.getCharacters().size();
		double x = leftMargin + widthRemaining / 2;
		height -= topMargin + bottomMargin;
		for (TextCharacter tc : ts.getCharacters()) {
			double y = topMargin + (height + tc.getAscent() * 0.7) / 2;
			tc.setX(x);
			tc.setY(y);
			x += tc.getWidth() + widthRemaining;
		}
	}

}
