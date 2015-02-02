package web.controller;

import dataLevel.entity.DepartmentEntity;
import dataLevel.realizationDAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Администратор on 30.01.2015.
 */
@Controller
public class GetListOfDepartment {
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/listOfDepartment")
    public ModelAndView getList(@CookieValue(value = "role", defaultValue = "worker") String role,
                          Model model){
        if(role.equals("hr")) {
            List<DepartmentEntity> department = departmentDao.findAll();
            model.addAttribute("lists", department);
            return new ModelAndView("listOfDepartment");
        }
        return new ModelAndView("redirect:index.html");
    }

}
