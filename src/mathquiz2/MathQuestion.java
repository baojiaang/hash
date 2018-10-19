package mathquiz2;

import java.math.BigDecimal;
import java.util.Random;

public class MathQuestion {
    private String question;
    private String answer;

    public MathQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public MathQuestion generateQuestion(){
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
        MathQuestion mathQuestion=new MathQuestion(x+"  "+opStr+"   "+y+"= ",String.valueOf(correctAnswer));
        return mathQuestion;

    }



    public int generateNumber(int range) {
        //generate a number from 0 to range

        Random generator=new Random();
        int aInt=generator.nextInt(range);
        return aInt;
    }

    public MathQuestion() {
    }

    public int checkAnswer(double uAnswer, double cAnswer){
        int roundScore=0;
        if(Math.abs(uAnswer-cAnswer)<=0.01)
            roundScore=10;
        else
            roundScore=-10;

        return roundScore;

    }
}
