package br.ledaimpl;

import br.ledaimpl.queue.RecursiveLinkedQueueImpl;
import br.ledaimpl.stack.StackUsingTwoQueuesImpl;

public class App 
{
    public static void main( String[] args )
    {
        StackUsingTwoQueuesImpl<String> s = new StackUsingTwoQueuesImpl<>(3);

        System.out.println(s.isEmpty());
        System.out.println(!s.isFull());
        s.push("Matheus");
        System.out.println(s.top().equals("Matheus"));
        System.out.println(s.isFull() == false);
        s.push("Cícera");
        s.push("Carlos");
        System.out.println(s.top().equals("Carlos"));
        System.out.println(!s.isFull());
        System.out.println(!s.isEmpty());
        System.out.println(s.pop().equals("Carlos"));
        s.push("Tarcisio");
        System.out.println(s.top().equals("Tarcisio"));
        System.out.println(!s.isFull());
        s.pop();
        s.pop();
        System.out.println(!s.isEmpty() && s.top().equals("Matheus"));
        s.pop();
        System.out.println(s.isEmpty());
        s.push("Eduarda");
        s.push("Marilia");
        s.push("Chimarrao");
        System.out.println(s.top().equals("Chimarrao"));
        s.pop();
        s.push("Chibata");
        System.out.println(s.top().equals("Chibata"));
        System.out.println(!s.isFull());
    }
}
