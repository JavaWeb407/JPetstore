package org.csu.javaweb.persistence.impl;

import org.csu.javaweb.domain.Item;
import org.csu.javaweb.domain.Product;
import org.csu.javaweb.persistence.ItemDao;

import java.nio.FloatBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ItemDaoImpl implements ItemDao {

    private static final String getItemListByProduct= "SELECT I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER,\n" +
            "       I.PRODUCTID,NAME,\n" +
            "       DESCN ,CATEGORY ,STATUS,ATTR1,ATTR2,\n" +
            "       ATTR3,ATTR4,\n" +
            "       ATTR5 FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID\n" +
            "                                                    AND\n" +
            "       I.PRODUCTID = ?";
    private static final String getItem="select I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER,I.PRODUCTID,NAME,DESCN,CATEGORY,STATUS,ATTR1,ATTR2,ATTR4,ATTR5,QTY from ITEM I, INVENTORY V, PRODUCT P where P.PRODUCTID = I.PRODUCTID and I.ITEMID = V.ITEMID and I.ITEMID = ?";
    private static final String getInventoryQuantity="SELECT QTY AS value\n" +
            "    FROM INVENTORY\n" +
            "    WHERE ITEMID = ?";
    private static final String updateInventoryQuantity="UPDATE INVENTORY SET\n" +
            "      QTY = QTY - ? \n" +
            "    WHERE ITEMID = ?";
    @Override
    public void updateInventoryQuantity(Map<String, Object> param) {
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(updateInventoryQuantity);
            String itemId=param.keySet().iterator().next();
            Integer increment =(Integer) param.get("increment");
            System.out.println(increment.toString());
            preparedStatement.setInt(1, increment);
            preparedStatement.setString(2,itemId);
            preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getInventoryQuantity(String itemId) {
        int result=-1;
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(getInventoryQuantity);
            preparedStatement.setString(1,itemId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                result=resultSet.getInt(1);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Item> getItemListByProduct(String productId)
    {
        List<Item> itemList=new ArrayList<Item>();
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(getItemListByProduct);
            preparedStatement.setString(1,productId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Item item=new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product=new Product();
                product.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));

                itemList.add(item);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  itemList;
    }

    @Override
    public Item getItem(String itemId) {
        Item item =new Item();
        try {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getItem);
        pStatement.setString(1, itemId);
        ResultSet resultSet = pStatement.executeQuery();
        System.out.println(resultSet.toString());
        if(resultSet.next()){
            item = new Item();
            item.setItemId(resultSet.getString(1));
            item.setListPrice(resultSet.getBigDecimal(2));
            item.setUnitCost(resultSet.getBigDecimal(3));
            item.setSupplierId(resultSet.getInt(4));
            Product product = new Product();
            product.setProductId(resultSet.getString(5));
            product.setName(resultSet.getString(6));
            product.setDescription(resultSet.getString(7));
            product.setCategoryId(resultSet.getString(8));
            item.setProduct(product);
            item.setStatus(resultSet.getString(9));
            item.setAttribute1(resultSet.getString(10));
            item.setAttribute2(resultSet.getString(11));
            item.setAttribute3(resultSet.getString(12));
            item.setAttribute4(resultSet.getString(13));
            item.setAttribute5(resultSet.getString(14));
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedStatement(pStatement);
        DBUtil.closeConnection(connection);
    }catch (Exception e){
        e.printStackTrace();
    }
        return item;
    }
}
