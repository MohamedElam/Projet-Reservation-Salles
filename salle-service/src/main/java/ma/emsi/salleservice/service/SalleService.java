package ma.emsi.salleservice.service;

import ma.emsi.salleservice.bean.Salle;
import ma.emsi.salleservice.dao.SalleDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {

    private SalleDao salleDao;

    public SalleService(SalleDao salleDao) {
        this.salleDao = salleDao;
    }

    public List<Salle> findAll() {
        return salleDao.findAll();
    }

    public Salle save(Salle entity) {
        return salleDao.save(entity);
    }

    public Optional<Salle> findById(Long aLong) {
        return salleDao.findById(aLong);
    }

    public void deleteById(Long aLong) {
        salleDao.deleteById(aLong);
    }
}
