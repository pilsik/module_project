package by.IvkoS.database.dao.catalogs;

import by.IvkoS.database.dao.GenericDaoJpaImpl;
import javafx.util.Pair;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class GenericDaoCatalogImpl<T, PK extends Serializable> extends GenericDaoJpaImpl<T, PK> implements GenericDaoCatalog<T, PK> {

    @Override
    @Transactional
    public int importCatalogToDB(List<T> list) {
        for (T entity : list) {
            super.hibernateTemplate.merge(entity);
        }
        return 0;
    }

    @Override
    public abstract List getListSatisfyString(String part);

    protected List<Pair> convertToPairList(List<Object[]> queryList) {
        List<Pair> listPair = new ArrayList<>();
        Iterator<Object[]> iterator = queryList.iterator();
        while (iterator.hasNext()) {
            Object[] item = iterator.next();
            listPair.add(new Pair(item[0], item[1]));
        }
        return listPair;
    }

}
