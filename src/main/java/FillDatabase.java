import dataLevel.entity.AnketaEntity;
import dataLevel.entity.DepartmentEntity;
import dataLevel.realizationDAO.AnketaDao;
import dataLevel.realizationDAO.DepartmentDao;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Администратор on 22.01.2015.
 */
public class FillDatabase {
    public static void main(String [] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("database/Spring-Data.xml");
        ctx.refresh();
        AnketaDao daoAnket = ctx.getBean("anketaDAO", AnketaDao.class);

        DepartmentDao daoDepart = ctx.getBean("departmentDAO", DepartmentDao.class);
        for (DepartmentEntity d:generateDepartment()){
            daoDepart.insert(d);
        }
        for (AnketaEntity a:generateRecords()){
            daoAnket.insert(a);
        }


    }

    public static List<AnketaEntity> generateRecords() {
           List<AnketaEntity> list = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("D:\\Search job\\test2\\src\\main\\java\\BasicInfo.txt"));
            String line = br.readLine();
            String[] nameArray = line.split(",");
            System.out.println(nameArray.length + " " + Arrays.toString(nameArray));
            String surnameLine = br.readLine();
            String[] surnameArray = surnameLine.split(",");
            System.out.println(surnameArray.length + " " + Arrays.toString(surnameArray));
            list = new ArrayList<>();
            for (int i = 0; i < nameArray.length-18; i++) {
                for(int j = 0; j < surnameArray.length-18; j++){
                  double salary = Math.round(((Math.random()*10)*100+3000)*100)/100;
                    int day = (int) (Math.random()*26 +1);
                    int month = (int) (Math.random()*11 +1);
                    int year = (int) (Math.random()*60+50);
                    Date date = new Date(year, month ,day);
                    int department = (int) Math.random()*4+1;
                    list.add(new AnketaEntity(nameArray[i], surnameArray[j], salary, date, 1));
                }
            }
            for(AnketaEntity es:list){
                System.out.println(es);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       return list;

    }

    public static List<DepartmentEntity> generateDepartment(){
        List<DepartmentEntity> list = new ArrayList<>();
        list.add(new DepartmentEntity("PR","PR department"));
        list.add(new DepartmentEntity("PM","PM department"));
        list.add(new DepartmentEntity("Sales","Sales department"));
        list.add(new DepartmentEntity("Security","Security department"));
        list.add(new DepartmentEntity("Developer","Developer department"));
        return list;
    }
}

