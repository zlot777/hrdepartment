package dataLevel.entity;

/**
 * Created by Администратор on 22.01.2015.
 */

public class DepartmentEntity {
    private Integer idDepartment;
    private String name;
    private String description;

    public DepartmentEntity() {
    }

    public DepartmentEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (idDepartment != null ? !idDepartment.equals(that.idDepartment) : that.idDepartment != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDepartment != null ? idDepartment.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "idDepartment=" + idDepartment +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
