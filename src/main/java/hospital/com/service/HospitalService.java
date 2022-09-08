package hospital.com.service;

import hospital.com.Department;
import hospital.com.model.Hospital;
import hospital.com.model.Soul;
import hospital.com.model.Doctor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
@Data
public class HospitalService {

  public static final String DEPARTMENT_ERROR_MESSAGE = "Такого отделения не существует";
  public static final String DOCTOR_ERROR_MESSAGE = "Такого доктора не существует";
  public static final String SOUL_ERROR_MESSAGE = "Такого пациента не существует";

  private final Hospital hospital;


  public HospitalService(Hospital hospital) {
    this.hospital = hospital;
  }


  public void generateSoul(String name, long medicalDocument, Department department) {
    if (getDepartmentExists(department)) {
      department.addSoul(new Soul(name, medicalDocument, department));
    } else {
      System.out.println(DEPARTMENT_ERROR_MESSAGE);
    }
  }

  public List<Soul> getSouls(Department department) {
    return department.getSoulList();
  }

  private boolean getDepartmentExists(Department department){
    return hospital.getDepartments().containsKey(department);
  }

  public void addDepartment(String name) {
    hospital.getDepartments().put(name, new Department(name));
  }

  public void generateDoctor(String name, Department department, String specialization) {
    department.addDoctor(new Doctor(name, specialization, department));
  }

  //    public void addPatient(String name) {
  //        this.soulsList.add(new hospital.com.model.Soul(name));
  //    }
}
