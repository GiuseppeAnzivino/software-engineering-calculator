package Calcolatrice;

//Import Exception
import Calcolatrice.Exceptions.InputException;
import Calcolatrice.Exceptions.OverflowException;
import Calcolatrice.Exceptions.VarException;

//Import coda
import java.util.Deque;
import java.util.LinkedList;

//Import JUnit
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anziv
 */
public class ParserTest {
    
    //Attributi
    private Deque<Complex> stack;
    private Stack buffer;
    private VarMap var;
    private Operation operation;
    private Parser parser;
    private static final double DELTA = 1e-15;
    
    
    @BeforeEach
    public void setUp() {
        stack=new LinkedList<>();
        buffer = new Stack(stack);
        var = new VarMap(stack);
        operation = new Operation(stack);
        parser=new Parser(stack);
    }

    //Test del metodo isComplex con numero composta da parte reale e immaginaria
    @Test
    public void testIsComplex1() {
        String s="3.4-4.5";
        String expResultString=s;
        assertEquals(expResultString, parser.isComplex(s));
    }
    
    //Test del metodo isComplex con numero composto solo da parte reale
    @Test
    public void testIsComplex2() {
        String s="3.4";
        String expResultString=s + "+0";
        assertEquals(expResultString, parser.isComplex(s));
    }

    //Test del metodo isRealPart, caso con parte immaginaria positiva
    @Test
    public void testIsRealPart1() {
        System.out.println("Test isRealPart : caso con il +");
        String s = "-24.87+15.01";
        
        String expResult = "-24.87";
        String result = parser.isRealPart(s);
        assertEquals(expResult, result);   
    }
    
    //Test del metodo isRealPart, caso con parte immaginaria negativa
    @Test
    public void testIsRealPart2() {
        System.out.println("Test isRealPart : caso con il -");
        String s = "4.8-15.81";
        
        String expResult = "4.8";
        String result = parser.isRealPart(s);
        assertEquals(expResult, result);
        
    }

    //Test del metodo isJPart, caso con parte immaginaria positiva
    @Test
    public void testIsJPart1() {
        System.out.println("Test isJPart, numero immaginario positivo");
        String s = "-4+3";
        String expResult = "+3";
        
        String result = parser.isJPart(s);
        assertEquals(expResult, result);
    }
    
    //Test del metodo isRealPart, caso con parte immaginaria negativa
    @Test
    public void testIsJPart2() {
        System.out.println("Test isJPart, numero immaginario negativo");
        String s = "+14-23";
        String expResult = "-23";
        
        String result = parser.isJPart(s);
        assertEquals(expResult, result);
      
    }

    //Test del parse per operazione di insert
    @Test
    public void testParse1() {
        String s="34";
        String svolgi="numero";
        
        parser.parse(s, svolgi);
        
        Complex num= new Complex(34, 0);
        
        String expStringResult= num.toString();
        
        assertEquals(1, stack.size());
        assertEquals(stack.removeFirst().toString(), expStringResult);
    }

    //Test del parse per operazione di addizione
    @Test
    public void testParse2() {
        
        String svolgi="+";
        
        Complex num= new Complex(34.56, -67.9);
        stack.addFirst(num);
        
        parser.parse(null, svolgi);
        
        Complex expResult= num.add(num);
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        assertEquals(1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di sottrazione
    @Test
    public void testParse3() {
        
        String svolgi="-";
        
        Complex num= new Complex(34.56, -67.9);
        stack.addFirst(num);
        
        parser.parse(null, svolgi);
        
        Complex expResult= num.sub(num);
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        assertEquals(1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    
    //Test del parse per operazione di moltiplicazione
    @Test
    public void testParse4() {
        
        String svolgi="*";
        
        Complex num= new Complex(34.56, -67.9);
        stack.addFirst(num);
        
        parser.parse(null, svolgi);
        
        Complex expResult= num.times(num);
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        assertEquals(1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di divisione
    @Test
    public void testParse5() {
        
        String svolgi="/";
        
        Complex num= new Complex(34.56, -67.9);
        stack.addFirst(num);
        
        parser.parse(null, svolgi);
        
        Complex expResult= num.division(num);
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        assertEquals(1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di radice
    @Test
    public void testParse6() {
        
        String svolgi="sqrt";
        
        Complex num= new Complex(34.56, -67.9);
        stack.addFirst(num);
        
        parser.parse(null, svolgi);
        
        Complex expResult= num.sqrt();
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        assertEquals(1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di inversione di segno
    @Test
    public void testParse7() {
        
        String svolgi="+-";
        
        Complex num= new Complex(34.56, -67.9);
        stack.addFirst(num);
        
        parser.parse(null, svolgi);
        
        Complex expResult= num.reverse();
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        assertEquals(1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di drop
    @Test
    public void testParse8() {
        
        String svolgi="drop";
        
        Complex num1= new Complex(34.56, -67.9);
        stack.addFirst(num1);
        
        Complex num2= new Complex(46.9, 90.1);
        stack.addFirst(num2);
        
        int beforeLength=stack.size();
        
        parser.parse(null, svolgi);
        
        
        double expResultRealPart = num1.getRealPart();
        double expResultJPart = num1.getJPart();
        
        assertEquals(beforeLength-1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di dup
    @Test
    public void testParse9() {
        
        String svolgi="dup";
        
        Complex num1= new Complex(34.56, -67.9);
        stack.addFirst(num1);
        
        int beforeLength=stack.size();
        
        parser.parse(null, svolgi);
        
        double expResultRealPart = num1.getRealPart();
        double expResultJPart = num1.getJPart();
        
        assertEquals(beforeLength+1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di swap
    @Test
    public void testParse10() {
        
        String svolgi="swap";
        
        Complex num1= new Complex(34.56, -67.9);
        stack.addFirst(num1);
        
        Complex num2= new Complex(46.9, 90.1);
        stack.addFirst(num2);
        
        int beforeLength=stack.size();
        
        parser.parse(null, svolgi);
        
        double expResultRealPart = num1.getRealPart();
        double expResultJPart = num1.getJPart();
        
        assertEquals(beforeLength, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di clear
    @Test
    public void testParse11() {
        
        String svolgi="clear";
        
        Complex num1= new Complex(34.56, -67.9);
        stack.addFirst(num1);
        
        Complex num2= new Complex(46.9, 90.1);
        stack.addFirst(num2);
        
        parser.parse(null, svolgi);        
        
        assertEquals(0, stack.size());
    }
    
    //Test del parse per operazione di over
    @Test
    public void testParse12() {
        
        String svolgi="over";
        
        Complex num1= new Complex(34.56, -67.9);
        stack.addFirst(num1);
        
        Complex num2= new Complex(46.9, 90.1);
        stack.addFirst(num2);
        
        int beforeLength=stack.size();
        
        parser.parse(null, svolgi);
        
        double expResultRealPart = num1.getRealPart();
        double expResultJPart = num1.getJPart();
        
        assertEquals(beforeLength+1, stack.size());
        assertEquals(expResultRealPart,stack.getFirst().getRealPart(), DELTA);
        assertEquals(expResultJPart,stack.removeFirst().getJPart(), DELTA);
    }
    
    //Test del parse per operazione di stackToVar
    @Test
    public void testParse13() {
        
        String svolgi="stackToVar";
        String input="a";
        Complex num1= new Complex(34.56, -67.9);
        stack.addFirst(num1);
        parser.parse(input, svolgi);
        
        assertEquals(0, stack.size());
    }
    
    //Test del parse per operazione di varToStack
    @Test
    public void testParse14() {
        
        String svolgi="varToStack";
        String input="a";
        Complex num1= new Complex(34.56, -67.9);
        stack.addFirst(num1);
        
        var.stackToVar('a');
                
        parser.parse(input, svolgi);
        
        assertEquals(1, stack.size());
    }
    
    //Test del parse per operazione di addVar
    @Test
    public void testParse15() {
        
        String input="a";
        String svolgi="addVar";
        
        Complex num2= new Complex(8.2, 38.45);
        stack.addFirst(num2);
       assertThrows(VarException.class,() -> {
            parser.parse(input, svolgi);
        });
    }
    
    //Test del parse per operazione di subVar
    @Test
    public void testParse16() {
        
        String input="a";
        String svolgi="addVar";
        
        Complex num2= new Complex(8.2, 38.45);
        stack.addFirst(num2);
        assertThrows(VarException.class,() -> {
            parser.parse(input, svolgi);
        });
    }
    
    //Test checkerNumber per un input errato
    @Test
    public void testCheckerNumber1() {
        System.out.println("Test checkerNumber : caso input errato con ,");
        
        assertThrows(InputException.class,() -> {
            parser.checkerNumber("12,45-02.15");
        });
    }

    //Test checkerNumber per un input vuoto
    @Test
    public void testCheckerNumber2() {
        System.out.println("Test checkerNumber : caso senza input");
        
        assertThrows(InputException.class,() -> {
            parser.checkerNumber("");
        });
    }
    
    //Test checkerNumber per un input con numeri troppo grandi
    @Test
    public void testCheckerNumber3() {
        System.out.println("Test checkerNumber : caso numero troppo grande");
        
        assertThrows(OverflowException.class,() -> {
            parser.checkerNumber("1.153486+5138463.585684151");
        });
    }
    
    //Test checkerVar per un input vuoto
    @Test
    public void testCheckerVar1() {
        System.out.println("Test checkerVar, caso stringa vuota");
                
        assertThrows(InputException.class, () -> {
            parser.checkerVar("");
        });
    }
    
    //Test checkerVar per un input diverso da una sola lettera
    @Test
    public void testCheckerVar2() {
        System.out.println("Test checkerVar, caso input invalido: stringa troppo lunga");
                
        assertThrows(InputException.class, () -> {
            parser.checkerVar("abc");
        });
    }
    
    //Test checkerVar per una lettera maiuscola
    @Test
    public void testCheckerVar3() {
        System.out.println("Test checkerVar, caso input invalido: lettera maiusciola");
                
        assertThrows(InputException.class, () -> {
            parser.checkerVar("A");
        }); 
    }
    
    //Test checkerVar per un input numerico
    @Test
    public void testCheckerVar4() {
        System.out.println("Test checkerVar, caso input invalido: valore numerico");
                
        assertThrows(InputException.class, () -> {
            parser.checkerVar("20");
        });
        
    }
    
   
    //Test varMapToString per la stampa della mappa
    @Test
    public void testVarMapToString() {
        Complex num1= new Complex(34.56, -67.9);
        stack.addFirst(num1);
        
        var.stackToVar('a');
        
        String expStringResult="\nVariabili Utilizzate: \n{a="+ num1+"}";
        assertEquals(expStringResult, var.toString());
    }
}
