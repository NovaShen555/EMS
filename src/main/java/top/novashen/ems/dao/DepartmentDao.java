package top.novashen.ems.dao;

import top.novashen.ems.pojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DepartmentDao {

    private static Map<Integer,Department> departmentMap = null;
    static {
        departmentMap = new HashMap<>();
        //伪造数据，以后会改为从数据库中获取
        departmentMap.put(1,new Department(1,"教学部"));
        departmentMap.put(2,new Department(2,"市场部"));
        departmentMap.put(3,new Department(3,"教研部"));
        departmentMap.put(4,new Department(4,"运营部"));
        departmentMap.put(5,new Department(5,"后勤部"));
        departmentMap.put(6,new Department(6,"开发部"));
    }

    //得到所有部门信息
    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }


}
