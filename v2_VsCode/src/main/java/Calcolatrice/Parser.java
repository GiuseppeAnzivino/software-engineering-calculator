package Calcolatrice;

//Import Exception
import Calcolatrice.Exceptions.InputException;
import Calcolatrice.Exceptions.OverflowException;

//Import coda
import java.util.Deque;

public class Parser {
    
    //Attributi utili
    private Stack buffer;
    private VarMap variable;
    private Operation operation;

    //Costruttore
    public Parser(Deque<Complex> stack) {
        this.buffer = new Stack(stack);
        this.variable = new VarMap(stack);
        this.operation = new Operation(stack);
    }

    // Aggiunta della parte immaginaria nel caso in cui non ci sia
    public String isComplex(String s) {
        if (s.matches("^[-, +]{0,1}\\d{0,9}\\.{0,1}\\d{1,9}[-, +]{1}\\d{0,9}\\.{0,1}\\d{1,9}$")){
            return s;
        } else{
            return s + "+0"; 
        }
    }
    
    // Estrazione della parte Reale
    public String isRealPart(String s) {
        int index;
        if(s.contains("-") && s.lastIndexOf('-')!=0){
            index = s.lastIndexOf('-');
        }else{
            index = s.lastIndexOf('+');
        }
        return s.substring(0, index);
    }

    // Estrazione della parte immaginaria
    public String isJPart(String s) {
        // Estrae la parte immaginaria dopo il carattere '+'
        int index;
        if(s.contains("-") && s.lastIndexOf('-')!=0){
            index = s.lastIndexOf('-');
        }else{
            index = s.lastIndexOf('+');
        }
        return s.substring(index);
    }

    // Analizza ed esegue le diverse operazioni fornite dalla stringa svolgi
    public void parse(String input, String svolgi) {
       //Controllo se bisogna inserire un numero complesso
       if(svolgi=="numero"){
            checkerNumber(input);
            input=isComplex(input);
            double realPart=Double.parseDouble(isRealPart(input));
            double jPart=Double.parseDouble(isJPart(input));
            Complex c= new Complex(realPart, jPart);
            operation.insert(c);
       }
       
       //Controllo se bisogna fare un addizione
       if(svolgi=="+"){
           operation.add();
       }
       
       //Controllo se bisogna fare una sottrazione
       if(svolgi=="-"){
           operation.sub();
       }
       
       //Controllo se bisogna fare una moltiplicazione
       if(svolgi=="*"){
           operation.times();
       }
       
       //Controllo se bisogna fare una divisione
       if(svolgi=="/"){
           operation.division();
       }
       
       //Controllo se bisogna fare una radice
       if(svolgi=="sqrt"){
           operation.sqrt();
       }
       
       //Controllo se bisogna fare una inversione di segno
       if(svolgi=="+-"){
           operation.reverse();
       }
       
       //Controllo se bisogna fare una drop
       if(svolgi=="drop"){
           buffer.drop();
       }
       
       //Controllo se bisogna fare una dup
       if(svolgi=="dup"){
           buffer.dup();
       }
       
       //Controllo se bisogna fare una swap
       if(svolgi=="swap"){
           buffer.swap();
       }
       
       //Controllo se bisogna fare una clear
       if(svolgi=="clear"){
           buffer.clear();
       }
       
       //Controllo se bisogna fare una over
       if(svolgi=="over"){
           buffer.over();
       }
       
       //Controllo se bisogna eseguire stackToVar
       if(svolgi=="stackToVar"){
           checkerVar(input);
           variable.stackToVar(input.charAt(input.indexOf(input)));
       }
       
       //Controllo se bisogna eseguire varToStack
       if(svolgi=="varToStack"){
           checkerVar(input);
           variable.varToStack(input.charAt(input.indexOf(input)));
       }
       
       //Controllo se bisogna eseguire addVar
       if(svolgi=="addVar"){
           checkerVar(input);
           variable.addVar(input.charAt(input.indexOf(input)));
       }
       
       //Controllo se bisogna eseguire subVar
       if(svolgi=="subVar"){
           checkerVar(input);
           variable.subVar(input.charAt(input.indexOf(input)));
       }
    }

   
    // Verifica la correttezza della stringa di input per l'Interfaccia Standard
    public void checkerNumber(String s) {
        
        // Verifica che la stringa non sia vuota
        if (s.isEmpty()) {
            throw new InputException("Input cannot be empty.");
        }
        
        if(s.contains(",")){
            throw new InputException("Invalid characters in input: " + s);
        }
        
        if(s.length()>15){
            throw new OverflowException("Character too big");
        }
        
        // Verifica che la stringa contenga solo caratteri validi
        if (!s.matches("^[-, +]{0,1}\\d{0,9}\\.{0,1}\\d{1,9}[-, +]{1}\\d{0,9}\\.{0,1}\\d{1,9}$")
                && !s.matches("^[-, +]{0,1}\\d{0,9}\\.{0,1}\\d{1,9}$")){
            throw new InputException("Invalid characters in input: " + s);
        }
        
        
    }
    
    //Verifica la correttezza della stringa di input per l'Interfaccia Variabili
    public void checkerVar(String s) {
        
        // Verifica che la stringa non sia vuota
        if (s.isEmpty()) {
            throw new InputException("Input vuoto.");
        }
        
        if(!s.matches("^[a-z]{1}$")){
             throw new InputException("Input Errato" + s);
        }
    }
    
    //Stampa della Mappa di variabili
    public String varMapToString(){
        return variable.toString();
    }
    
    
}


