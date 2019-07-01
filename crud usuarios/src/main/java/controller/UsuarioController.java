/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mathe
 */
@Controller
public class UsuarioController {
    
    @RequestMapping("salvarUsuario")
    public ModelAndView salvarUsuario(Usuario usuario) throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView("home");
        boolean retorno = new UsuarioDAO().salvarUsuario(usuario);
        if (retorno) {
           modelAndView.addObject("usuarios", new UsuarioDAO().getUsuarios());
           modelAndView.addObject("ok", "Usuario salvo com sucesso.");
        } else {
           modelAndView.addObject("erro", "Usuario não salvo, tente novamente.");
        }
        return modelAndView;
    }
    
    @RequestMapping("redirectEditarUsuario")
    public ModelAndView redirectEditUser(int idUsuario) throws Exception {
        return new ModelAndView("alteraUsuario")
                .addObject("usuario", new UsuarioDAO().getUsuario(idUsuario));
    }
    
    @RequestMapping("deletarUsuario")
    public ModelAndView deletarUsuario(int idUsuario) throws Exception {
        ModelAndView modelAndView = new ModelAndView("home");
        boolean retorno = new UsuarioDAO().deletarUsuario(idUsuario);
        if (retorno) {
           modelAndView.addObject("ok", "Usuario removido com sucesso.");
           modelAndView.addObject("usuarios", new UsuarioDAO().getUsuarios());
        } else {
           modelAndView.addObject("erro", "Usuario não removido, tente novamente.");
        }
        return modelAndView;
    }
    
}
