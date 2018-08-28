package cn.jetclouds.aclibrary.service;

import cn.jetclouds.aclibrary.background.BackgroundFactory;
import cn.jetclouds.aclibrary.color.ColorFactory;
import cn.jetclouds.aclibrary.filter.FilterFactory;
import cn.jetclouds.aclibrary.font.FontFactory;
import cn.jetclouds.aclibrary.text.renderer.TextRenderer;
import cn.jetclouds.aclibrary.word.WordFactory;

import java.awt.image.BufferedImage;

public abstract class AbstractCaptchaService implements CaptchaService {

	protected FontFactory fontFactory;
	protected WordFactory wordFactory;
	protected ColorFactory colorFactory;
	protected BackgroundFactory backgroundFactory;
	protected TextRenderer textRenderer;
	protected FilterFactory filterFactory;
	protected int width;
	protected int height;

	public void setFontFactory(FontFactory fontFactory) {
		this.fontFactory = fontFactory;
	}

	public void setWordFactory(WordFactory wordFactory) {
		this.wordFactory = wordFactory;
	}

	public void setColorFactory(ColorFactory colorFactory) {
		this.colorFactory = colorFactory;
	}

	public void setBackgroundFactory(BackgroundFactory backgroundFactory) {
		this.backgroundFactory = backgroundFactory;
	}

	public void setTextRenderer(TextRenderer textRenderer) {
		this.textRenderer = textRenderer;
	}

	public void setFilterFactory(FilterFactory filterFactory) {
		this.filterFactory = filterFactory;
	}

	public FontFactory getFontFactory() {
		return fontFactory;
	}

	public WordFactory getWordFactory() {
		return wordFactory;
	}

	public ColorFactory getColorFactory() {
		return colorFactory;
	}

	public BackgroundFactory getBackgroundFactory() {
		return backgroundFactory;
	}

	public TextRenderer getTextRenderer() {
		return textRenderer;
	}

	public FilterFactory getFilterFactory() {
		return filterFactory;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Captcha getCaptcha() {
		BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		backgroundFactory.fillBackground(bufImage);
		String word = wordFactory.getNextWord();
		textRenderer.draw(word, bufImage, fontFactory, colorFactory);
		bufImage = filterFactory.applyFilters(bufImage);
		return new Captcha(word, bufImage);
	}

}
