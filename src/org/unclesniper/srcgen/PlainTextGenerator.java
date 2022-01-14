package org.unclesniper.srcgen;

import java.io.IOException;

public class PlainTextGenerator extends AbstractTextPieceGenerator {

	public PlainTextGenerator() {}

	@Override
	protected void print(TextSink sink, String piece) throws IOException {
		sink.print(piece);
	}

}
