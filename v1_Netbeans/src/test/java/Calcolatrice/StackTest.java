package Calcolatrice;

//Import Excpetions
import Calcolatrice.Exceptions.EmptyStackException;

//Import coda
import java.util.Deque;
import java.util.LinkedList;

//Import jUnit
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Aldo
 */
public class StackTest {
    
    //Attributi utili
    Deque<Complex> stack;
    Stack buffer;
    private static final double DELTA = 1e-15;
    
    
    @BeforeEach
    public void setUp() {
        this.stack= new LinkedList<>();
        buffer= new Stack(stack);
    }


    //Test operazione di clear, caso ordinario
    @Test
    public void testClear1() {
        System.out.println("Test operazione di Clear: caso ordinario");
        
        
        Complex num1 = new Complex(-3.0, -2.0);
        stack.addFirst(num1);
        Complex num2 = new Complex(4.0, -1.0);
        stack.addFirst(num2);
        
        buffer.clear();
        
        assertEquals(0, stack.size());
    }
    
    //Test operazione di clear, stack vuoto
    @Test
    public void testClear2() {
        System.out.println("Test operazione di Clear : caso stack vuoto");
        
       assertThrows(EmptyStackException.class,() -> {
            buffer.clear();
        });
    }

    //Test operazione di drop, caso ordinario
    @Test
    public void testDrop1() {
        System.out.println("Test operazione di Drop: caso ordinario");
        
        Complex num1 = new Complex(-3.0, -2.0);
        stack.addFirst(num1);
        Complex num2 = new Complex(4.0, -1.0);
        stack.addFirst(num2);
        double expResultRealPart = num1.getRealPart();
        double expResultJPart = num1.getJPart();
        
        int beforeLength=stack.size();
        buffer.drop();
        
        assertEquals(beforeLength-1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test operazione di drop, stack vuoto
    @Test
    public void testDrop2() {
        System.out.println("Test operazione di Drop : caso stack vuoto");
        
       assertThrows(EmptyStackException.class,() -> {
            buffer.drop();
        });
    }

    ////Test operazione di dup, caso ordinario
    @Test
    public void testDup1() {
        System.out.println("Test Dup: caso ordinario");
       
        Complex num1 = new Complex(-15.8, 23.02);
        stack.addFirst(num1);
        
        double expResultRealPart = num1.getRealPart();
        double expResultJPart = num1.getJPart();
        
        int dim = stack.size();
        buffer.dup();
        
        assertEquals(dim + 1, stack.size());
        assertEquals(expResultRealPart ,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart ,stack.removeFirst().getJPart(), DELTA);
        assertEquals(expResultRealPart ,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart ,stack.removeFirst().getJPart(), DELTA); 
    }
    
    //Test operazione di dup, stack vuoto
    @Test
    public void testDup2() {
        System.out.println("Test Dup: caso stack vuoto");
        
        int dim = stack.size();
        buffer.dup();
        
        assertEquals(dim + 2, stack.size());
        assertEquals(0,stack.getFirst().getRealPart(), DELTA);
        assertEquals(0,stack.removeFirst().getJPart(), DELTA);
        assertEquals(0,stack.getFirst().getRealPart(), DELTA);
        assertEquals(0,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test operazione di swap, caso ordinario
    @Test
    public void testSwap1() {
        System.out.println("Test operazione di Swap: caso ordinario");
        
        Complex num1 = new Complex(-3.0, -2.0);
        stack.addFirst(num1);
        Complex num2 = new Complex(4.0, -1.0);
        stack.addFirst(num2);
        
        double expResultRealPart1 = num1.getRealPart();
        double expResultJPart1 = num1.getJPart();
        double expResultRealPart2 = num2.getRealPart();
        double expResultJPart2 = num2.getJPart();
        
        buffer.swap();
        
        double resultRealPart1 = stack.getFirst().getRealPart();
        double resultJPart1 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart1 ,resultRealPart1,DELTA); 
        assertEquals(expResultJPart1 ,resultJPart1,DELTA);
        assertEquals(1,stack.size());

        double resultRealPart2 = stack.getFirst().getRealPart();
        double resultJPart2 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart2,resultRealPart2,DELTA); 
        assertEquals(expResultJPart2,resultJPart2,DELTA);
        assertEquals(0,stack.size());
    }
    
    //Test operazione di swap, stack con un solo elemento
    @Test
    public void testSwap2() {
        System.out.println("Test operazione di Swap: caso stack con un solo elemento");
        
        Complex num1 = new Complex(5.78, 89.33);
        
        double expResultRealPart = num1.getRealPart();
        double expResultJPart = num1.getJPart();
        stack.addFirst(num1);
        
        buffer.swap();
        
        double resultRealPart1 = stack.getFirst().getRealPart();
        double resultJPart1 = stack.removeFirst().getJPart();
        assertEquals(0 ,resultRealPart1,DELTA); 
        assertEquals(0 ,resultJPart1,DELTA);
        assertEquals(1,stack.size());

        double resultRealPart2 = stack.getFirst().getRealPart();
        double resultJPart2 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart,resultRealPart2,DELTA); 
        assertEquals(expResultJPart,resultJPart2,DELTA);
        assertEquals(0,stack.size());
    }
    
    //Test operazione di swap, stack vuoto
    @Test
    public void testSwap3() {
        System.out.println("Test operazione di Swap: caso stack vuoto");
        
        double expResultRealPart = 0;
        double expResultJPart = 0;
        
        buffer.swap();
        double resultRealPart1 = stack.getFirst().getRealPart();
        double resultJPart1 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart,resultRealPart1,DELTA); 
        assertEquals(expResultJPart,resultJPart1,DELTA);
        assertEquals(1,stack.size());

        double resultRealPart2 = stack.getFirst().getRealPart();
        double resultJPart2 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart,resultRealPart2,DELTA); 
        assertEquals(expResultJPart,resultJPart2,DELTA);
        assertEquals(0,stack.size());
        
    }
    
    //Test operazione di over, caso ordinario
    @Test
    public void testOver1() {
        System.out.println("Test operazione di Over: caso stack con elementi");
        
        Complex num1 = new Complex(-3.0, -2.0);
        stack.addFirst(num1);
        Complex num2 = new Complex(4.0, -1.0);
        stack.addFirst(num2);
        
        double expResultRealPart1 = num1.getRealPart();
        double expResultJPart1 = num1.getJPart();
        double expResultRealPart2 = num2.getRealPart();
        double expResultJPart2 = num2.getJPart();
        
        buffer.over();
        
        double resultRealPart1 = stack.getFirst().getRealPart();
        double resultJPart1 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart1 ,resultRealPart1,DELTA); 
        assertEquals(expResultJPart1 ,resultJPart1,DELTA);
        assertEquals(2,stack.size());

        double resultRealPart2 = stack.getFirst().getRealPart();
        double resultJPart2 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart2,resultRealPart2,DELTA); 
        assertEquals(expResultJPart2,resultJPart2,DELTA);
        assertEquals(1,stack.size());
        
        
        double resultRealPart3 = stack.getFirst().getRealPart();
        double resultJPart3 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart1 ,resultRealPart3,DELTA); 
        assertEquals(expResultJPart1 ,resultJPart3,DELTA);
        assertEquals(0,stack.size());
    }
    
    //Test operazione di over, stack con un solo elemento
    @Test
    public void testOver2() {
        System.out.println("Test operazione di Over: caso stack con un solo elemento");
        
        Complex num1 = new Complex(5.78, 89.33);
        
        double expResultRealPart = num1.getRealPart();
        double expResultJPart = num1.getJPart();
        stack.addFirst(num1);
        
        buffer.over();
        
        double resultRealPart1 = stack.getFirst().getRealPart();
        double resultJPart1 = stack.removeFirst().getJPart();
        assertEquals(0 ,resultRealPart1,DELTA); 
        assertEquals(0 ,resultJPart1,DELTA);
        assertEquals(2,stack.size());

        double resultRealPart2 = stack.getFirst().getRealPart();
        double resultJPart2 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart,resultRealPart2,DELTA); 
        assertEquals(expResultJPart,resultJPart2,DELTA);
        assertEquals(1,stack.size());
        
        double resultRealPart3 = stack.getFirst().getRealPart();
        double resultJPart3 = stack.removeFirst().getJPart();
        assertEquals(0 ,resultRealPart1,DELTA); 
        assertEquals(0 ,resultJPart1,DELTA);
        assertEquals(0,stack.size());
    }
    
    //Test operazione di stack, stack vuoto
    @Test
    public void testOver3() {
        System.out.println("Test operazione di Over: caso stack vuoto");
        
        double expResultRealPart = 0;
        double expResultJPart = 0;
        
        buffer.over();
        double resultRealPart1 = stack.getFirst().getRealPart();
        double resultJPart1 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart,resultRealPart1,DELTA); 
        assertEquals(expResultJPart,resultJPart1,DELTA);
        assertEquals(1,stack.size());

        double resultRealPart2 = stack.getFirst().getRealPart();
        double resultJPart2 = stack.removeFirst().getJPart();
        assertEquals(expResultRealPart,resultRealPart2,DELTA); 
        assertEquals(expResultJPart,resultJPart2,DELTA);
        assertEquals(0,stack.size());        
    }
    
}
