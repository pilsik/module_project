package by.IvkoS.web.controllers;

import by.IvkoS.database.models.clients.Address;
import by.IvkoS.database.models.clients.User;
import by.IvkoS.database.models.clients.security.UserProfile;
import by.IvkoS.database.services.UserProfileService;
import by.IvkoS.database.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    protected final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.getAllList();
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index() {
        logger.info("Returning index view");
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String fromLoginIndex() {
        logger.info("Post redirect get");
        return "redirect:/home";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        User user = new User();
        Address address = new Address();
        model.addAttribute("user", user);
        model.addAttribute("address", address);
        return "newUser";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(User user,
                                   BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "redirect:/newUser";
        }
        logger.info("Save client:" + user.toString());
        userService.addUser(user);
        model.addAttribute("success", "User " + user.getLogin() + " has been registered successfully");
        return "registrationsuccess";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.GET)
    public String addAddress(ModelMap model) {
        Address address = new Address();
        model.addAttribute("address", address);
        return "addAddress";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String saveAddress(Address address, Principal principal) {
        String login = principal.getName();
        User user = userService.findUserByLogin(login);
        user.getAddressSet().add(address);
        userService.updateUser(user);
        return "redirect:/addAddress";
    }
}
