package by.IvkoS.database.services;


import by.IvkoS.database.models.employers.Employer;

import java.util.List;

public interface EmployerService {

    Employer addEmployer(Employer employer);

    Employer getEmployerById(int id);

    Employer findEmployerByName(String name);

    Employer removeEmployer(Employer employer);

    Employer updateEmployer(Employer employer);

    List<Employer> getEmployerList();

    Employer removeEmployerById(int id);

    void addEmployerList (List<Employer> list);

    List getListSatisfyString(String part);
}
