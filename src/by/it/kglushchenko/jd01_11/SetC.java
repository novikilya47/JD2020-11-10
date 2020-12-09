package by.it.kglushchenko.jd01_11;

import java.util.*;


public class SetC<T> implements Set<T> {
    @SuppressWarnings("unchecked")
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 3 / 2 + 1);
        }
        if (!contains(t)) {
            elements[size++] = t;
            //System.out.println(size);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == (T) o) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this set (its cardinality).  If this
     * set contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this set (its cardinality)
     */
    @Override
    public int size() {
//        int size = set1.size();
//        for (E e : set2) {
//            if (!set1.contains(e)) {
//                size++;
//            }
//        }
        return elements.length;
    }

    /**
     * Returns {@code true} if this set contains no elements.
     *
     * @return {@code true} if this set contains no elements
     */
    @Override
    public boolean isEmpty() {
        if(elements.length==0)
        return true;
        else
            return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        String[] col = ((c.toString()).replaceAll("[{}\\[\\],]", "")).split(" ");
        if (size != 0) {
            for (int i = 0; i < col.length; i++) {
                if (!contains(col[i])) {
                    add((T) col[i]);
                }
            }
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
