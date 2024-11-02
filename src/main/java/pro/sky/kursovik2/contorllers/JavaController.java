package pro.sky.kursovik2.contorllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.kursovik2.exceptions.BadRequestException;
import pro.sky.kursovik2.exceptions.QuestionAlreadyExistException;
import pro.sky.kursovik2.interfaces.JavaService;

@RestController
@RequestMapping("/exam")
public class JavaController {
    private final JavaService javaServ;
    public JavaController(JavaService javaServ) { this.javaServ = javaServ; }

    @GetMapping("/java/add")
    public String addQuestion(@RequestParam("question") String question,
                              @RequestParam("answer") String answer) {
        try{ return "Add " + javaServ.addQuestion(question, answer).toString(); }
        catch (QuestionAlreadyExistException e) { return "Такой question уже существует."; }
    }
    @GetMapping("/java/remove")
    public String removeQuestion(@RequestParam("question") String question,
                              @RequestParam("answer") String answer) {
        try{ return "Remove " + javaServ.removeQuestion(question, answer).toString(); }
        catch (BadRequestException e) { return "No the same question in allQuestion"; }
    }
    @GetMapping("/java")
    public String allQuestions() {
        return "All questions = " + javaServ.allQuestion().toString();
    }
}
