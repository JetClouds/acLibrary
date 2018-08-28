package cn.jetclouds.aclibrary.service;

import cn.jetclouds.aclibrary.background.SingleColorBackgroundFactory;
import cn.jetclouds.aclibrary.color.SingleColorFactory;
import cn.jetclouds.aclibrary.filter.FilterFactory;
import cn.jetclouds.aclibrary.font.RandomFontFactory;
import cn.jetclouds.aclibrary.text.renderer.BestFitTextRenderer;
import cn.jetclouds.aclibrary.word.AdaptiveRandomWordFactory;

import java.awt.*;

public class SimpleCaptchaService extends AbstractCaptchaService {

	public SimpleCaptchaService(int width, int height, Color textColor, Color backgroundColor, int fontSize, FilterFactory ff,int fontMinSize,int fontMaxSize) {
		backgroundFactory = new SingleColorBackgroundFactory(backgroundColor);
		wordFactory = new AdaptiveRandomWordFactory(6,6);
		fontFactory = new RandomFontFactory(fontMinSize,fontMaxSize);
		textRenderer = new BestFitTextRenderer();
		colorFactory = new SingleColorFactory(textColor);
		filterFactory = ff;
		this.width = width;
		this.height = height;
	}
	
	public SimpleCaptchaService(int width, int height, Color textColor, Color backgroundColor, int fontSize, String[]fontNames, FilterFactory ff) {
		backgroundFactory = new SingleColorBackgroundFactory(backgroundColor);
		wordFactory = new AdaptiveRandomWordFactory(6,6);
		fontFactory = new RandomFontFactory(fontNames);
		textRenderer = new BestFitTextRenderer();
		colorFactory = new SingleColorFactory(textColor);
		filterFactory = ff;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public Captcha getCaptcha() {
		return null;
	}

}
