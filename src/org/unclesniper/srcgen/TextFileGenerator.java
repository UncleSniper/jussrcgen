package org.unclesniper.srcgen;

import java.io.IOException;

public class TextFileGenerator extends AbstractFileGenerator {

	private final MultiTextGenerator multi = new MultiTextGenerator();

	public TextFileGenerator() {}

	public void addGenerator(TextGenerator generator) {
		multi.addGenerator(generator);
	}

	@Override
	public void generate(GenConfig config, Variables variables) throws GenException, IOException {
		into(config, variables, multi, TextStyleTextConfig.instance);
	}

}
