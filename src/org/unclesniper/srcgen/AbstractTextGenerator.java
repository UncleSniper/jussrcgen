package org.unclesniper.srcgen;

import java.io.IOException;

import static org.unclesniper.util.ArgUtils.notNull;
import static org.unclesniper.srcgen.SpecUtils.genPredicate;

public abstract class AbstractTextGenerator implements TextGenerator {

	private GenPredicate blankLineAbove;

	private GenPredicate blankLineBelow;

	public AbstractTextGenerator() {}

	public GenPredicate getBlankLineAbove() {
		return blankLineAbove;
	}

	public void setBlankLineAbove(GenPredicate blankLineAbove) {
		this.blankLineAbove = blankLineAbove;
	}

	public void setBlankLineAbove(boolean blankLineAbove) {
		this.blankLineAbove = genPredicate(blankLineAbove);
	}

	public GenPredicate getBlankLineBelow() {
		return blankLineBelow;
	}

	public void setBlankLineBelow(GenPredicate blankLineBelow) {
		this.blankLineBelow = blankLineBelow;
	}

	public void setBlankLineBelow(boolean blankLineBelow) {
		this.blankLineBelow = genPredicate(blankLineBelow);
	}

	protected abstract void generateImpl(GenConfig config, Variables variables, TextSink sink)
			throws GenException, IOException;

	@Override
	public void generate(GenConfig config, Variables variables, TextSink sink) throws GenException, IOException {
		notNull(variables, "variables");
		notNull(sink, "sink");
		if(blankLineAbove != null && blankLineAbove.test(config, variables))
			sink.println();
		generateImpl(config, variables, sink);
		if(blankLineBelow != null && blankLineBelow.test(config, variables))
			sink.println();
	}

}
