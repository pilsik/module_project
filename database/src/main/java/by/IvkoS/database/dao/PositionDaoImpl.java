package by.IvkoS.database.dao;

import by.IvkoS.database.models.employers.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionDaoImpl extends GenericDaoJpaImpl<Position,Integer> implements PositionDao {

    private final int INDEX_FIRST_POSITION_AT_LIST = 0;

    @Override
    public Position findPositionByName(String positionName){
        List<Position> position = (List<Position>) super.hibernateTemplate
                .findByNamedParam("from Position as position where position.positionName=:positionName", "positionName", new Object[]{positionName});
        return (position.size() != 0) ? position.get(INDEX_FIRST_POSITION_AT_LIST) : Position.EMPTY_POSITION;
    }
}
