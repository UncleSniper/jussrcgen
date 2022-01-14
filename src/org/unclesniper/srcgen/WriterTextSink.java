package org.unclesniper.srcgen;

import java.io.Writer;
import java.io.IOException;

import static org.unclesniper.util.ArgUtils.notNull;

public class WriterTextSink extends AbstractTextSink {

	private final Writer writer;

	public WriterTextSink(Writer writer) {
		this.writer = notNull(writer, "writer");
	}

	public Writer getWriter() {
		return writer;
	}

	@Override
	protected void write(String str) throws IOException {
		writer.write(notNull(str, "str"));
	}

}
