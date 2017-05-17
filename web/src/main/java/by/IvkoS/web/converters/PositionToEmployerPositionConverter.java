package by.IvkoS.web.converters;

import by.IvkoS.database.models.employers.Position;
import by.IvkoS.database.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PositionToEmployerPositionConverter  implements Converter<Object, Position>{

    @Autowired
    PositionService positionService;

    @Override
    public Position convert(Object o) {
        Integer id = Integer.parseInt((String) o);
        Position position = positionService.getPositionById(id);
        System.out.println("Profile PositionToEmployerPositionConverter : " + position);
        return position;
    }
}
