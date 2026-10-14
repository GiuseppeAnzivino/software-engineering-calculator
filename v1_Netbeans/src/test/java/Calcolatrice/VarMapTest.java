package Calcolatrice;

//Import Exception
import Calcolatrice.Exceptions.EmptyStackException;
import Calcolatrice.Exceptions.VarException;

//Import coda
import java.util.Deque;
import java.util.LinkedList;

//Import Junit
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anviz
 */
public class VarMapTest {
    
    //Attributi utili
    private Deque<Complex> stack;
    private VarMap var;
    private static final double DELTA = 1e-15;
  
    @BeforeEach
    public void setUp(){
        stack = new LinkedList<>();
        var = new VarMap(stack);
    }
    
    
    //Test per la stackToVar, caso ordinario
    @Test
    public void testStackToVar1() throws EmptyStackException {
        
        System.out.println("Test stackToVar : caso ordinario");
        
        Complex num = new Complex(-48.28, -62.000);
        double expResultRealPart = num.getRealPart();
        double expResultJPart = num.getJPart();
        
        this.stack.addFirst(num);
        var.stackToVar('a');
        
        Complex result = var.getValue('a');
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(0, stack.size());

        assertEquals(expResultRealPart,resultRealPart, DELTA);
        assertEquals(expResultJPart,resultJPart, DELTA);
    }
    
    //Test per la stackToVar, stack vuoto
    @Test
    public void testStackToVar2() {
        System.out.println("Test stackToVar : stack vuoto");
        
        assertThrows(EmptyStackException.class,() -> {
            var.stackToVar('a');
        });
    }
    
    //Test per la varToStack, caso ordinario
    @Test
    public void testVarToStack1() throws EmptyStackException {
        
        System.out.println("Test VarToStack : caso ordinario");
        
        Complex num = new Complex(48.28, 62.000);
        double expResultRealPart = num.getRealPart();
        double expResultJPart = num.getJPart();
        
        stack.addFirst(num);
        var.stackToVar('a');
        
        Complex result = var.getValue('a');
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(0, stack.size());

        assertEquals(expResultRealPart,resultRealPart, DELTA);
        assertEquals(expResultJPart,resultJPart, DELTA);
        
        var.varToStack('a');
        
        assertEquals(1, stack.size());
        
        Complex top=stack.removeFirst();
        double topRealPart=top.getRealPart();
        double topJPart=top.getJPart();
        
        assertEquals(expResultRealPart,topRealPart, DELTA);
        assertEquals(expResultJPart,topJPart, DELTA);
    }
    
    //Test per la stackToVar, variabile vuota
    @Test
    public void testVarToStack2() throws EmptyStackException {

        System.out.println("Test VarToStack : variabile vuota");
        
        var.varToStack('a');
        
        assertEquals(1, stack.size());
        
        Complex zero = new Complex(0, 0);
        double zeroRealPart=zero.getRealPart();
        double zeroJPart=zero.getJPart();
        
        assertEquals(0,zeroRealPart, DELTA);
        assertEquals(0,zeroJPart, DELTA);  
    }
    
    //Test per l' addVar, caso ordinario
    @Test
    public void testAddVar1() {
        System.out.println("operazione di addVar: caso ordinario");
        
        Complex num1 = new Complex(-3.34, 24.67);
        stack.addFirst(num1);
        
        var.stackToVar('a');
        
        Complex num2 = new Complex(44.0, -1.0);
        stack.addFirst(num2);
        
        var.addVar('a');
        assertEquals(0, stack.size());
        
        var.varToStack('a');
        
        Complex result=num1.add(num2);
        
        double expResultRealPart = result.getRealPart();
        double expResultJPart = result.getJPart();
        
        assertEquals(expResultRealPart ,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart ,stack.removeFirst().getJPart(), DELTA); 
    }
    
    //Test per l'addVar, stack vuoto
    @Test
    public void testAddVar2() {
        System.out.println("operazione di addVar: caso stack vuoto");
        
        Complex num1 = new Complex(-3.34, 24.67);
        stack.addFirst(num1);
        
        var.stackToVar('a');
        
        var.addVar('a');
        assertEquals(0, stack.size());
        
        var.varToStack('a');
        
        Complex result=num1.add(new Complex(0, 0));
        
        double expResultRealPart = result.getRealPart();
        double expResultJPart = result.getJPart();
        
        assertEquals(expResultRealPart ,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart ,stack.removeFirst().getJPart(), DELTA); 
    }
    
    //Test addVar, variabile vuota
    @Test
    public void testAddVar3(){
        System.out.println("operazione di addVar: caso variabile vuota");
        
        Complex num1 = new Complex(-3.34, 24.67);
        stack.addFirst(num1);
        assertThrows(VarException.class,() -> {
            var.addVar('a');
        });   
    }

    //Test per la subVar, caso ordinario
    @Test
    public void testSubVar1() {
        System.out.println("operazione di subVar: caso ordinario");
        
        Complex num1 = new Complex(-3.34, 24.67);
        stack.addFirst(num1);
        
        var.stackToVar('a');
        
        Complex num2 = new Complex(44.0, -1.0);
        stack.addFirst(num2);
        
        var.subVar('a');
        assertEquals(0, stack.size());
        
        var.varToStack('a');
        
        Complex result=num2.sub(num1);
        
        double expResultRealPart = result.getRealPart();
        double expResultJPart = result.getJPart();
        
        assertEquals(expResultRealPart ,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart ,stack.removeFirst().getJPart(), DELTA); 
    }
    
    //Test per la subVar, stack vuoto
    @Test
    public void testSubVar2() {
        System.out.println("operazione di subVar: caso stack vuoto");
        
        Complex num1 = new Complex(-3.34, 24.67);
        stack.addFirst(num1);
        
        var.stackToVar('a');
        
        var.subVar('a');
        assertEquals(0, stack.size());
        
        var.varToStack('a');
        
        Complex result=num1.sub(new Complex(0, 0));
        
        double expResultRealPart = result.getRealPart();
        double expResultJPart = result.getJPart();
        
        assertEquals(expResultRealPart ,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart ,stack.removeFirst().getJPart(), DELTA); 
    }
    
    //Test subVar, variabile vuota
    @Test
    public void testSubVar3(){
        System.out.println("operazione di subVar: caso variabile vuota");
        
        Complex num1 = new Complex(-3.34, 24.67);
        stack.addFirst(num1);
        assertThrows(VarException.class,() -> {
            var.subVar('a');
        });   
    }


    //Test toString mappa
    @Test
    public void testToString() {
        Complex num1 = new Complex(-3.34, 24.67);
        stack.addFirst(num1);
        
        var.stackToVar('a');
        
        Complex num2 = new Complex(44.0, -1.0);
        stack.addFirst(num2);
        
        var.stackToVar('c');
        
        String expResultString="\nVariabili Utilizzate: \n{a="+ num1+ ", c=" + num2 +"}";
        assertEquals(expResultString, var.toString());
    }
    
}
