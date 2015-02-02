package web.controller;

import dataLevel.entity.AnketaEntity;
import dataLevel.entity.DepartmentEntity;
import dataLevel.realizationDAO.AnketaDao;
import dataLevel.realizationDAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Администратор on 30.01.2015.
 */
@Controller
public class InfoAboutWorker {

    @Autowired
    AnketaDao dao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/id={id}")
    public String end(@PathVariable Integer id, Model model){
        AnketaEntity entity = dao.findById(id);
        model.addAttribute("entity", entity);
        DepartmentEntity department = departmentDao.findById(entity.getDepartment());
        model.addAttribute("department", department.getName());
        System.out.println("lalda");
        return "infoWorker";
    }

}
