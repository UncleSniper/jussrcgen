package org.unclesniper.srcgen;

public class EmptyOutputPathException extends GenException {

	public EmptyOutputPathException() {
		super("Destination path is empty");
	}

}
