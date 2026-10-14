package Calcolatrice;

import Calcolatrice.Exceptions.ArithmeticException;


public class Complex {
    private double realPart;
    private double jPart;

    public Complex(double realPart, double jPart) {
        this.realPart = realPart;
        this.jPart = jPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getJPart() {
        return jPart;
    }

    // Restituisce la rappresentazione stringa del numero complesso
    @Override
    public String toString() {
        if (jPart >= 0) {
            return Double.toString(round(getRealPart())) + 
                    "+" + Double.toString(round(getJPart())) + "j";
        } else {
            return Double.toString(round(getRealPart())) + 
                    Double.toString(round(getJPart())) + "j";
        }
    }
    
    private double round(double n) {
        double scaledNumber = n * 1e8;
        long roundedValue = Math.round(scaledNumber);
        return roundedValue / 1e8;
    }
       
    public boolean isZero(){
        return this.getRealPart() == 0 && this.getJPart() == 0;
    }
    
    public Complex add(Complex num){
        
        return new Complex(realPart + num.realPart, jPart + num.jPart);
        
    }
    
    public Complex sub(Complex num){
        
        return new Complex(realPart - num.realPart, jPart - num.jPart);
        
    }
    
    public Complex times(Complex num) {
        
        return new Complex(this.getRealPart() * num.getRealPart() - this.getJPart() * num.getJPart(),
                this.getRealPart() * num.getJPart() + this.getJPart() * num.getRealPart());
        
    }
    
    public Complex division(Complex num) {
        
        if(num.isZero())
            throw new ArithmeticException("Divided by 0, ERROR");
        
        double denominator = num.getRealPart() * num.getRealPart() + num.getJPart() * num.getJPart();
        return new Complex(
                (this.getRealPart() * num.getRealPart() + this.getJPart() * num.getJPart()) / denominator,
                (this.getJPart() * num.getRealPart() - this.getRealPart() * num.getJPart()) / denominator
        );
    }
    
    public Complex sqrt(){
        
        double magnitude = Math.sqrt(this.getRealPart() * this.getRealPart() + this.getJPart() * this.getJPart());
        double phase = Math.atan2(this.getJPart(), this.getRealPart()) / 2.0;
        
        return new Complex(Math.sqrt(magnitude) * Math.cos(phase), Math.sqrt(magnitude) * Math.sin(phase));
    }
    
    public Complex reverse(){
        return new Complex(-this.getRealPart(),-this.getJPart());
    }
}

