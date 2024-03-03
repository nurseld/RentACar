package com.tobeto.pair2.entities.concretes;

import com.tobeto.pair2.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "corporate_customers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorporateCustomer extends BaseEntity {

    @Column(name="company_name")
    private String companyName;

    @Column(name="tax_no")
    private String taxNo;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="phone_number")
    private String phoneNumber;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
