package org.unclesniper.srcgen;

import java.io.IOException;

import static org.unclesniper.util.ArgUtils.notNull;
import static org.unclesniper.util.PropertyUtils.requireSet;

public class CrossProductGenerator extends AbstractCrossProductGenerator implements Generator {

	private Generator generator;

	public CrossProductGenerator() {}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	@Override
	public void generate(GenConfig config, Variables variables) throws GenException, IOException {
		notNull(variables, "variables");
		requireSet(generator, "generator", this);
		explode(config, variables, generator);
	}

}
