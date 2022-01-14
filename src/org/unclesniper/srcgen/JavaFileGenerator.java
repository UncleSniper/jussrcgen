package org.unclesniper.srcgen;

import java.io.IOException;

public class JavaFileGenerator extends AbstractFileGenerator {

	private final MultiJavaTopGenerator multi = new MultiJavaTopGenerator();

	public JavaFileGenerator() {}

	public void addGenerator(JavaTopGenerator generator) {
		multi.addGenerator(generator);
	}

	@Override
	public void generate(GenConfig config, Variables variables) throws GenException, IOException {
		into(config, variables, multi, JavaStyleTextConfig.instance);
	}

}
