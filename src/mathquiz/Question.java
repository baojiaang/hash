package mathquiz;

public class Question {
    private String question_word;
    private String answer;
    private boolean visited;

    public Question(String question_word,String answer){
           this.question_word=question_word;
           this.answer=answer;
           this.visited=false;
    }
}
