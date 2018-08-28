package cn.jetclouds.aclibrary.word;

import java.util.Random;

public class AdaptiveRandomWordFactory extends RandomWordFactory {

	protected String wideCharacters;

	public void setWideCharacters(String wideCharacters) {
		this.wideCharacters = wideCharacters;
	}

	public AdaptiveRandomWordFactory(int minLength, int maxLength) {
		//characters = "absdegkmnopwx23456789";
		characters = "qX3wM8er1WtNasYd2fgYPz9ZJxU5cv0by6HupA4SGFCnKmQERThj7DBkV";
		wideCharacters = "mwWM";
		super.minLength = minLength;
		super.maxLength = maxLength;
	}
	
	@Override
	public String getNextWord() {
		Random rnd = new Random();
		StringBuffer sb = new StringBuffer();
		StringBuffer chars = new StringBuffer(characters);
		int l = minLength + (maxLength > minLength ? rnd.nextInt(maxLength - minLength) : 0);
		for (int i = 0; i < l; i++) {
			int j = rnd.nextInt(chars.length());
			char c = chars.charAt(j);
			if (wideCharacters.indexOf(c) != -1) {
				for (int k = 0; k < wideCharacters.length(); k++) {
					int idx = chars.indexOf(String.valueOf(wideCharacters.charAt(k)));
					if (idx != -1) {
						chars.deleteCharAt(idx);
					}
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}

}
