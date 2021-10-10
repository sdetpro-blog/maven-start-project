package employee;

import java.util.Arrays;
import java.util.List;

public class SalaryCalculator {

    //     static double buyingCOMPUTER
    public static double calculateEmployeeSalaries(List<Employee> employees){
        double totalSalary = 0.0;

        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }

        return totalSalary;
    }


    // Noi cu the hoa INSTANCES
    public static void main(String[] args) {
        Employee ceo = new CLevel();
        Employee teo = new StandardEmployee();

        System.out.printf("Total salary: %f", SalaryCalculator.calculateEmployeeSalaries(Arrays.asList(ceo, teo)));
    }
}
