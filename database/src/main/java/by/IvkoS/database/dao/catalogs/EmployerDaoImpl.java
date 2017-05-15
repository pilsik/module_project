package by.IvkoS.database.dao.catalogs;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import by.IvkoS.database.models.employers.Employer;

import java.util.List;

@Repository
public class EmployerDaoImpl extends GenericDaoCatalogImpl<Employer, Integer> implements EmployerDao {

    private final int INDEX_FIRST_EMPLOYER_AT_LIST = 0;

    @Override
    public Employer findByName(String firstName) {
        List<Employer> employer = (List<Employer>) super.hibernateTemplate
                .findByNamedParam("from Employer as emp where emp.firstName=:firstName", "firstName", new Object[]{firstName});
        return (employer.size() != 0) ? employer.get(INDEX_FIRST_EMPLOYER_AT_LIST) : Employer.EMPTY_EMPLOYER;
    }

    @Override
    public List getListSatisfyString(String part) {
        Session session = super.hibernateTemplate.getSessionFactory().openSession();
        part = part + "%";
        List results;
        results = session.createCriteria(Employer.class, "employer")
                .add(Restrictions.like("employer.lastName", part, MatchMode.ANYWHERE))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("employer.lastName"), "employerLastName")
                        .add(Projections.property("employer.idEmployer"), "employerIdClient")
                )
                .list();
        return convertToPairList(results);
    }
}
