package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenConfig;
import org.unclesniper.srcgen.Variables;
import org.unclesniper.util.JavaVisibility;
import org.unclesniper.srcgen.GenException;

public interface GenJavaVisibility {

	JavaVisibility asSymbolic(GenConfig config, Variables variables) throws GenException;

}
