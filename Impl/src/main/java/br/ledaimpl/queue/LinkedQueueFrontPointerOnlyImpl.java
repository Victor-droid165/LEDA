package br.ledaimpl.queue;

import java.util.EmptyStackException;

import br.ledaimpl.linkedlist.SinglyLinkedListNode;

public class LinkedQueueFrontPointerOnlyImpl<T> implements Queue<T> {

    private SinglyLinkedListNode<T> head;

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
            this.head = new SinglyLinkedListNode<>(obj);
        else{
            SinglyLinkedListNode<T> node = head;
            while(node.getNext() != null) node = node.getNext();
            node.setNext(new SinglyLinkedListNode<T>(obj));
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
