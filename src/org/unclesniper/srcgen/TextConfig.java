package org.unclesniper.srcgen;

public interface TextConfig {

	String getIndentString(GenConfig config);

	String getShiftString(GenConfig config);

	Boolean isKeepEmptyIndentedLines(GenConfig config);

}
