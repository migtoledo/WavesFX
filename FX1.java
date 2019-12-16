/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author mtg
 * <p>
 * This class is the base for waves functions f=f(x,t) In fact, the
 * function represent waves of particles:
 * <p>
 * f=f(Particles at time t)
 * <p>
 * f represents the probability of such a particle at time t be at
 * position x in the space : Wave
 * <p>
 * This class FX1 is prepared to be integrated in the "super-class" [[[
 * VirtualSystem ]]]
 * <p>
 * FX1 : Waves System : Virtual System
 */
public final class FX1 {

    ArrayList<PointXY> particlesMatrix;

    boolean initialTime(){
        return ((GlobalsTimers.t==0) ? true : false);
    }

    // Just the function f=f(x)
    double f(double x) {
        double y = GlobalsFX1.A1 * Math.sin(GlobalsFX1.K1 * x - GlobalsFX1.W1*GlobalsTimers.t);
        return y;
    }

    // At each instant of time, it calculates corresponding f(x)
    // then loads the dynamical matrix of particles

    void computeXY() {
        for (int i = 0; i < particlesMatrix.size(); i++) {
            double x = particlesMatrix.get(i).xy.getReal();
            particlesMatrix.get(i).setXY(new XY(x, f(x)));
        }
    }

    void computeParticlesMatrix() {
        reloadParticles();
        computeXY();
        System.out.println("Computing particles of F1 : " + particlesMatrix.size());
    }

    void setInitialState() { setup(); }

    void reloadParticles() {
        if (initialTime()) {
            loadParticlesMatrix();
        }
    }

    void drawTheParticles(GraphicsContext gc) {
        Iterator<PointXY> it = particlesMatrix.iterator();
        while (it.hasNext()) {
            it.next().draw(gc);
        }
    }

    void drawParticles(GraphicsContext gc) {
        reloadParticles();
        drawTheParticles(gc);
    }

    void draw(GraphicsContext gc) {
        computeParticlesMatrix();
        drawParticles(gc);
    }

    void calculateNewPointsXY() {
        particlesMatrix.clear();
        for (double x = GlobalsXY.xMin; x < GlobalsXY.xMax; x += GlobalsFX1.dx1) {
            particlesMatrix.add(new PointXY(new XY(x, f(x)), Color.BLUEVIOLET));
        }
    }

    // This function should be called when dx resolution changes
    void loadParticlesMatrix() {
        calculateNewPointsXY();
    }

    void setup() {
        particlesMatrix = new ArrayList<>();
        loadParticlesMatrix();
    }

    /**
     * Default constructor
     */
    FX1() {
        setInitialState();
    }

}
