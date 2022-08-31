package org.profi.order.web.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationRequest {

  private String name;
  private Long customerId;
  private Long categoryId;
  private String description;
  private List<CustomerAnswer> customerAnswers;

}
