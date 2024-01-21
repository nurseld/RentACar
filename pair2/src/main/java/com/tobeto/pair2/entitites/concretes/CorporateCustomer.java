package com.tobeto.pair2.entitites.concretes;

import com.tobeto.pair2.entitites.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "corporate_customers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomer extends BaseEntity {

    @Column(name="company_name")
    private String companyName;
    @Column(name="tax_no")
    private String taxNo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
