package tr.com.cagrialdemir.universitystudentassistant.Core.Utils;

import android.util.Log;

public class MyLog {
    private static final boolean DEBUG = true;

    public static void d(String classTAG, String methodName, String error) {
        if (DEBUG) {
            Log.d(classTAG, methodName + " - " + error);
        }
    }

    public static void v(String classTAG, String methodName, String error) {
        if (DEBUG) {
            Log.v(classTAG, methodName + " - " + error);
        }
    }

    public static void i(String classTAG, String methodName, String error) {
        if (DEBUG) {
            Log.i(classTAG, methodName + " - " + error);
        }
    }

    public static void e(String classTAG, String methodName, String error) {
        if (DEBUG) {
            Log.e(classTAG, methodName + " - " + error);
        }
    }

    public static void w(String classTAG, String methodName, String error) {
        if (DEBUG) {
            Log.w(classTAG, methodName + " - " + error);
        }
    }
}
