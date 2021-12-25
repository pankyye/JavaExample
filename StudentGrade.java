//需求：创建一个二维数组存储学生成绩。并显示全部学生的平均成绩和每个学生的平均成绩。

public class StudentGrade {
    public static void main(String[] args) {
        int[][] student = new int[6][3];
        int[] Mike ={98,96,90};
        int[] Tony ={89,77,90};
        int[] Alexa ={87,66,90};
        int[] Bob ={98,89,90};
        int[] Tom ={79,96,90};
        int[] Bill ={90,93,86};
        student[0] = Mike;
        student[1] = Tony;
        student[2] = Alexa;
        student[3] = Bob;
        student[4] = Tom;
        student[5] = Bill;

        int gradeSum = 0; //全部学生成绩总和
        int[] studentSum = new int[6]; //单个学生成绩总和
        for(int i=0;i<6;i++){
            System.out.println("Student #"+i);
            studentSum[i]=0;
            for (int j=0;j<3;j++){
                gradeSum = gradeSum + student[i][j];
                studentSum[i] = studentSum[i] + student[i][j];
            }
            System.out.println("Average grade:"+studentSum[i]/3);
        }
        System.out.println("Average grade of all students:"+gradeSum/18);

    }
}
