package app.puntjes.sdk;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/** Walks a paginated call page by page, starting at page 1, until the last page in its meta. */
public final class Paginator {
    private Paginator() {
    }

    /** One page of items with the paging meta of the API's envelope. */
    public record Page<T>(List<T> items, int currentPage, int lastPage) {
    }

    /**
     * A lazy stream of every item. It stops early when the server answers another page than the one asked for, so a
     * server that ignores {@code page} cannot loop it forever.
     */
    public static <T> Stream<T> all(IntFunction<Page<T>> fetch) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Items<>(fetch), Spliterator.ORDERED), false);
    }

    /** The same walk as {@link #all}, as an {@link Iterable} for a {@code for} loop. Each loop starts from page 1. */
    public static <T> Iterable<T> iterable(IntFunction<Page<T>> fetch) {
        return () -> new Items<>(fetch);
    }

    private static final class Items<T> implements Iterator<T> {
        private final IntFunction<Page<T>> fetch;
        private Iterator<T> current = List.<T>of().iterator();
        private int page;
        private boolean lastPageRead;

        Items(IntFunction<Page<T>> fetch) {
            this.fetch = fetch;
        }

        @Override
        public boolean hasNext() {
            while (!current.hasNext() && !lastPageRead) {
                readNextPage();
            }
            return current.hasNext();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return current.next();
        }

        private void readNextPage() {
            page++;
            Page<T> read = fetch.apply(page);
            if (read.currentPage() != page) {
                lastPageRead = true;
                return;
            }
            current = read.items() == null ? List.<T>of().iterator() : read.items().iterator();
            lastPageRead = page >= read.lastPage();
        }
    }
}
