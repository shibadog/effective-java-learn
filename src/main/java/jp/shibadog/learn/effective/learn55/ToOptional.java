package jp.shibadog.learn.effective.learn55;

import java.util.Collection;
import java.util.Objects;

public class ToOptional {

    public <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");
        
            E result = null;
            for (E e : c)
                if (result == null || e.compareTo(result) > 0)
                    result = Objects.requireNonNull(e);
            return result;
    }
}