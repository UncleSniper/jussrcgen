package org.unclesniper.srcgen;

public class JavaStyleTextConfig implements TextConfig {

	public static final TextConfig instance = new JavaStyleTextConfig();

	public JavaStyleTextConfig() {}

	@Override
	public String getIndentString(GenConfig config) {
		return JavaStyle.getJavaIndentString(config);
	}

	@Override
	public String getShiftString(GenConfig config) {
		return JavaStyle.getJavaShiftString(config);
	}

	@Override
	public Boolean isKeepEmptyIndentedLines(GenConfig config) {
		return JavaStyle.isJavaKeepEmptyIndentedLines(config);
	}

}
