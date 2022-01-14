package org.unclesniper.srcgen;

public class StaticGenPredicate implements GenPredicate {

	private boolean value;

	public StaticGenPredicate() {}

	public StaticGenPredicate(boolean value) {
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	@Override
	public boolean test(GenConfig config, Variables variables) {
		return value;
	}

}
