package org.unclesniper.srcgen;

public class TextStyleTextConfig implements TextConfig {

	public static final TextConfig instance = new TextStyleTextConfig();

	public TextStyleTextConfig() {}

	@Override
	public String getIndentString(GenConfig config) {
		return TextStyle.getIndentString(config);
	}

	@Override
	public String getShiftString(GenConfig config) {
		return TextStyle.getShiftString(config);
	}

	@Override
	public Boolean isKeepEmptyIndentedLines(GenConfig config) {
		return TextStyle.isKeepEmptyIndentedLines(config);
	}

}
