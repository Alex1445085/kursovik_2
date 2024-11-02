package pro.sky.kursovik2.interfaces;

import pro.sky.kursovik2.model.Question;

import java.util.Collection;

public interface JavaService {
    Question addQuestion(String question, String answer);
    Question removeQuestion(String question, String answer);
    Collection<Question> allQuestion();
}

