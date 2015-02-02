package dataLevel.realizationDAO;

import dataLevel.entity.DepartmentEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 23.01.2015.
 */
public class DepartmentMapper implements RowMapper<DepartmentEntity> {
    public DepartmentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setIdDepartment(rs.getInt("idDepartment"));
        departmentEntity.setName(rs.getString("name"));
        departmentEntity.setDescription(rs.getString("description"));
        return departmentEntity;
    }
}
