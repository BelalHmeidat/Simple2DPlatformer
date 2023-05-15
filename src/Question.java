import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question {


    static Question[] questions;

    static {
        try {
            questions = readQuastionsFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i].question);
            System.out.println(questions[i].op1);
            System.out.println(questions[i].op2);
            System.out.println(questions[i].op3);
            System.out.println(questions[i].op4);
            System.out.println(questions[i].whoTrue);
        }
    }

    public static Question []readQuastionsFile() throws FileNotFoundException {
        File file = new File("quastions.txt");
        Scanner scan = new Scanner(file);
        String line = "";
        Question arr[]=new Question [20];
        for(int i=0;i<20;i++) {
            Question question=new Question();
            line = scan.nextLine();
            line=line.toString().toUpperCase();
            question.question = line;

            line = scan.nextLine();
            line=line.toString().toUpperCase();
//            NewString op1=new NewString(characters,line);
            question.op1 = line;

            line = scan.nextLine();
            line=line.toString().toUpperCase();
//            NewString op2=new NewString(characters,line);
            question.op2 = line;

            line = scan.nextLine();
            line=line.toString().toUpperCase();
//            NewString op3=new NewString(characters,line);
            question.op3 = line;

            line = scan.nextLine();
            line=line.toString().toUpperCase();
//            NewString op4=new NewString(characters,line);
            question.op4 = line;

            line = scan.nextLine();
            int isTrue=Integer.parseInt(line);
//            Question q=new Question(question,op1,op2,op3,op4,isTrue);
            question.whoTrue=isTrue;
            arr[i]=question;

        }
        return arr;

    }

    String question;
    String op1;
    String op2;
    String op3;
    String op4;
    int whoTrue;

    public Question() {
    }
    public Question(String question, String op1, String op2, String op3, String op4, int whoTrue) {
        this.question = question;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.whoTrue=whoTrue;
    }





}
