package tr.com.cagrialdemir.universitystudentassistant.Core.Utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by barisatalay on 21.02.2019.
 */
public class UtilsKeyboard {

    public static void focusEditText( EditText editText){
        editText.requestFocus();
    }
    /**
     * Eğer klavye açıksa kapatır.
     */
    public static void hideSoftKeyboard(Activity mActivity) {
        if(mActivity.getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) mActivity.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(mActivity.getCurrentFocus().getWindowToken(), 0);
        }
    }
    /**
     * Klavyeyi açar.
     */
    public static void showSoftKeyboard(Activity mActivity, View view) {

        InputMethodManager inputMethodManager = (InputMethodManager)mActivity.getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInputFromWindow(view.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
    }
}
