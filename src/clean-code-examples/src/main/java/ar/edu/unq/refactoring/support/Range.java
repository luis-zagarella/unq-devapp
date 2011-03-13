package ar.edu.unq.refactoring.support;

public class Range<T extends Comparable<? super T>> {

    private final T start;

    private final T end;

    public Range(final T start, final T end) {
        this.start = start;
        this.end = end;
    }

    public boolean notIncludes(final T value) {
        return !this.includes(value);
    }

    public boolean includes(final T value) {
        return this.startIsLowerOrEqualThan(value) && this.endIsGreaterOrEqualThan(value);
    }

    private boolean startIsLowerOrEqualThan(final T value) {
        return start.compareTo(value) <= 0;
    }

    private boolean endIsGreaterOrEqualThan(final T value) {
        return end.compareTo(value) >= 0;
    }

}