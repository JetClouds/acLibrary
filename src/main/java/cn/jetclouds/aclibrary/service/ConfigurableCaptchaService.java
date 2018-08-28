package cn.jetclouds.aclibrary.service;

import cn.jetclouds.aclibrary.background.SingleColorBackgroundFactory;
import cn.jetclouds.aclibrary.color.SingleColorFactory;
import cn.jetclouds.aclibrary.filter.predefined.CurvesRippleFilterFactory;
import cn.jetclouds.aclibrary.font.RandomFontFactory;
import cn.jetclouds.aclibrary.text.renderer.BestFitTextRenderer;
import cn.jetclouds.aclibrary.word.AdaptiveRandomWordFactory;

public class ConfigurableCaptchaService extends AbstractCaptchaService {

	public ConfigurableCaptchaService(int width,int height,int fontMinSize,int fontMaxSize,int minLength,int maxLength) {
		backgroundFactory = new SingleColorBackgroundFactory();
		wordFactory = new AdaptiveRandomWordFactory(minLength,maxLength);
		fontFactory = new RandomFontFactory(fontMinSize,fontMaxSize);
		textRenderer = new BestFitTextRenderer();
		colorFactory = new SingleColorFactory();
		filterFactory = new CurvesRippleFilterFactory(colorFactory);
		textRenderer.setLeftMargin(10);
		textRenderer.setRightMargin(10);
		this.width = width;
		this.height = height;
	}

}
