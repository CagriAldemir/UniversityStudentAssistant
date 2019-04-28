package tr.com.cagrialdemir.universitystudentassistant.UI.Activity.AddDersActivity;

import android.os.Bundle;

import tr.com.cagrialdemir.universitystudentassistant.BaseMVP.BaseActivity;
import tr.com.cagrialdemir.universitystudentassistant.R;

public class AddDersActivity extends BaseActivity implements AddDersView {

    AddDersPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ders);
    }

    @Override
    public void initPresenter() {
        presenter = new AddDersPresenter(this);
        presenter.attachView(this);
    }

    @Override
    public void onAsynchronousLoad() {

    }

    @Override
    public void initViews() {

    }
}
