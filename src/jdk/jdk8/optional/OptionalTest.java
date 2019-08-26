package jdk.jdk8.optional;


import jdk.jdk8.Company;
import jdk.jdk8.Employee;
import org.junit.Assert;
import org.junit.Test;

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
        System.out.println("---------");

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


    /**
     *  of() 会有空指针
     *
     * ofNullable() 不会有空指针
     */
    @Test(expected = NullPointerException.class)
    public void test01(){

        Optional<String> optional = Optional.of(null);

        //Optional<String> optional2 = Optional.ofNullable(null);

    }

    /**
     * get()
     */
    @Test(expected = NoSuchElementException.class)
    public void test02(){
        Optional<String> optional = Optional.empty();
        optional.get();
    }



    @Test
    public void test03(){

//        Employee employee = new Employee();

//        Employee employee = null;
//        Optional<Employee> optional = Optional.of(employee);
//        System.out.println(optional.get());

        Employee employee1 = new Employee("shang",23);
        Employee employee2 = new Employee("shang",212);
        Optional<Employee> optional1 = Optional.ofNullable(employee1);

//        System.out.println(optional1.get());

//        Assert.assertEquals(null, optional1.get());

        Assert.assertEquals(employee2, optional1.get());

    }


    /**
     *  ifPresent()
     */
    @Test
    public void test04(){
        Employee employee1 = new Employee("shang",23);
        Optional<Employee> optional1 = Optional.ofNullable(employee1);
        if(optional1.isPresent()){
            System.out.println(optional1.get());
        }

        optional1.ifPresent(x-> System.out.println(x));

    }

    /**
     *
     * orElse(other)
     *
     *  if(value != null){
     *      return value;
     *  }else{
     *      return other
     *  }
     *
     */

    @Test
    public void test05(){
        Employee employee = null;
        Employee employee1 = new Employee("shang",23);
        Optional<Employee> optional1 = Optional.ofNullable(employee);
        Employee emp = optional1.orElse(employee1);
        System.out.println(emp);
    }

    /**
     * orElseGet
     */
    @Test
    public void test06(){
        Employee employee = null;
        Employee employee1 = new Employee("shang",23);
        Optional<Employee> optional1 = Optional.ofNullable(employee);

        Employee emp = optional1.orElseGet(() -> employee1);

        System.out.println(emp);


    }


    /**
     * 重要的一点是 Optional 不是 Serializable。因此，它不应该用作类的字段。
     *
     * 如果你需要序列化的对象包含 Optional 值，Jackson 库支持把 Optional 当作普通对象。也就是说，
     * Jackson 会把空对象看作 null，而有值的对象则把其值看作对应域的值。这个功能在 jackson-modules-java8 项目中。
     *
     * Optional 主要用作返回类型。在获取到这个类型的实例后，如果它有值，你可以取得这个值，否则可以进行一些替代行为。
     * Optional 类有一个非常有用的用例，就是将其与流或其它返回 Optional 的方法结合，以构建流畅的API。
     *
     * Java 9 增强
     * 我们介绍了 Java 8 的特性，Java 9 为 Optional 类添加了三个方法：or()、ifPresentOrElse() 和 stream()。
     */
    @Test
    public void test07(){

    }


    @Test
    public void test08(){
        System.out.println(111);




    }



    public void optionalTest(Optional optional){

    }
}
