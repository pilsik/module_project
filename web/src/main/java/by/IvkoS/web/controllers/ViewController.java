package by.IvkoS.web.controllers;

import by.IvkoS.database.services.EmployerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import by.IvkoS.database.models.tree.TreeCreator;

@Controller
public class ViewController {

    static private final Logger log = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    EmployerService employerService;

    @Autowired
    TreeCreator treeNode;

    @RequestMapping(value = "/viewListEmployer", method = RequestMethod.GET)
    public String showList(Model model) {
        model.addAttribute("data", employerService.getEmployerList());
        return "viewListEmployer";
    }

    @RequestMapping(value = "/viewTree", method = RequestMethod.GET)
    public String showTree(Model model) {
        String tree = treeNode.createTree();
        model.addAttribute("tree", tree);
        return "viewTree";
    }

    @RequestMapping(value = "/viewListEmployer", method = RequestMethod.GET, params = "index")
    public String searchAndShowListClient(@RequestParam(required = false) final Integer index, Model model) {
        if (index != null) {
            model.addAttribute("index", index);
        }
        model.addAttribute("data", employerService.getEmployerList());
        return "viewListEmployer";
    }

    @RequestMapping(value = "/viewTree", method = RequestMethod.GET, params = "index")
    public String searchAndShowTree(@RequestParam(required = false) final Integer index, Model model) {
        if (index != null) {
            model.addAttribute("index", "\"" + index + "\"");
        }
        String tree = treeNode.createTree();
        model.addAttribute("tree", tree);
        return "viewTree";
    }

}
