package by.IvkoS.database.dao.catalogs;

import by.IvkoS.database.dao.GenericDao;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoCatalog<T, PK extends Serializable> extends GenericDao<T, PK> {

    int importCatalogToDB(List<T> list);

    List getListSatisfyString(String part);
}
