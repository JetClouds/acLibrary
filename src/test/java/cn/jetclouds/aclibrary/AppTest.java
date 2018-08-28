package cn.jetclouds.aclibrary;

/**
 * <p>ClassName：AppTest</p>
 * <p>Description：验证码生成示例程序</p>
 * @author JohnnyWu
 * @email johnnywu9712@live.com
 * @date 2018年3月29日 下午5:25:45 
 * @version v1.0.0
 */
public class AppTest {
	
	public static void main(String[] args) {
		// 生成验证码图像，当前示例程序图像默认生成在D盘
		String code = Generate.obtainImageFile(160, 70, 45, 45, 6, 6, "D:\\codeImage.png", "png");
		System.out.println("Current generated auth code:" + code);
	}
	
}
