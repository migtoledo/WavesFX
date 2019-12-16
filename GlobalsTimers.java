
package application;

/**
 *
 * @author mtg
 */
public class GlobalsTimers {

    // Update period of background elements, in seconds
    static final double updateBackgroundPeriod = 0.017;

    // Frames-per-second background refresh frequency : FPS
    static final double FPS = (1 / updateBackgroundPeriod);

    // Variable "time" for the animation of the Canvas graphics
    static double t = 0;

    // Offset delay from background update is used for calculating
    // the adequate animation's update time period
    //static final double offsetDelay = > Factor k as percentage.
    
    // ****************** ADJUST K FOR GLOBAL PERFORMANCE *******************************
    static final double k=10;
    // **********************************************************************************
    // For large number of particles -> increase k value : typically > 0.5
    
    // Update period of the animation's time variable, in seconds
    static final double updateAnimationPeriod = updateBackgroundPeriod*k;

    // Update period in seconds : dt ; for t = t + dt / Run-time cycle /
    static final double dtReal = updateAnimationPeriod;

    // Real time in seconds :
    static double tReal = 0;

    // Update period in seconds : dt ; for t = t + dt / Run-time cycle /
    static double dt = updateAnimationPeriod;

    // For optimal running of the animation dt > background update period
    // By default : dt = updateBackgroundPeriod + OffsetDelayPeriod
    // This way we assure the animation runs on top of the native window frames
    // refreshing
    static void setDt(double _dt) {
        dt = _dt;
    }

    static void setDtDefault() {
        double val = updateAnimationPeriod;
        setDt(val);
    }

    static void setT(double _t) {
        t = _t;
    }
    
    static void setTR(double _t) {
        tReal = _t;
    }

    static void setT0() {
        setT(0);
    }

    static void setTR0() {
        setTR(0);
    }
    
    static void updateAnimationTime() {
        t += dt;
    }

    static void updateRealTime() {
        tReal += dtReal;
    }

    static double getDt() {
        return dt;
    }

    static double getDtReal() {
        return dtReal;
    }

    static double getT() {
        return t;
    }

    static double getTReal() {
        return tReal;
    }

    static String getStrT() {
        return String.format("%.2f", getT());
    }

    static String getStrTReal() {
        return String.format("%.2f", getTReal());
    }

    static String getStrUpdateAnimPeriod() {
        return String.format("%.3f", updateAnimationPeriod);
    }

    static String getStrDt() {
        return String.format("%.3f", getDt());
    }

    static String getStrDtReal() {
        return String.format("%.3f", getDtReal());
    }

    // Dual Strings for periods and frequencies of the animation
    static String getStrFPS() {
        return String.format("%.0f", FPS);
    }

    // 1 second of real time = .... seconds of virtual time
    static double getRealTimeVersusVirtualTime() {
        return (getDt() / updateAnimationPeriod);
    }

    // 1 second of real time = .... seconds of virtual time
    static double getVirtualTimeVersusRealTime() {
        return (updateAnimationPeriod / getDt());
    }

    // 1 second of real time = .... seconds of virtual time
    static String getStrRealTimeVersusVirtualTime() {
        double val = (getDt() / updateAnimationPeriod);
        return String.format("%.3f", val);
    }

    // 1 second of real time = .... seconds of virtual time
    static String getStrVirtualTimeVersusRealTime() {
        double val = (updateAnimationPeriod / getDt());
        return String.format("%.3f", val);
    }

    // Get the animation state : synchronized, slower, faster
    static String getAnimState() {
        return ((dt < dtReal) ? "SLOWER" : (dt > dtReal) ? "FASTER" : "SYNCHRONIZED");
    }
}
