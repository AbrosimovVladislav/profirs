package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.profi.order.model.Order;
import org.profi.order.service.CategoryService;
import org.profi.order.service.CustomerService;
import org.profi.order.service.SpecialistService;
import org.profi.order.web.dto.OrderDto;
import org.profi.order.web.request.OrderCreationRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

  private final CustomerService customerService;
  private final SpecialistService specialistService;
  private final CategoryService categoryService;

  public List<OrderDto> ordersToDtos(List<Order> orders) {
    return orders.stream().map(this::orderToDto).collect(Collectors.toList());
  }

  public OrderDto orderToDto(Order order) {
    return OrderDto.builder()
        .name(order.getName())
        .category(order.getCategory().getShowName())
        .description(order.getDescription())
        .customerId(order.getCustomer().getCustomerId())
        .customerName(order.getCustomer().getPerson().getName())
        .specialistId(
            order.getSpecialist() != null ? order.getSpecialist().getSpecialistId() : null)
        .specialistName(
            order.getSpecialist() != null ? order.getSpecialist().getPerson().getName() : null)
        .orderStatus(order.getOrderStatus().toString())
        .build();
  }

  public Order requestToOrder(OrderCreationRequest request) {
    return new Order()
        .setName(request.getName())
        .setCustomer(customerService.findById(request.getCustomerId()))
        .setOrderStatus(request.getOrderStatus())
        .setSpecialist(
            request.getSpecialistId() != null
                ? specialistService.findById(request.getSpecialistId())
                : null)
        .setCategory(categoryService.findByShowName(request.getCategory()))
        .setDescription(request.getDescription());
  }
}
