package hospital.com.model;

public class Soul {

  private String name;
  private long medicalDocument;
  private double temperature;
  private String diagnosis;
  private Department department;

  public Soul(String name, long medicalDocument, Department department) {
    this.name = name;
    this.medicalDocument = medicalDocument;
    this.department = department;
    //        this.temperature = generateTemperature();
  }

  public String getName() {
    return name;
  }

  public long getMedicalDocument() {
    return medicalDocument;
  }

  public double getTemperature() {
    return temperature;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  public String getDiagnosis() {
    return diagnosis;
  }

  @Override
  public String toString() {
    return "Soul: "
        + name
        + "\tmedicalDocument: "
        + medicalDocument
        + "\tdepartment: "
        + department;
  }
}
