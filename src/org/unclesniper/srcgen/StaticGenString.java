package org.unclesniper.srcgen;

import static org.unclesniper.util.ArgUtils.notNull;

public class StaticGenString extends AbstractGenString {

	private String value;

	public StaticGenString() {}

	public StaticGenString(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	protected void buildStringImpl(GenConfig config, Variables variables, StringBuilder sink) {
		notNull(sink, "sink");
		if(value != null)
			sink.append(value);
	}

}
