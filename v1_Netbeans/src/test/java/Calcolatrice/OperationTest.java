package Calcolatrice;

//Import Exception
import Calcolatrice.Exceptions.EmptyStackException;

//Import coda
import java.util.Deque;
import java.util.LinkedList;

//Import jUnit
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author raffaele
 */
public class OperationTest {
    
    //attributi utili
    private Operation operation;
    private Deque<Complex> stack;
    private static final double DELTA = 1e-15;

    
    @BeforeEach
    public void setUp() {
        stack = new LinkedList<>();
        operation = new Operation(stack);
    }
   

    //Test Insert, inserimento di un complex nello stack
    @Test
    public void testInsert() {
        
        System.out.println("Test Insert");
        
        Complex num1 = new Complex(2.0, -37.2); 
        operation.insert(num1);
        
        double expResultRealPart1 = num1.getRealPart();
        double expResultJPart1 = num1.getJPart();
        
        double resultRealPart1 = stack.getFirst().getRealPart();
        double resultJPart1 = stack.getFirst().getJPart();
        assertEquals(expResultRealPart1,resultRealPart1, DELTA);
        assertEquals(expResultJPart1,resultJPart1, DELTA);
        
        Complex num2 = new Complex(-9.8,5);
        operation.insert(num2);
        
        double expResultRealPart2 = num2.getRealPart();
        double expResultJPart2 = num2.getJPart();
        
        double resultRealPart2 = stack.getFirst().getRealPart();
        double resultJPart2 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart2,resultRealPart2, DELTA);
        assertEquals(expResultJPart2,resultJPart2, DELTA);
        assertEquals(expResultRealPart1,resultRealPart1, DELTA);
        assertEquals(expResultJPart1,resultJPart1, DELTA); 
    }
    
    //Test operazione di addizione con lo stack, caso ordinario
    @Test
    public void testAdd1() throws EmptyStackException {
        
        System.out.println("Test somma con lo stack : caso ordinario");
        
        Complex num1 = new Complex(-5.9,46);
        operation.insert(num1);
        Complex num2 = new Complex(36.0,23.2);
        operation.insert(num2);
        operation.add();
        
        Complex expResult = num1.add(num2);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size());
    }
    
    //Test operazione di addizione con lo stack, stack con un solo elemento
    @Test
    public void testAdd2() throws EmptyStackException {
        
        System.out.println("Test somma con lo stack : caso con un solo elemento");
        
        Complex num1 = new Complex(-23.12,18.45);
        operation.insert(num1);
        operation.add();
        
        Complex expResult = num1.add(num1);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size());     
    }
    
    //Test operazione di addizione con lo stack, stack vuoto
    @Test
    public void testAdd3() {
        System.out.println("Test somma con lo stack : " + "stack vuoto");
        
        assertThrows(EmptyStackException.class,() -> {
            operation.add();
        });
    }

    //Test operazione di sottrazione con lo stack, caso ordinario
    @Test
    public void testSub1() throws EmptyStackException{
        System.out.println("Test sottrazione con lo stack : caso ordinario");

        Complex num1 = new Complex(8.0, -37.81);
        operation.insert(num1);
        Complex num2 = new Complex(101, -6.6);
        operation.insert(num2);
        operation.sub();
        
        Complex expResult = num2.sub(num1);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size());
        
    }
    
    //Test operazione di sottrazione con lo stack, caso con un solo elemento
    @Test
    public void testSub2() throws EmptyStackException{
        System.out.println("Test sottrazione con lo stack : caso con un solo elemento");

        Complex num1 = new Complex(-1.2567, 25.9);
        operation.insert(num1);
        operation.sub();
        
        Complex expResult = num1.sub(num1);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size());
    }
    
    //Test operazione di sottrazione con lo stack, stack vuoto
    @Test
    public void testSub3() {
        System.out.println("Test sottrazione con lo stack : caso stack vuoto");
        
        assertThrows(EmptyStackException.class,() -> {
            operation.sub();
        });
    }
    
    //Test operazione di moltiplicazione con lo stack, caso ordinario
    @Test
    public void testTimes1() throws EmptyStackException{
        System.out.println("Test moltiplicazione con lo stack : caso ordinario");
        Complex num1 = new Complex(4.0, 4.0);
        Complex num2 = new Complex(2.0, 2.0);
        
        Complex expResult = num1.times(num2);
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        operation.insert(num1);
        operation.insert(num2);
        operation.times();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size());        
    }
    
    //Test operazione di moltiplicazione con lo stack, caso con un solo elemento
    @Test
    public void testTimes2() throws EmptyStackException{
        System.out.println("Test moltiplicazione con lo stack : caso con un solo elemento");
        Complex num1 = new Complex(4.0, 4.0);
        
        Complex expResult = num1.times(num1);
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        operation.insert(num1);
        operation.times();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size());        
    }
    
    //Test operazione di moltiplicazione con lo stack, stack vuoto
    @Test
    public void testTimes3() {
        System.out.println("Test moltiplicazione con lo stack : caso stack vuoto");
        Complex num1 = new Complex(4.0, 4.0);
         
        assertThrows(EmptyStackException.class,() -> {
            operation.times();
        });
    }
    
    
    //Test operazione di divisione con lo stack, caso ordinario
    @Test
    public void testDivision1() throws EmptyStackException {
        System.out.println("Test divisione con lo stack : caso ordinario");
 
        Complex num1 = new Complex(-3.0, -2.0);
        operation.insert(num1);
        Complex num2 = new Complex(4.0, -1.0);
        operation.insert(num2);
        operation.division();
        
        Complex expResult = num2.division(num1);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size()); 
    }
    
    //Test operazione di divisione con lo stack, caso con un solo elemento
    @Test
    public void testDivision2() throws EmptyStackException {
        System.out.println("Test divisione con lo stack : caso con un solo elemento");
 
        Complex num1 = new Complex(5.0, 2.0);
        operation.insert(num1);
        operation.division();
        
        Complex expResult = num1.division(num1);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size()); 
        
    }
    
    //Test operazione di divisione con lo stack, stack vuoto
    @Test
    public void testDivision3() {
        System.out.println("Test divisione con lo stack : "+ "stack vuoto");
        
        assertThrows(EmptyStackException.class,() -> {
            operation.division();
        });
    }
    
    //Test operazione di radice con lo stack, caso ordinario
    @Test
    public void testSqrt1() throws EmptyStackException{
        System.out.println("Test radice con lo stack : caso ordinario");
        Complex num1 = new Complex(3.0, 4.0);
        Complex expResult = num1.sqrt();
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        operation.insert(num1);
        operation.sqrt();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size()); 
    }
    
    //Test operazione di radice con lo stack, stack vuoto
    @Test
    public void testSqrt2() {
        System.out.println("Test radice con lo stack : caso stack vuoto");
        Complex num1 = new Complex(4.0, 4.0);
         
        assertThrows(EmptyStackException.class,() -> {
            operation.sqrt();
        });
    }
    
    //Test operazione di inversione del segno con lo stack, caso ordinario
    @Test
    public void testReverse1() throws EmptyStackException{
        System.out.println("Test inversione di segno con lo stack : caso ordinario");
        Complex num1 = new Complex(3.0, 4.0);
        Complex expResult = num1.reverse();
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        operation.insert(num1);
        operation.reverse();
        
        Complex result = stack.getFirst();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart,resultRealPart,DELTA); 
        assertEquals(expResultJPart,resultJPart,DELTA);
        assertEquals(1,stack.size()); 
    }
    
    //Test operazione di inversione del segno con lo stack, stack vuoto
    @Test
    public void testReverse2() {
        System.out.println("Test inversione di segno con lo stack : caso stack vuoto");
        Complex num1 = new Complex(4.0, 4.0);
         
        assertThrows(EmptyStackException.class,() -> {
            operation.reverse();
        });
    }
    
    
}
