package by.IvkoS.web.controllers;

import by.IvkoS.jms.consumers.CatalogJmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/convert")
public class ConvertController {

    static private final Logger log = (Logger) LoggerFactory.getLogger(ConvertController.class);

    @Autowired
    CatalogJmsSender catalogJmsSender;

    @RequestMapping(method = RequestMethod.GET)
    public String showConvertPage() {
        return "convert";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String convertFile(@RequestParam MultipartFile file,
                              @RequestHeader String extensionConvert,
                              @RequestHeader String type,
                              HttpServletRequest request) throws IOException {
        String phyPath = request.getSession().getServletContext().getRealPath("/");
        String filepath = phyPath+"file" + File.separator;
        int nameLength = file.getOriginalFilename().length();
        String extension = file.getOriginalFilename().substring(nameLength - 3);
        catalogJmsSender.sendMessages(file.getInputStream(), extension, extensionConvert, type, filepath);
        return "./files/";
    }

    /* String phyPath = request.getSession().getServletContext().getRealPath("/");
        String filepath = phyPath + "files/";
     if (fileNameProp.equals("xls")) {
            downloadFile = xslConverter.convertFile(file, filepath);
        } else{
            downloadFile = csvConverter.convertFile(file, filepath);
        }*/
    //return "./files/" + downloadFile;
}
