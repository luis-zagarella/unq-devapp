package ar.edu.unq.examples;

import java.util.List;

import ar.edu.unq.examples.ext.Element;

public class PaginatorExample {

    int cacheOffset;

    int cacheSize;

    List<Element> cachedElements;

    public List<Element> nextFrom(final int offset, final int size) {
        if (this.cacheNeedsRePopulation(offset, size)) {
            this.repopulateCache(offset, size);
        }
        return this.nextFromCache(offset, size);
    }

    private boolean cacheNeedsRePopulation(final int offset, final int size) {
        return this.requestIsUnderCacheWindow(offset, size) || this.requestIsOverCacheWindow(offset);
    }

    private boolean requestIsOverCacheWindow(final int offset) {
        return offset < cacheOffset;
    }

    private boolean requestIsUnderCacheWindow(final int offset, final int size) {
        return offset + size > cacheOffset + cacheSize;
    }

    private List<Element> nextFromCache(final int offset, final int size) {
        throw new UnsupportedOperationException();
    }

    private void repopulateCache(final int offset, final int size) {
        throw new UnsupportedOperationException();
    }

    // /////////////////////////////////////////////////////////////////
    // /////////////////////////////////////////////////////////////////
    // /////////////////////////////////////////////////////////////////

    public List<Element> nextFrom2(final int offset, final int size) {
        if (offset + size > cacheOffset + cacheSize || offset < cacheOffset) {
            this.repopulateCache(offset, size);
        }
        return this.nextFromCache(offset, size);
    }

}
