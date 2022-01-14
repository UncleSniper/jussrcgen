package org.unclesniper.srcgen;

import java.io.IOException;

public interface TextSink {

	void indent();

	void unindent();

	void shift();

	void unshift();

	void print(String str) throws IOException;

	void println(String str) throws IOException;

	void println() throws IOException;

}
