package tasks._8_exc_handling;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Storage<E extends Comparable<E>> implements Iterable<E> {
    private static final int NO_NULLS_LEFT = -1;
    private final E[] array;

    @SuppressWarnings("unchecked")
    public Storage(Class<? extends E> clazz) {
        array = (E[]) Array.newInstance(clazz, 10);
    }

    public void push(E element) {
        if(isFull()) {
            throw new UnsupportedOperationException("Storage is full.");
        }

        array[getIndexOfFirstNull()] = element;
    }

    public void sort() {
        if(Stream.of(array).allMatch(element -> element.equals(array[0]))) {
            throw new UnsupportedOperationException("sort() cannot be invoked on an empty storage or on a storage with the same elements inside.");
        }

        Arrays.sort(array, 0, getIndexOfFirstNull() - 1);
    }

    public boolean contains(E element) {
        if(isEmpty()) {
            throw new UnsupportedOperationException("contains(E) cannot be invoked on an empty storage.");
        }

        return Arrays.asList(array).contains(element);
    }

    public <T> T accumulate(T accumulator, BiFunction<E, T, T> accumulationAction) {
        if(isEmpty()) {
            throw new UnsupportedOperationException("accumulate(T, BiFunction<E, T, T>) cannot be used on an empty storage.");
        }

        for (int index = 0; index < getIndexOfFirstNull(); index++) {
            accumulator = accumulationAction.apply(array[index], accumulator);
        }

        return accumulator;
    }

    public boolean isEmpty() {
        return getIndexOfFirstNull() == 0;
    }

    public boolean isFull() {
        return getIndexOfFirstNull() == NO_NULLS_LEFT;
    }

    private int getIndexOfFirstNull() {
        for(int index = 0; index < array.length; index++) {
            if(array[index] == null) {
                return index;
            }
        }

        return NO_NULLS_LEFT;
    }

    @Override
    public Iterator<E> iterator() {
        return Stream.of(array).iterator();
    }
}
