/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.interfaces;

import java.util.List;

/**
 *
 * @author Herikles
 * @param <T>
 */
public interface DAO <T> {
    void insert(T o);
    void update(T o);
    void delete(T o);
    T read(Integer id);
    List<T> recuperarTodos();
    
}
