package kz.narxoz.argo.controller;

import kz.narxoz.argo.entity.Writer;
import kz.narxoz.argo.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WriterController {
    @Autowired
    WriterService writerService;

    @GetMapping("/writer")
    public String viewWriters(Model model){
        model.addAttribute("writer", writerService.findAllWriter());
        return "writer";
    }

    @GetMapping("/writer/new")
    public String addWriterForm(Model model){
        Writer writer = new Writer();
        model.addAttribute("writer", writer);
        return "add_writer";
    }

    @PostMapping("/writer/add")
    public String saveBook(@ModelAttribute("writer") Writer writer){
        writerService.saveWriter(writer);
        return "redirect:/writer";
    }

    @GetMapping("/writer/update/{id}")
    public String updateBookForm(Model model, @PathVariable("id") Long id){
        Writer writer = writerService.findWriter(id);
        model.addAttribute("writer", writer);
        return "update_writer";
    }

    @GetMapping("/writer/info/{id}")
    public String infoWriter(Model model, @PathVariable("id") Long id){
        Writer writer = writerService.findWriter(id);
        model.addAttribute("writer", writer);
        return "writer";
    }

    @PostMapping("/writer/change/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("writer") Writer writer){
        Writer myWriter = writerService.findWriter(id);
        myWriter = writer;
        writerService.saveWriter(myWriter);
        return "redirect:/writer";
    }

    @GetMapping("/writer/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        writerService.deleteWriter(id);
        return "redirect:/writer";
    }

}
