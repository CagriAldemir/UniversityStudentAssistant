package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;

public interface BaseModel {

    boolean save();

    int update();

    boolean check();

    void getByID();

    boolean delete();
}
