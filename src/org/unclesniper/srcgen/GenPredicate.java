package org.unclesniper.srcgen;

public interface GenPredicate {

	boolean test(GenConfig config, Variables variables) throws GenException;

}
