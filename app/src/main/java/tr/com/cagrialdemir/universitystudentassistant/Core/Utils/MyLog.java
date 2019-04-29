package tr.com.cagrialdemir.universitystudentassistant.Core.Utils;

import android.util.Log;

/*
d: DEBUG
v: VERBOSE
i: INFO
e: ERROR
w: WARNING
*/

public class MyLog {
    private static final boolean DEBUG = true;

    /**
     * Hata ayıklama işlemleri için kullanılan LOG metodu.
     *
     * @param classTAG   Class içerisinde tanımlanan TAG
     * @param methodName Kullanılan methodun adı.
     * @param message    Mesaj içeriği
     */
    public static void d(String classTAG, String methodName, String message) {
        if (DEBUG) {
            Log.d(classTAG, methodName + " - " + message);
        }
    }

    /**
     * Herhangi bir şey yazdırmak için kullanılan LOG metodu.
     *
     * @param classTAG   Class içerisinde tanımlanan TAG
     * @param methodName Kullanılan methodun adı.
     * @param message    Mesaj içeriği
     */
    public static void v(String classTAG, String methodName, String message) {
        if (DEBUG) {
            Log.v(classTAG, methodName + " - " + message);
        }
    }

    /**
     * Bilgi vermek için kullanılan LOG metodu.
     *
     * @param classTAG   Class içerisinde tanımlanan TAG
     * @param methodName Kullanılan methodun adı.
     * @param message    Mesaj içeriği
     */
    public static void i(String classTAG, String methodName, String message) {
        if (DEBUG) {
            Log.i(classTAG, methodName + " - " + message);
        }
    }

    /**
     * Hata yazdırmak için kullanılan LOG metodu.
     *
     * @param classTAG   Class içerisinde tanımlanan TAG
     * @param methodName Kullanılan methodun adı.
     * @param message    Mesaj içeriği
     */
    public static void e(String classTAG, String methodName, String message) {
        if (DEBUG) {
            Log.e(classTAG, methodName + " - " + message);
        }
    }

    /**
     * Uyarı mesajı yazdırmak için kullanılan LOG metodu.
     *
     * @param classTAG   Class içerisinde tanımlanan TAG
     * @param methodName Kullanılan methodun adı.
     * @param message    Mesaj içeriği
     */
    public static void w(String classTAG, String methodName, String message) {
        if (DEBUG) {
            Log.w(classTAG, methodName + " - " + message);
        }
    }
}
