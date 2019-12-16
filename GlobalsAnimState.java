package application;

/**
 *
 * @author mtg
 */
public class GlobalsAnimState {

    static boolean isNotRunning = true;

    static boolean isRunning = false;

    static boolean isRunningOnWards = false;

    static boolean isRunningBackwards = false;

    static boolean isPaused = false;

    static boolean isStopped = false;

    static String strAnimState = null;
    
    static double tSig=0;

    static void updateStrAnimState() {

        if (isStopped) {
            strAnimState = "STOPPED";
            tSig=0;
        }

        if (isNotRunning) {
            strAnimState = "NOT RUNNING";
            if(isStopped) strAnimState="STOPPED";
            isRunningOnWards = false;
            isRunningBackwards = false;
            tSig=0;
        }

        if (isRunning) {
            strAnimState = "RUNNING";
            isStopped=false;
            if (GlobalsTimers.dt > 0) {
                isRunningOnWards = true;
                isRunningBackwards = false;
                tSig=1;
            }
            if (GlobalsTimers.dt < 0) {
                isRunningBackwards = true;
                isRunningOnWards = false;
                tSig=-1;
            }
        }

        if (isRunningOnWards) {
            strAnimState = "RUNNING ONWARDS";
            tSig=1;
        }

        if (isRunningBackwards) {
            strAnimState = "RUNNING BACKWARDS";
            tSig=-1;
        }

        if (isPaused) {
            isStopped=false;
            strAnimState = "PAUSED";
            tSig=0;
        }
    }

}
