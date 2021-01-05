package org.csu.javaweb.persistence.impl;

import org.csu.javaweb.domain.CartItem;
import org.csu.javaweb.domain.Item;
import org.csu.javaweb.persistence.CartDao;
import org.csu.javaweb.service.CatalogService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private static final String GetCartItemListByUserId="select ItemId ItemNum from cart where UserId=?";
    private static final String SetCartItemList="INSERT cart (UserId, ItemId, ItemNum) VALUES (?,?,?);";
    private static final String UpDateCart="UPDATE cart set ItemId=?, ItemNum=? where UserId=?";
    @Override
    public List<CartItem> getCartItemListByUserId(String UserId) {
        List<CartItem> cartItems=new ArrayList<CartItem>();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GetCartItemListByUserId);
            preparedStatement.setString(1, UserId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                String ItemId=resultSet.getString(1);
                String ItemNum=resultSet.getString(2);
                String [] ItemIds=ItemId.split(",");
                int [] ItemNums=Arrays.asList(ItemNum.split(",")).stream().mapToInt(Integer::parseInt).toArray();
                for (int i=0;i<ItemIds.length;i++){
                    CartItem cartItem=new CartItem();
                    cartItem.setQuantity(ItemNums[i]);
                    CatalogService catalogService=new CatalogService();
                    Item item=catalogService.getItem(ItemIds[i]);
                    cartItem.setItem(item);
                    cartItems.add(cartItem);
                }
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setCartItemList(String UserId, List<CartItem> CartItemList) {
        String ItemIds = "",ItemNums="";
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SetCartItemList);
            for(CartItem cartItem:CartItemList){
                ItemIds=ItemIds+cartItem.getItem().getItemId()+",";
                ItemNums+=cartItem.getItem().getQuantity()+",";
                System.out.println(ItemIds);
                System.out.println(ItemNums);
            }
            preparedStatement.setString(1,ItemIds);
            preparedStatement.setString(2,ItemNums);
            preparedStatement.executeQuery();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void UpDateCart(String UserId, List<CartItem> CartItemList) {
        String ItemIds="",ItemNums="";
        try {
        Connection connection=DBUtil.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(UpDateCart);
            for(CartItem cartItem:CartItemList){
                ItemIds=ItemIds+cartItem.getItem().getItemId()+",";
                ItemNums+=cartItem.getItem().getQuantity()+",";
                System.out.println(ItemIds);
                System.out.println(ItemNums);
            }
            preparedStatement.setString(1,ItemIds);
            preparedStatement.setString(2,ItemNums);
            preparedStatement.setString(3,UserId);
            preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
