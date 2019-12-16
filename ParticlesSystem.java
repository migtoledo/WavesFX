/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author mtg
 */
public class ParticlesSystem {

   // Point Elements
   
	//PointXY p1 = new PointXY(new XY(0, 0), Color.GREEN);

   //PointXY p2 = new PointXY(new XY(3, 3), new Radius(new RadiusPixels(2)));

   //PointXY p3 = new PointXY(new XY(-3, 1), new Radius(new RadiusUnits(1)));

   final void setInitialState() {

      System.out.println("Particles system ready and running");

      //p1.setInitialState();
      //p2.setInitialState();
      //p3.setInitialState();
   }

   void draw(GraphicsContext gc) {
      //p1.draw(gc);
      //p2.draw(gc);
      //p3.draw(gc);
   }
   
   ParticlesSystem()
   {
      setInitialState();
   }
}
