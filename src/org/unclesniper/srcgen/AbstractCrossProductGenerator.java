package org.unclesniper.srcgen;

import java.util.List;
import java.io.IOException;
import java.util.LinkedList;
import org.unclesniper.util.OMGWereDoomedError;

import static org.unclesniper.util.ArgUtils.notNull;

public abstract class AbstractCrossProductGenerator {

	private final List<VarSequence> sequences = new LinkedList<VarSequence>();

	public AbstractCrossProductGenerator() {}

	public void addSequence(VarSequence sequence) {
		sequences.add(notNull(sequence, "sequence"));
	}

	protected final void explode(GenConfig config, Variables parent, Generator sink)
			throws GenException, IOException {
		notNull(sink, "sink");
		VarSequence[] outer = sequences.toArray(new VarSequence[sequences.size()]);
		MultiVariables multi = new MultiVariables();
		explodeRec(outer, 0, multi, config, parent, sink);
	}

	private void explodeRec(VarSequence[] outer, int depth, MultiVariables multi, GenConfig config,
			Variables parent, Generator sink) throws GenException, IOException {
		if(depth > outer.length)
			throw new OMGWereDoomedError("Recursion is too deep: " + depth + " > " + outer.length);
		if(depth == outer.length) {
			if(parent != null)
				multi.addChild(parent);
			sink.generate(config, multi);
			if(parent != null)
				multi.popChild();
			return;
		}
		for(Variables variables : outer[depth].getElements()) {
			multi.addChild(variables);
			explodeRec(outer, depth + 1, multi, config, parent, sink);
			multi.popChild();
		}
	}

}
