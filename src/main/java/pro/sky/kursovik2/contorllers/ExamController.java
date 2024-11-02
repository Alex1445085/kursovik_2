package pro.sky.kursovik2.contorllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kursovik2.exceptions.InvalidNumberException;
import pro.sky.kursovik2.interfaces.ExaminerService;
import pro.sky.kursovik2.interfaces.JavaService;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examServ;
    public ExamController(ExaminerService examServ) { this.examServ = examServ; }

    @GetMapping("/getQuestion/{amount}")
    public String getQuestion(@PathVariable Integer amount) {
        try { return "Amount of question = " + examServ.getQuestion(amount).toString(); }
        catch (InvalidNumberException e) { return "InvalidNumberException"; }
    }
}
