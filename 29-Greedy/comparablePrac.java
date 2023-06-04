import java.util.*;
public class comparablePrac {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("shruti", 20));
        list.add(new Student("labonno", 23));
        list.add(new Student("boichu", 18));
        // Collections.sort(list);
        
        // 2nd class defn
        // Collections.sort(list, (a, b) -> a.age - b.age);
        // Collections.sort(list, Comparator.comparing(o -> o.age));
        System.out.println(list);
    }
}
class Student implements Comparable<Student>{
    String name;
    int age;
    Student(String n, int a) {
        name = n;
        age = a;
    }
    public int compareTo(Student a) {
        if(this.age == a.age) {
            return 0;
        }
        return this.age < a.age ? -1 : 1;
    }
    public String toString() {
        return this.name + " " + this.age;
    }
}
// class Student {
//     String name;
//     int age;
//     Student(String n, int a) {
//         name = n;
//         age = a;
//     }
//     public String toString() {
//         return this.name + " " + this.age;
//     }
// }

// Arrays
/*
    Arrays.sort(  arr_name, Comparator.comparingDouble(o -> o[0])  ) --> on te
*/ 