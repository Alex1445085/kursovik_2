package pro.sky.kursovik2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.kursovik2.exceptions.InvalidNumberException;
import pro.sky.kursovik2.interfaces.ExaminerService;
import pro.sky.kursovik2.model.Question;
import pro.sky.kursovik2.services.JavaServiceImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    Set<Question> questionForTest = Set.of(new Question("q1", "a1"));

    @Mock
    private ExaminerService examServ;

    @InjectMocks
    private JavaServiceImpl javaServ;

    @Test
    public void getQuestion() {
        when(examServ.getQuestion(1)).thenReturn(questionForTest);
        Set<Question> expected = Set.of(new Question( "q1","a1"));
        Set<Question> actual = examServ.getQuestion(1);
        assertEquals(actual, expected);
        verify(examServ, times(1)).getQuestion(1);
    }
//    @Test
//    public void getQueThrow() {
//        when(examServ.getQuestion(1)).thenReturn(questionForTest);
//        assertThrows(InvalidNumberException.class,
//                () -> examServ.getQuestion(100),
//                "InvalidNumberException");
//    }
}
