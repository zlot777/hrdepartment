package dataLevel.realizationDAO;

import dataLevel.entity.AnketaEntity;
import dataLevel.interfaces.AnketaInterface;
import dataLevel.interfaces.genericCrud;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 22.01.2015.
 */
public class AnketaDao implements genericCrud<AnketaEntity>, InitializingBean, AnketaInterface {
    private DataSource  dataSource;
    private JdbcTemplate jdbcTemplate;
    private AnketaInsert anketaInsert;
    private SelectByParametrDao selectByParametr;
    private static final String FIND_ALL_SQL = "SELECT * FROM anketa";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM anketa WHERE id = ?";
    private static final String FIND_BY_PAGE_SQL = "SELECT * FROM anketa WHERE id BETWEEN ? AND ?";
    private static final String DELETE_SQL = "DELETE FROM anketa WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE anketa SET firstName = ?, lastName = ?," +
                                                              "salary = ?, birthDay = ?, " +
                                                              "department = ?, active = ? WHERE id=?";

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        anketaInsert = new AnketaInsert(dataSource);
        selectByParametr = new SelectByParametrDao(dataSource);
        this.dataSource = dataSource;

    }

    public List<AnketaEntity> findByPage(int page){
            return jdbcTemplate.query(FIND_BY_PAGE_SQL,new AnketaMapper(), new Object[]{page, page+9});
    }

    @Override
    public List<AnketaEntity> findAll(){
        return  jdbcTemplate.query(FIND_ALL_SQL, new AnketaMapper());
    }

    @Override
    public AnketaEntity findById(int id){
        AnketaEntity anketaEntity =(AnketaEntity) jdbcTemplate.queryForObject(FIND_BY_ID_SQL, new Object[]{id}, new AnketaMapper());
        return anketaEntity;
    }

    @Override
    public void update (AnketaEntity entity){

        jdbcTemplate.update(UPDATE_SQL, new Object []{ entity.getFirstName(), entity.getLastName(),
                                                entity.getSalary(), entity.getBirthDay(),
                                                entity.getDepartment(), entity.getActive(), entity.getId()});
    }

    @Override
    public void delete(int id){
        jdbcTemplate.update(DELETE_SQL, id);
    }

    @Override
    public void insert(AnketaEntity anketaEntity){
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("firstName", prepareString(anketaEntity.getFirstName()));
        paramMap.put("lastName", prepareString(anketaEntity.getLastName()));
        paramMap.put("salary", anketaEntity.getSalary());
        paramMap.put("birthDay", anketaEntity.getBirthDay());
        paramMap.put("department", anketaEntity.getDepartment());
        paramMap.put("active", true);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        anketaInsert.updateByNamedParam(paramMap, keyHolder);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set dataSource on AnketaDao");
        }
        System.out.println("Yohoo!");
    }

    private String prepareString(String string){
        string = string.trim();
        if(string.length() > 0){
            string = string.substring(0,1).toUpperCase() + string.substring(1, string.length()).toLowerCase();
        }
        return string;
    }

    @Override
    public List<AnketaEntity> findByCreteria(String searchString) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("some", searchString);
        return selectByParametr.executeByNamedParam(paramMap);
    }
}
