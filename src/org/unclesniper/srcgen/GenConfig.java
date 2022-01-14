package org.unclesniper.srcgen;

public interface GenConfig {

	<StyleT extends Style> StyleT getStyle(Class<StyleT> type);

}
