import java.util.*;
public class PQ_objs {
    public static class Student implements Comparable<Student>{
        String name;
        int rank;

        Student(String n, int r) {
            name = n;
            rank = r;
        }

        @Override
        public int compareTo(Student a) {
            if(this.rank == a.rank) {
                return 0;
            }
            return this.rank < a.rank ? -1:1;
        }
        @Override
        public String toString() {
            return this.name + " : " + this.rank;
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Student> stds = new PriorityQueue<>();
        stds.add(new Student("dx", 79));
        stds.add(new Student("fd", 465));
        stds.add(new Student("hjy", 32));
        stds.add(new Student("res", 987));
        while(!stds.isEmpty()) {
            System.out.println(stds.remove());
        }
    }
}
