package hospital.com.model;

import hospital.com.Department;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Doctor {
  private String name;
  private Doctor.Grade grade;
  private String specialization;
  private Department department;

  public Doctor(String name, String specialization, Department department) {
    this.name = name;
    this.specialization = specialization;
    this.department = department;
  }

  public enum Grade {
    FIRST_CATEGORY,
    HIGHEST_CATEGORY,
    NURSE,
    SECOND_CATEGORY
  }
}
