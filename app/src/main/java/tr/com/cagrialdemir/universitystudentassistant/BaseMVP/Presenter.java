package tr.com.cagrialdemir.universitystudentassistant.BaseMVP;

/**
 * Created by barisatalay on 21.02.2019.
 */
public interface Presenter<V extends BaseView> {
    void attachView(V mvpView);

    void detachView();

    void detachAll();
}
