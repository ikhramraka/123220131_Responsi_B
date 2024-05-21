/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import gym.*;
import gym.modeltabel;
import java.util.List;
import DAOdata.dataDAO;
import DAOimplement.dataimpl;
import view.Mainview;
/**
 *
 * @author Lab Informatika
 */
public class datacontrol {
    Mainview frame;
    dataimpl impldata;
    List<data> dp;
    
    public datacontrol(Mainview frame){
        this.frame=frame;
        impldata = new dataDAO();
        dp = impldata.getAll();
    }
    public void isi(){
        dp=impldata.getAll();
        modeltabel mp = new modeltabel(dp);
        frame.getjTable1().setModel(mp);
    }
    public void insert(){
        data dp = new data();
        dp.setNama(frame.getJ1().getText());
        dp.setAlat(frame.getJ2().getText());
        dp.setNomor(Double.parseDouble(frame.getJ3().getText()));
        dp.setSewa(Double.parseDouble(frame.getJ4().getText()));
        impldata.insert(dp);
        
    }
    
    public void update(){
        data dp = new data();
        
        dp.setNama(frame.getJ1().getText());
        dp.setAlat(frame.getJ2().getText());
        dp.setNomor(Double.parseDouble(frame.getJ3().getText()));
        dp.setSewa(Double.parseDouble(frame.getJ4().getText()));
        impldata.update(dp);
    }
    
    public void delete(){
        String nama = frame.getJ1().getText();
        impldata.delete(nama);
    }
}
