package by.IvkoS.database.services;

import by.IvkoS.database.dao.catalogs.EmployerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.IvkoS.database.models.employers.Employer;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private static final Logger logger = LoggerFactory.getLogger(EmployerServiceImpl.class);

    @Autowired
    private EmployerDao employerDao;

    @Override
    public Employer addEmployer(Employer employer) {
        return this.employerDao.create(employer);
    }

    @Override
    public Employer getEmployerById(int id) {
        return this.employerDao.readById(id);
    }

    @Override
    public Employer findEmployerByName(String name) {
        return this.employerDao.findByName(name);
    }

    @Override
    public Employer removeEmployer(Employer employer) {
        return this.employerDao.delete(employer);
    }

    @Override
    public Employer updateEmployer(Employer employer) {
        return this.employerDao.update(employer);
    }

    @Override
    public List<Employer> getEmployerList() {
        return this.employerDao.readList();
    }

    @Override
    public Employer removeEmployerById(int id) {
        return this.employerDao.deleteById(id);
    }

    @Override
    public void addEmployerList(List<Employer> list) {
        this.employerDao.importCatalogToDB(list);
    }

    @Override
    public List getListSatisfyString(String part) {
        return this.employerDao.getListSatisfyString(part);
    }
}
