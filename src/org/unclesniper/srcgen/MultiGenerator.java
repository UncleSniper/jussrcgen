package org.unclesniper.srcgen;

import java.util.List;
import java.io.IOException;
import java.util.LinkedList;

import static org.unclesniper.util.ArgUtils.notNull;

public class MultiGenerator implements Generator {

	private final List<Generator> generators = new LinkedList<Generator>();

	public MultiGenerator() {}

	public void addGenerator(Generator generator) {
		generators.add(notNull(generator, "generator"));
	}

	@Override
	public void generate(GenConfig config, Variables variables) throws GenException, IOException {
		for(Generator generator : generators)
			generator.generate(config, variables);
	}

}
