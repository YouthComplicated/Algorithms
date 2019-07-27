package leetcode;

import java.util.*;

public class EmployeeImportance_690 {

    /**
     *
     *You are given a data structure of employee information, which includes the employee's unique id,
     * his importance value and his direct subordinates' id.
     *
     * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3.
     * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]],
     * and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate
     * of employee 1, the relationship is not direct.
     *
     * Now given the employee information of a company, and an employee id, you need to return the total
     * importance value of this employee and all his subordinates.
     *
     * Example 1:
     *
     * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     * Output: 11
     * Explanation:
     * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
     * They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
     *
     *
     * Note:
     *
     * One employee has at most one direct leader and may have several subordinates.
     * The maximum number of employees won't exceed 2000.
     *
     */


    public static int getImportance(List<Employee> employees, int id) {

        int result = 0;
        for(Employee employee : employees){
            if(employee.id == id){
                result += employee.importance;
                for(Integer t : employee.subordinates){
                    result += getImportance(employees, t);
                }
            }
        }

        return result;
    }




    //fast  给定具体范围，使用数组代替map 之后进行递归操作
    public static int getImportance0(List<Employee> employees, int id) {
        return getImportance01(employees, id);
    }
    public static int getImportance01(List<Employee> employees, int id) {
        Employee[] es = new Employee[2001];
        for (Employee e : employees) {
            es[e.id] = e;
        }
        return getAllImportance02(es, id);
    }


    private static int getAllImportance02(Employee[] es, int id) {
        Employee lead = es[id];
        int sum = lead.importance;
        for (Integer subId : lead.subordinates) {
            sum += getAllImportance02(es, subId);
        }
        return sum;
    }


    //使用map，降低循环次数 递归
    private static int dfs(Map<Integer, Employee> employees, int id) {
        int ret = employees.get(id).importance;
        for (Integer sub: employees.get(id).subordinates) {
            ret += dfs(employees, sub);
        }
        return ret;
    }

    public static int getImportance1(List<Employee> employees, int id) {
        int target = -1;
        Map<Integer, Employee> all = new HashMap<>();
        for (Employee e: employees) {
            all.put(e.id, e);
        }
        return dfs(all, id);
    }



    //使用map，降低循环次数 使用堆栈代替递归
    public static int getImportance2(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = mapEmployees(employees);
        int importance = 0;

        Employee headEmployee = employeeMap.get(id);
        Stack<Employee> employeeStack = new Stack<>();
        employeeStack.push(headEmployee);

        while (!employeeStack.isEmpty()) {
            Employee current = employeeStack.pop();
            importance += current.importance;

            List<Integer> currentSubordinates = current.subordinates;
            for (Integer i : currentSubordinates) {
                employeeStack.push(employeeMap.get(i));
            }
        }
        return importance;
    }

    private static Map<Integer, Employee> mapEmployees(List<Employee> list) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : list) {
            map.put(e.id, e);
        }
        return map;
    }



    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getImportance() {
            return importance;
        }

        public void setImportance(int importance) {
            this.importance = importance;
        }

        public List<Integer> getSubordinates() {
            return subordinates;
        }

        public void setSubordinates(List<Integer> subordinates) {
            this.subordinates = subordinates;
        }
    }

    //Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]]
    public static void main(String[] args) {

        List<Integer> ids1 = Arrays.asList(2,3);
        Employee employee1 = new Employee(1,5,ids1);
        List<Integer> ids2 = new ArrayList<>();
        Employee employee2 = new Employee(2,3,ids2);

        List<Integer> ids3 = new ArrayList<>();
        Employee employee3 = new Employee(3,3,ids3);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        System.out.println(getImportance(employees,1));


    }

}
