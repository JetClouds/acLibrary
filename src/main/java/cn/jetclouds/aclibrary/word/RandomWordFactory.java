package cn.jetclouds.aclibrary.word;

import java.util.Random;

public class RandomWordFactory implements WordFactory {

	protected String characters;
	protected int minLength;
	protected int maxLength;
	
	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public RandomWordFactory() {}

	public RandomWordFactory(int minLength, int maxLength) {
		//characters = "absdegkmnopwx23456789";
		characters = "qX3wM8er1WtNasYd2fgYPz9ZJxU5cv0by6HupA4SGFCnKmQERThj7DBkV";
		this.minLength = minLength;
		this.maxLength = maxLength;
	}
	
	public String getNextWord() {
		Random rnd = new Random();
		StringBuffer sb = new StringBuffer();
		int l = minLength + (maxLength > minLength ? rnd.nextInt(maxLength - minLength) : 0);
		for (int i = 0; i < l; i++) {
			int j = rnd.nextInt(characters.length());
			sb.append(characters.charAt(j));
		}
		return sb.toString();
	}
	
}
