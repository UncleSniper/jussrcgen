package org.unclesniper.srcgen;

import static org.unclesniper.util.ArgUtils.notNull;

public interface TextStyle extends Style {

	public static final String DEFAULT_INDENT_STRING = "\t";

	String getIndentString();

	String getShiftString();

	Boolean isKeepEmptyIndentedLines();

	public static <StyleT extends TextStyle> String getIndentString(GenConfig config, Class<StyleT> styleType) {
		notNull(styleType, "styleType");
		if(config == null)
			return TextStyle.DEFAULT_INDENT_STRING;
		StyleT style = config.getStyle(styleType);
		String indentString = style == null ? null : style.getIndentString();
		return indentString == null ? TextStyle.DEFAULT_INDENT_STRING : indentString;
	}

	public static String getIndentString(GenConfig config) {
		return TextStyle.getIndentString(config, TextStyle.class);
	}

	public static <StyleT extends TextStyle> String getShiftString(GenConfig config, Class<StyleT> styleType) {
		notNull(styleType, "styleType");
		StyleT style = config == null ? null : config.getStyle(styleType);
		String shiftString = style == null ? null : style.getShiftString();
		return shiftString == null ? TextStyle.getIndentString(config, styleType) : shiftString;
	}

	public static String getShiftString(GenConfig config) {
		return TextStyle.getShiftString(config, TextStyle.class);
	}

	public static <StyleT extends TextStyle> boolean isKeepEmptyIndentedLines(GenConfig config,
			Class<StyleT> styleType) {
		notNull(styleType, "styleType");
		if(config == null)
			return false;
		StyleT style = config.getStyle(styleType);
		Boolean keep = style == null ? null : style.isKeepEmptyIndentedLines();
		return keep != null && keep.booleanValue();
	}

	public static boolean isKeepEmptyIndentedLines(GenConfig config) {
		return TextStyle.isKeepEmptyIndentedLines(config, TextStyle.class);
	}

}
