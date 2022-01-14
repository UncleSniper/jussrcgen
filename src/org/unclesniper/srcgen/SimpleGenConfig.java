package org.unclesniper.srcgen;

import org.unclesniper.util.collection.TypeMap;

public class SimpleGenConfig implements GenConfig {

	private final TypeMap<Style> styles = new TypeMap<Style>();

	public SimpleGenConfig() {
		styles.setUpperBoundClass(Style.class);
		styles.setCheckType(true);
	}

	public <StyleT extends Style> void setStype(Class<StyleT> type, StyleT instance) {
		styles.put(type, instance);
	}

	@Override
	public <StyleT extends Style> StyleT getStyle(Class<StyleT> type) {
		return styles.get(type);
	}

}
