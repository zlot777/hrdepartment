package dataLevel.realizationDAO;

import dataLevel.entity.AnketaEntity;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by Администратор on 01.02.2015.
 */
public class SelectByParametrDao extends MappingSqlQuery<AnketaEntity> {

    private static final String FIND_BY_CRETERIA = "SELECT * FROM anketa WHERE firstName like :some or lastName like :some";

    public SelectByParametrDao(DataSource dataSource){
        super(dataSource, FIND_BY_CRETERIA);
        super.declareParameter(new SqlParameter("some", Types.VARCHAR));
    }

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
