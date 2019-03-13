package tr.com.cagrialdemir.universitystudentassistant.BaseMVP;

import android.app.Activity;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.repository.ProjectRepository;

public abstract class BasePresenter<V extends BaseView, R extends ProjectRepository> implements Presenter<V, R> {
    public String TAG = this.getClass().getSimpleName();
    private V view;
    private R repository;
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
    public void attachRepository(R repository) {
        this.repository = repository;
    }

    @Override
    public void detachRepository() {
        repository = null;
    }

    @Override
    public void detachAll() {
        detachView();
        detachRepository();
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

    public R getRepository() {
        return repository;
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(view) before" +
                    " requesting data to the Presenter");
        }
    }
}
