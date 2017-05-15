package by.IvkoS.domain.readers;

import by.IvkoS.database.models.employers.Position;
import by.IvkoS.database.services.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public abstract class EmployerReader {

    private static final Logger logger = LoggerFactory.getLogger(EmployerReader.class);

    @Autowired
    PositionService positionService;

    protected Set<Position> getPositionFromCell(String positions, String REGEX) {
        String[] positionsArray = positions.split(REGEX);
        List<Position> positionsBDList = positionService.getPositionList();
        Set<Position> positionSetEmployer = new HashSet<>();
        for (String namePosition : positionsArray) {
            boolean findPositionInDB = false;
            for (Position positionDB : positionsBDList) {
                if (namePosition.trim().equals(positionDB.getPositionName())) {
                    positionSetEmployer.add(positionDB);
                    findPositionInDB = true;
                    break;
                }
            }
            if(!findPositionInDB){
                logger.warn(String.format("В базе не найдено профессия с именем %s",namePosition));
            }
        }
        return positionSetEmployer;
    }

}
