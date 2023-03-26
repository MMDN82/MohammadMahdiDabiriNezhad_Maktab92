import java.util.AbstractList;
import java.util.Arrays;

public class Student {
    int counter = 0 ;
    private String [][] detail ;
    private String [][] saver ;

    private String name;
    private String field;
    private int semester;
    private String professor;
    private String study;
    private int grade;

    public Student(String name, String field, int semester) {
        this.name = name;
        this.field = field;
        this.semester = semester;
    }
    public void insert(String professor , String study , int grade){
        this.professor = professor;
        this.study = study;
        this.grade = grade;
        saver = new String[counter+2][3];
        for (int i = 0 ; i < counter ; i++){
            for (int j = 0 ; j < 3 ;j++){
                saver[i][j] = detail[i][j] ;
            }
        }
        detail = new String[counter+1][3];

        detail=saver;

        detail[counter][0] = professor;
        detail[counter][1] = study;
        detail[counter][2] = String.valueOf(grade);
        counter++;
    }

    public void printDetail (){
        System.out.println("name : " + name);
        System.out.println("field : " + field);
        System.out.println("semester : " + semester);
        for (int i = 0 ; i < counter ; i++){
            for (int j = 0 ; j < 3 ;j++){
                System.out.print(detail[i][j]+" ");
            }
            System.out.println();
        }


    }

}
