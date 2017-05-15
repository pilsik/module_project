package by.IvkoS.jms.receivers;

import by.IvkoS.domain.converters.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JmsConvertEmployerReceiver extends JmsConvertReceiver  {

    @Autowired
    @Qualifier("employerConverter")
    private Converter converter;

    @Override
    protected Converter getConverter() {
        return converter;
    }
}
