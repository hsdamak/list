import java.util.Scanner;

public class Arrays1 {

    private Student[] sectionG;
    private int bottom;

    public void insert(Student student)
    {
        if(bottom != sectionG.length - 1)
        {
            bottom++;
            sectionG[bottom] = student;
        }
    }

    public Arrays1(int numberOfStudents)
    {
        sectionG = new Student[numberOfStudents];
        bottom = -1;
    }

    public void display()
    {
        for (Student student : sectionG) {
            if(student != null){
            System.out.println(student);
        }
        }
    }

    public Student remove(int rollno){
        Student temp=null;
        if(bottom != -1){
            for (int i = 0; i <= bottom; i++) {
                if(sectionG[i].getRollno()==rollno){
                    temp=sectionG[i];
                    sectionG[i]=null;
                    int j;
                    for ( j = 0; j <sectionG.length-1 ; j++) {
                        sectionG[j]=sectionG[j+1];
                    }
                    sectionG[j]=null;
                    bottom--;
                }
            }
        }
    return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length");
        int length = scanner.nextInt();
        Arrays1 list = new Arrays1(length);

        for(int i=0 ;i < length ; i++)
        {
            Student student = new Student();
            student.setRollno(i+1);
            student.setName("Guudu" + i);
            list.insert(student);
        }
        list.display();
        System.out.println(list.remove(1).getName()+"was removed");
    }
}

class Student{
    private int rollno;
    private  String name;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return ("(" + rollno + " , " + name + ")");
    }

}