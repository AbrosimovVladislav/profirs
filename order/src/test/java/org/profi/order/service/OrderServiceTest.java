package org.profi.order.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.profi.order.exception.CannotUpdateOrderStatusException;
import org.profi.order.model.Category;
import org.profi.order.model.Order;
import org.profi.order.model.Person;
import org.profi.order.model.Specialist;
import org.profi.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.profi.order.model.Order.OrderStatus.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @MockBean
    OrderRepo orderRepo;

    @SpyBean
    OrderValidator orderValidator;

    @Autowired
    OrderService orderService;

    @Captor
    ArgumentCaptor<Order> orderCaptor;

    @Test
    public void testSuccessPublishing() {
        Order draftOrder = getByStatus(DRAFT);
        Order published = getByStatus(PUBLISHED);

        when(orderRepo.findById(1L)).thenReturn(Optional.of(draftOrder));
        when(orderRepo.save(any())).thenReturn(published);

        Order order = orderService.publish(1L);

        assertEquals(draftOrder.getOrderId(), order.getOrderId());
        verify(orderRepo, times(1)).findById(any());
        verify(orderValidator, times(1)).validateBeforePublish(any());
        verify(orderRepo, times(1)).save(orderCaptor.capture());
        assertEquals(orderCaptor.getValue().getOrderStatus(), PUBLISHED);
    }

    @Test
    public void testFailedPublishing() {
        Order resolvedOrder = getByStatus(RESOLVED);
        when(orderRepo.findById(1L)).thenReturn(Optional.of(resolvedOrder));

        CannotUpdateOrderStatusException exception = Assertions.assertThrows(CannotUpdateOrderStatusException.class, () -> {
            orderService.publish(1L);
        });

        Assertions.assertEquals("Can not set order status to PUBLISHED from status RESOLVED",
                exception.getMessage());
    }

    @Test
    public void testSuccessDraft() {
        Order draftOrder = getByStatus(DRAFT);
        Order published = getByStatus(PUBLISHED);

        when(orderRepo.findById(1L)).thenReturn(Optional.of(published));
        when(orderRepo.save(any())).thenReturn(draftOrder);

        Order order = orderService.draft(1L);

        assertEquals(published.getOrderId(), order.getOrderId());
        verify(orderRepo, times(1)).findById(any());
        verify(orderValidator, times(1)).validateBeforeDraft(any());
        verify(orderRepo, times(1)).save(orderCaptor.capture());
        assertEquals(orderCaptor.getValue().getOrderStatus(), DRAFT);
    }

    @Test
    public void testFailedDraft() {
        Order resolvedOrder = getByStatus(IN_PROGRESS);
        when(orderRepo.findById(1L)).thenReturn(Optional.of(resolvedOrder));

        CannotUpdateOrderStatusException exception = Assertions.assertThrows(CannotUpdateOrderStatusException.class, () -> {
            orderService.draft(1L);
        });

        Assertions.assertEquals("Can not set order status to DRAFT from status IN_PROGRESS",
                exception.getMessage());
    }

    @Test
    public void testSuccessInProgress() {
        Order published = getByStatusWithSpecialist(PUBLISHED);
        Order inProgressOrder = getByStatusWithSpecialist(IN_PROGRESS);

        when(orderRepo.save(any())).thenReturn(inProgressOrder);

        Order order = orderService.inProgress(published);

        assertEquals(published.getOrderId(), order.getOrderId());
        verify(orderValidator, times(1)).validateBeforeSetInProgress(any());
        verify(orderRepo, times(1)).save(orderCaptor.capture());
        assertEquals(orderCaptor.getValue().getOrderStatus(), IN_PROGRESS);
        assertEquals(orderCaptor.getValue().getSpecialist().getSpecialistId(), 100L);
    }

    @Test
    public void testFailedInProgress() {
        Order published = getByStatus(PUBLISHED);

        CannotUpdateOrderStatusException exceptionWithoutSpec = Assertions.assertThrows(CannotUpdateOrderStatusException.class, () -> {
            orderService.inProgress(published);
        });

        Assertions.assertEquals("Impossible to set status of order to IN_PROGRESS if there is no specialist",
                exceptionWithoutSpec.getMessage());

        Order closed = getByStatusWithSpecialist(CLOSED);

        CannotUpdateOrderStatusException exceptionWithWrongStatus = Assertions.assertThrows(CannotUpdateOrderStatusException.class, () -> {
            orderService.inProgress(closed);
        });

        Assertions.assertEquals("Can not set order status to IN_PROGRESS from status CLOSED",
                exceptionWithWrongStatus.getMessage());
    }

    @Test
    public void testSuccessClose() {
        Order closedOrder = getByStatus(CLOSED);
        Order published = getByStatus(PUBLISHED);

        when(orderRepo.findById(1L)).thenReturn(Optional.of(published));
        when(orderRepo.save(any())).thenReturn(closedOrder);

        Order order = orderService.close(1L);

        assertEquals(published.getOrderId(), order.getOrderId());
        verify(orderRepo, times(1)).findById(any());
        verify(orderValidator, times(1)).validateBeforeClose(any());
        verify(orderRepo, times(1)).save(orderCaptor.capture());
        assertEquals(orderCaptor.getValue().getOrderStatus(), CLOSED);
    }

    @Test
    public void testFailedClose() {
        Order inProgressOrder = getByStatus(IN_PROGRESS);
        when(orderRepo.findById(1L)).thenReturn(Optional.of(inProgressOrder));

        CannotUpdateOrderStatusException exception = Assertions.assertThrows(CannotUpdateOrderStatusException.class, () -> {
            orderService.close(1L);
        });

        Assertions.assertEquals("Can not set order status to CLOSED from status IN_PROGRESS",
                exception.getMessage());
    }

    @Test
    public void testSuccessResolve() {
        Order resolvedOrder = getByStatusWithSpecialist(RESOLVED);
        Order inProgressOrder = getByStatusWithSpecialist(IN_PROGRESS);

        when(orderRepo.findById(1L)).thenReturn(Optional.of(inProgressOrder));
        when(orderRepo.save(any())).thenReturn(resolvedOrder);

        Order order = orderService.resolve(1L);

        assertEquals(inProgressOrder.getOrderId(), order.getOrderId());
        verify(orderRepo, times(1)).findById(any());
        verify(orderValidator, times(1)).validateBeforeResolve(any());
        verify(orderRepo, times(1)).save(orderCaptor.capture());
        assertEquals(orderCaptor.getValue().getOrderStatus(), RESOLVED);
        assertEquals(orderCaptor.getValue().getSpecialist().getSpecialistId(), 100L);
    }

    @Test
    public void testFailedResolve() {
        Order closedOrder = getByStatus(CLOSED);
        when(orderRepo.findById(1L)).thenReturn(Optional.of(closedOrder));

        CannotUpdateOrderStatusException exception = Assertions.assertThrows(CannotUpdateOrderStatusException.class, () -> {
            orderService.resolve(1L);
        });

        Assertions.assertEquals("Can not set order status to RESOLVED from status CLOSED",
                exception.getMessage());
    }

    private Order getByStatus(Order.OrderStatus status) {
        return new Order()
                .setOrderId(1L)
                .setOrderStatus(status)
                .setCategory(new Category().setCategoryId(1L).setShowName("TestCategory"))
                .setName("TestOrder")
                .setDescription("TestOrderDesc");
    }

    private Order getByStatusWithSpecialist(Order.OrderStatus status) {
        return new Order()
                .setOrderId(1L)
                .setOrderStatus(status)
                .setCategory(new Category().setCategoryId(1L).setShowName("TestCategory"))
                .setName("TestOrder")
                .setSpecialist(new Specialist().setSpecialistId(100L).setPerson(new Person().setPersonId(101L)))
                .setDescription("TestOrderDesc");
    }

}
