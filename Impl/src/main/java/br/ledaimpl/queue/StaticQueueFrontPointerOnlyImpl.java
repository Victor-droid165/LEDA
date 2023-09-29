package br.ledaimpl.queue;

import java.util.EmptyStackException;

public class StaticQueueFrontPointerOnlyImpl<T> implements Queue<T>{

    private T array[];
    private int front;
    private static final int DEFAULT_SIZE = 50;

    public StaticQueueFrontPointerOnlyImpl(){
        this(DEFAULT_SIZE);
    }

    public StaticQueueFrontPointerOnlyImpl(int length){
        this.array = (T[]) new Object[length];
        front = -1;
    }

    private void shiftRight(){
        for(int i = front + 1; i > 0; i--)
            array[i] = array[i - 1];
        front++;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new EmptyStackException(); // Should be EmptyQueueException here
        return array[front--];
    }

    @Override
    public void enqueue(T obj) {
        if(isFull())
            throw new StackOverflowError(); // Should be QueueOverflowError
        shiftRight();
        array[0] = obj;
    }

    @Override
    public T front() {
        if(isEmpty())
            throw new EmptyStackException(); // Should be EmptyQueueException;
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return front == array.length - 1;
    }
    
}
