package web.controller;

import dataLevel.entity.AnketaEntity;
import dataLevel.realizationDAO.AnketaDao;
import logic.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Администратор on 24.01.2015.
 */

@Controller

public class MainController {
    @Autowired
    private AnketaDao anketaDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
        public String index (Model model){
            List<AnketaEntity> list = anketaDao.findByPage(1);
            model.addAttribute("lists", list);
            Integer size = ((anketaDao.findAll().size()-1)/20)+1;
            model.addAttribute("listSize", size);
            model.addAttribute("criteria", new String());
            return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam("criteria") String criteria, Model model){
        String request = Search.replace(criteria);
        if(!request.equals("")) {
            List<AnketaEntity> list = anketaDao.findByCreteria(request);
            model.addAttribute("lists", list);
            System.out.println(list);
        }
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/worker", method = RequestMethod.GET)
    public ModelAndView worker (HttpServletResponse response) {
        Cookie cookie = new Cookie("role", "worker");
        response.addCookie(cookie);
        return new ModelAndView("redirect:index.html");
    }

    @RequestMapping(value = "/hr", method = RequestMethod.GET)
    public ModelAndView hr(HttpServletResponse response) {
        Cookie cookie = new Cookie("role", "hr");
        response.addCookie(cookie);
        return new ModelAndView("redirect:index.html");
    }







}
