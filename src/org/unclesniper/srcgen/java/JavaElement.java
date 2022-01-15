package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenConfig;
import org.unclesniper.srcgen.Variables;
import org.unclesniper.srcgen.GenException;
import org.unclesniper.util.JavaVisibility;

public interface JavaElement {

	String getName(GenConfig config, Variables variables) throws GenException;

	JavaVisibility getVisibility(GenConfig config, Variables variables) throws GenException;

}
