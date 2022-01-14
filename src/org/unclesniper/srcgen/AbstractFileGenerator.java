package org.unclesniper.srcgen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileOutputStream;

import static org.unclesniper.util.ArgUtils.notNull;
import static org.unclesniper.srcgen.SpecUtils.genString;
import static org.unclesniper.util.PropertyUtils.requireSet;

public abstract class AbstractFileGenerator extends AbstractOutputStreamTextGenerator implements Generator {

	private GenString file;

	public AbstractFileGenerator() {}

	public GenString getFile() {
		return file;
	}

	public void setFile(GenString file) {
		this.file = file;
	}

	public void setFile(String file) {
		this.file = genString(file);
	}

	protected final void into(GenConfig config, Variables variables, TextGenerator sink, TextConfig textConfig)
			throws GenException, IOException {
		notNull(variables, "variables");
		notNull(sink, "sink");
		String path = requireSet(file, "file", this).getString(config, variables);
		if(path == null || path.length() == 0)
			throw new EmptyOutputPathException();
		File f = new File(path).getAbsoluteFile();
		Files.createDirectories(f.getParentFile().toPath());
		try(FileOutputStream fos = new FileOutputStream(f)) {
			into(config, variables, fos, sink, textConfig);
		}
	}

}
