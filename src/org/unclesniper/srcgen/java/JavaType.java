package org.unclesniper.srcgen.java;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import org.unclesniper.srcgen.GenString;
import org.unclesniper.srcgen.Variables;
import org.unclesniper.srcgen.GenConfig;
import org.unclesniper.srcgen.GenException;
import org.unclesniper.util.JavaVisibility;

import static org.unclesniper.util.ArgUtils.notNull;
import static org.unclesniper.srcgen.SpecUtils.genString;
import static org.unclesniper.srcgen.SpecUtils.genJavaVisibility;

public abstract class JavaType extends JavaPackaged implements JavaTop, JavaMember, JavaElement {

	private GenString name;

	private GenJavaVisibility visibility;

	private final List<JavaMember> members = new LinkedList<JavaMember>();

	public JavaType() {}

	public GenString getName() {
		return name;
	}

	public void setName(GenString name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = genString(name);
	}

	public GenJavaVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(GenJavaVisibility visibility) {
		this.visibility = visibility;
	}

	public void setVisibility(JavaVisibility visibility) {
		this.visibility = genJavaVisibility(visibility);
	}

	public void setVisibility(String visibility) {
		this.visibility = genJavaVisibility(visibility);
	}

	public void addMember(JavaMember member) {
		members.add(notNull(member, "member"));
	}

	public List<JavaMember> getMembers() {
		return Collections.unmodifiableList(members);
	}

	public Class<? extends JavaType> getTypeKind() {
		return getClass();
	}

	@Override
	public Class<? extends JavaTop> getTopKind() {
		return getTypeKind();
	}

	@Override
	public Class<? extends JavaMember> getMemberKind() {
		return getTypeKind();
	}

	@Override
	public String getName(GenConfig config, Variables variables) throws GenException {
		return JavaGenUtils.getName(config, variables, name, this);
	}

	@Override
	public JavaVisibility getVisibility(GenConfig config, Variables variables) throws GenException {
		return JavaVisibility.smartDefault(visibility == null ? null : visibility.asSymbolic(config, variables));
	}

}
