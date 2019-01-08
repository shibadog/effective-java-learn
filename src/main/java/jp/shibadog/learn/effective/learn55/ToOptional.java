package jp.shibadog.learn.effective.learn55;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public class ToOptional {

    public <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }
}