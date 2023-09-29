package br.ledaimpl.stack;

public interface Stack<T> {
    T pop();
    void push(T obj);
    T top();
    boolean isEmpty();
    boolean isFull();
}
