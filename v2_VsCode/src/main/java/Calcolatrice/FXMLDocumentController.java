package Calcolatrice;

//Import Exception
import Calcolatrice.Exceptions.EmptyStackException;
import Calcolatrice.Exceptions.ArithmeticException;
import Calcolatrice.Exceptions.InputException;
import Calcolatrice.Exceptions.OverflowException;
import Calcolatrice.Exceptions.VarException;

//Import per la coda
import java.util.Deque;
import java.util.LinkedList;

//Import FXML
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;


public class FXMLDocumentController {
    
    //Attributi
    private Deque<Complex> stack;
    private Parser parser;
    
    
    //TextArea
    @FXML
    private TextArea TextStandard;
    @FXML
    private TextArea labelStandard;
    @FXML
    private TextArea TextVariabili;
    @FXML
    private TextArea labelVariabili;
    @FXML
    private TextArea StackStandard;

    
    //Azione di inizializzaizone dell'interfaccia
    @FXML
    void initialize(){
        this.stack= new LinkedList<>();
        this.parser=new Parser (stack);
        labelVariabili.setText(parser.varMapToString());
    }
    
    //Azioni per i numeri
    @FXML
    void pointAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + ".");
        
    }
    @FXML
    void zeroAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "0");
    }
    @FXML
    void oneAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "1");
    }
    @FXML
    void twoAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "2");
    }
    @FXML
    void threeAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "3");
    }
    @FXML
    void fourAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "4");
    }
    @FXML
    void fiveAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "5");
    }
    @FXML
    void sixAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "6");
    }
    @FXML
    void sevenAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "7");
        
    }
    @FXML
    void eightAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "8");
    }
    @FXML
    void nineAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "9");
    }

    
    //Azioni Operazioni
    @FXML
    void addAction(ActionEvent event) {
        try{
            parser.parse(null, "+");
            labelStandard.setText("Operazione di addizione\n" + stack.getLast().toString());
        }catch(EmptyStackException e){
            labelStandard.setText(e.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void subAction(ActionEvent event) {
        try{
            parser.parse(null, "-");
            labelStandard.setText("Operazione di sottrazione\n" + stack.getLast().toString());
        }catch(EmptyStackException e){
            labelStandard.setText(e.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void reverseAction(ActionEvent event) {
        try{
            parser.parse(null, "+-");
            labelStandard.setText("Operazione di inversione di segno\n" + stack.getLast().toString());
        }catch(EmptyStackException e){
            labelStandard.setText(e.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void divAction(ActionEvent event) {
        try{
            parser.parse(null, "/");
            labelStandard.setText("Operazione di divisione\n" + stack.getLast().toString());
        }catch(EmptyStackException e){
            labelStandard.setText(e.getMessage());
        }catch(ArithmeticException c){
            labelStandard.setText(c.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void timesAction(ActionEvent event) {
        try{
            parser.parse(null, "*");
            labelStandard.setText("Operazione di moltiplicazione\n" + stack.getLast().toString());
        }catch(EmptyStackException e){
            labelStandard.setText(e.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void sqrtAction(ActionEvent event) {
        try{
            parser.parse(null, "sqrt");
            labelStandard.setText("Operazione di radice quadrata\n" + stack.getLast().toString());
        }catch(EmptyStackException e){
            labelStandard.setText(e.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }

    //Azioni Manipolazione Stack (Interfaccia Standard)
    @FXML
    void clearAction(ActionEvent event) {
        try{
            parser.parse(null, "clear");
            labelStandard.setText("clear operation");
        }catch(EmptyStackException e){
            labelStandard.setText(e.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void dropAction(ActionEvent event) {
         try{
            parser.parse(null, "drop");
            labelStandard.setText("drop operation");
        }catch(EmptyStackException e){
            labelStandard.setText(e.getMessage());
        }finally{
             StackStandard.setText(toString());
         }
    }
    @FXML
    void dupAction(ActionEvent event) {
        parser.parse(null, "dup");
        labelStandard.setText("dup operation");
        StackStandard.setText(toString());
    }
    @FXML
    void swapAction(ActionEvent event) {
        parser.parse(null, "swap");
        labelStandard.setText("swap operation");
        StackStandard.setText(toString());
    }
    @FXML
    void overAction(ActionEvent event) {
        parser.parse(null, "over");
        labelStandard.setText("over operation");
        StackStandard.setText(toString());
    }
    
    
    //Azioni Manipolazione TextArea (Interfaccia Standard)
    @FXML
    void delAction(ActionEvent event) {
        String text = TextStandard.getText();
        int index = text.lastIndexOf("");
        if (index > 0) {
            TextStandard.setText(text.substring(0, index-1));
        } else {
            TextStandard.setText("");
        }
    }
    @FXML
    void acAction(ActionEvent event) {
        labelStandard.setText("");
        TextStandard.setText("");
    }
    @FXML
    void enterAction(ActionEvent event) {
        try{
            parser.parse(TextStandard.getText(), "numero");
            labelStandard.setText("Inserimento di un valore\n" + stack.getFirst().toString());
            TextStandard.setText("");
        }catch(InputException i){
            labelStandard.setText(i.getMessage());
        }catch(OverflowException o){
            labelStandard.setText(o.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }

    
    //Azioni Manipolazione TextArea (Interfaccia Variabili)
    @FXML
    void ac1Action(ActionEvent event) {
        labelVariabili.setText(parser.varMapToString());
        TextVariabili.setText("");
    }
    
    
    //Azioni per Complex
    @FXML
    void posAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "+");
    }
    @FXML
    void negAction(ActionEvent event) {
        TextStandard.setText(TextStandard.getText() + "-");
    }
    
    
    //Azioni Caratteri delle variabili
    @FXML
    void aAction(ActionEvent event) {
        TextVariabili.setText("a");
    }
    @FXML
    void bAction(ActionEvent event) {
        TextVariabili.setText("b");
    }
    @FXML
    void cAction(ActionEvent event) {
        TextVariabili.setText("c");
    }
    @FXML
    void dAction(ActionEvent event) {
        TextVariabili.setText("d");
    }
    @FXML
    void eAction(ActionEvent event) {
        TextVariabili.setText("e");
    }
    @FXML
    void fAction(ActionEvent event) {
        TextVariabili.setText("f");
    }
    @FXML
    void gAction(ActionEvent event) {
        TextVariabili.setText("g");
    }
    @FXML
    void hAction(ActionEvent event) {
        TextVariabili.setText("h");
    }
    @FXML
    void iAction(ActionEvent event) {
        TextVariabili.setText("i");
    }    
    @FXML
    void jAction(ActionEvent event) {
        TextVariabili.setText("j");
    }
    @FXML
    void kAction(ActionEvent event) {
        TextVariabili.setText("k");
    }    
    @FXML
    void lAction(ActionEvent event) {
        TextVariabili.setText("l");
    }
    @FXML
    void mAction(ActionEvent event) {
        TextVariabili.setText("m");
    }
    @FXML
    void nAction(ActionEvent event) {
        TextVariabili.setText("n");
    }
    @FXML
    void oAction(ActionEvent event) {
        TextVariabili.setText("o");
    }
    @FXML
    void pAction(ActionEvent event) {
        TextVariabili.setText("p");
    }
    @FXML
    void qAction(ActionEvent event) {
        TextVariabili.setText("q");
    }
    @FXML
    void rAction(ActionEvent event) {
        TextVariabili.setText("r");
    }
    @FXML
    void sAction(ActionEvent event) {
        TextVariabili.setText("s");
    }
    @FXML
    void tAction(ActionEvent event) {
        TextVariabili.setText("t");
    }
    @FXML
    void uAction(ActionEvent event) {
        TextVariabili.setText("u");
    }
    @FXML
    void vAction(ActionEvent event) {
        TextVariabili.setText("v");
    }
    @FXML
    void wAction(ActionEvent event) {
        TextVariabili.setText("w");
    }
    @FXML
    void xAction(ActionEvent event) {
        TextVariabili.setText("x");
    }
    @FXML
    void yAction(ActionEvent event) {
        TextVariabili.setText("y");
    }
    @FXML
    void zAction(ActionEvent event) {
        TextVariabili.setText("z");
    }

    
    //Azioni operazioni Variabili
    
    @FXML
    void varToStackAction(ActionEvent event) {
        try{
            parser.parse(TextVariabili.getText(), "varToStack");
            labelVariabili.setText("operazione di "+TextVariabili.getText()+"->Stack\n"+parser.varMapToString());
        }catch(InputException i){
            labelVariabili.setText(i.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void stackToVarAction(ActionEvent event) {
        try{
            parser.parse(TextVariabili.getText(), "stackToVar");
            labelVariabili.setText("operazione di stack->"+TextVariabili.getText()+"\n"+parser.varMapToString());
        }catch(EmptyStackException e){
            labelVariabili.setText(e.getMessage());
        }catch(InputException i){
            labelVariabili.setText(i.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void addVarAction(ActionEvent event) {
        try{
            parser.parse(TextVariabili.getText(), "addVar");
            labelVariabili.setText("operazione di +"+TextVariabili.getText()+"\n"+parser.varMapToString());
        }catch(VarException v){
            labelVariabili.setText(v.getMessage());
        }catch(InputException i){
            labelVariabili.setText(i.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }
    @FXML
    void subVarAction(ActionEvent event) {
        try{
            parser.parse(TextVariabili.getText(), "subVar");
            labelVariabili.setText("operazione di -"+TextVariabili.getText()+"\n"+parser.varMapToString());
        }catch(VarException v){
            labelVariabili.setText(v.getMessage());
        }catch(InputException i){
            labelVariabili.setText(i.getMessage());
        }finally{
            StackStandard.setText(toString());
        }
    }

    
    //Azione per la stampa dello stack
    @Override
    public String toString() {
        StringBuilder string=new StringBuilder("");
        for( Complex n : stack ){
            string.append(n.toString()+'\n');
        }
        return string.toString();
    }
}
