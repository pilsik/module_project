package by.IvkoS.domain.readers;

import java.io.InputStream;
import java.util.List;

public interface Reader<T> {

    List<T> readObjects(InputStream inputStream);

}
