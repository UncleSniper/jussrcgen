package org.unclesniper.srcgen;

import java.io.IOException;

public interface Generator {

	void generate(Variables variables) throws GenException, IOException;

}
