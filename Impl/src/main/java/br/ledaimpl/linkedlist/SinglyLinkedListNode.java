package br.ledaimpl.queue;

public class SingleLinkedListNode<T> {
    private T data;
    private SingleLinkedListNode<T> next;
    
    public SingleLinkedListNode(){}
    
    public SingleLinkedListNode(T data){
        this.data = data;
    }
    
    public SingleLinkedListNode(T data, SingleLinkedListNode<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public SingleLinkedListNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(SingleLinkedListNode<T> next) {
        this.next = next;
    }
}
