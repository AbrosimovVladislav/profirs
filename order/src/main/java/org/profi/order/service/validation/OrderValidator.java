package org.profi.order.service.validation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.profi.order.exception.CannotUpdateOrderStatusException;
import org.profi.order.exception.NotAllRequiredFieldsFilledException;
import org.profi.order.model.Category;
import org.profi.order.model.CategoryProperty;
import org.profi.order.model.Order;
import org.profi.order.model.Question;
import org.profi.order.model.Specialist;
import org.profi.order.service.CategoryQuestionService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderValidator {

  private final CategoryQuestionService categoryQuestionService;

  public void validateBeforePublish(Order order) {
    Order.OrderStatus orderStatus = order.getOrderStatus();
    if (!orderStatus.equals(Order.OrderStatus.DRAFT)
        && !orderStatus.equals(Order.OrderStatus.IN_PROGRESS)
        && !orderStatus.equals(Order.OrderStatus.CLOSED)) {
      throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.PUBLISHED);
    }

    validateRequiredCategoryProperties(order);
  }

  public void validateBeforeDraft(Order order) {
    Order.OrderStatus orderStatus = order.getOrderStatus();
    if (!orderStatus.equals(Order.OrderStatus.PUBLISHED)) {
      throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.DRAFT);
    }
  }

  public void validateBeforeSetInProgress(Order order) {
    Order.OrderStatus orderStatus = order.getOrderStatus();
    Specialist specialist = order.getSpecialist();

    if (!orderStatus.equals(Order.OrderStatus.PUBLISHED)
        || specialist == null || specialist.getPerson() == null) {
      throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.IN_PROGRESS);
    }
  }

  public void validateBeforeClose(Order order) {
    Order.OrderStatus orderStatus = order.getOrderStatus();
    if (!orderStatus.equals(Order.OrderStatus.PUBLISHED)
        && !orderStatus.equals(Order.OrderStatus.DRAFT)) {
      throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.CLOSED);
    }
  }

  public void validateBeforeResolve(Order order) {
    Order.OrderStatus orderStatus = order.getOrderStatus();
    if (!orderStatus.equals(Order.OrderStatus.IN_PROGRESS)) {
      throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.RESOLVED);
    }
  }

  private void validateRequiredCategoryProperties(Order order) {
    Category category = order.getCategory();
    List<Question> questions = categoryQuestionService.getByCategoryId(category.getCategoryId());
    List<String> propertyNames = order.getCategoryProperties().stream()
        .map(CategoryProperty::getKey).toList();

    List<String> notFilledProperties = questions.stream()
        .filter(Question::getRequired)
        .map(Question::getPropertyName)
        .filter(questionPropertyName -> !propertyNames.contains(questionPropertyName)).toList();

    if (notFilledProperties.size() > 0) {
      throw new NotAllRequiredFieldsFilledException(String.join(",", notFilledProperties)
      );
    }

  }

}
