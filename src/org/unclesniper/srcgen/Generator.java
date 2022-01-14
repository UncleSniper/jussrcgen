package org.unclesniper.srcgen;

import java.io.IOException;

public interface Generator {

	void generate(GenConfig config, Variables variables) throws GenException, IOException;

}
