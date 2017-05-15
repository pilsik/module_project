package by.IvkoS.database.services;

import by.IvkoS.database.dao.PositionDao;
import by.IvkoS.database.models.employers.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private static final Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Autowired
    private PositionDao positionDao;

    @Override
    @Transactional
    public Position addPosition(Position position) {
        return this.positionDao.create(position);
    }

    @Override
    @Transactional
    public Position getPositionById(int id) {
        return this.positionDao.readById(id);
    }

    @Override
    @Transactional
    public Position findPositionByName(String positionName) {
        return this.positionDao.findPositionByName(positionName);
    }

    @Override
    @Transactional
    public Position removePosition(Position position) {
        return this.positionDao.delete(position);
    }

    @Override
    @Transactional
    public Position updatePosition(Position position) {
        return this.positionDao.update(position);
    }

    @Override
    @Transactional
    public List<Position> getPositionList() {
        return this.positionDao.readList();
    }

    @Override
    @Transactional
    public Position removePositionById(int id) {
        return this.positionDao.deleteById(id);
    }
}
