package by.IvkoS.database.dao.catalogs;

import by.IvkoS.database.models.employers.Employer;

public interface EmployerDao extends GenericDaoCatalog<Employer,Integer> {
    Employer findByName(String name);
}
