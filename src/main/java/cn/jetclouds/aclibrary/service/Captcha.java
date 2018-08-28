package cn.jetclouds.aclibrary.service;

import java.awt.image.BufferedImage;

public class Captcha {

	private String challenge;
	private BufferedImage image;

	public Captcha(String challenge, BufferedImage image) {
		this.challenge = challenge;
		this.image = image;
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
