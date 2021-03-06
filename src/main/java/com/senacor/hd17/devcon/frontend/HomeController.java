package com.senacor.hd17.devcon.frontend;


import com.senacor.hd17.devcon.repositories.TalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    private TalkRepository talksRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model) {

        model.addAttribute("talks", talksRepo.findAll());

        return "home";
    }
}
