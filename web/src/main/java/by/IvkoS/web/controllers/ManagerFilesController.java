package by.IvkoS.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/managerFiles")
public class ManagerFilesController {

    @RequestMapping(method = RequestMethod.GET, params = "nameFile")
    @ResponseBody
    public Boolean deleteFile(@RequestParam String nameFile, HttpServletRequest request) {
        String phyPath = request.getSession().getServletContext().getRealPath("/");
        String filePath = phyPath + "file/" + nameFile;
        File filesConvert = new File(filePath);
        return filesConvert.delete();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showFilesManager(Model model, HttpServletRequest request) {
        String phyPath = request.getSession().getServletContext().getRealPath("/");
        String filesPath = phyPath + "file/";
        List<String> listFiles = this.getListNameFiles(filesPath);
        model.addAttribute("listFiles", listFiles);
        return "managerFiles";
    }

    private List getListNameFiles(String filesPath) {
        List<String> listNameFiles = new ArrayList<>();
        File folderWithXMlFiles = new File(filesPath);
        File[] listOfXMLFiles = folderWithXMlFiles.listFiles();
        if (listOfXMLFiles != null) {
            for (File file : listOfXMLFiles) {
                if (file.isFile() && (file.getName().contains(".xml") || file.getName().contains(".json")) ) {
                    listNameFiles.add(file.getName());
                }
            }
        }
        return listNameFiles;
    }


}
