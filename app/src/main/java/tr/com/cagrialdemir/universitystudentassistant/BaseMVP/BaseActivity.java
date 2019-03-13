package tr.com.cagrialdemir.universitystudentassistant.BaseMVP;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.UtilsKeyboard;


/**
 * Created by barisatalay on 21.02.2019.
 *
 * Bu sınıf içerisinde bütün aktivitylerde kullanmak istediğin ortak şeyleri hazırlamalısın.
 * */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected final String TAG = this.getClass().getSimpleName();
    private boolean isUiRendered = false;

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
       super.onCreate(bundle);

       initPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!isUiRendered){
            renderUi();
        }
    }

    private void renderUi() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                onAsynchronousLoad();
            }
        });

        isUiRendered = true;
    }


    protected Activity getActivity() {
        return this;
    }

    protected Context getContext() {
        return getApplicationContext();
    }

    public void showToast(final String message) {
        Log.i(TAG, "ToastMessage has been sent");
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showToast(int resourceId) {
        this.showToast(this.getString(resourceId));
    }

    @Override
    public void hideKeyboard() {
        Log.i(TAG, "Keyboard has been closed");
        UtilsKeyboard.hideSoftKeyboard(getActivity());
    }

    @Override
    public void closeActivity() {
        finish();
    }


    public abstract void initPresenter();
    public abstract void onAsynchronousLoad();
}
