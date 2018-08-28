package cn.jetclouds.aclibrary;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import cn.jetclouds.aclibrary.color.SingleColorFactory;
import cn.jetclouds.aclibrary.filter.predefined.CurvesRippleFilterFactory;
import cn.jetclouds.aclibrary.service.ConfigurableCaptchaService;
import cn.jetclouds.aclibrary.utils.encoder.EncoderHelper;

/**
 * <p>ClassName：Generate</p>
 * <p>Description：生成验证码图像类</p>
 * @author JohnnyWu
 * @email johnnywu9712@live.com
 * @date 2018年3月29日 上午11:38:23 
 * @version v1.0.0
 */
public class Generate {
	
	/**
	 * 生成Web验证码图像
	 * @param width 图像宽度
	 * @param height 图像高读
	 * @param fontMinSize 图像字体最小尺寸
	 * @param fontMaxSize 图像字体最大尺寸
	 * @param minLength 验证码字符最小长度
	 * @param maxLength 验证码字符最大长度
	 * @param os 输出流
	 * @param imageType 图像类型/后缀名
	 * @return 当前生成验证码字符代码
	 */
	public static String obtainWebImage(int width,int height,int fontMinSize,int fontMaxSize,int minLength,int maxLength,OutputStream os,String imageType) {
		ConfigurableCaptchaService ccs = new ConfigurableCaptchaService(width,height,fontMinSize,fontMaxSize,minLength,maxLength);
		ccs.setColorFactory(new SingleColorFactory(new Color(25,60,170)));
		ccs.setFilterFactory(new CurvesRippleFilterFactory(ccs.getColorFactory()));
		
		String code = null;
		try {
			code = EncoderHelper.getChallangeAndWriteImage(ccs, "png", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return code;
	}
	
	/**
	 * 生成验证码图像文件
	 * @param width 图像宽度
	 * @param height 图像高读
	 * @param fontMinSize 图像字体最小尺寸
	 * @param fontMaxSize 图像字体最大尺寸
	 * @param minLength 验证码字符最小长度
	 * @param maxLength 验证码字符最大长度
	 * @param filePath 生成图像文件的位置
	 * @param imageType 图像类型/后缀名
	 * @return 当前生成验证码字符代码
	 */
	public static String obtainImageFile(int width,int height,int fontMinSize,int fontMaxSize,int minLength,int maxLength,String filePath,String imageType) {
		ConfigurableCaptchaService ccs = new ConfigurableCaptchaService(width,height,fontMinSize,fontMaxSize,minLength,maxLength);//160,70,45,45,6,6
		ccs.setColorFactory(new SingleColorFactory(new Color(25,60,170)));
		ccs.setFilterFactory(new CurvesRippleFilterFactory(ccs.getColorFactory()));
		
		FileOutputStream fos = null;
		String code = null;
		try {
			fos = new FileOutputStream(filePath);// 指定生成图像文件位置
			code = EncoderHelper.getChallangeAndWriteImage(ccs, imageType, fos);// png,jpg
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return code;
		
	}
	
}
