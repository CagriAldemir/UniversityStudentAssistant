package tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models;

import java.util.List;

public interface BaseModel <M> {

    boolean save();

    int update();

    boolean check();

    void getByID();

    boolean delete();

    List<M> getAllByID(String where, String[] args);
}
