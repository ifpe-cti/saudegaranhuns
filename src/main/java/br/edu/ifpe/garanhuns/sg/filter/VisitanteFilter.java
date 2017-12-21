/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.filter;

import br.edu.ifpe.garanhuns.sg.model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando
 */
@WebFilter(urlPatterns = {"*.xhtml"})
public class VisitanteFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession();
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
            if (usuario != null || req.getRequestURI().endsWith("login.xhtml") || req.getRequestURI().endsWith("index.xhtml") || req.getRequestURI().endsWith("/paciente/cadastro.xhtml") || req.getRequestURI().contains("javax.faces.resource/")) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect("/index.xhtml");
            }
        } catch (IOException | ServletException e) {
            System.err.println("Falha ao verificar permissão de acesso para visitante. Erro: " + e);
        }
    }

    @Override
    public void destroy() {
    }

}
