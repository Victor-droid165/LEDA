package br.ledaimpl.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class DynamicStackImpl<T> implements Stack<T>{

    private ArrayList<T> array;

    public DynamicStackImpl(){
        array = new ArrayList<T>();
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return array.remove(array.size() - 1);
    }

    @Override
    public void push(T obj) {
        if(isFull())
            throw new StackOverflowError();
        array.add(obj);
    }

    @Override
    public T top() {
        if(isEmpty())
            throw new EmptyStackException();
        return array.get(array.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return array.size() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
}