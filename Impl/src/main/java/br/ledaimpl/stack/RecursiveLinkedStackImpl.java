package br.ledaimpl.stack;

import java.util.EmptyStackException;

public class RecursiveLinkedStackImpl<T> implements Stack<T>{

    private T data;
    private RecursiveLinkedStackImpl<T> next;

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        T removed = this.data;
        if(next == null)
            this.data = null;
        else{
            this.data = next.data;
            this.next = this.next.next;
        }
        return removed;
    }

    @Override
    public void push(T obj) {
        if(isEmpty())
            this.data = obj;
        else{
            RecursiveLinkedStackImpl<T> lastTop = new RecursiveLinkedStackImpl<T>();
            lastTop.data = this.data;
            lastTop.next = this.next;

            this.data = obj;
            this.next = lastTop;
        }
    }

    @Override
    public T top() {
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