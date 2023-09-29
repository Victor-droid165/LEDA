package br.ledaimpl.queue;

import java.util.EmptyStackException;

public class RecursiveLinkedQueueImpl<T> implements Queue<T> {

    private T data;
    private RecursiveLinkedQueueImpl<T> next;

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new EmptyStackException();
        T removed = this.data;
        if(this.next != null){
            this.data = this.next.data;
            this.next = this.next.next;
        } else
            this.data = null;
        return removed;
    }

    @Override
    public void enqueue(T obj) {
        if (isEmpty())
            this.data = obj;
        else{
            if(this.next == null){
                this.next = new RecursiveLinkedQueueImpl<>();
                this.next.data = obj;
            } else{
                this.next.enqueue(obj);
            }
        }
    }

    @Override
    public T front() {
        if(isEmpty())
            throw new EmptyStackException();
        return this.data;
    }

    @Override
    public boolean isEmpty() {
        return this.data == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
}
