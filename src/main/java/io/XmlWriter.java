package io;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.FullInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class XmlWriter {

    private static final Logger logger = LoggerFactory.getLogger(XlsWriter.class.getName());

    private XmlWriter() {
    }

    public static void generateXmlReq(FullInfo fullInfo) {

        try {
            logger.info("XML marshalling started");

            //получаем контекст (связываем jaxb с классом, по объектам которого нужно строить xml  конструкции
            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);

            //создаем маршаллер, хрень которая и занимается сериализации джава объектов
            Marshaller marshaller = jaxbContext.createMarshaller();
            //устанавливаем форматированный ввод
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //пробоуем создать файл, если он уже есть пишим в лог
            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.info("Directory created successfully");
            } catch (IOException ioEx) {
                logger.trace("Directory already created", ioEx);
            }
            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");
            //создаём xml файл, на вход функции получает, связанный с контекстом класс
            // и classpath места куда необходимо записать данные
            marshaller.marshal(fullInfo, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.warn( "XML marshalling failed", jaxbEx);
            return;
        }

        logger.info("XML marshalling finished successfully");
    }
}