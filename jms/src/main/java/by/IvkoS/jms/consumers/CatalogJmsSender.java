package by.IvkoS.jms.consumers;

import javax.jms.*;

import by.IvkoS.jms.receivers.JmsConvertTreeBranchReceiver;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


import java.io.*;
import java.nio.file.Files;

@Service
public class CatalogJmsSender {

    private static final Logger logger = LoggerFactory.getLogger(CatalogJmsSender.class);

    @Autowired
    protected JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("convertDestinationEmployer")
    protected Destination convertDestinationEmployer;

    @Autowired
    @Qualifier("convertDestinationTreeBranch")
    protected Destination convertDestinationTreeBranch;


    public void sendMessages(InputStream inputStream, String extension, String extensionConvert, String type, String filepath) {
        if (type.equals("tree")) {
            this.jmsTemplate.setDefaultDestination(convertDestinationTreeBranch);
            logger.warn("выбрана очередь для tree");
        } else if (type.equals("employer")) {
            this.jmsTemplate.setDefaultDestination(convertDestinationEmployer);
            logger.warn("выбрана очередь для employer");
        }
        this.jmsTemplate.send(session -> {
            BytesMessage message = session.createBytesMessage();
            try {
                byte[] bytes = IOUtils.toByteArray(inputStream);
                message.writeBytes(bytes);
                message.setStringProperty("extension", extension);
                message.setStringProperty("extensionConvert", extensionConvert);
                message.setStringProperty("filepath", filepath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return message;
        });
    }
}

