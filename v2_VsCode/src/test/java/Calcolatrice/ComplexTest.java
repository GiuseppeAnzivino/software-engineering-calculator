package Calcolatrice;

//Import Exception
import Calcolatrice.Exceptions.ArithmeticException;

//Import JUnit
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ComplexTest {
    
    //Attributo utile
    private static final double DELTA = 1e-15;
    
    //Test per il getRealPart
    @Test
    public void testGetRealPart() {
        System.out.println("Test getRealPart");
        Complex num = new Complex(23.5542, 53);
        
        double expResult = 23.5542;
        double result = num.getRealPart();
        
        assertEquals(expResult, result);
    }

    //Test per il getJPart
    @Test
    public void testGetJPart() {
        System.out.println("Test getJPart");
        Complex num = new Complex(23.5542, 0);
        
        double expResult = 0;
        double result = num.getJPart();
        
        assertEquals(expResult, result);
    }

    //Test per il toString con parte immaginaria e reale positiva
    @Test
    public void testToString1() {
        System.out.println("Test toString: parte reale e parte immaginaria interi > 0");
        Complex num = new Complex(532, 12);
        
        String expResult = "532.0+12.0j";
        String result = num.toString();
        
        assertEquals(expResult, result);
    }
    
    //Test per il toString con parte immaginaria e reale negativa 
    @Test
    public void testToString2() {
        System.out.println("Test toString: parte reale e parte immaginaria interi < 0");
        Complex num = new Complex(-32, -1);
        
        String expResult = "-32.0-1.0j";
        String result = num.toString();
        
        assertEquals(expResult, result);
        
    }
    
    //Test per il toString con parte immaginaria e reale in decimali positivi
    @Test
    public void testToString3() {
        System.out.println("Test toString: parte reale e parte immaginaria decimali > 0");
        Complex num = new Complex(432.124, 5.9);
        
        String expResult = "432.124+5.9j";
        String result = num.toString();
        
        assertEquals(expResult, result);
        
    }
    
    //Test per il toString con parte immaginaria e reale in decimali negativi
    @Test
    public void testToString4() {
        System.out.println("Test toString: parte reale e parte immaginaria decimali < 0");
        Complex num = new Complex(-42.54, -12.2174);
        
        String expResult = "-42.54-12.2174j";
        String result = num.toString();
        
        assertEquals(expResult, result);
        
    }
    
    //Test per il toString con parte reale nulla e immaginaria positiva
    @Test
    public void testToString5() {
        System.out.println("Test toString: parte reale nulla e parte immaginaria < 0");
        Complex num = new Complex(0, -12.634);
        
        String expResult = "0.0-12.634j";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    //Test per il toString con parte reale nulla e immaginaria negativa
    @Test
    public void testToString6() {
        System.out.println("Test toString: parte reale nulla e parte immaginaria > 0");
        Complex num = new Complex(0, 234);
        
        String expResult = "0.0+234.0j";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    //Test per il toString con parte immaginaria nulla e reale negativa
    @Test
    public void testToString7() {
        System.out.println("Test toString: parte immaginaria nulla e parte reale < 0");
        Complex num = new Complex(-312.5, 0);
        
        String expResult = "-312.5+0.0j";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    //Test per il toString con parte immaginaria nulla e reale positiva
    @Test
    public void testToString8() {
        System.out.println("Test toString: parte immaginaria nulla e parte reale > 0");
        Complex num = new Complex(75, 0);
        
        String expResult = "75.0+0.0j";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    //Test per il toString con parte immaginaria ed immaginaria nulla
    @Test
    public void testToString9() {
        System.out.println("Test toString: parte reale ed immaginaria entrambi nulli");
        Complex num = new Complex(0, 0);
        
        String expResult = "0.0+0.0j";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    //Test isZero con parte reale ed immaginaria positivi
    @Test
    public void testIsZero1(){
        System.out.println("Test isZero1: parte reale e parte immaginaria interi > 0");
        
        Complex num = new Complex(532, 12);
        
        boolean expResult = false;
        boolean result = num.isZero();
        
        assertEquals(expResult, result);
    }
    
    //Test isZero con parte reale ed immaginaria negativi
    @Test
    public void testIsZero2(){
        System.out.println("Test isZero2: parte reale e parte immaginaria interi < 0");
        Complex num = new Complex(-32, -1);
        
        boolean expResult = false;
        boolean result = num.isZero();
        
        assertEquals(expResult, result);
    }
    
    //Test isZero con parte reale nulla ed immaginaria negativa
    @Test
    public void testIsZero3() {
        System.out.println("Test isZero3: parte reale nulla e parte immaginaria < 0");
        Complex num = new Complex(0, -12.634);
        
        boolean expResult = false;
        boolean result = num.isZero();
        
        assertEquals(expResult, result);    
    }
    
    //Test isZero con parte reale nulla ed immaginaria positiva
    @Test
    public void testIsZero4() {
        System.out.println("Test isZero4: parte reale nulla e parte immaginaria > 0");
        Complex num = new Complex(0, 234);
        
        boolean expResult = false;
        boolean result = num.isZero();
        
        assertEquals(expResult, result); 
    }
    
    //Test isZero con parte reale negativa ed immaginaria nulla
    @Test
    public void testIsZero5() {
        System.out.println("Test isZero: parte immaginaria nulla e parte reale < 0");
        Complex num = new Complex(-312.5, 0);
        
        boolean expResult = false;
        boolean result = num.isZero();
        
        assertEquals(expResult, result); 
    }
    
    //Test isZero con parte reale positiva ed immaginaria nulla
    @Test
    public void testIsZero6() {
        System.out.println("Test isZero6: parte immaginaria nulla e parte reale > 0");
        Complex num = new Complex(75, 0);
        
        boolean expResult = false;
        boolean result = num.isZero();
        
        assertEquals(expResult, result); 
    }
    
    //Test isZero con parte reale ed immaginaria nulli
    @Test
    public void testIsZero7() {
        System.out.println("Test isZero7: parte reale ed immaginaria entrambi nulli");
        Complex num = new Complex(0, 0);
        
        boolean expResult = true;
        boolean result = num.isZero();
        
        assertEquals(expResult, result); 
    
    }
    
    //Test per l'addizione tra numeri complessi, parte reale ed immaginaria positivi
    @Test
    public void testAdd1() {
        System.out.println("Test sommma: parte reale ed immaginaria entrambi positivi");
        Complex num1 = new Complex(23.5, 53);
        Complex num2 = new Complex(534.2, 23.98);
        Complex expResult = new Complex(23.5+534.2, 53+23.98);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.add(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
   
    //Test per l'addizione tra numeri complessi, parte reale ed immaginaria negativi
    @Test
    public void testAdd2() {
        System.out.println("Test sommma: parte reale ed immaginaria entrambi negativi");
        Complex num1 = new Complex(-235, -123);
        Complex num2 = new Complex(-7.10, -1237.9);
        Complex expResult = new Complex(-235-7.10, -123-1237.9);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.add(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per l'addizione tra numeri complessi, parte reale positiva ed immaginaria nulla
    @Test
    public void testAdd3() {
        System.out.println("Test sommma: parte immaginaria nulla");
        Complex num1 = new Complex(8, 0);
        Complex num2 = new Complex(29, 0);
        Complex expResult = new Complex(8+29, 0);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.add(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per l'addizione tra numeri complessi, parte reale nulla  
    @Test
    public void testAdd4() {
        System.out.println("Test sommma: parte reale nulla");
        Complex num1 = new Complex(0, 235);
        Complex num2 = new Complex(0, -12.643);
        Complex expResult = new Complex(0, 235-12.643);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.add(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per l'addizione tra numeri complessi, misto
    @Test
    public void testAdd5() {
        System.out.println("Test sommma: misto");
        Complex num1 = new Complex(0, -235);
        Complex num2 = new Complex(12.6, 43.1);
        Complex expResult = new Complex(0+12.6, -235+43.1);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.add(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }

    //Test per la sottrazione tra numeri complessi, parte reale ed immaginaria positivi
    @Test
    public void testSub1() {
        System.out.println("Test sottrazione: parte reale ed immaginaria entrambi positivi");
        Complex num1 = new Complex(23.5, 53);
        Complex num2 = new Complex(534.2, 23.98);
        Complex expResult = new Complex(23.5-534.2, 53-23.98);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sub(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la sottrazione tra numeri complessi, parte reale ed immaginaria negativi
    @Test
    public void testSub2() {
        System.out.println("Test sottrazione: parte reale ed immaginaria entrambi negativi");
        Complex num1 = new Complex(-235, -123);
        Complex num2 = new Complex(-7.10, -1237.9);
        Complex expResult = new Complex(-235+7.10, -123+1237.9);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sub(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la sottrazione tra numeri complessi, parte immaginaria nulla
    @Test
    public void testSub3() {
        System.out.println("Test sottrazione: parte immaginaria nulla");
        Complex num1 = new Complex(8, 0);
        Complex num2 = new Complex(29, 0);
        Complex expResult = new Complex(8-29, 0);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sub(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la sottrazione tra numeri complessi, parte reale nulla
    @Test
    public void testSub4() {
        System.out.println("Test sottrazione: parte reale nulla");
        Complex num1 = new Complex(0, 235);
        Complex num2 = new Complex(0, -12.643);
        Complex expResult = new Complex(0, 235+12.643);
        
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sub(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la sottrazione tra numeri complessi, misto
    @Test
    public void testSub5() {
        System.out.println("Test sottrazione: misto");
        Complex num1 = new Complex(0, -235);
        Complex num2 = new Complex(12.6, 43.1);
        Complex expResult = new Complex(0-12.6, -235-43.1);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sub(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la moltiplicazione tra numeri complessi, parte reale ed immaginaria positivi
    @Test
    public void testTimes1() {
        System.out.println("Test moltiplicazione: parte reale ed immaginaria entrambi positivi");
        Complex num1 = new Complex(23.5, 53);
        Complex num2 = new Complex(534.2, 23.98);
        Complex expResult = new Complex((23.5*534.2) - (53*23.98),(23.5*23.98) + (53*534.2));
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.times(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la moltiplicazione tra numeri complessi, parte reale ed immaginaria negativi
    @Test
    public void testTimes2() {
        System.out.println("Test moltiplicazione: parte reale ed immaginaria entrambi negativi");
        Complex num1 = new Complex(-235, -123);
        Complex num2 = new Complex(-7.10, -1237.9);
        Complex expResult = new Complex(((-235) * (-7.10)) - ((-123) * (-1237.9)), ((-235) * (-1237.9))+((-123) * (-7.10)));
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.times(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la moltiplicazione tra numeri complessi, parte immaginaria nulla
    @Test
    public void testTimes3() {
        System.out.println("Test moltiplicazione: parte immaginaria nulla");
        Complex num1 = new Complex(8, 0);
        Complex num2 = new Complex(29, 0);
        Complex expResult = new Complex(8*29, 0);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.times(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la moltiplicazione tra numeri complessi, parte reale nulla
    @Test
    public void testTimes4() {
        System.out.println("Test moltiplicazione: parte reale nulla");
        Complex num1 = new Complex(0, 235);
        Complex num2 = new Complex(0, -12.643);
        Complex expResult = new Complex(-(235*(-12.643)), 0);
        
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.times(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la moltiplicazione tra numeri complessi, misto
    @Test
    public void testTimes5() {
        System.out.println("Test moltiplicazione: misto");
        Complex num1 = new Complex(0, -235);
        Complex num2 = new Complex(12.6, 43.1);
        Complex expResult = new Complex(-(-235*43.1), (-235)*(12.6));
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.times(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la divisione tra numeri complessi, parte reale ed immaginaria positivi
    @Test
    public void testDivision1() {
        System.out.println("Test divisione: parte reale ed immaginaria entrambi positivi");
        Complex num1 = new Complex(23.5, 53);
        Complex num2 = new Complex(534.2, 23.98);
        Complex expResult = new Complex(0.04834725367389628, 0.09704349093391981);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.division(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la divisione tra numeri complessi, parte reale ed immaginaria negativi
    @Test
    public void testDivision2() {
        System.out.println("Test divisione: parte reale ed immaginaria entrambi negativi");
        Complex num1 = new Complex(-235, -123);
        Complex num2 = new Complex(-7.10, -1237.9);
        Complex expResult = new Complex(0.10044733558845455, -0.18926151055604004);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.division(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    
    //Test per la divisione tra numeri complessi, immaginaria nulla
    @Test
    public void testDivision3() {
        System.out.println("Test divisione: parte immaginaria nulla");
        Complex num1 = new Complex(8, 0);
        Complex num2 = new Complex(29, 0);
        Complex expResult = new Complex(0.27586206896551724, 0);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.division(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la divisione tra numeri complessi, parte reale nulla
    @Test
    public void testDivision4() {
        System.out.println("Test divisione: parte reale nulla");
        Complex num1 = new Complex(0, 235);
        Complex num2 = new Complex(0, -12.643);
        Complex expResult = new Complex(-18.587360594795534, 0);
        
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.division(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la divisione tra numeri complessi, misto
    @Test
    public void testDivision5() {
        System.out.println("Test divisione: misto");
        Complex num1 = new Complex(0, -235);
        Complex num2 = new Complex(12.6, 43.1);
        Complex expResult = new Complex(-5.023135634828925, -1.4684804872121684);
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.division(num2);
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la divisione tra numeri complessi, divisione per 0
    @Test
    public void testDivision6() {
        System.out.println("Test divisione: divisione per 0");
        Complex num1= new Complex(4, 5);
        Complex num2= new Complex(0, 0);
        
        assertThrows(ArithmeticException.class,() -> {
            num1.division(num2);
        });
    }
    
    //Test per la radice di un numero complesso, parte reale ed immaginaria positivi
    @Test
    public void testSqrt1() {
        System.out.println("Test radice: parte reale ed immaginaria entrambi positivi");
        Complex num1 = new Complex(23.5, 53);
        
        double magnitude = Math.sqrt(num1.getRealPart() * num1.getRealPart() + num1.getJPart() * num1.getJPart());
        double phase = Math.atan2(num1.getJPart(), num1.getRealPart()) / 2.0;
        
        Complex expResult = new Complex(Math.sqrt(magnitude) * Math.cos(phase), Math.sqrt(magnitude) * Math.sin(phase));
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sqrt();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la radice di un numero complesso, parte reale ed immaginaria negativi
    @Test
    public void testSqrt2() {
        System.out.println("Test radice: parte reale ed immaginaria entrambi negativi");
        Complex num1 = new Complex(-235, -123);
        
        double magnitude = Math.sqrt((-235) * (-235) + (-123) * (-123));
        double phase = Math.atan2(-123, -235) / 2.0;
        
        Complex expResult = new Complex(Math.sqrt(magnitude) * Math.cos(phase), Math.sqrt(magnitude) * Math.sin(phase));
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sqrt();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la radice di un numero complesso, parte immaginaria nulla
    @Test
    public void testSqrt3() {
        System.out.println("Test radice: parte immaginaria nulla");
        Complex num1 = new Complex(8, 0);
        
        double magnitude = Math.sqrt( 8*8 );
        double phase = Math.atan2(0, 8) / 2.0;
        
        Complex expResult = new Complex(Math.sqrt(magnitude) * Math.cos(phase), Math.sqrt(magnitude) * Math.sin(phase));
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sqrt();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la radice di un numero complesso, parte reale nulla
    @Test
    public void testSqrt4() {
        System.out.println("Test radice: parte reale nulla");
        Complex num1 = new Complex(0, 235);
        
        double magnitude = Math.sqrt( 235 * 235);
        double phase = Math.atan2(235, 0) / 2.0;
        
        Complex expResult = new Complex(Math.sqrt(magnitude) * Math.cos(phase), Math.sqrt(magnitude) * Math.sin(phase));
        
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sqrt();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per la radice di un numero complesso, misto
    @Test
    public void testSqrt5() {
        System.out.println("Test radice: misto");
        Complex num1 = new Complex(5, -235);
        
        double magnitude = Math.sqrt(5 * 5 + (-235) * (-235));
        double phase = Math.atan2((-235), 5) / 2.0;
        
        Complex expResult = new Complex(Math.sqrt(magnitude) * Math.cos(phase), Math.sqrt(magnitude) * Math.sin(phase));
        
        double expResultRealPart = expResult.getRealPart();
        double expResultJPart = expResult.getJPart();
        
        Complex result = num1.sqrt();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per l'inversione di segno di un numero complesso, parte reale ed immaginaria positivi
    @Test
    public void testReverse1() {
        System.out.println("Test Inversione di segno: parte reale ed immaginaria entrambi positivi");
        Complex num1 = new Complex(23.5, 53);
        
        double expResultRealPart = -23.5;
        double expResultJPart = -53;
        
        Complex result = num1.reverse();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per l'inversione di segno di un numero complesso, parte reale ed immaginaria negativi
    @Test
    public void testReverse2() {
        System.out.println("Test invesrione di segno: parte reale ed immaginaria entrambi negativi");
        Complex num1 = new Complex(-235, -123);
        
        double expResultRealPart = 235;
        double expResultJPart = 123;
        
        Complex result = num1.reverse();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    //Test per l'inversione di segno di un numero complesso, misto
    @Test
    public void testReverse3() {
        System.out.println("Test Inversione di segno: misto");
        Complex num1 = new Complex(5, -235);
        
        double expResultRealPart = -5;
        double expResultJPart = 235;
        
        Complex result = num1.reverse();
        double resultRealPart = result.getRealPart();
        double resultJPart = result.getJPart();
        
        assertEquals(expResultRealPart, resultRealPart, DELTA);
        assertEquals(expResultJPart, resultJPart, DELTA);
    }
    
    
    
}
