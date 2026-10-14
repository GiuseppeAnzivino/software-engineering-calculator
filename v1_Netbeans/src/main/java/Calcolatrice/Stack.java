package Calcolatrice;

//Import eccezioni
import Calcolatrice.Exceptions.EmptyStackException;

//Import Coda
import java.util.Deque;


public class Stack {
    
    //Coda
    private Deque<Complex> stack;
   
    //Costruttore 
    public Stack(Deque<Complex> stack) {
        this.stack = stack;
    }

    //Esegue operazione di clear 
    public void clear() {
        if(stack.isEmpty()){
              throw new EmptyStackException("Errore, Stack Vuoto");
        }
        stack.clear();
    }

    //Esegue operazione di drop
    public void drop() {
        if(stack.isEmpty()){
              throw new EmptyStackException("Errore, Stack Vuoto");
        }
        stack.pollFirst();
    }

    //Esegue operazione di dup
    public void dup() {
        if(stack.isEmpty()){
            stack.addFirst(new Complex(0.0,0.0));
            stack.addFirst(new Complex(0.0,0.0));
        } else {
        Complex num1 = stack.pollFirst();

        stack.addFirst(num1);
        stack.addFirst(num1);
        }
    }
    
    //Esegue operazione di swap
    public void swap() {
        if(stack.isEmpty()){
            stack.addFirst(new Complex(0.0,0.0));
            stack.addFirst(new Complex(0.0,0.0));
        } else if(stack.size()==1){
            stack.addFirst(new Complex(0.0,0.0));
        } else {
            Complex num1 = stack.removeFirst();
            Complex num2 = stack.removeFirst();
            stack.addFirst(num1);
            stack.addFirst(num2);
        }
    }

    //Esegue operazione di over
    public void over() {
         if(stack.isEmpty()){
            stack.addFirst(new Complex(0.0,0.0));
            stack.addFirst(new Complex(0.0,0.0));
         } else if(stack.size()==1) { 
            Complex num1 = stack.removeFirst();
            stack.addFirst(new Complex(0.0,0.0));  
            stack.addFirst(num1);
            stack.addFirst(new Complex(0.0,0.0));
            } else {
            Complex op1 = stack.removeFirst();
            Complex op2 = stack.removeFirst();
            stack.addFirst(op2);
            stack.addFirst(op1);
            stack.addFirst(op2);
        }
    }

}