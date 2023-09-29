package br.ledaimpl.stack;

import java.util.EmptyStackException;

public class StaticStackImpl<T> implements Stack<T>{

    private T array[];
    private int top;
    private static final int DEFAULT_SIZE = 50;

    public StaticStackImpl(){
        this(DEFAULT_SIZE);
    }

    public StaticStackImpl(int length){
        this.array = (T[]) new Object[length];
        this.top = -1;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return array[top--];
    }

    @Override
    public void push(T obj) {
        if(isFull())
            throw new StackOverflowError();
        array[++top] = obj;
    }

    @Override
    public T top() {
        if(isEmpty())
            throw new EmptyStackException();
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == array.length - 1;
    }
    
}
