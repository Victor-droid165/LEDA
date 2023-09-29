package br.ledaimpl.queue;

import java.util.EmptyStackException;

public class StaticQueueTwoPointersImpl<T> implements Queue<T>{

    private T array[];
    private int front;
    private int rear;
    private static final int DEFAULT_SIZE = 50;

    public StaticQueueTwoPointersImpl(){
        this(DEFAULT_SIZE);
    }

    public StaticQueueTwoPointersImpl(int length){
        this.array = (T[]) new Object[length];
        front = rear = 0;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new EmptyStackException(); // Should be EmptyQueueException here
        T frontElement = array[front];
        array[front++] = null;
        front %= array.length;
        return frontElement;
    }

    @Override
    public void enqueue(T obj) {
        if(isFull())
            throw new StackOverflowError(); // Should be QueueOverflowError
        array[rear++] = obj;
        rear %= array.length;
    }

    @Override
    public T front() {
        if(isEmpty())
            throw new EmptyStackException(); // Should be EmptyQueueException;
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return front == rear && array[front] == null;
    }

    @Override
    public boolean isFull() {
        return front == rear && array[front] != null;
    }
    
}
