package org.unclesniper.srcgen;

public interface JavaStyle extends TextStyle {

	public static String getJavaIndentString(GenConfig config) {
		if(config == null)
			return TextStyle.DEFAULT_INDENT_STRING;
		TextStyle style = config.getStyle(JavaStyle.class);
		if(style == null)
			style = config.getStyle(TextStyle.class);
		String indentString = style == null ? null : style.getIndentString();
		return indentString == null ? TextStyle.DEFAULT_INDENT_STRING : indentString;
	}

	public static String getJavaShiftString(GenConfig config) {
		TextStyle style;
		if(config == null)
			style = null;
		else {
			style = config.getStyle(JavaStyle.class);
			if(style == null)
				style = config.getStyle(TextStyle.class);
		}
		String shiftString = style == null ? null : style.getShiftString();
		return shiftString == null ? JavaStyle.getJavaIndentString(config) : shiftString;
	}

	public static boolean isJavaKeepEmptyIndentedLines(GenConfig config) {
		if(config == null)
			return false;
		TextStyle style = config.getStyle(JavaStyle.class);
		if(style == null)
			style = config.getStyle(TextStyle.class);
		Boolean keep = style == null ? null : style.isKeepEmptyIndentedLines();
		return keep != null && keep.booleanValue();
	}

}
