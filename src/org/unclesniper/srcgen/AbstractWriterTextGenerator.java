package org.unclesniper.srcgen;

import java.io.Writer;
import java.io.IOException;

import static org.unclesniper.util.ArgUtils.notNull;
import static org.unclesniper.srcgen.SpecUtils.genString;
import static org.unclesniper.srcgen.SpecUtils.genPredicate;

public abstract class AbstractWriterTextGenerator {

	private GenString indentString;

	private GenString shiftString;

	private GenPredicate keepEmptyIndentedLines;

	public AbstractWriterTextGenerator() {}

	public GenString getIndentString() {
		return indentString;
	}

	public void setIndentString(GenString indentString) {
		this.indentString = indentString;
	}

	public void setIndentString(String indentString) {
		this.indentString = genString(indentString);
	}

	public GenString getShiftString() {
		return shiftString;
	}

	public void setShiftString(GenString shiftString) {
		this.shiftString = shiftString;
	}

	public void setShiftString(String shiftString) {
		this.shiftString = genString(shiftString);
	}

	public GenPredicate getKeepEmptyIndentedLines() {
		return keepEmptyIndentedLines;
	}

	public void setKeepEmptyIndentedLines(GenPredicate keepEmptyIndentedLines) {
		this.keepEmptyIndentedLines = keepEmptyIndentedLines;
	}

	public void setKeepEmptyIndentedLines(boolean keepEmptyIndentedLines) {
		this.keepEmptyIndentedLines = genPredicate(keepEmptyIndentedLines);
	}

	protected final void into(GenConfig config, Variables variables, Writer writer, TextGenerator sink,
			TextConfig textConfig) throws GenException, IOException {
		notNull(variables, "variables");
		WriterTextSink wts = new WriterTextSink(writer);
		wts.setIndentString(indentString == null ? textConfig.getIndentString(config)
				: indentString.getString(config, variables));
		wts.setShiftString(shiftString == null ? textConfig.getShiftString(config)
				: shiftString.getString(config, variables));
		Boolean keep = keepEmptyIndentedLines == null ? textConfig.isKeepEmptyIndentedLines(config)
				: keepEmptyIndentedLines.test(config, variables);
		if(keep != null)
			wts.setKeepEmptyIndentedLines(keep);
		sink.generate(config, variables, wts);
	}

}
