package tr.com.cagrialdemir.universitystudentassistant.Core.Data.repository;


import tr.com.cagrialdemir.universitystudentassistant.BaseMVP.BaseRepository;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Ders;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Devamsizlik;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Donem;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Hatirlatma;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Odev;
import tr.com.cagrialdemir.universitystudentassistant.Core.Data.model.Sinav;

public class ProjectRepositoryImpl extends BaseRepository implements ProjectRepository {
    @Override
    public boolean saveDers(Ders ders) {
        return false;
    }

    @Override
    public int updateDers(Ders ders) {
        return 0;
    }

    @Override
    public boolean checkDers(Ders ders) {
        return false;
    }

    @Override
    public Ders getDersByID(int id) {
        return null;
    }

    @Override
    public boolean deleteDers(Ders ders) {
        return false;
    }

    @Override
    public boolean saveDonem(Donem donem) {
        return false;
    }

    @Override
    public int updateDonem(Donem donem) {
        return 0;
    }

    @Override
    public boolean checkDonem(Donem donem) {
        return false;
    }

    @Override
    public Ders getDonemByID(int id) {
        return null;
    }

    @Override
    public boolean deleteDonem(Donem donem) {
        return false;
    }

    @Override
    public boolean saveDevamsizlik(Devamsizlik devamsizlik) {
        return false;
    }

    @Override
    public int updateDevamsizlik(Devamsizlik devamsizlik) {
        return 0;
    }

    @Override
    public boolean checkDevamsizlik(Devamsizlik devamsizlik) {
        return false;
    }

    @Override
    public Devamsizlik getDevamsizlikByID(int id) {
        return null;
    }

    @Override
    public boolean deleteDevamsizlik(Devamsizlik devamsizlik) {
        return false;
    }

    @Override
    public boolean saveHatirlatma(Hatirlatma hatirlatma) {
        return false;
    }

    @Override
    public int updateHatirlatma(Hatirlatma hatirlatma) {
        return 0;
    }

    @Override
    public boolean checkHatirlatma(Hatirlatma hatirlatma) {
        return false;
    }

    @Override
    public Hatirlatma getHatirlatmaByID(int id) {
        return null;
    }

    @Override
    public boolean deleteHatirlatma(Hatirlatma hatirlatma) {
        return false;
    }

    @Override
    public boolean saveOdev(Odev odev) {
        return false;
    }

    @Override
    public int updateOdev(Odev odev) {
        return 0;
    }

    @Override
    public boolean checkOdev(Odev odev) {
        return false;
    }

    @Override
    public Odev getOdevByID(int id) {
        return null;
    }

    @Override
    public boolean deleteOdev(Odev odev) {
        return false;
    }

    @Override
    public boolean saveSinav(Sinav sinav) {
        return false;
    }

    @Override
    public int updateSinav(Sinav sinav) {
        return 0;
    }

    @Override
    public boolean checkSinav(Sinav sinav) {
        return false;
    }

    @Override
    public Sinav getSinavByID(int id) {
        return null;
    }

    @Override
    public boolean deleteSinav(Sinav sinav) {
        return false;
    }
}
