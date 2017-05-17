package by.IvkoS.web.controllers;

import by.IvkoS.database.models.employers.Employer;
import by.IvkoS.database.services.EmployerService;
import by.IvkoS.database.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @Autowired
    PositionService positionService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String getEmployer(@PathVariable("id") Integer id, ModelMap modelMap) {
        Employer employer = employerService.getEmployerById(id);
        List positionsList = positionService.getPositionList();
        modelMap.addAttribute("employer", employer);
        modelMap.addAttribute("positionsList", positionsList);
        return "singleEmployer";
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public String updateEmployer(@PathVariable("id") Integer id, Employer employer) {
        employerService.updateEmployer(employer);
        return "redirect:/employer/id/" + employer.getIdEmployer();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public String deleteEmployer(@PathVariable("id") Integer id) {
        employerService.removeEmployerById(id);
        return "redirect:/viewListEmployer";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createEmployer(ModelMap modelMap) {
        Employer employer = new Employer();
        List positionsList = positionService.getPositionList();
        modelMap.addAttribute("employer", employer);
        modelMap.addAttribute("positionsList", positionsList);
        return "singleEmployer";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addEmployer(Employer employer) {
        System.out.println(employer.getIdEmployer());
        employer = employerService.addEmployer(employer);
        System.out.println(employer.getIdEmployer());
        return "redirect:/employer/id/" + employer.getIdEmployer();
    }

}
