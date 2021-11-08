package GUIA7;

import java.util.List;

public interface DAO<T, K> {
    void create(T a) throws DAOException;
    
    void read(T a) throws DAOException;
    
    void update(T a) throws DAOException;
    
    void delete(T a) throws DAOException;
    
    List<T> getall(String id) throws DAOException;
    
    T get(String id) throws DAOException;
    
}
