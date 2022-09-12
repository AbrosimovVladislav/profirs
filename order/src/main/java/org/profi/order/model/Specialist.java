package org.profi.order.model;

import static org.profi.order.model.Category.CATEGORY_ID;
import static org.profi.order.model.Person.PERSON_ID;

import javax.persistence.*;

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
public class Specialist {

    public static final String SPECIALIST_ID = "specialist_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialistId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = PERSON_ID, referencedColumnName = PERSON_ID)
    private Person person;

    @ManyToOne
    @JoinColumn(name = CATEGORY_ID, nullable = false)
    private Category category;

}
