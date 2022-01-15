package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenString;
import org.unclesniper.srcgen.GenConfig;
import org.unclesniper.srcgen.Variables;
import org.unclesniper.srcgen.GenException;

import static org.unclesniper.srcgen.SpecUtils.genString;

public abstract class JavaPackaged {

	private GenString packageName;

	public JavaPackaged() {}

	public GenString getPackage() {
		return packageName;
	}

	public void setPackage(GenString packageName) {
		this.packageName = packageName;
	}

	public void setPackage(String packageName) {
		this.packageName = genString(packageName);
	}

	public String getPackage(GenConfig config, Variables variables) throws GenException {
		return JavaGenUtils.getPackage(config, variables, packageName);
	}

}
