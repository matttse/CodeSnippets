package objecttofunctionalconversion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ender_Laptop
 */
public class ObjectToFunctionalConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // using an anonymous class

        Runnable r = new Runnable() { 

          @Override

          public void run() {

            System.out.println("Hello World");

          }
          
        };
    }
    
}
