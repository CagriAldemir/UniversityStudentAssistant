package tr.com.cagrialdemir.universitystudentassistant.UI.Activity.MainActivity;

import android.os.Bundle;

import com.amitshekhar.DebugDB;

import tr.com.cagrialdemir.universitystudentassistant.BaseMVP.BaseActivity;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models.Ders;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models.Devamsizlik;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models.Donem;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models.Hatirlatma;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models.Odev;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models.Sinav;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.SQLiteHelper;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.MyLog;
import tr.com.cagrialdemir.universitystudentassistant.R;

public class MainActivity extends BaseActivity implements MainView {

    protected final String TAG = this.getClass().getSimpleName();
    private MainPresenter presenter;
    SQLiteHelper mSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyLog.i(TAG, "DB Log IP Adress", DebugDB.getAddressLog());
        mSQLiteHelper = new SQLiteHelper(this);
        mSQLiteHelper.getWritableDatabase();

        testRun();
    }

    private void testRun() {

//        boolean save();
//        int update();
//        +++++boolean check();
//        void getByID();
//        boolean delete();
//        List<M> getAllByID(String where, String[] args);

        Ders mDers = new Ders(mSQLiteHelper);
        Devamsizlik mDevamsizlik = new Devamsizlik(mSQLiteHelper);
        Donem mDonem = new Donem(mSQLiteHelper);
        Hatirlatma mHatirlatma = new Hatirlatma(mSQLiteHelper);
        Odev mOdev = new Odev(mSQLiteHelper);
        Sinav mSinav = new Sinav(mSQLiteHelper);


        mDers.setDersID(1);
        mDers.getByID();
        mDers.setDersID(3);
        mDers.getByID();
        mDers.setDersID(4);
        mDers.getByID();

        mDevamsizlik.setDevamsizlikID(1);
        mDevamsizlik.getByID();
        mDevamsizlik.setDevamsizlikID(3);
        mDevamsizlik.getByID();
        mDevamsizlik.setDevamsizlikID(4);
        mDevamsizlik.getByID();

        mDonem.setDonemID(1);
        mDonem.getByID();
        mDonem.setDonemID(3);
        mDonem.getByID();
        mDonem.setDonemID(4);
        mDonem.getByID();




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
