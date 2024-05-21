/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;
import gym.*;
import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public interface dataimpl {
    public void insert(data p);
    public void update(data p);
    public void delete(String nama);
    public List<data>getAll();
    
}
