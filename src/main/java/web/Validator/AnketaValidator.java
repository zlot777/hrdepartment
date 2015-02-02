package web.Validator;

import dataLevel.entity.AnketaEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Администратор on 26.01.2015.
 */
@Component
public class AnketaValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return AnketaEntity.class.isAssignableFrom(aClass);
    }

    public static final Date startDate;

    static {
        Calendar cal = Calendar.getInstance();
        cal.set(1900, Calendar.JANUARY, 1);
        Date date = cal.getTime();
        startDate = date;
    }


    @Override
    public void validate(Object object, Errors errors) {
        AnketaEntity anketa = (AnketaEntity) object;
        if(anketa.getSalary() == 0){
        errors.rejectValue("salary", "salary.NotZero", "value must be more than 0");
        }
        if(!anketa.getFirstName().isEmpty()) {
            if (anketa.getFirstName().trim().matches("[a-zA-Za-яА-Я]+") == false) {
                errors.rejectValue("firstName", "firstName.onlyLetter", "firstName must consist with only letter");}
        } else{
            errors.rejectValue("firstName", "firstName.empty", "firstName must not empty");}
        if(!anketa.getLastName().isEmpty()) {
            if (anketa.getLastName().trim().matches("[a-zA-Za-яА-Я]+") == false) {
                errors.rejectValue("lastName", "firstName.onlyLetter", "lastName must consist with only letter");}
        } else{
            errors.rejectValue("lastName", "lastName.empty", "lastName must not empty!");}
        Date end = new Date(System.currentTimeMillis());
        if(anketa.getBirthDay() != null){
        if(anketa.getBirthDay().before(startDate) || anketa.getBirthDay().after(end)){
            errors.rejectValue("birthDay", "birthDay.onlyLetter", "Birth date must be between 1900 and currentDate;");}
        }
        else {errors.rejectValue("birthDay","birthDay.empty", "Date can't be null");}
    }


}
