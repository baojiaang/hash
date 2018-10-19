package mathquiz2;

import mathquiz.UserDAO;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class QuizMain {

    public static void main(String[] args) throws IOException {
        int score=0;
        int rounds=3;
        boolean quit=false;
        QuizMain mq=new QuizMain();
        UserList userList=new UserList();
        QuestionList questionList=new QuestionList();
        System.out.println("enter username");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        User user=userList.userLogin(username);
        HashMap<Integer,Question> questions=questionList.getQuestionMap();
        GenerateQuestion g=new GenerateQuestion();
        g.init();
        Random r=new Random();
        while(!quit){
            String answer=g.generate();
            String userAnswer=sc.next();
            if(userAnswer.toLowerCase().equals("x")){
                    quit=true;
            }

            if(!quit){
                user.setScore(user.getScore()+mq.checkAnswer(userAnswer,answer));
                userList.updateScore(user);
            }
        }

    }  

     
     
     public int generateNumber(int range) {
          //generate a number from 0 to range
         
        Random generator=new Random();
        int aInt=generator.nextInt(range);
        return aInt;
    }

    public int checkAnswer(String uanswer, String cAnswer){
        if(uanswer.equals(cAnswer))
            return 10;
        else
            return -10;
    
    }


}
