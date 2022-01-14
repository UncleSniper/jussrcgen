package org.unclesniper.srcgen;

import java.io.IOException;

public class LineGenerator extends AbstractTextPieceGenerator {

	public LineGenerator() {}

	@Override
	protected void print(TextSink sink, String piece) throws IOException {
		sink.println(piece);
	}

}
