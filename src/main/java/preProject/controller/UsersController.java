package preProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import preProject.model.User;
import preProject.service.UserService;
import preProject.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping()
public class UsersController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView allUser() {
        List<User> users = userService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showUsers");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updatePage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/update/update", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        userService.update(user);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getById(id);
        modelAndView.setViewName("deletePage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/delete", method = RequestMethod.POST)
    public ModelAndView deleteUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        userService.update(user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        userService.add(user);
        return modelAndView;
    }
}