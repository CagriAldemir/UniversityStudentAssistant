package tr.com.cagrialdemir.universitystudentassistant.UI.Activity.MainActivity;


import tr.com.cagrialdemir.universitystudentassistant.BaseMVP.BaseView;

/**
 * Created by barisatalay on 21.02.2019.
 */
public interface MainView extends BaseView {
    void loadDonem(String userName);
}
