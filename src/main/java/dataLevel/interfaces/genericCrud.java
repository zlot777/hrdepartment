package dataLevel.interfaces;

import java.util.List;

/**
 * Created by Администратор on 22.01.2015.
 */
public interface genericCrud<T> {
      public List<T> findAll();
      public  T findById(int id);
      public void insert (T entity);
      public void update(T entity);
      public void delete(int id);
}
