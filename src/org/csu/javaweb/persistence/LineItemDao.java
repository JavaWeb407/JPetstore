package org.csu.javaweb.persistence;

import java.util.List;

import org.csu.javaweb.domain.LineItem;

public interface LineItemDao {

  List<LineItem> getLineItemsByOrderId(int orderId);

  void insertLineItem(LineItem lineItem);

}
