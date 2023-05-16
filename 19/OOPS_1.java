public class OOPS_1 {

    public static void main(String args[])
    {
        // Pen p1 = new Pen();
        // p1.setColor("blue");
        // System.out.println(p1.color);
        // p1.color = "yellow";
        // System.out.println(p1.color);
        // p1.setTip((4));
        // System.out.println(p1.tip);


        // BankAccount myAcc = new BankAccount();
        // myAcc.username = "shrutzz";
        // myAcc.setPassword("dawsfvsdf");
        // System.out.println(myAcc.username);

        Student s1 = new Student();
        s1.name  = "Shruti";
        s1.age = 20;
        s1.password = "cdxs";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;
        Student s2 = new Student(s1);
        s1.age = 12;
        s1.marks[2] = 100;
        s2.password = "bgfsd";
        s1.getData();
        s2.getData();
        System.out.println(s2.marks[0]);
        System.out.println(s2.marks[1]);
        System.out.println(s2.marks[2]);
    }
}

class Student {
    String name;
    int age;
    String password;
    int marks[];

    //shallow copy constructor
    /*Student(Student s1)
    {
        marks = new int[3];
        this.name = s1.name;
        this.marks = s1.marks;
        this.age = s1.age;
    }*/

    //deep copy constructor
    Student(Student s1)
    {
        marks = new int[3];
        this.name = s1.name;
        // this.marks = s1.marks;
        this.age = s1.age;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

    Student() {
        marks = new int[3];
        System.out.println("constructor has been called..");
    }
    public void getData()
    {
        System.out.println(this.name + " " + this.age + " " + this.password);
    }
}
class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd)
    {
        password = pwd;
    }
}

class Pen {
    String color;
    int tip;

    void setColor(String newColor)
    {
        color = newColor;
    }

    void setTip(int newTip)
    {
        tip = newTip;
    }
}
