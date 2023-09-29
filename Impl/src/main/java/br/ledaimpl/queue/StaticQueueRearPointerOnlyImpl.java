package br.ledaimpl.queue;

import java.util.EmptyStackException;

public class StaticQueueRearPointerOnlyImpl<T> implements Queue<T>{

    private T array[];
    private int rear;
    private static final int DEFAULT_SIZE = 50;

    public StaticQueueRearPointerOnlyImpl(){
        this(DEFAULT_SIZE);
    }

    public StaticQueueRearPointerOnlyImpl(int length){
        this.array = (T[]) new Object[length];
        rear = -1;
    }

    private void shiftLeft(){
        for(int i = 1; i <= rear; i++)
            array[i - 1] = array[i];
        rear--;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new EmptyStackException(); // Should be EmptyQueueException here
        T frontElement = array[0];
        shiftLeft();
        return frontElement;
    }

    @Override
    public void enqueue(T obj) {
        if(isFull())
            throw new StackOverflowError(); // Should be QueueOverflowError
        array[++rear] = obj;
    }

    @Override
    public T front() {
        if(isEmpty())
            throw new EmptyStackException(); // Should be EmptyQueueException;
        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return rear == -1;
    }

    @Override
    public boolean isFull() {
        return rear == array.length - 1;
    }
    
}
