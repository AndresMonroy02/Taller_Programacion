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
public class PruebaHilos {
 
    public static void main(String[] args) {
         
        BucleNUMLETRAS h1 = new BucleNUMLETRAS(1);
        BucleNUMLETRAS h2 = new BucleNUMLETRAS(2);
         
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
         
        t1.start();
        t2.start();
         
    }
 
}