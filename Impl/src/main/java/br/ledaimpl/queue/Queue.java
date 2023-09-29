package br.ledaimpl.queue;

public interface Queue<T>{
    T dequeue();
    void enqueue(T obj);
    T front();
    boolean isEmpty();
    boolean isFull();
}
