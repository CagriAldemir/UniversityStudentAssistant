package tr.com.cagrialdemir.universitystudentassistant.Core.Data.repository;


import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Ders;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Devamsizlik;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Donem;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Hatirlatma;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Odev;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Sinav;

public interface ProjectRepository {

    boolean saveDers(Ders ders);

    int updateDers(Ders ders);

    boolean checkDers(Ders ders);

    Ders getDersByID(int id);

    boolean deleteDers(Ders ders);
    //---------------------------------

    boolean saveDonem(Donem donem);

    int updateDonem(Donem donem);

    boolean checkDonem(Donem donem);

    Ders getDonemByID(int id);

    boolean deleteDonem(Donem donem);
    //---------------------------------

    boolean saveDevamsizlik(Devamsizlik devamsizlik);

    int updateDevamsizlik(Devamsizlik devamsizlik);

    boolean checkDevamsizlik(Devamsizlik devamsizlik);

    Devamsizlik getDevamsizlikByID(int id);

    boolean deleteDevamsizlik(Devamsizlik devamsizlik);
    //---------------------------------

    boolean saveHatirlatma(Hatirlatma hatirlatma);

    int updateHatirlatma(Hatirlatma hatirlatma);

    boolean checkHatirlatma(Hatirlatma hatirlatma);

    Hatirlatma getHatirlatmaByID(int id);

    boolean deleteHatirlatma(Hatirlatma hatirlatma);
    //---------------------------------

    boolean saveOdev(Odev odev);

    int updateOdev(Odev odev);

    boolean checkOdev(Odev odev);

    Odev getOdevByID(int id);

    boolean deleteOdev(Odev odev);
    //---------------------------------

    boolean saveSinav(Sinav sinav);

    int updateSinav(Sinav sinav);

    boolean checkSinav(Sinav sinav);

    Sinav getSinavByID(int id);

    boolean deleteSinav(Sinav sinav);
}
