package com.tobeto.pair2.services.dtos.model.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelResponse {

    private Integer id;

    private String name;

    private int brandId;
}
