package hospital.com.model;

import hospital.com.model.Doctor;
import hospital.com.model.Soul;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Department {

  private String departmentName;
  private List<Soul> soulList;
  private List<Doctor> doctorList;

  public Department(String departmentName) {
    this.departmentName = departmentName;
    soulList = new ArrayList<>();
    doctorList = new ArrayList<>();
  }

  public void addSoul(Soul soul) {
    soulList.add(soul);
  }

  public void addDoctor(Doctor doctor) {
    doctorList.add(doctor);
  }

  @Override
  public String toString(){
    return departmentName + "\n";
  }
}
