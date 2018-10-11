/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Ilangovane
 */
public interface DAO {
    public void create (Object a);
    public void update (Object a);
    public void delete(Object o);
    public Object findById(Object o, String id);
    public List<Object> findAll(String className);
    public void close();
    
    
}
