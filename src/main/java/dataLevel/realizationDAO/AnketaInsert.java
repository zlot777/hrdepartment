package dataLevel.realizationDAO;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by Администратор on 23.01.2015.
 */
public class AnketaInsert extends SqlUpdate  {
    public static final String INSERT_SQL = "INSERT INTO anketa (firstName, lastName, salary, birthDay, department,active) " +
            "values (:firstName, :lastName, :salary, :birthDay, :department, :active)";

    public AnketaInsert(DataSource dataSource){
        super(dataSource, INSERT_SQL);
        super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("lastName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("salary", Types.DOUBLE));
        super.declareParameter(new SqlParameter("birthDay", Types.DATE));
        super.declareParameter(new SqlParameter("department", Types.INTEGER));
        super.declareParameter(new SqlParameter("active", Types.BOOLEAN));
        super.setGeneratedKeysColumnNames(new String[]{"id"});
        super.setReturnGeneratedKeys(true);
    }


}
