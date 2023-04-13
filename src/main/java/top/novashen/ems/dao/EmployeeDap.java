package top.novashen.ems.dao;

import top.novashen.ems.pojo.Employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDap {

    private static Map<Integer, Employee> employees = null;
    private static DepartmentDao departmentDao = new DepartmentDao();
    static {
        employees = new HashMap<>();

        //伪造数据，以后会改为从数据库中获取
        employees.put(1, new Employee(1, "张三", "1@a.com", 1, new Date(2004, 1, 1), departmentDao.getDepartmentById(1)));
        employees.put(2, new Employee(2, "李四", "2@a.com", 0, new Date(2003, 1, 1), departmentDao.getDepartmentById(2)));
        employees.put(3, new Employee(3, "王五", "3@a.com", 0, new Date(2005, 1, 1), departmentDao.getDepartmentById(3)));
        employees.put(4, new Employee(4, "赵六", "4@a.com", 1, new Date(2007, 1, 1), departmentDao.getDepartmentById(4)));
    }

    //获得所有员工信息
    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    //通过id得到员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //增加员工
    public void addEmployee(Employee employee){
        //前端只在其部门对象中填入了id，需要通过id得到完整的部门对象
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //通过id删除员工
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }

}
