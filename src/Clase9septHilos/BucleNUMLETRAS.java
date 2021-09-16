/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase9septHilos;

/**
 *
 * @author macdemateo
 */
public class BucleNUMLETRAS implements Runnable{
 
    
    private int tipo;
 
    public BucleNUMLETRAS(int tipo) {
        this.tipo = tipo;
    }
     
    @Override
    public void run() {
         
      
        while (true) {
           
            switch (tipo) {
                case 1:
                   
                    for (int i = 1; i < 30; i++) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                   
                    for (char c = 'a'; c < 'z'; c++) {
                        System.out.println(c);
                    }
                    break;
                     
            }
 
        }
         
    }
     
}
