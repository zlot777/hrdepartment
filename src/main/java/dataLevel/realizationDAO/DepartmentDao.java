package dataLevel.realizationDAO;

import dataLevel.entity.DepartmentEntity;
import dataLevel.interfaces.DepartmentInterface;
import dataLevel.interfaces.genericCrud;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Администратор on 23.01.2015.
 */
public class DepartmentDao implements genericCrud<DepartmentEntity>,DepartmentInterface {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private DepartmentInsert insert;
    private static final String GET_ALL_NAME_SQL = "SELECT name FROM department";
    private static final String FIND_BY_NAME_SQL = "SELECT * FROM department WHERE name=?";
    private static final String FIND_ALL_SQL = "SELECT * FROM department";
    private static final String DELETE_SQL = "DELETE FROM department WHERE idDepartment = ?";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM department where idDepartment = ?";
    private static final String UPDATE_SQL = "UPDATE department SET (name, description) values (?, ?)";

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        insert = new DepartmentInsert(dataSource);
    }


    @Override
    public List<DepartmentEntity> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, new DepartmentMapper());
    }

    @Override
    public DepartmentEntity findById(int id) {
        DepartmentEntity department = (DepartmentEntity) jdbcTemplate.queryForObject(FIND_BY_ID_SQL, new Object[]{id}, new DepartmentMapper());
        return department;
    }


    @Override
    public void insert(DepartmentEntity entity) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", entity.getName());
        paramMap.put("description", entity.getDescription());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insert.updateByNamedParam(paramMap, keyHolder);
    }

    @Override
    public void update(DepartmentEntity entity) {
       jdbcTemplate.update(UPDATE_SQL, new Object[]{entity.getName(), entity.getDescription()});
    }

    @Override
    public void delete(int id) {
         jdbcTemplate.update(DELETE_SQL, id);
    }

    @Override
    public DepartmentEntity findByName(String name) {
        return jdbcTemplate.queryForObject(FIND_BY_NAME_SQL, new Object[]{name}, new DepartmentMapper());
    }

    @Override
    public List<String> getAllName() {
    return jdbcTemplate.queryForList(GET_ALL_NAME_SQL, String.class);
    }
}
