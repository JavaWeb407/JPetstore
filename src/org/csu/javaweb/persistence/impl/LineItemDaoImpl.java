package org.csu.javaweb.persistence.impl;

import org.csu.javaweb.domain.LineItem;
import org.csu.javaweb.persistence.LineItemDao;

import java.util.List;

public class LineItemDaoImpl implements LineItemDao {
    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) {
        return null;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {

    }
}
