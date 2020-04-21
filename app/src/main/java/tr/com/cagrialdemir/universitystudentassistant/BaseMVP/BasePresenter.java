package tr.com.cagrialdemir.universitystudentassistant.BaseMVP;

import android.app.Activity;

public abstract class BasePresenter<V extends BaseView> implements Presenter<V> {
    public String TAG = this.getClass().getSimpleName();
    private V view;
    private Activity mActivity;


    public BasePresenter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void detachAll() {
        detachView();
    }

    public Activity getActivity() {
        return mActivity;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public V getView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(view) before" +
                    " requesting data to the Presenter");
        }
    }
}
