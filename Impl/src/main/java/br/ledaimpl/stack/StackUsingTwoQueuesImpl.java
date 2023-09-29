package br.ledaimpl.stack;

import java.util.EmptyStackException;

import br.ledaimpl.queue.LinkedQueueFrontPointerOnlyImpl;
import br.ledaimpl.queue.Queue;

public class StackUsingTwoQueuesImpl<T> implements Stack<T>{

    private Queue<T> queue1, queue2;
    private static final int DEFAULT_SIZE = 50;

    public StackUsingTwoQueuesImpl(){
        this(DEFAULT_SIZE);
    }

    public StackUsingTwoQueuesImpl(int length){
        this.queue1 = new LinkedQueueFrontPointerOnlyImpl<>();
        this.queue2 = new LinkedQueueFrontPointerOnlyImpl<>();
    }

    private void moveToQueue(){
        if(!queue1.isEmpty())
            while(!queue1.isEmpty())
                queue2.enqueue(queue1.dequeue());
        else{
            while(!queue2.isEmpty())
                queue1.enqueue(queue2.dequeue());
        }
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        T topElement = queue1.dequeue();
        while(!queue1.isEmpty()){
            queue2.enqueue(topElement);
            topElement = queue1.dequeue();
        }
        moveToQueue();
        return topElement;
    }

    @Override
    public void push(T obj) {
        if(isFull())
            throw new StackOverflowError();
        queue1.enqueue(obj);
    }

    @Override
    public T top() {
        if(isEmpty())
            throw new EmptyStackException();
        T topElement = queue1.dequeue();
        while(!queue1.isEmpty()){
            queue2.enqueue(topElement);
            topElement = queue1.dequeue();
        }
        queue2.enqueue(topElement);
        moveToQueue();
        return topElement;
    }

    @Override
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue1.isFull();
    }
    
}
