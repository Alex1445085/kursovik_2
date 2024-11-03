package pro.sky.kursovik2.services;

import org.springframework.stereotype.Service;
import pro.sky.kursovik2.exceptions.InvalidNumberException;
import pro.sky.kursovik2.interfaces.ExaminerService;
import pro.sky.kursovik2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaServiceImpl serv;
    public ExaminerServiceImpl(JavaServiceImpl serv) { this.serv = serv; }
    private final Set<Question> examQuestion = new HashSet<>();

    @Override
    public Set<Question> getQuestion(int amount) {
        List<Question> allQestion = serv.allQuestion();//new ArrayList<>();
        if (amount < 1 || amount > serv.allQuestion().size()) {
            throw new InvalidNumberException("InvalidNumberException");
        }
        examQuestion.clear();
        int i = 0;
        while (i < amount) {
            examQuestion.add(allQestion.get(randm(allQestion.size())));
            i = examQuestion.size();
        }
        return Collections.unmodifiableSet(examQuestion);
    }
    public int randm(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
