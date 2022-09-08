package hospital.com.model;

import hospital.com.Department;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class Hospital {

    private String name;
    private Map<String, Department> departments;

    public Hospital(String name, Map<String, Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public Map<String, Department> getDepartments() {
        return departments;
    }
}
