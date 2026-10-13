import java.util.*;

class StudentGrade
{
    private String name;
    private ArrayList<String> subjects;
    private ArrayList<Integer> marks;

    StudentGrade(String name)
    {
        this.name = name;
        subjects = new ArrayList<String>();
        marks = new ArrayList<Integer>();
    }

    void addMarks(String subject, int mark)
    {
        subjects.add(subject);
        marks.add(mark);
    }

    char calculateGrade(int mark)
    {
        if (mark >= 90)
            return 'O';
        else if (mark >= 80)
            return 'A';
        else if (mark >= 70)
            return 'B';
        else if (mark >= 60)
            return 'C';
        else if (mark >= 50)
            return 'D';
        else
            return 'F';
    }

    void display()
    {
        int total = 0;

        System.out.println("\nStudent Name: " + name);
        System.out.println("\nSubject\t\tMarks\tGrade");

        for (int i = 0; i < subjects.size(); i++)
        {
            int mark = marks.get(i);
            total += mark;

            System.out.println(subjects.get(i) +
                "\t\t" + mark + "\t" +
                calculateGrade(mark));
        }

        double average = (double) total / marks.size();

        System.out.printf("\nAverage Marks: %.2f\n", average);

        if (average >= 90)
            System.out.println("Performance: Excellent");
        else if (average >= 75)
            System.out.println("Performance: Very Good");
        else if (average >= 60)
            System.out.println("Performance: Good");
        else if (average >= 50)
            System.out.println("Performance: Average");
        else
            System.out.println("Performance: Needs Improvement");
    }
}

public class StudentGradeAnalyzer
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        StudentGrade s = new StudentGrade(name);

        for (int i = 0; i < 4; i++)
        {
            System.out.print("Enter Subject Name: ");
            String subject = sc.nextLine();

            System.out.print("Enter Marks: ");
            int mark = sc.nextInt();
            sc.nextLine();

            s.addMarks(subject, mark);
        }

        s.display();
        sc.close();
    }
}