package objecttofunctionalconversion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsemd
 */
public class ObjectToFunctionalConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        newLambda myLambdaVar = () -> {
            System.out.println("hello world");
        };
        
        myLambdaVar.run();
    }
    interface newLambda {
        void run();
    }
    // using an anonymous class
    Runnable r = new Runnable() { 

    @Override

    public void run() {

        System.out.println("Hello World");

    }

    };
}
