package com.marek.shipment.service;

import com.marek.Application;
import com.marek.order.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by marek.papis on 2016-04-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ShippingContextTest {

    @Autowired
    private ShippingContext shippingContext;

    @Autowired
    private WarehouseShippingStrategy warehouseShippingStrategy;

    private Order order;

    @Before
    public void preTest() throws Exception {
        order = new Order();
        shippingContext.setShippingContext(warehouseShippingStrategy);
    }

    @Test
    public void shouldShipOrderCorrectly() throws Exception {
        assertThat(order).isEqualTo(shippingContext.shipOrder(order));
    }
}