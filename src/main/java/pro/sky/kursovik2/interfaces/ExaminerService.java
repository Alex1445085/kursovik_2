package pro.sky.kursovik2.interfaces;

import pro.sky.kursovik2.model.Question;

import java.util.List;
import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestion(int amount);
}
