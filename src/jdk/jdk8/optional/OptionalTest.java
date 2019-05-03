package jdk.jdk8.optional;


import jdk.jdk8.Company;
import jdk.jdk8.Employee;

import java.util.*;

/**
 *  A container object which may or may not contain a non-null value.
 *  If a value is present, {@code isPresent()} will return {@code true} and
 *  {@code get()} will return the value.
 */
public class OptionalTest {

    public static void main(String[] args) {

        //单个对象
//      Optional<String> optional = Optional.ofNullable("hello");
        Optional<String> optional = Optional.ofNullable(null);

        String str = null;
        if(str != null){
            System.out.println(str);
        }

        //不推荐
        if(optional.isPresent()) {
            System.out.println("optional:" + optional.get());
        }

        //推荐的Optional使用方式
        optional.ifPresent(item -> System.out.println(item));
        System.out.println("-------");

        System.out.println(optional.orElse("world"));
        System.out.println("---------");

        System.out.println(optional.orElseGet(() -> "nihao"));


        //集合的处理
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company1");

        List<Employee> employees = Arrays.asList(employee, employee2);

//        company.setEmployees(employees);

        List<Employee> list = company.getEmployees();

//        if(null != list){
//            return list;
//        }else{
//            return new ArrayList<Employee>();
//        }


        Optional<Company> optional1 = Optional.ofNullable(company);
        System.out.println(optional1.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));


    }

    public void optionalTest(Optional optional){

    }
}
