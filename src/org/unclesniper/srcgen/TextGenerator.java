package org.unclesniper.srcgen;

import java.io.IOException;

public interface TextGenerator {

	void generate(GenConfig config, Variables variables, TextSink sink) throws GenException, IOException;

}
