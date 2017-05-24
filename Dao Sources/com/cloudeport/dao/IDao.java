package com.cloudeport.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
 
 

public interface IDao {
	
	public <T> int insert(T obj) throws DataAccessException;
	
	public <T> int update(T obj) throws DataAccessException;
	
	public <T> int delete(T obj) throws DataAccessException;

    /**
     * 根据主键寻找记录
     * @param <T>
     * @param gameObject
     * @return
     */
    public <T> T getByPk(String  gId);
    
    /**
     * 自定义条件查询
     * @param <T>
     * @param thisClass
     * @param condition
     * @return
     * @throws DataAccessException
     */
    public <T> List<T> getListByCondition(Map<String, String> condition) throws DataAccessException;
    
    public <T> T getObjectByCondition(Map<String, String> condition) throws DataAccessException;
}
