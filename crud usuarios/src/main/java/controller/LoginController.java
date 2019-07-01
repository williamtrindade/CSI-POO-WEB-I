/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mathe
 */
@Controller
public class LoginController {
    
    @RequestMapping("login")
    public ModelAndView autenticarUsuario(String email, String senha, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();

        if(email!= null && senha !=null) {

            PrintWriter out = response.getWriter();
            HttpSession sessao = request.getSession(true);
            Usuario usuario = new UsuarioDAO().login(email,senha);

            if (usuario != null) { //logado
                sessao.setAttribute("logado", usuario);
                modelAndView.setViewName("home");
                modelAndView.addObject("logado", usuario);
                modelAndView.addObject("usuarios", new UsuarioDAO().getUsuarios());
            } else {
                modelAndView.setViewName("login");
                modelAndView.addObject("erro", "Email e ou senha incorretos.");
            }
        } else {
            modelAndView.addObject("erro", "Por favor digite os campos.");
        }
        return modelAndView;
    }

}
