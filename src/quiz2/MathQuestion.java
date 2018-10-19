package quiz2;

import edu.princeton.cs.algs4.Quick3string;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class MathQuestion extends Question {
    private LinkedList<Question> mathQuestions;
    public static int generateNumber(int range) {
        //generate a number from 0 to range

        Random generator=new Random();
        int aInt=generator.nextInt(range);
        return aInt;
    }

    public MathQuestion() throws FileNotFoundException {

    }

    public Question generateMathQuestion(){
        //add your code here
        //x +y=anser
        double correctAnswer=0;
        String opStr="";
        int x= generateNumber(100);
        int y=generateNumber(100);
        int op=generateNumber(4);

        switch (op){
            case 0: //+
                correctAnswer=x+y;
                opStr="+";
                break;
            case 1: //+
                correctAnswer=x-y;
                opStr="-";
                break;
            case 2: //+
                correctAnswer=x*y;
                opStr="*";
                break;
            default:
                while(y==0)
                    y=generateNumber(100);
                correctAnswer=1.0*x/y;
                opStr="/";
                break;
        }
        BigDecimal b = new BigDecimal(correctAnswer);
        correctAnswer = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        Question mathQuestion=new Question(x+"  "+opStr+"   "+y+"= ",String.valueOf(correctAnswer));
        return mathQuestion;
    }

    public  LinkedList<Question> init(){
        LinkedList<Question> maps=new LinkedList<>();
        for(int i=0;i<10;){
            Question q=generateMathQuestion();
            if(!maps.contains(q)){
                maps.add(q);
                i++;
                
            }
        }
        this.mathQuestions=maps;
        return maps;
    }

    public void setMathQuestions(LinkedList<Question> mathQuestions) {
        this.mathQuestions = mathQuestions;
    }

    public Question getMathQuestion(){
        Random r=new Random();
        int random=r.nextInt(mathQuestions.size());
        Question q=mathQuestions.get(random);
        mathQuestions.remove(random);
        return q;
    }

}
