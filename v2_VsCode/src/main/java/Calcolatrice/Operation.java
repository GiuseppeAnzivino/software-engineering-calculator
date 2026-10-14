package Calcolatrice;

//Import Exceptions
import Calcolatrice.Exceptions.EmptyStackException;

//Import Coda
import java.util.Deque;

public class Operation {
    
    //Coda
    private Deque<Complex> stack;
    
    //Costruttore
    public Operation(Deque<Complex> stack) {
        this.stack = stack;
    }

    //Inserimento di un Complex nella coda
    public void insert(Complex num) {
        stack.addFirst(num);
    }

    // Esegue l'operazione di addizione
    public void add() {
        
        if (stack.isEmpty()) {
            throw new EmptyStackException("Operandi insufficienti per l'addizione");
        }
        else if (stack.size() < 2){
            Complex num = stack.removeFirst();
            stack.addFirst(num.add(num));
        }
        else {
            Complex num2 = stack.removeFirst();
            Complex num1 = stack.removeFirst();
            stack.addFirst(num1.add(num2));
        }
    }

    // Esegue l'operazione di sottrazione
    public void sub() {
        if (stack.isEmpty()) {
            throw new EmptyStackException("Operandi insufficienti per la sottrazione");
        }
        else if (stack.size() < 2){
            Complex num = stack.removeFirst();
            stack.addFirst(num.sub(num));
        }
        else {
            Complex num2 = stack.removeFirst();
            Complex num1 = stack.removeFirst();
            stack.addFirst(num2.sub(num1));
        }    
    }

    // Esegue l'operazione di moltiplicazione
    public void times() {
        if (stack.isEmpty()) {
            throw new EmptyStackException("Insufficient operands for multiplication.");
        }
        else if (stack.size() < 2){
            Complex num = stack.removeFirst();
            stack.addFirst(num.times(num));
        }
        else {
            Complex num2 = stack.removeFirst();
            Complex num1 = stack.removeFirst();
            stack.addFirst(num1.times(num2));
        }
    }

    // Esegue l'operazione di divisione
    public void division() {
         if (stack.isEmpty()) {
            throw new EmptyStackException("Operandi insufficienti per la divisione");
        }
        else if (stack.size() < 2){
            Complex num = stack.removeFirst();
            stack.addFirst(new Complex(1.0,0.0));
        }
        else{
            Complex num1 = stack.removeFirst();
            Complex num2 = stack.removeFirst();
            stack.addFirst(num1.division(num2));
        }
    }

    // Esegue l'operazione di radice quadrata
    public void sqrt() {
        if (stack.isEmpty()) {
            throw new EmptyStackException("Operandi insufficienti per la radice");
        }
        else{

        Complex num = stack.pop();

        stack.push(num.sqrt());
        }
    }

    // Esegue l'operazione di cambio segno
    public void reverse() {
        if (stack.isEmpty()) {
            throw new EmptyStackException("Operandi insufficienti per l'inversione di segno");
        }
        else{
        Complex num = stack.pop();
        stack.push(num.reverse());
        }
    }
}