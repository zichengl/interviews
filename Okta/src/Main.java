import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main{

    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
    public static void printPrettyNames(List<Employee> employees){
        Map<Integer, Employee> idToEmployee = new HashMap<>();

        int maxId = -1;

        for(Employee e: employees){
            idToEmployee.put(e.id, e);

            if(e.id == e.managerID)
                maxId = Math.max(maxId, e.id);

            if(e.id != e.managerID){
                if(idToEmployee.containsKey(e.managerID)){
                    idToEmployee.get(e.managerID).team.add(e);
                }
            }
        }

        Employee highest = idToEmployee.get(maxId);
        dfsPrint(highest,0);


    }

    public static void dfsPrint(Employee emp, int indent){
        if(emp == null)
            return;
        printWithIndent(emp.name, indent);

        for(Employee e: emp.team){
            dfsPrint(e,indent + 3);
        }

    }

    private static void printWithIndent(String str, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(str);
    }
}

class Employee{
    int id;
    int managerID;
    String name;
    List<Employee> team;

    public Employee(int id, int managerId, String name){
        this.id = id;
        this.managerID = managerId;
        this.name = name;
        team = new ArrayList<>();

    }

}