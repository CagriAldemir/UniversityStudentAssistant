package tr.com.cagrialdemir.universitystudentassistant.UI.Activity.MainActivity;

import android.os.Bundle;

import tr.com.cagrialdemir.universitystudentassistant.BaseMVP.BaseActivity;
import tr.com.cagrialdemir.universitystudentassistant.R;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.attachView(this);
    }

    @Override
    public void onAsynchronousLoad() {

    }

    @Override
    public void loadUserName(String userName) {

    }
}
