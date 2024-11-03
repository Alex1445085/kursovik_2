package pro.sky.kursovik2.contorllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.kursovik2.exceptions.BadRequestException;
import pro.sky.kursovik2.exceptions.QuestionAlreadyExistException;
import pro.sky.kursovik2.interfaces.JavaService;
import pro.sky.kursovik2.model.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaController {
    private final JavaService javaServ;
    public JavaController(JavaService javaServ) { this.javaServ = javaServ; }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return javaServ.addQuestion(question, answer);
    }
    @GetMapping("/java/remove")
    public void removeQuestion(@RequestParam("question") String question,
                               @RequestParam("answer") String answer) {
        javaServ.removeQuestion(question, answer);
    }
//    public String removeQuestion(@RequestParam("question") String question,
//                              @RequestParam("answer") String answer) {
//         return "Remove " + javaServ.removeQuestion(question, answer).toString();
//    }
    @GetMapping("/java")
    public Collection allQuestions() {
        return javaServ.allQuestion();
    }
}
