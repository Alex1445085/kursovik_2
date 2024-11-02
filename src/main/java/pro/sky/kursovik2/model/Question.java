package pro.sky.kursovik2.model;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public void setQuestion(String question) { this.question = question; }
    public void setAnswer(String answer) { this.answer = answer; }

    @Override
    public String toString() { return "question = " + this.question + ", answer = " + this.answer; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question que = (Question) o;
        return Objects.equals(this.question, que.question) &&
                Objects.equals(this.answer, que.answer);
    }
    @Override
    public int hashCode() { return Objects.hash(this.question, this.answer); }
}
