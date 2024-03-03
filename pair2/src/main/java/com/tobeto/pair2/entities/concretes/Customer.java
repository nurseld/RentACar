package com.tobeto.pair2.entities.concretes;

import com.tobeto.pair2.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "customers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends BaseEntity {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="national_id_no")
    private String nationalIdNo;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
}
