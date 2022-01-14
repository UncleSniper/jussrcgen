package org.unclesniper.srcgen;

public final class SpecUtils {

	private SpecUtils() {}

	public static GenString genString(String string) {
		return string == null ? null : new StaticGenString(string);
	}

	public static GenPredicate genPredicate(boolean value) {
		return new StaticGenPredicate(value);
	}

}
