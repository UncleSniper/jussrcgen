package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenString;
import org.unclesniper.srcgen.GenConfig;
import org.unclesniper.srcgen.Variables;
import org.unclesniper.util.JavaVisibility;
import org.unclesniper.srcgen.GenException;

import static org.unclesniper.srcgen.SpecUtils.genString;

public class StringJavaVisibility implements GenJavaVisibility {

	private GenString visibility;

	public StringJavaVisibility() {}

	public StringJavaVisibility(GenString visibility) {
		this.visibility = visibility;
	}

	public StringJavaVisibility(String visibility) {
		this.visibility = genString(visibility);
	}

	public GenString getVisibility() {
		return visibility;
	}

	public void setVisibility(GenString visibility) {
		this.visibility = visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = genString(visibility);
	}

	@Override
	public JavaVisibility asSymbolic(GenConfig config, Variables variables) throws GenException {
		String v = visibility == null ? null : visibility.getString(config, variables);
		try {
			return v == null ? JavaVisibility.PUBLIC : JavaVisibility.byName(v);
		}
		catch(IllegalArgumentException e) {
			throw new UnrecognizedVisibilityException(v);
		}
	}

}
