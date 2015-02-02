package web.Validator;

import dataLevel.entity.AnketaEntity;
import dataLevel.entity.DepartmentEntity;
import dataLevel.realizationDAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Администратор on 29.01.2015.
 */
public class DepartmentValidator implements Validator {
    @Autowired
    DepartmentDao departmentDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return AnketaEntity.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        DepartmentEntity departmentEntity = (DepartmentEntity) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "name must not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.empty", "description must not be empty.");
        System.out.println();
        if(checkName(departmentEntity.getName())){
            errors.rejectValue("name", "name.notUnique", "Name must be unique.");
        }
    }

    private boolean checkName(String name){
        for(String s:departmentDao.getAllName()){
            if(s.compareToIgnoreCase(name)==0){
                return true;
            }
        }
        return false;
    }
}
