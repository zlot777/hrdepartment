package dataLevel.interfaces;

import dataLevel.entity.AnketaEntity;

import java.util.List;

/**
 * Created by Администратор on 25.01.2015.
 */
public interface AnketaInterface {
    List<AnketaEntity> findByPage (int page);
    List<AnketaEntity> findByCreteria (String searchString);
}
