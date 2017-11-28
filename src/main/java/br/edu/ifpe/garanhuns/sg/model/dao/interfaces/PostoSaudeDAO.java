/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.interfaces;
import br.edu.ifpe.garanhuns.sg.model.pojo.PostoSaude;

/**
 *
 * @author Herikles */
public interface PostoSaudeDAO extends DAO<PostoSaude>{
    public PostoSaude readByName(String name);
    public void deleteOnCascade(PostoSaude ps);
}
