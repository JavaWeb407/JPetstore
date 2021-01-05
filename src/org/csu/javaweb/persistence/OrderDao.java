package org.csu.javaweb.persistence;

import java.util.List;

import org.csu.javaweb.domain.Order;

public interface OrderDao {

  List<Order> getOrdersByUsername(String username);

  Order getOrder(int orderId);
  
  void insertOrder(Order order);
  
  void insertOrderStatus(Order order);

}
