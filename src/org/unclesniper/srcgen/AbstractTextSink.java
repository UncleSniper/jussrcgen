package org.unclesniper.srcgen;

import java.io.IOException;
import org.unclesniper.util.SystemProperties;

import static org.unclesniper.util.ArgUtils.notNull;

public abstract class AbstractTextSink implements TextSink {

	private String indentString;

	private String shiftString;

	private boolean keepEmptyIndentedLines;

	private boolean cleanLine = true;

	private int indentLevel;

	private int shiftLevel;

	public AbstractTextSink() {}

	public String getIndentString() {
		return indentString;
	}

	public void setIndentString(String indentString) {
		this.indentString = indentString;
	}

	public String getShiftString() {
		return shiftString;
	}

	public void setShiftString(String shiftString) {
		this.shiftString = shiftString;
	}

	public boolean isKeepEmptyIndentedLines() {
		return keepEmptyIndentedLines;
	}

	public void setKeepEmptyIndentedLines(boolean keepEmptyIndentedLines) {
		this.keepEmptyIndentedLines = keepEmptyIndentedLines;
	}

	private void doIndent() throws IOException {
		String is = indentString == null ? TextStyle.DEFAULT_INDENT_STRING : indentString;
		for(int i = 0; i < indentLevel; ++i)
			write(is);
		String ss = shiftString == null ? is : shiftString;
		for(int i = 0; i < shiftLevel; ++i)
			write(ss);
	}

	protected abstract void write(String str) throws IOException;

	@Override
	public void indent() {
		if(shiftLevel > 0)
			throw new IllegalStateException("Cannot indent with active shift");
		++indentLevel;
	}

	@Override
	public void unindent() {
		if(shiftLevel > 0)
			throw new IllegalStateException("Cannot unindent with active shift");
		if(indentLevel <= 0)
			throw new IllegalStateException("Cannot unindent to negative level");
		--indentLevel;
	}

	@Override
	public void shift() {
		++shiftLevel;
	}

	@Override
	public void unshift() {
		if(shiftLevel <= 0)
			throw new IllegalStateException("Cannot unshift to negative level");
		--shiftLevel;
	}

	@Override
	public void print(String str) throws IOException {
		if(notNull(str, "str").length() == 0)
			return;
		if(cleanLine)
			doIndent();
		write(str);
		cleanLine = false;
	}

	@Override
	public void println(String str) throws IOException {
		print(str);
		println();
	}

	@Override
	public void println() throws IOException {
		if(cleanLine && keepEmptyIndentedLines)
			doIndent();
		write(SystemProperties.LINE_SEPARATOR);
		cleanLine = true;
	}

}
