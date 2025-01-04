package com.senac.cardcaptor.controller;

/**
 *
 * @author elisa
 */
public class PhotocardController {
    
    private List<Photocard> listaPhotocards = new ArrayList<>();
    private List<Comentario> listaComentarios = new ArrayList<>();
    private int proximoId = 1;
    
    @GetMapping("/")
    public String irParaInicio() {
        return "index";
    }
    
    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        model.addAttribute("photocard", new Photocard());
        return "cadastro";
    }
    
    @PostMapping("/salvar")
    public String processarFormulario(@ModelAttribute Photocard photocard) {
        photocard.setId(proximoId++);
        photocard.add(photocard);
        return "redirect:/detalhes?id=" + photocard.getId();
    }
    
    @GetMapping("/lista")
    public String listaForm(Model model) {
        model.addAttribute("lista", listaPhotocards);
        return "lista";
    }
    
    @GetMapping("/detalhes")
    public String exibirDetalhes(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Photocard photocardEncontrado = null;
        for (Photocard p : listaPhotocards) {
            if (f.getId().equals(id)) {
                photocardEncontrado = f;
                break;
            }
        }
        
         model.addAttribute("photocard", photocardEncontrado);

         //adicionar aqui os comentarios em lista

        return "detalhes";
    }
    
    @PostMapping("/salvarComentario")
    public String salvarComentario(@ModelAttribute Comentario comentario, @RequestParam("photocardId") Integer photocardId) {
        Photocard photocard = null;
        for (Photocard p : listaPhotocards) {
            if (f.getId().equals(photocardId)) {
                photocard = p;
                break;
            }
        }

        if (photocard == null) {
            return "redirect:/lista";
        }

        comentario.setPhotocard(photocard);

        boolean analiseExiste = false;
        for (int i = 0; i < analises.size(); i++) {
            Analise a = analises.get(i);
            if (a.getFilme() != null && a.getFilme().getId().equals(filmeId)) {
                analises.set(i, analise);
                analiseExiste = true;
                break;
            }
        }

        if (!analiseExiste) {
            analises.add(analise);
        }

        return "redirect:/detalhes?id=" + filmeId;
    }


}
