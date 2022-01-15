package org.unclesniper.srcgen;

import org.unclesniper.util.JavaVisibility;
import org.unclesniper.srcgen.java.GenJavaVisibility;
import org.unclesniper.srcgen.java.StringJavaVisibility;
import org.unclesniper.srcgen.java.SymbolicJavaVisibility;

public final class SpecUtils {

	private SpecUtils() {}

	public static GenString genString(String string) {
		return string == null ? null : new StaticGenString(string);
	}

	public static GenPredicate genPredicate(boolean value) {
		return new StaticGenPredicate(value);
	}

	public static GenJavaVisibility genJavaVisibility(JavaVisibility visibility) {
		return visibility == null ? null : new SymbolicJavaVisibility(visibility);
	}

	public static GenJavaVisibility genJavaVisibility(String visibility) {
		return visibility == null ? null : new StringJavaVisibility(visibility);
	}

}
