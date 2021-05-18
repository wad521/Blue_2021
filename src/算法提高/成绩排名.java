package 算法提高;

import java.util.*;

/**
 * @author:yxl
 **/
public class 成绩排名 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Student> student = new ArrayList<Student>();
        for (int i = 0; i < n; i++) {
            student.add(new Student(input.next(), input.nextInt()));
        }
        Collections.sort(student);
        for (Student s : student) {
            System.out.println(s.name);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int space;

    public Student(String name, int space) {
        this.name = name;
        this.space = space;
    }

    @Override
    public int compareTo(Student o) {
        if (this.space > o.space){
            return -1;
        }else if(this.space<o.space){
            return 1;
        }else {
            //前一个字符串比后一个大 返回负值
            //否则 返回正值
            //返回他们之间的差值（当前-被比较的）
            return this.name.compareTo(o.name);
        }
    }
}
