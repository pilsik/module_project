package by.IvkoS.database.services;

import by.IvkoS.database.models.employers.Position;

import java.util.List;

public interface PositionService {
    
    Position addPosition(Position position);

    Position getPositionById(int id);

    Position findPositionByName(String positionName);

    Position removePosition(Position position);

    Position updatePosition(Position position);

    List<Position> getPositionList();

    Position removePositionById(int id);

}
