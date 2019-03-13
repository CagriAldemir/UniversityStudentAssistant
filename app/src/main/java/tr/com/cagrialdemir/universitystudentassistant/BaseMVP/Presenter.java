package tr.com.cagrialdemir.universitystudentassistant.BaseMVP;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.repository.ProjectRepository;

/**
 * Created by barisatalay on 21.02.2019.
 */
public interface Presenter<V extends BaseView, R extends ProjectRepository> {
    void attachView(V mvpView);

    void detachView();

    void attachRepository(R repository);

    void detachRepository();

    void detachAll();
}
