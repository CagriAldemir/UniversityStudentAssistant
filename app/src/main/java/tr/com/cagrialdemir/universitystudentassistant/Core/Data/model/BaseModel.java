package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;

import java.util.List;

public interface BaseModel <M> {

    boolean save();

    int update();

    boolean check();

    void getByID();

    boolean delete();

    List<M> getAllByID(String where, String[] args);
}
