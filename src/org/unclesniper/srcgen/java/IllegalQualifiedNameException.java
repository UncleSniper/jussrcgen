package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenException;

import static org.unclesniper.util.ArgUtils.notNull;

public class IllegalQualifiedNameException extends GenException {

	private final String packageName;

	public IllegalQualifiedNameException(String packageName) {
		super("Illegal Java package name: " + notNull(packageName, "packageName"));
		this.packageName = packageName;
	}

	public String getPackage() {
		return packageName;
	}

}
