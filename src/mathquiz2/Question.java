package mathquiz2;

public class Question {
    private String q;
    private String answer;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(String q, String answer) {
        this.q = q;
        this.answer = answer;
    }
}
