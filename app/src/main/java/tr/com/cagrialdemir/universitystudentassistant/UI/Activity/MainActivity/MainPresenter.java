package tr.com.cagrialdemir.universitystudentassistant.UI.Activity.MainActivity;

import android.app.Activity;
import android.content.Intent;

import tr.com.cagrialdemir.universitystudentassistant.BaseMVP.BasePresenter;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.repository.ProjectRepository;


/**
 * Created by barisatalay on 21.02.2019.
 */
public class MainPresenter extends BasePresenter<MainView, ProjectRepository> {

    public MainPresenter(Activity mActivity) {
        super(mActivity);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1000) {
                if (data.hasExtra("UserName")) {
                    String userName = data.getStringExtra("UserName");

                    if (getView() != null) {
                        getView().loadUserName(userName);
                    }
                }
            }
        }
    }
}
