package web.controller;

import dataLevel.entity.DepartmentEntity;
import dataLevel.realizationDAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Администратор on 30.01.2015.
 */
@Controller
@RequestMapping("editdepartment-id={id}")
public class EditDepartment{
    @Autowired
    DepartmentDao departmentDao;

 @RequestMapping(method = RequestMethod.GET)
    public ModelAndView edit(@CookieValue(value = "role", defaultValue = "worker") String role,
                       @PathVariable("id") Integer id, Model model){
     if(role.equals("hr")) {
         DepartmentEntity entity = departmentDao.findById(id);
         System.out.println("lada" + id);
         model.addAttribute("currentDepartment", entity);
         return new ModelAndView("editDepartment");
     }
     return new ModelAndView("redirect:index.html");
 }


}
