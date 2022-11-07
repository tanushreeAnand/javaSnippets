import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Student
{  
    int rollNo;  
    String name;  
    int age;  
    Student(int rollno,String name,int age)
    {  
        this.rollNo=rollno;  
        this.name=name;  
        this.age=age;  
    }  
}
class RollNameComparator implements Comparator<Student>{
	public int compare(Student s1, Student s2){
        if (s1.rollNo == s2.rollNo){
            if (s1.name == s2.name){
                return 0;
            }
            else if (s1.name.compareTo(s2.name) < 0){
                return 1;
            }
            else{
                return -1;
            }
            
        }
        else if (s1.rollNo > s2.rollNo){
            return 1;
        }
        else
        return -1;
        
    }
}
class Main
{  
    public static void main(String args[])
    {  
        ArrayList<Student> listOfStudent = new ArrayList<Student>();  
        listOfStudent.add(new Student(1,"bavi",26));  
        listOfStudent.add(new Student(1,"ant",35));
        listOfStudent.add(new Student(1,"ant",27));  
        listOfStudent.add(new Student(3,"kamboj",20));  
        
        // Sort Comparator1 : custom Comparator class
       // Collections.sort(listOfStudent, new RollNameComparator());  
            
        //Sort Comparator2 :  lambda expressions to write custom comparator
        
        Comparator<Student> RollNoComparator = Comparator.comparing((Student p)->p.rollNo)
          .thenComparing(p->p.name)
          .thenComparingInt(p->p.age); 
           Collections.sort(listOfStudent,  RollNoComparator); 
                for(Student student:listOfStudent)
                {  
                    System.out.println("RollNo of Student = "+student.rollNo);
                    System.out.println("Age of Student = "+student.age);
                    System.out.println("Name of Student = "+student.name);
                    System.out.println("**");
                }
    }  
}  
