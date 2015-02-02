package web.controller;

import dataLevel.entity.AnketaEntity;
import dataLevel.realizationDAO.AnketaDao;
import dataLevel.realizationDAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.Validator.AnketaValidator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Администратор on 30.01.2015.
 */
@Controller
@RequestMapping("edit-id={id}")
public class EditAnketa {
    @Autowired
    AnketaDao dao;
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    private AnketaValidator anketaValidator;

     @InitBinder
     public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }

     @RequestMapping(method = RequestMethod.GET)
     public ModelAndView edit(@CookieValue(value = "role", defaultValue = "worker") String role,
                              @PathVariable Integer id, Model model){
         if(role.equals("hr")) {
             AnketaEntity entity = dao.findById(id);
             model.addAttribute("currentAnket", entity);
             model.addAttribute("departmentList", departmentDao.findAll());
             return new ModelAndView("editAnketa");
         }
         return new ModelAndView("redirect:index.html");
   }



    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("currentAnket") AnketaEntity currentAnket, BindingResult result, Model model){
    anketaValidator.validate(currentAnket, result);
    if(result.hasErrors()){
        model.addAttribute("departmentList", departmentDao.findAll());
        return new ModelAndView("editAnketa");
    }
    dao.update(currentAnket);
    return new ModelAndView("redirect:index.html");
}

}
