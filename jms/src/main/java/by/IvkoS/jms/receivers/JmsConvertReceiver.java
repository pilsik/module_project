package by.IvkoS.jms.receivers;

import by.IvkoS.domain.converters.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class JmsConvertReceiver implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(JmsConvertTreeBranchReceiver.class);

    private static final String MESSAGE_PROPERTY_EXTENSION_NAME = "extension";
    private static final String MESSAGE_PROPERTY_EXTENSION_CONVERT_NAME = "extensionConvert";

    public void onMessage(Message message) {
        try {
            logger.info("Конвертирование файла");
            Converter converter =  getConverter();
            String extension = message.getStringProperty(MESSAGE_PROPERTY_EXTENSION_NAME);
            String convertExtension = message.getStringProperty(MESSAGE_PROPERTY_EXTENSION_CONVERT_NAME);
            byte[] data = new byte[(int) ((BytesMessage) message).getBodyLength()];
            ((BytesMessage) message).readBytes(data);
            InputStream inputStream = new ByteArrayInputStream(data);
            if (convertExtension.equals(Converter.JSON_EXTENSION)) {
                converter.convertFileToJSON(inputStream, extension);
            } else if (convertExtension.equals(Converter.XML_EXTENSION)){
                converter.convertFileToXML(inputStream, extension);
            } else {
                logger.warn("Данный формат не поддерживается (ActiveMQ)");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected abstract Converter getConverter();

}
