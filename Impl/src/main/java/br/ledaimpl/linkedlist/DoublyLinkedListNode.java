package br.ledaimpl.linkedlist;

public class DoublyLinkedListNode<T> {
    private T data;
    private DoublyLinkedListNode<T> next;
    private DoublyLinkedListNode<T> prev;
    
    public DoublyLinkedListNode(){}
    
    public DoublyLinkedListNode(T data){
        this.data = data;
    }
    
    public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> next){
        this.data = data;
        this.next = next;
    }
    
    public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> next, DoublyLinkedListNode<T> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }
}
