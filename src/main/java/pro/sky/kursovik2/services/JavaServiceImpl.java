package pro.sky.kursovik2.services;

import org.springframework.stereotype.Service;
import pro.sky.kursovik2.exceptions.BadRequestException;
import pro.sky.kursovik2.exceptions.QuestionAlreadyExistException;
import pro.sky.kursovik2.interfaces.JavaService;
import pro.sky.kursovik2.model.Question;

import java.util.*;

@Service
public class JavaServiceImpl implements JavaService {

    private final List<Question> allQuestions = new ArrayList<>();
    {
        allQuestions.add(new Question("Q1", "A1"));
        allQuestions.add(new Question("Q2", "A2"));
        allQuestions.add(new Question("Q3", "A3"));
        allQuestions.add(new Question("Q4", "A4"));
        allQuestions.add(new Question("Q5", "A5"));
        allQuestions.add(new Question("Q6", "A6"));
        allQuestions.add(new Question("Q7", "A7"));
        allQuestions.add(new Question("Q8", "A8"));
        allQuestions.add(new Question("Q9", "A9"));
        allQuestions.add(new Question("Q10", "A10"));
        allQuestions.add(new Question("Q11", "A11"));
        allQuestions.add(new Question("Q12", "A12"));
        allQuestions.add(new Question("Q13", "A13"));
        allQuestions.add(new Question("Q14", "A14"));
        allQuestions.add(new Question("Q15", "A15"));
        allQuestions.add(new Question("Q16", "A16"));
        allQuestions.add(new Question("Q17", "A17"));
        allQuestions.add(new Question("Q18", "A18"));
        allQuestions.add(new Question("Q19", "A19"));
        allQuestions.add(new Question("Q20", "A20"));
    }

    @Override
    public Question addQuestion(String question, String answer) {
        Question temp = new Question(question, answer);
        if (allQuestions.contains(temp)) {throw new QuestionAlreadyExistException("QuestionAlreadyExistException"); }
        else { allQuestions.add(temp); }
        return temp;
    }

    @Override
    public void removeQuestion(String question, String answer) {
        Question temp = new Question(question, answer);
        if (allQuestions.contains(temp)) { allQuestions.remove(temp); }
        else { throw new BadRequestException("There are no the same question in allQuestion"); }
    }

    @Override
    public List<Question> allQuestion() {
        return Collections.unmodifiableList(allQuestions);
    }
}
