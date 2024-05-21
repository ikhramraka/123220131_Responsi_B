/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdata;
import gym.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.connector;
import DAOimplement.dataimpl;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class dataDAO implements dataimpl{
    Connection connection;
    final String select = "SELECT * FROM `gym`";
    final String insert = "INSERT INTO `gym`(`nama`, `alat`, `nomor`, `sewa`, `biaya`) VALUES (?,?,?,?,?)";
    final String update = "UPDATE gym set nama=?, alat=?, nomor=?, sewa=?, biaya=? where nama=?";
    final String delete = "DELETE from gym where nama =?";
    public dataDAO(){
        connection =connector.connection();
    }

    @Override
    public void insert(data p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getAlat());
            statement.setDouble(3, p.getNomor());
            statement.setDouble(4, p.getSewa());
            
            if (p.getSewa() > 2){
            double biaya = (p.getSewa())*50000+ (25000*p.getSewa());
            statement.setDouble(5, biaya);
            }else{
            double biaya = (p.getSewa())*50000;
            statement.setDouble(5, biaya);
            }
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
            while(rs.next()){
                p.setNama(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    

    @Override
    public void update(data p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getAlat());
            statement.setDouble(3, p.getNomor());
            statement.setDouble(4, p.getSewa());
            
            double biaya = (p.getSewa())*50000;
            statement.setDouble(5, biaya);
            String temp = p.getNama();
            statement.setString(6, temp);
            
            statement.executeUpdate();       
            JOptionPane.showMessageDialog(null, "Success!");
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed!");
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, p);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success!");

        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed!");

        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }


    @Override
    public List<data> getAll() {
        List<data>dp=null;
        try{
            dp = new ArrayList<data>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                data g = new data();
                g.setNama(rs.getString("Nama"));
                g.setAlat(rs.getString("Alat"));
                g.setNomor(rs.getDouble("Nomor"));
                g.setSewa(rs.getDouble("Sewa"));
                g.setBiaya(rs.getDouble("Biaya"));
                dp.add(g);
            }
        }catch (SQLException ex){
            Logger.getLogger(dataDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dp;
    }
}
