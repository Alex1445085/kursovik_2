package pro.sky.kursovik2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.kursovik2.exceptions.BadRequestException;
import pro.sky.kursovik2.exceptions.QuestionAlreadyExistException;
import pro.sky.kursovik2.model.Question;
import pro.sky.kursovik2.services.JavaServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaServiceImplTest {
    private JavaServiceImpl javaServ = new JavaServiceImpl();

    Question temp = new Question("q1", "a1");

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void addQuestion() {
        Question expected = temp;
        Question actual = javaServ.addQuestion(temp.getQuestion(), temp.getAnswer());
        assertEquals(expected, actual);
        assertThrows(QuestionAlreadyExistException.class,
                () -> javaServ.addQuestion("Q1", "A1"),
                "QuestionAlreadyExistException");
    }
    @Test
    public void removeQuestion() {
        Question expected = temp;
        javaServ.addQuestion(temp.getQuestion(), temp.getAnswer());
        int l1 = javaServ.allQuestion().size();
        Question actual = javaServ.removeQuestion(temp.getQuestion(), temp.getAnswer());
        int l2 = javaServ.allQuestion().size();
        assertEquals(expected, actual);
        assertEquals(l1, l2 + 1);
        assertThrows(BadRequestException.class,
                () -> javaServ.removeQuestion(" - ", " - "),
                "BadRequestException");
    }
}
