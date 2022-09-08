package hospital.com;

import hospital.com.model.Hospital;
import hospital.com.model.Soul;
import hospital.com.service.HospitalService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

  // TODO: console commands

  private static final Path DEPARTMENTS_PATH = Paths.get("data/hospital_files/departments.txt");

  private static HospitalService hospitalService;

  public static void main(String[] args) {
    //printChecklist();
    printConsoleCommands();
    System.out.println("");
    while (true) {
      System.out.print("\nВведите название больницы: ");
      String hospitalName = new Scanner(System.in).nextLine();
      System.out.print("\nВведите количество отделений в больнице: ");
      byte departmentsCount = new Scanner(System.in).nextByte();
      if (departmentsCount <= 0) {
        System.out.println("Вы ввели невозможное количество отделений");
        break;
      }

      hospitalService =
          new HospitalService(
              new Hospital(
                  hospitalName, addDepartmentsToMap(createDepartmentNames(departmentsCount))));
      getDepartmentsOfHospital(
          hospitalService.getHospital().getDepartments()); // просто выводит в консоль все отделения
      for (int i = 0; i < 2; i++) {
        hospitalService.generateSoul(
            getNameFromConsole(), generateMedicalDocument(), getDepartmentFromConsole());
      }
      List<Soul> souls = hospitalService.getSouls(getDepartmentFromConsole());
      souls.stream().forEach(System.out::println);
    }
  }

  // =========================================================================================================================\\

  private static Set<String> createDepartmentNames(byte departmentCount) {
    Set<String> departmentsList = new TreeSet<>();
    for (int i = 0; i < departmentCount; i++) {
      System.out.print("Введите название " + (i + 1) + "-го отделения: ");
      String deptName = new Scanner(System.in).nextLine();
      departmentsList.add(deptName);
    }
    writeDepartmentsToFile(departmentsList);
    return departmentsList;
  }


  private static Map<String, Department> addDepartmentsToMap(Set<String> departmentNames) {
    Map<String, Department> departments = new HashMap<>();
    for (String name : departmentNames) {
      departments.put(name, new Department(name));
    }
    return departments;
  }


  private static void getDepartmentsOfHospital(Map<String, Department> departmentMap) {
    List<String> departments = new ArrayList<>(departmentMap.keySet());
    departments.stream().forEach(System.out::println);
  }


  private static String getNameFromConsole() {
    System.out.print("Введите ФИО пациента: ");
    return new Scanner(System.in).nextLine();
  }


  private static long generateMedicalDocument() {
    Random random = new Random();
    return random.nextLong(999999999 - 100000000) + 1_000_000;
  }


  private static Department getDepartmentFromConsole() {
    System.out.print("Введите отделение, в которое нужно определить пациента: ");
    String department = new Scanner(System.in).nextLine().trim();
    return hospitalService.getHospital().getDepartments().get(department);
    // TODO: вернуть нужное отделение, соответсвующее названию, которое передали с консоли
  }


  private static void writeDepartmentsToFile(Set<String> depts){
    try{
      Files.write(DEPARTMENTS_PATH, depts);
    } catch (Exception ex){
      ex.printStackTrace();
    }
  }


  private static void printConsoleCommands() {
    System.out.println("\nКоманды для использования программы:\n");

    System.out.println("\"create new hospital\" - создание новой больницы с отделениями" +
            "\n!Информация о предыдущей больнице станет недоступна!");
    System.out.println("\"add new department\" - добавление нового отделения больницы к списку текущих");
    System.out.println("\"add new doctor\" - добавление нового доктора в определённое отделение");
    System.out.println("\"add new patient\" - добавление нового пациента в определённое отделение");
    System.out.println("\"remove department\" - удаление определённого отделения больницы из списка" +
            "\nВсе врачи и пациенты этого отделения автоматически удалятся");
    System.out.println("\"remove doctor\" - удаление доктора из всех отделений");
  }


  private static void printChecklist(){
    StringBuilder builder = new StringBuilder();
    try {
      List<String> lines = Files.readAllLines(Paths.get("data/Checklist.txt"));
      lines.forEach(line -> builder.append(line + "\n"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(builder);
  }

}

  //        System.out.print("Введите ФИО пациента: ");
  //        String patientName = new Scanner(System.in).nextLine();

  //
  //
  //        List<hospital.com.model.Soul> darkSouls = donatella.getSoulsList();
  //        darkSouls.stream()
  //                .filter(soul -> soul.getTemperature() > 36.2D && soul.getTemperature() < 36.9D)
  //                .sorted(Comparator.comparing(hospital.com.model.Soul::getTemperature))
  //                .forEach(System.out::println);
