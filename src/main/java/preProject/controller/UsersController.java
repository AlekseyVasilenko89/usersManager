package preProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import preProject.model.User;
import preProject.service.UserService;

import java.util.List;

@RequestMapping("/")
@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomeUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView loginUsers() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }

    @RequestMapping(value = "/showUsers", method = RequestMethod.GET)
    public ModelAndView allUser(ModelAndView modelAndView) {
        List<User> users = userService.getAll();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("showUsers");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(ModelAndView modelAndView, @PathVariable String id) {
        User user = userService.getById(Integer.parseInt(id));
        modelAndView.setViewName("updatePage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/");
        userService.update(user);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(ModelAndView modelAndView, @PathVariable String id) {
        User user = userService.getById(Integer.parseInt(id));
        modelAndView.setViewName("deletePage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/");
        userService.remove(user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(ModelAndView modelAndView) {
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/");
        userService.add(user);
        return modelAndView;
    }

    @RequestMapping(value = "/forUsers", method = RequestMethod.GET)
    public ModelAndView forUsersPage(ModelAndView modelAndView) {
        modelAndView.setViewName("forUsers");
        return modelAndView;
    }
}