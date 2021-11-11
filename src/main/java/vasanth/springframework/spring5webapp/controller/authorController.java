package vasanth.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vasanth.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class authorController {
    private final AuthorRepository authorRepository;

    public authorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors",authorRepository.findAll());
        return "authors/authorsHTML";
    }
}
