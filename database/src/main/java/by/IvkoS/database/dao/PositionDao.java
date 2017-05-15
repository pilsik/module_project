package by.IvkoS.database.dao;

import by.IvkoS.database.models.employers.Position;

public interface PositionDao extends GenericDao<Position,Integer>{

     Position findPositionByName(String name);

}
