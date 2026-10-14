package Calcolatrice;

//Import Exception
import Calcolatrice.Exceptions.EmptyStackException;
import Calcolatrice.Exceptions.VarException;

//Import Map
import java.util.TreeMap;

//Import Coda
import java.util.Deque;

public class VarMap {
    
    //Attributi privati
    private TreeMap<Character, Complex> variable;
    private Deque<Complex> stack;

    //Costruttore
    public VarMap(Deque<Complex> stack) {
        this.variable = new TreeMap<Character, Complex>();
        this.stack = stack;
    }
    
    public Complex getValue(char key){
        
        return variable.get(key);
        
    }
    
    // Trasferisce gli elementi dello stack alle variabili
    public void stackToVar(char key) {
        
        if(stack.isEmpty())
            throw new EmptyStackException("Errore, Stack Vuoto");
        variable.put(key, stack.removeFirst());
        
        
    }

    // Trasferisce i valori delle variabili allo stack
    public void varToStack(char key) {
        int controllo=0;
        for(char k : variable.keySet()){
            if(key==k){
                controllo=1;
            }
        }
        if(controllo!=1){
            stack.addFirst(new Complex(0.0,0.0));
        }else{
            stack.addFirst(variable.get(key));
        }
        
        
    }

    // Somma il valore in cima allo stack ad una variabile
    public void addVar(char key) {
        int controllo=0;
        for(char k : variable.keySet()){
            if(key==k){
                controllo=1;
            }
        }
        if( controllo!=1){
            throw new VarException("Variabile Vuota");
        }else if (stack.isEmpty()){
            Complex c=new Complex(0.0,0.0);
            variable.put(key, c.add(variable.get(key)));
        }else{
            Complex c = stack.removeFirst();
            variable.put(key, c.add(variable.get(key)));
        }
    }

    // Sottrae il valore in cima allo stack da una variabile
    public void subVar(char key) {
        int controllo=0;
        for(char k : variable.keySet()){
            if(key==k){
                controllo=1;
            }
        }
        if(controllo!=1){
            throw new VarException("Variabile Vuota");
        }else if(stack.isEmpty()){
            Complex c=new Complex(0.0,0.0);
            variable.put(key, variable.get(key).sub(c));
        }else{
            Complex c = stack.removeFirst();
            variable.put(key, c.sub(variable.get(key)));
        } 
    }

    @Override
    public String toString() {
        return "\nVariabili Utilizzate: \n" + variable;
    }
    
    
}
