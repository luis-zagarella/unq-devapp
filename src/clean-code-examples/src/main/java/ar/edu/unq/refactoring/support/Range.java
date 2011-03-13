package ar.edu.unq.refactoring.support;

public class Range<T extends Comparable<? super T>> {

	private final T start;
	private final T end;

	public Range(T start, T end) {
		this.start = start;
		this.end = end;
	}

	public boolean notIncludes(T value) {
		return !includes(value);
	}

	public boolean includes(T value) {
		return startIsLowerOrEqualThan(value) && endIsGreaterOrEqualThan(value);
	}

	private boolean startIsLowerOrEqualThan(T value) {
		return start.compareTo(value) <= 0;
	}

	private boolean endIsGreaterOrEqualThan(T value) {
		return end.compareTo(value) >= 0;
	}

}