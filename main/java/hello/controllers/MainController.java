package hello.controllers;

import hello.repository.WordsRepository;
import hello.services.Words;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private WordsRepository wordsRepository;

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewWord(@RequestParam String Word, String Translation) {
        Words w = new Words();
        w.setWord(Word);
        w.setTranslation(Translation);
        wordsRepository.save(w);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Words> getAllWords() {
        return wordsRepository.findAll();
    }
}