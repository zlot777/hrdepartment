package dataLevel.realizationDAO;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by Администратор on 23.01.2015.
 */
public class DepartmentInsert extends SqlUpdate {
    private static final String INSERT_SQL = "INSERT INTO Department (name, description) values (:name, :description)";

    public DepartmentInsert(DataSource dateSource){
        super(dateSource, INSERT_SQL);
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("description", Types.VARCHAR));
        super.setGeneratedKeysColumnNames(new String[]{"idDepartment"});
        super.setReturnGeneratedKeys(true);
    }

}
