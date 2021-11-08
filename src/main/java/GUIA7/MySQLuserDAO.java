package GUIA7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLuserDAO implements userDAO {
    
    final String INSERT = "INSERT INTO user(id, name, last_name, mail, celphone) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE user set name = ?, last_name = ?, mail = ?, celphone = ? WHERE id = ?";
    final String DELETE = "DELETE FROM user WHERE id = ?";
    final String GETALL = "SELECT id, name last_name, mail, celphone FROM user";
    final String GETONE = "SELECT id, name last_name, mail, celphone FROM user WHERE id = ?";
    
    private Connection conn;
    
    public MySQLuserDAO(Connection conn){
        this.conn = conn;
    }
    
    
    @Override
    public void create(user a) throws DAOException {
        
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, a.getId());
            stat.setString(2, a.getName());
            stat.setString(3, a.getLast_name());
            stat.setString(4, a.getMail());
            stat.setString(5, a.getCelphone());
            if (stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado");
            }
        }catch (SQLException ex){
            throw new DAOException("Error en SQL", ex);
        }
        finally {
            if (stat !=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
            
        }
        
    }

    @Override
    public void read(user a) throws DAOException {

    }

    @Override
    public void update(user a) throws DAOException {
               
                PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getId());
            stat.setString(2, a.getName());
            stat.setString(3, a.getLast_name());
            stat.setString(4, a.getMail());
            stat.setString(5, a.getCelphone());
            if (stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado");
            }
        }catch (SQLException ex){
            throw new DAOException("Error en SQL", ex);
        }
        finally {
            if (stat !=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
            
        }
        
    }

    @Override
    public void delete(user a) throws DAOException{
                
                PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, a.getId());
            stat.setString(2, a.getName());
            stat.setString(3, a.getLast_name());
            stat.setString(4, a.getMail());
            stat.setString(5, a.getCelphone());
            if (stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado");
            }
        }catch (SQLException ex){
            throw new DAOException("Error en SQL", ex);
        }
        finally {
            if (stat !=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
            
        }
        
    }

    
private user convertir(ResultSet rs )throws SQLException{
       String name = rs.getString("name");
       String last_name = rs.getString("last_name");
       String mail = rs.getString("mail");
       String celphone = rs.getString("celphone");
       user user1 = new user(name, last_name, mail, celphone);
       user1.setId(rs.getString("id"));
       return user1;
        
    }
            
            
    @Override
    public List<user> getall(String id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        user user1 = null;
        List<user> users = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                users.add(convertir(rs));
            }
            if (rs.next()){
                
            }else{
                throw new DAOException("No se ha encontrado ese registro");
            }
        }catch(SQLException ex){
            throw new DAOException("ERROR en SQL", ex);
        }finally{
            if (rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("ERROR en SQL", ex);
                }
            }
            if (stat != null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("ERROR en SQL", ex);
                }
            
        }
            return users;
        }   
    }

    @Override
    public user get(String id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        user user1 = null;
        try{
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, id);
            rs = stat.executeQuery();
            if (rs.next()){
                
            }else{
                throw new DAOException("No se ha encontrado ese registro");
            }
        }catch(SQLException ex){
            throw new DAOException("ERROR en SQL", ex);
        }finally{
            if (rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("ERROR en SQL", ex);
                }
            }
            if (stat != null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("ERROR en SQL", ex);
                }
            
        }
            return user1;
        }   
    }

}
