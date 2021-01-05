package org.csu.javaweb.persistence.impl;

import org.csu.javaweb.domain.Category;
import org.csu.javaweb.persistence.CategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private static  final String Get_Category_list="SELECT\n" +
            "      CATID AS categoryId,\n" +
            "      NAME,\n" +
            "      DESCN AS description\n" +
            "    FROM CATEGORY" ;
    private static  final String Get_Category="SELECT CATID ,NAME,DESCN  FROM CATEGORY WHERE CATID =?";

    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList=new ArrayList<Category>();
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(Get_Category_list);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Category category=new Category();
                category.setCategoryId(resultSet.getString(1));
                category.setName(resultSet.getString(2));
                
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getCategory(String categoryId) {
        Category category=new Category();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Get_Category);
            preparedStatement.setString(1, categoryId );
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setCategoryId(resultSet.getString("CATID"));
                category.setName(resultSet.getString("NAME"));
                category.setDescription(resultSet.getString("DESCN"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return category;
    }
}
