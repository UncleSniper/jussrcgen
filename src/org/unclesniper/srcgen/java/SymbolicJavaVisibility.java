package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenConfig;
import org.unclesniper.srcgen.Variables;
import org.unclesniper.util.JavaVisibility;

public class SymbolicJavaVisibility implements GenJavaVisibility {

	private JavaVisibility visibility;

	public SymbolicJavaVisibility() {}

	public SymbolicJavaVisibility(JavaVisibility visibility) {
		this.visibility = visibility;
	}

	public JavaVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(JavaVisibility visibility) {
		this.visibility = visibility;
	}

	@Override
	public JavaVisibility asSymbolic(GenConfig config, Variables variables) {
		return JavaVisibility.smartDefault(visibility);
	}

}
