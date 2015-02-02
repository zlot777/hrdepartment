package web.controller;

import dataLevel.entity.DepartmentEntity;
import dataLevel.realizationDAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.Validator.DepartmentValidator;

/**
 * Created by Администратор on 29.01.2015.
 */
@Controller
@RequestMapping("/addDepartment")
public class AddDepartment {
    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    DepartmentValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(@CookieValue(value = "role", defaultValue = "worker") String role, Model model){
        if(role.equals("hr")) {
            model.addAttribute("currentDepartment", new DepartmentEntity());
            return new ModelAndView("addDepartment");
        }
        return new ModelAndView("redirect:index.html");
    }





    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView end(@ModelAttribute("currentDepartment") DepartmentEntity currentDepartment, BindingResult result){
     validator.validate(currentDepartment, result);
        if(result.hasErrors()){
            return new ModelAndView("addDepartment");
        }
        departmentDao.insert(currentDepartment);
        return new ModelAndView("redirect:index.html");
    }

}
