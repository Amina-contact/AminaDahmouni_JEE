package com.example.gestion_etudiant.Web;

import com.example.gestion_etudiant.Entities.Etudiant;
import com.example.gestion_etudiant.Entities.Genre;
import com.example.gestion_etudiant.Repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class EtudiantController {
    private EtudiantRepository etudiantRepository;
    @GetMapping( "/")
    public  String home(){
        return "home";
    }
    @GetMapping(path = "/user/index")
    public  String etudiants(Model model,//page & size données dans l'URL
                            @RequestParam(name = "page",defaultValue ="0") int page,
                            @RequestParam(name = "size",defaultValue ="5") int size,
                            @RequestParam(name = "keyword",defaultValue ="") String keyword){
        Page<Etudiant> pageEtudiants=etudiantRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listeEtudiants",pageEtudiants.getContent());
        model.addAttribute("pages",new int[pageEtudiants.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "etudiants";//la vue
    }
    @GetMapping("/admin/delete")
    public  String delete(Long id,String keyword,int page){
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/formEtudiant")
    public String formEtudiant(Model model){
        model.addAttribute("etudiant",new Etudiant());
        model.addAttribute("genres", Genre.values());
        return  "formEtudiant";
    }
    @GetMapping("/admin/editEtudiant")
    public String editEtudiant(Model model,Long id,String keyword,int page){
        Etudiant etudiant=etudiantRepository.findById(id).orElse(null);
        if (etudiant==null) throw new RuntimeException("Etudiant introuvable");
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("genres", Genre.values());
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return  "editEtudiant";
    }
    @PostMapping(path = "/admin/save")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "")String keyword){
        if (bindingResult.hasErrors()) return "formEtudiant";
        etudiantRepository.save(etudiant);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
}
