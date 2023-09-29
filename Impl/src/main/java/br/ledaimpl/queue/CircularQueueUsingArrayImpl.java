package br.ledaimpl.queue;

import java.util.EmptyStackException;

public class CircularQueueUsingArrayImpl<T> implements Queue<T>{

    private T array[];
    private int front;
    private int rear;
    private static final int DEFAULT_SIZE = 50;

    public CircularQueueUsingArrayImpl(){
        this(DEFAULT_SIZE);
    }

    public CircularQueueUsingArrayImpl(int length){
        this.array = (T[]) new Object[length];
        front = rear = -1;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new EmptyStackException(); // Should be EmptyQueueException here
        T frontElement = array[front];
        array[front] = null;
        if(front == rear)
            front = rear = -1;
        else{
            front++;
            front %= array.length; //[1, 2, 3]
        }
        return frontElement;
    }

    @Override
    public void enqueue(T obj) {
        if(isFull() || isEmpty()){
            front++;
            front %= array.length;
        }
        ++rear;
        rear %= array.length;
        array[rear] = obj;
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
        if(rear > front)
            return rear - front + 1 == array.length;
        else
            return array.length - front + rear + 1 == array.length;
    }
    
}
