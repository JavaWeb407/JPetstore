package org.csu.javaweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.csu.javaweb.domain.Item;
import org.csu.javaweb.domain.LineItem;
import org.csu.javaweb.domain.Order;
import org.csu.javaweb.domain.Sequence;
import org.csu.javaweb.persistence.ItemDao;
import org.csu.javaweb.persistence.LineItemDao;
import org.csu.javaweb.persistence.OrderDao;
import org.csu.javaweb.persistence.SequenceDao;
import org.csu.javaweb.persistence.impl.ItemDaoImpl;
import org.csu.javaweb.persistence.impl.LineItemDaoImpl;
import org.csu.javaweb.persistence.impl.OrderDaoImpl;
import org.csu.javaweb.persistence.impl.SequenceDaoImpl;


public class OrderService {


  private ItemDao itemDao=new ItemDaoImpl();
  private OrderDao orderMapper=new OrderDaoImpl();
  private SequenceDao sequenceDao =new SequenceDaoImpl();
  private LineItemDao lineItemMapper=new LineItemDaoImpl();

  public void insertOrder(Order order) {
    order.setOrderId(getNextId("ordernum"));
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      String itemId = lineItem.getItemId();
      Integer increment = new Integer(lineItem.getQuantity());
      Map<String, Object> param = new HashMap<String, Object>(2);
      param.put("itemId", itemId);
      param.put("increment", increment);
      itemDao.updateInventoryQuantity(param);
    }

    orderMapper.insertOrder(order);
    orderMapper.insertOrderStatus(order);
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      lineItem.setOrderId(order.getOrderId());
      lineItemMapper.insertLineItem(lineItem);
    }
  }


  public Order getOrder(int orderId) {
    Order order = orderMapper.getOrder(orderId);
    order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));

    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      Item item = itemDao.getItem(lineItem.getItemId());
      item.setQuantity(itemDao.getInventoryQuantity(lineItem.getItemId()));
      lineItem.setItem(item);
    }

    return order;
  }

  public List<Order> getOrdersByUsername(String username) {
    return orderMapper.getOrdersByUsername(username);
  }

  public int getNextId(String name) {
    Sequence sequence = new Sequence(name, -1);
    sequence = (Sequence) sequenceDao.getSequence(sequence);
    if (sequence == null) {
      throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
          + " sequence).");
    }
    Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
    sequenceDao.updateSequence(parameterObject);
    return sequence.getNextId();
  }

}
