package application;

import javafx.scene.canvas.GraphicsContext;

/**
 * This class is the nucleus of this program. It represents a system of
 * interacting particles and waves.
 * <p>
 * It can be understood as the union of the respective classes for
 * "ParticlesSystem" + "WavesSystem"
 * <p>
 * VIRTUAL SYSTEM = PARTICLES SYSTEM + WAVES SYSTEM
 * <p>
 * <p>
 */
public class VirtualSystem {

   // Particles System ---> Set of individual particles
   ParticlesSystem particlesSystem;

   // Waves System ---> Set of waves of particles
   WavesSystem wavesSystem;

   void setInitialState() {

      System.out.println("Virtual system ready and running");

      particlesSystem.setInitialState();

      wavesSystem.setInitialState();

   }

   // draw() function performs XY calculations before
   // actually drawing the graphical elements
   void draw(GraphicsContext gc) {

      particlesSystem.draw(gc);
      wavesSystem.draw(gc);
   }

   
   void loadSubsystems()
   {
      particlesSystem = new ParticlesSystem();
      wavesSystem = new WavesSystem();
   }
   
   final void setup()
   {
      loadSubsystems();
      setInitialState();
   }
   
   /**
    * Default constructor *
    */
   VirtualSystem() {
      // Initializing particles system and waves system

      setup();
   }

}
