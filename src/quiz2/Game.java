package quiz2;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Game {
    private LinkedList<Question> qmaps;

    public LinkedList<Question> getQmaps() throws FileNotFoundException {
        GeneralQuestion generalQuestion=new GeneralQuestion();
        MathQuestion mathQuestion=new MathQuestion();
        LinkedList<Question> maps=new LinkedList<>();
        generalQuestion.setGeneralQustionMap(generalQuestion.init());
        mathQuestion.setMathQuestions(mathQuestion.init());
        for(int i=0;i<10;i++){
            int random=MathQuestion.generateNumber(2);
            if(random==0){
                maps.add(generalQuestion.getGeneralQuestion());
            }
            else {
                maps.add(mathQuestion.getMathQuestion());
            }
        }
        this.qmaps=maps;
        return maps;
    }

    public Question getQustion() throws FileNotFoundException {
        int random=MathQuestion.generateNumber(qmaps.size());

        Question q=qmaps.get(random);
        qmaps.remove(q);
        return q;
    }
}
