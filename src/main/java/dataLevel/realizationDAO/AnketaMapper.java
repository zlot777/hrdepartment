package dataLevel.realizationDAO;

import dataLevel.entity.AnketaEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 23.01.2015.
 */
public class AnketaMapper implements RowMapper<AnketaEntity> {
    public AnketaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        AnketaEntity anketaEntity = new AnketaEntity();
        anketaEntity.setId(rs.getInt("id"));
        anketaEntity.setFirstName(rs.getString("firstName"));
        anketaEntity.setLastName(rs.getString("lastName"));
        anketaEntity.setSalary(rs.getDouble("salary"));
        anketaEntity.setBirthDay(rs.getDate("birthDay"));
        anketaEntity.setDepartment(rs.getInt("department"));
        anketaEntity.setActive(rs.getBoolean("active"));
        return anketaEntity;
    }
}
