package by.it.plehanova.jd01_11;

import java.util.*;

public class SetC<E> implements Set {
    private ListB<E> elements = new ListB<>();
    int size = elements.size();

    @Override
    public boolean add(Object o) {

        if (!contains(o)) {
            elements.add((E) o);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c) {
            elements.add((E) o);
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == o) {
                elements.remove(elements.get(i));
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object o : c) {
            for (int i = 0; i < elements.size(); i++) {
                if (o.equals(elements.get(i))) {
                    elements.remove(elements.get(i));
                }
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        } else {
            for (int i = 0; i < elements.size(); i++) {
                if (o.equals(elements.get(i))) {
                    return true;
                } else {
                    continue;
                }
            }

        }
        return false;
    }


    @Override
    public boolean containsAll(Collection c) {
        int count = 0;
        if (!isEmpty()) {
            for (E element : elements) {
                for (Object o : c) {
                    if (element.equals(o)) {
                        count++;
                    }
                }
            }
            if (count == c.size()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        return elements.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

//stubs

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
