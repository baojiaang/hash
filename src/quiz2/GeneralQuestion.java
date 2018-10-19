package quiz2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GeneralQuestion extends Question {
    private LinkedList<Question> generalQustionMap;

    public GeneralQuestion() throws FileNotFoundException {

    }



    public  LinkedList<Question> init() throws FileNotFoundException {
        LinkedList<Question> questions=new LinkedList<>();
        File file=new File("GeneralQuestions.txt");
        Scanner sc=new Scanner(file);
        int index=0;
        while(sc.hasNext()){

            String line=sc.nextLine();
            StringTokenizer st=new StringTokenizer(line,";");
            StringBuffer buffer=new StringBuffer();
            for(int i=0;i<5;i++){
                buffer.append(st.nextToken().trim());
            }
            String answer=st.nextToken().trim();
            Question q=new Question(buffer.toString(),answer);
            questions.add(q);
            index++;
        }
        return questions;
    }

    public LinkedList<Question> getGeneralQustionMap() {
        return generalQustionMap;
    }

    public void setGeneralQustionMap(LinkedList<Question> generalQustionMap) {
        this.generalQustionMap = generalQustionMap;
    }

    public Question getGeneralQuestion(){
        Random r=new Random();
        int n=r.nextInt(generalQustionMap.size());
        Question q=generalQustionMap.get(n);
        generalQustionMap.remove(n);
        return q;
    }
}
