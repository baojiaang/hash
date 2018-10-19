package quiz2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) throws IOException {
        QuizMain quizMain=new QuizMain();
//        Question q=new Question();
//        q.getQmaps();
        Game g=new Game();
        g.getQmaps();
        UserList userList=new UserList();
        System.out.println("输入用户名");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        User user=userList.userLogin(username);

      for(int i=0;i<10;i++) {
          Question aquestion = g.getQustion();
          String qword = aquestion.getQ();
          System.out.println(qword);
          String qanswer = aquestion.getAnswer();
          String uanswer = sc.next();
          user.setScore(user.getScore() + quizMain.checkAnswer(uanswer, qanswer));
          userList.updateScore(user);
      }
        System.out.println("you gou"+ user.getScore());
    }
    public int checkAnswer(String uanswer, String cAnswer){
        if(uanswer.equals(cAnswer))
            return 10;
        else
            return -10;

    }
}
