package br.ledaimpl.queue;

import java.util.EmptyStackException;

import br.ledaimpl.linkedlist.DoublyLinkedListNode;

public class LinkedQueueFrontPointerOnlyImpl<T> implements Queue<T> {

    private DoublyLinkedListNode<T> head;

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new EmptyStackException();
        T lastHead = head.getData();
        head = head.getNext();
        return lastHead;
    }

    @Override
    public void enqueue(T obj) {
        if(isEmpty())
            this.head = new DoublyLinkedListNode<>(obj);
        else{
            DoublyLinkedListNode<T> node = head;
            while(node.getNext() != null) node = node.getNext();
            node.setNext(new DoublyLinkedListNode<T>(obj));
        }
    }

    @Override
    public T front() {
        if(isEmpty())
            throw new EmptyStackException();
        return this.head.getData();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    


}
