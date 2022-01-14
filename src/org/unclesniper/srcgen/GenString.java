package org.unclesniper.srcgen;

public interface GenString {

	void buildString(GenConfig config, Variables variables, StringBuilder sink) throws GenException;

	default String getString(GenConfig config, Variables variables) throws GenException {
		StringBuilder builder = new StringBuilder();
		this.buildString(config, variables, builder);
		return builder.toString();
	}

}
