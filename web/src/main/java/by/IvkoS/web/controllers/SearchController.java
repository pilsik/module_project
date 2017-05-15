package by.IvkoS.web.controllers;

import by.IvkoS.database.services.EmployerService;
import by.IvkoS.database.services.TreeBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    EmployerService employerService;

    @Autowired
    TreeBranchService treeBranchService;

    @RequestMapping(method = RequestMethod.GET)
    public String showSearchUserView() {
        return "search";
    }


    @RequestMapping(method = RequestMethod.POST, params = "employer")
    @ResponseBody
    public List searchRequestClient(@RequestParam String textStartsWith) {
        List employerList = employerService.getListSatisfyString(textStartsWith);
        return employerList;
    }

    @RequestMapping(method = RequestMethod.POST, params = "tree")
    @ResponseBody
    public List searchRequestTree(@RequestParam String textStartsWith) {
        List listBranches = treeBranchService.getListSatisfyString(textStartsWith);
        return listBranches;
    }
}
