package org.profi.order.model;

import static org.profi.order.model.Person.PERSON_ID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Customer {

  public static final String CUSTOMER_ID = "customer_id";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = PERSON_ID, referencedColumnName = PERSON_ID)
  private Person person;

}
