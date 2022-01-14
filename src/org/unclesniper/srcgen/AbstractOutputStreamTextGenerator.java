package org.unclesniper.srcgen;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static org.unclesniper.util.ArgUtils.notNull;
import static org.unclesniper.srcgen.SpecUtils.genString;

public abstract class AbstractOutputStreamTextGenerator extends AbstractWriterTextGenerator {

	private GenString charset;

	public AbstractOutputStreamTextGenerator() {}

	public GenString getCharset() {
		return charset;
	}

	public void setCharset(GenString charset) {
		this.charset = charset;
	}

	public void setCharset(String charset) {
		this.charset = genString(charset);
	}

	protected final void into(GenConfig config, Variables variables, OutputStream stream, TextGenerator sink,
			TextConfig textConfig) throws GenException, IOException {
		notNull(variables, "variables");
		notNull(stream, "stream");
		notNull(sink, "sink");
		String cs = charset == null ? null : charset.getString(config, variables);
		OutputStreamWriter osw = new OutputStreamWriter(stream, cs == null ? "UTF-8" : cs);
		into(config, variables, osw, sink, textConfig);
	}

}
