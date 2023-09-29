package br.ledaimpl.linkedlist;

public class SinglyLinkedListNode<T> {
    private T data;
    private SinglyLinkedListNode<T> next;
    
    public SinglyLinkedListNode(){}
    
    public SinglyLinkedListNode(T data){
        this.data = data;
    }
    
    public SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public SinglyLinkedListNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }
}
