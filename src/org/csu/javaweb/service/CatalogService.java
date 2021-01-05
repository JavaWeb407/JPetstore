package org.csu.javaweb.service;

import java.util.List;

import org.csu.javaweb.domain.CartItem;
import org.csu.javaweb.domain.Category;
import org.csu.javaweb.domain.Item;
import org.csu.javaweb.domain.Product;
import org.csu.javaweb.persistence.CartDao;
import org.csu.javaweb.persistence.CategoryDao;
import org.csu.javaweb.persistence.ItemDao;
import org.csu.javaweb.persistence.ProductDao;
import org.csu.javaweb.persistence.impl.CartDaoImpl;
import org.csu.javaweb.persistence.impl.CategoryDaoImpl;
import org.csu.javaweb.persistence.impl.ItemDaoImpl;
import org.csu.javaweb.persistence.impl.ProductDaoImpl;


public class CatalogService {

  private CategoryDao categoryDao=new CategoryDaoImpl();
  private ItemDao itemDao=new ItemDaoImpl();
  private ProductDao productDao=new ProductDaoImpl();
  private CartDao cartDao=new CartDaoImpl();

  public List<Category> getCategoryList() {

    return categoryDao.getCategoryList();
  }

  public Category getCategory(String categoryId) {
    return categoryDao.getCategory(categoryId);
  }

  public Product getProduct(String productId) {
    return productDao.getProduct(productId);
  }

  public List<Product> getProductListByCategory(String categoryId) {
    return productDao.getProductListByCategory(categoryId);
  }

  // TODO enable using more than one keyword
  public List<Product> searchProductList(String keyword) {
    return productDao.searchProductList("%" + keyword.toLowerCase() + "%");
  }

  public List<Item> getItemListByProduct(String productId) {
    return itemDao.getItemListByProduct(productId);
  }

  public Item getItem(String itemId) {

    return itemDao.getItem(itemId);
  }

  public boolean isItemInStock(String itemId) {

    return itemDao.getInventoryQuantity(itemId) > 0;
  }

  public void saveCart(String UserId,List<CartItem>i){
     cartDao.setCartItemList(UserId,i);
  }

  public List<CartItem> getCartItemByUserId(String UserId){
    return cartDao.getCartItemListByUserId(UserId);
  }
}