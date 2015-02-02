package dataLevel.interfaces;

import dataLevel.entity.DepartmentEntity;

import java.util.List;

/**
 * Created by Администратор on 29.01.2015.
 */
public interface DepartmentInterface {
    DepartmentEntity findByName(String name);
    List<String> getAllName();
}
