/*
 * Data Structures and Algorithms.
 * Copyright (C) 2016 Rafael Guterres Jeffman
 *
 * See the LICENSE file accompanying this source code, for
 * licensing restrictions that might apply.
 *
 */
package estruturas;

import interfaces.Iterator;

class VectorIterator<T> implements interfaces.Iterator<T> {

    private Vector<T> container;
    private int current;

    public VectorIterator(Vector<T> vector) {
        this.container = vector;
        this.current = -1;
    }

    @Override
    public void insert(T value) {
        container.insert(current, value);
        current++;
    }

    @Override
    public void remove() {
        container.remove(this.current);
    }

    @Override
    public T next() {
        current++;
        return container.get(current);
    }

    @Override
    public boolean hasNext() {
        return current < container.size() - 1;
    }

}

/**
 * Implements a list data structure where elements are stored in contiguous
 * memory.
 */
public class Vector<T> implements interfaces.Iterable<T> {

    private Object[] data = new Object[16];
    private int count = 0;

    public Vector(){}
    
    public Vector( T[] array ) {
        fromArray(array);
    }

    /**
     * Inserts a new element to the vector at the specified index. The index
     * must be between 0 and the number of elements already stored.
     *
     * @param index The index to insert the new value.
     * @param value The value to be stored.
     */
    public void insert(int index, T value) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        ensureSpaceAvailable();
        System.arraycopy(data, index, data, index + 1, count - index);
        data[index] = value;
        count++;
    }

    /**
     * Query the number of elements stored.
     *
     * @return The current number of elements stored.
     */
    public int size() {
        return count;
    }

    /**
     * Remove the element at the given index, if its between 0 and the number of
     * elements stored.
     *
     * @param index The index of the element to be removed.
     */
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        ensureSpaceAvailable();
        System.arraycopy(data, index + 1, data, index, count - index - 1);
        count--;
        data[count] = null;
    }
    
    /**
     * Removes the element at index and returns it
     * @param index
     * @return 
     */
    public T pop( int index ){
        
        T tmp = get(index);
        
        remove(index);
        
        return tmp;
        
    }

    /**
     * Append a value to the end of the data.
     *
     * @param value The value to be stored.
     */
    public void append(T value) {
        insert(count, value);
    }

    /**
     * Returns an element stored at a given index.
     *
     * @param index The index of the element to be retrieved.
     * @return The element at the given index.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return (T) data[index];
    }

    // resize the underlying storage pool if necessary.
    private void ensureSpaceAvailable() {
        if (count < data.length) {
            return;
        }
        Object[] novo = new Object[newSize()];
        System.arraycopy(data, 0, novo, 0, count);
        data = novo;
    }

    // compute the new size of the storage pool.
    private int newSize() {
        final int INCREASE_LIMIT = 1024;
        return data.length > INCREASE_LIMIT
                ? data.length + INCREASE_LIMIT
                : data.length * 2;
    }

    /**
     * Return an iterator for the underlying vector.
     */
    @Override
    public Iterator<T> iterator() {
        return new VectorIterator<>(this);
    }
    
    /**
     * Returns an array of T with the items from this Vector
     * @return 
     */
    public <T> T[] toArray( T[] array ){
        
        System.arraycopy(data, 0, array, 0, size());
        
        return (T[])(array);
    }
    
    /**
     * Populates this Vector with the items from the specified array
     * @param array 
     */
    private void fromArray( T[] array ){
        
        for( T obj : array )
            this.append(obj);
        
    }

    public Vector<T> clonar() {
        
        Vector<T> copia = new Vector<>();
        
        for( T item : this )
            copia.append(item);
        
        return copia;
    }
    
    
}
