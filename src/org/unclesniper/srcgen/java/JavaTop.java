package org.unclesniper.srcgen.java;

public interface JavaTop extends JavaThing {

	default Class<? extends JavaTop> getTopKind() {
		return this.getClass();
	}

}
