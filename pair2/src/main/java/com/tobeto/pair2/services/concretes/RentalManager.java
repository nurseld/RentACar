package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.utilities.mapper.ModelMapperService;
import com.tobeto.pair2.entitites.Rental;
import com.tobeto.pair2.repositories.RentalRepository;
import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.abstracts.RentalService;
import com.tobeto.pair2.services.abstracts.UserService;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair2.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair2.services.dtos.rental.responses.GetAllRentalResponse;
import com.tobeto.pair2.services.dtos.rental.responses.GetByIdRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final UserService userService;
    private final CarService carService;


    @Override
    public void add(AddRentalRequest request) {

        LocalDate startDate = request.getStartDate();

        if (startDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("The start date of the rental can not be earlier than today.");
        }

        LocalDate endDate = request.getEndDate();
        if (endDate.isBefore(startDate)) {
            throw new RuntimeException("The end date of the rental can not be later than the start date.");
        }

        if (startDate.plusDays(25).isBefore(endDate)) {
            throw new RuntimeException("A car can be rented for 25 days at most.");
        }

        if(!userService.existsByUserId(request.getUserId())) {
            throw new RuntimeException("The User must exist in the database.");
        }

        if(!carService.existsByCarId(request.getCarId())) {
            throw new RuntimeException("The Car must exist in the database.");
        }


        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);

        GetByIdCarResponse carId = carService.getById(request.getCarId());
        rental.setStartKilometer(carId.getKilometer());

        if(rental.getReturnDate() == null){

            Double totalPrice = ChronoUnit.DAYS.between(rental.getStartDate(),rental.getEndDate())* carId.getDailyPrice();
            rental.setTotalPrice(totalPrice);
        } else{
            Double totalPrice = ChronoUnit.DAYS.between(rental.getStartDate(),rental.getReturnDate())* carId.getDailyPrice();
            rental.setTotalPrice(totalPrice);
        }

        this.rentalRepository.save(rental);



    }


    @Override
    public void update(UpdateRentalRequest request) {

        if(!rentalRepository.existsById(request.getId())){
            throw new RuntimeException("RentalId not found");
        }

        LocalDate startDate = request.getStartDate();

        if (startDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("The start date of the rental can not be earlier than today.");
        }

        LocalDate endDate = request.getEndDate();
        if (endDate.isBefore(startDate)) {
            throw new RuntimeException("The end date of the rental can not be later than the start date.");
        }

        if (startDate.plusDays(25).isBefore(endDate)) {
            throw new RuntimeException("A car can be rented for 25 days at most.");
        }

        if(!userService.existsByUserId(request.getUserId())) {
            throw new RuntimeException("The User must exist in the database.");
        }

        if(!carService.existsByCarId(request.getCarId())) {
            throw new RuntimeException("The Car must exist in the database.");
        }


        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);

        GetByIdCarResponse carId = carService.getById(request.getCarId());
        rental.setStartKilometer(carId.getKilometer());

        if(rental.getReturnDate() == null){

            Double totalPrice = ChronoUnit.DAYS.between(rental.getStartDate(),rental.getEndDate())* carId.getDailyPrice();
            rental.setTotalPrice(totalPrice);
        } else{
            Double totalPrice = ChronoUnit.DAYS.between(rental.getStartDate(),rental.getReturnDate())* carId.getDailyPrice();
            rental.setTotalPrice(totalPrice);
        }

        this.rentalRepository.saveAndFlush(rental);

    }

    @Override
    public void delete(Integer id) {

        Rental rentalToDelete = this.rentalRepository.findById(id).orElseThrow();
        this.rentalRepository.delete(rentalToDelete);
    }


    public List<GetAllRentalResponse> getAll() {

        List<Rental> rentals = rentalRepository.findAll();
        List<GetAllRentalResponse> rentalResponses = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse().map(rental,GetAllRentalResponse.class)).toList();
        return rentalResponses;
    }

    @Override
    public GetByIdRentalResponse getById(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        GetByIdRentalResponse response = this.modelMapperService.forResponse().map(rental,GetByIdRentalResponse.class);
        return response;
    }
}
