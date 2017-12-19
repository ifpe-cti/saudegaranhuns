/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.util;

import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.UsuarioHibernate;
import br.edu.ifpe.garanhuns.sg.model.enumarador.PerfilUsuario;
import java.time.LocalDate;

/**
 *
 * @author nosso
 */

public class NewClass {

    public static void main(String[] args) {

        PacienteHibernate pH = new PacienteHibernate();
        UsuarioHibernate uH = new UsuarioHibernate();
        pH.inserir(new Paciente("Satanás", "123456", LocalDate.now(), new Endereco("0", "rua 1", new Bairro("COHAB 5")), new PostoSaude("Casa do senhor", new Endereco("0", "CEÚ", new Bairro("Ceú"))), new Usuario("deus", "00000", PerfilUsuario.PACIENTE)));
        pH.inserir(new Paciente("Satanás1", "1123456", LocalDate.now(), new Endereco("01", "rua1 1", new Bairro("COHAB 15")), new PostoSaude("Casa do senhor1", new Endereco("01", "CEÚ1", new Bairro("C1eú"))), new Usuario("deus1", "00000", PerfilUsuario.PACIENTE)));
        Usuario u = uH.recuperarUsuarioPorLogin("deus", "00000");
        System.out.println(u);
    }
}