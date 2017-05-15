package by.IvkoS.web.controllers;

import by.IvkoS.domain.uploaders.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController {

    static private final Logger log = (Logger) LoggerFactory.getLogger(ImportController.class);

    @Autowired
    @Qualifier("employerUploader")
    Uploader employerUploader;

    @Autowired
    @Qualifier("treeBranchUploader")
    Uploader treeBranchUploader;

    @RequestMapping(method = RequestMethod.GET)
    public String showAndDeleteImport(@RequestParam(value = "clear", required = false) Integer clear) {
        return "importCatalogs";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String importTables(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        try {
            log.info("Импорт в таблицу");
            String first =request.getHeader("type").toString();
            if(first.equals("employer")) {
                employerUploader.uploadCatalogToDB(file.getInputStream(), getExtansion(file.getOriginalFilename()));
            } else if (first.equals("tree")) {
                treeBranchUploader.uploadCatalogToDB(file.getInputStream(), getExtansion(file.getOriginalFilename()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    private String getExtansion(String fileName) {
        int fileNameLength = fileName.length();
        return fileName.substring(fileNameLength - 3, fileNameLength);
    }
}

