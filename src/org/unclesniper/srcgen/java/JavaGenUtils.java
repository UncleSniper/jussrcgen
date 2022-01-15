package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenConfig;
import org.unclesniper.srcgen.Variables;
import org.unclesniper.srcgen.GenString;
import org.unclesniper.srcgen.GenException;

import static org.unclesniper.util.ArgUtils.notNull;
import static org.unclesniper.util.JavaUtils.isIdentifier;
import static org.unclesniper.util.PropertyUtils.requireSet;
import static org.unclesniper.util.JavaUtils.isQualifiedName;

public final class JavaGenUtils {

	private JavaGenUtils() {}

	public static String getName(GenConfig config, Variables variables, GenString name, JavaThing thing)
			throws GenException {
		String n = requireSet(name, "name", notNull(thing, "thing")).getString(config, variables);
		if(n == null || !isIdentifier(n))
			throw new IllegalIdentifierException(n);
		return n;
	}

	public static String getPackage(GenConfig config, Variables variables, GenString packageName)
			throws GenException {
		String name = packageName == null ? null : packageName.getString(config, variables);
		if(name == null || name.length() == 0)
			return null;
		if(!isQualifiedName(name))
			throw new IllegalQualifiedNameException(name);
		return name;
	}

}
