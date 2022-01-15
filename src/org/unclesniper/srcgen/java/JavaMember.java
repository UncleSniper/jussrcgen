package org.unclesniper.srcgen.java;

public interface JavaMember extends JavaThing {

	default Class<? extends JavaMember> getMemberKind() {
		return this.getClass();
	}

}
