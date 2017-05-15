package by.IvkoS.database.dao.catalogs;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import by.IvkoS.database.models.tree.TreeBranch;

import java.util.List;

@Repository
public class TreeBranchDaoImpl extends GenericDaoCatalogImpl<TreeBranch,Integer> implements TreeBranchDao {

    @Override
    public List getListSatisfyString(String part) {
        Session session = super.hibernateTemplate.getSessionFactory().openSession();
        part = part + "%";
        List results;
        results = session.createCriteria(TreeBranch.class, "branch")
                .add(Restrictions.like("branch.text", part, MatchMode.ANYWHERE))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("branch.text"))
                        .add(Projections.property("branch.id"))
                )
                .list();
        return convertToPairList(results);
    }
}
