/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import jpl.Query;
import java.applet.AudioClip;



/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException {
        // Conexion con Prolog
        AudioClip audio;
        String t1 = "consult('laberinto.pl')";
        Query q1 = new Query(t1);
        String solu1 = "";
        char p = ' '; 
        System.out.println( t1 + " " + (q1.hasSolution() ? "correcto" : "fallo") );
        String t4 = "solucion(E)";
        Query q4 = new Query(t4);
        System.out.println( "Solucion para t4 " + t4 );
        String sol=String.valueOf(q4.oneSolution().get("E"));
        Animation laberinto = new Animation();
        for(int i=0;i<sol.length();i++){
                if(sol.charAt(i) >=97 && sol.charAt(i)<=122)
                {
                    solu1 = solu1+sol.charAt(i); 
                }
            }
        System.out.println(solu1);
        for(int i=solu1.length()-1;i>=0;i--)
        {
            laberinto.setMusic();
            if(laberinto.getX() == 30 && laberinto.getY()== 30)
            {
                System.out.println("Termino");
            }
            
            switch(solu1.charAt(i)){
                
                case 'i': System.out.println("IR A LA IZQUIERDA");
                            for(int y = 0;y<20;y++)
                            {
                                if(laberinto.getX()%2==0)
                                {
                                    laberinto.setBandera(4);
                                    laberinto.cargaImagen();
                                    laberinto.setX(-5);
                                    laberinto.repaint();
                                    Thread.sleep(50);
                                }
                                else
                                {
                                    laberinto.setBandera(5);
                                    laberinto.cargaImagen();
                                    laberinto.setX(-5);
                                    laberinto.repaint();
                                    Thread.sleep(50);
                                }
                               
                            }
                          break;
                
                case 'd': System.out.println("IR A LA DERECHA");
                            for(int y = 0;y<20;y++)
                            {
                                if(laberinto.getX()%2==0)
                                {
                                    laberinto.setBandera(1);
                                    laberinto.cargaImagen();
                                    laberinto.setX(5);
                                    laberinto.repaint();
                                    Thread.sleep(50);
                                }
                                else
                                {
                                    laberinto.setBandera(0);
                                    laberinto.cargaImagen();
                                    laberinto.setX(5);
                                    laberinto.repaint();
                                    Thread.sleep(50);
                                }
                                
                            }
                          break;
                    
                case 's': System.out.println("IR ARRIBA");
                          for(int y = 0;y<20;y++)
                            {
                                if(laberinto.getY()%2==0)
                                {
                                    laberinto.setBandera(6);
                                    laberinto.cargaImagen();
                                    laberinto.setY(-5);
                                    laberinto.repaint();
                                    Thread.sleep(50);
                                }
                                else
                                {
                                    laberinto.setBandera(7);
                                    laberinto.cargaImagen();
                                    laberinto.setY(-5);
                                    laberinto.repaint();
                                    Thread.sleep(50);
                                }
                                if(laberinto.getY()==60)
                                {
                                    System.out.println("Termino");
                                    laberinto.setBandera(8);
                                    laberinto.cargaImagen();
                                    laberinto.repaint();
                                    Thread.sleep(50);
                                    laberinto.setMusic1();
                                    break;
                                }
                                System.out.println(laberinto.getY());
                               
                            }
                          break;
                    
                case 'b': System.out.println("IR ABAJO");
                          break;
            }     
            }
    }
    
}
