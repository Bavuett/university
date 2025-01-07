import java.util.*;


/***
 * Ricorda: public class Stack<E> extends Vector<E> 
 * Il seguente programma ha l'obiettivo di mostrare come sia possibile
 * violare le restrizioni di accesso ad un stack usando i metodi
 * dell'interfaccia List per accedere ad elementi diversi dall'ultimo.
***/

public class StackExample
{
    public static void main (String[] args) {                             
          new StackExample().run();
    } // method main

    
    public void run()
    {
        Stack<Character> myStack = new Stack<Character>();
       
        System.out.println ("push " + myStack.push ('a'));
        System.out.println ("push " + myStack.push ('b'));
        System.out.println ("push " + myStack.push ('c'));
        System.out.println ("pop " + myStack.pop());
        System.out.println ("top = " + myStack.peek());
        System.out.println ("push " + myStack.push ('d'));
        System.out.println ("The stack now has " + myStack.size() + " elements.");
        
        System.out.println ("\nHere are the contents of the stack, from top to bottom:");  
        for (int i = myStack.size() - 1; i >= 0; i--)
            System.out.println (myStack.get (i));
        
        System.out.println ("\nHere are the contents of the stack, starting from index 0:");
        for (Character c : myStack)
            System.out.println (c);  
        
        System.out.println (
        "\nHere are the contents of the stack, from top to bottom, during destruction:");
        while (!myStack.isEmpty())
              System.out.println (myStack.pop()); 
        System.out.println ("The stack now has " + myStack.size() + " elements.");
    } // method run

}  // class StackExample
