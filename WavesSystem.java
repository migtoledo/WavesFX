/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author mtg
 */
public class WavesSystem {
   
   // Waves of particles
   
   FX1 fx1;
   FX2 fx2;
   
   final void setInitialState() {

      System.out.println("Waves system ready and running");

      fx1.setInitialState();
      fx2.setInitialState();
   }

   void draw(GraphicsContext gc) {
      fx1.draw(gc);
      fx2.draw(gc);
   }
   
   final void setup()
   {
      fx1=new FX1();
      fx2=new FX2();
      setInitialState();
      
   }
   
   WavesSystem()
   {
      setup();
   }
   
}
