package com.ganglia_java.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ganglia_java.core.mapper.GridMapper;
import com.ganglia_java.core.model.Grid;

@Service
public class GridService {
	 
	 @Autowired
     private GridMapper gridMapper;

     public List<Grid> selectAll() {
        return gridMapper.selectAll();
     }
     
     public Grid selectByName(String gridName){
    	 return gridMapper.selectByName(gridName);
     }
     
     public void insertGrid(Grid grid){
        gridMapper.insertGrid(grid);
     }
     
     public void updateGrid(Grid newGrid,String oldGridName){
        gridMapper.updateGrid(newGrid,oldGridName);
     }
     
     public void deleteGrid(Grid grid){
        gridMapper.deleteGrid(grid);
     }
     
}
