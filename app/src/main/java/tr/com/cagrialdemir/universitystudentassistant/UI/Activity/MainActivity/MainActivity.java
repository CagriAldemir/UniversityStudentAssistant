package tr.com.cagrialdemir.universitystudentassistant.UI.Activity.MainActivity;

import android.os.Bundle;

import java.util.Calendar;

import tr.com.cagrialdemir.universitystudentassistant.BaseMVP.BaseActivity;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.SQLiteHelper;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Ders;
import tr.com.cagrialdemir.universitystudentassistant.R;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter presenter;
    SQLiteHelper mSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSQLiteHelper = new SQLiteHelper(this);

        Ders mDers = new Ders(mSQLiteHelper, "Matematik", 5, Calendar.getInstance().getTime(), 10, "CEN123", 15, "R2 301", 1);
        boolean x = mDers.save();

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
    public void initViews() {

    }
}
