package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.RentalRepository;
import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.abstracts.UserService;
import com.tobeto.pair2.services.constants.BusinessMessages;
import com.tobeto.pair2.services.constants.BusinessRuleConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class RentalBusinessRules {

    private RentalRepository rentalRepository;
    private UserService userService;
    private CarService carService;


    public void checkIfUserIdExists(Integer id){
        if(!userService.existsByUserId(id)){
            throw new BusinessException(BusinessMessages.Rental.USER_ID_MUST_EXISTS);
        }
    }

    public void checkIfCarIdExists(Integer id){
        if(!carService.existsByCarId(id)){
            throw new BusinessException(BusinessMessages.Rental.CAR_ID_MUST_EXISTS);
        }
    }

    public void checkIfStartDateBeforeToday(LocalDate startDate){
        if(startDate.isBefore(LocalDate.now())){
            throw new BusinessException(BusinessMessages.Rental.START_DATE_MUST_AFTER_TODAY);
        }
    }

    public void checkIfEndDateBeforeStartDate(LocalDate endDate, LocalDate startDate){
        if(endDate.isBefore(startDate)){
            throw new BusinessException(BusinessMessages.Rental.END_DATE_MUST_LATER_START_DATE);

        }
    }

    public void checkIfRentalDayExceed(LocalDate startDate,LocalDate endDate){
        if(startDate.plusDays(BusinessRuleConstants.Rental.RENTAL_DAY_LIMIT).isBefore(endDate)){
            throw new BusinessException(BusinessMessages.Rental.rentalDayLimit());
        }
    }
}
