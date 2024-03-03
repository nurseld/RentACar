package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entities.concretes.Invoice;
import com.tobeto.pair2.entities.concretes.Rental;
import com.tobeto.pair2.repositories.RentalRepository;
import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.abstracts.InvoiceService;
import com.tobeto.pair2.services.abstracts.RentalService;
import com.tobeto.pair2.services.abstracts.UserService;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair2.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair2.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair2.services.dtos.rental.responses.GetAllRentalResponse;
import com.tobeto.pair2.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.pair2.services.dtos.rental.responses.OrderResponse;
import com.tobeto.pair2.services.rules.RentalBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final RentalBusinessRules rentalBusinessRules;
    private final CarService carService;
    private final UserService userService;
    private final InvoiceService invoiceService;

    @Override
    @Transactional
    public OrderResponse add(AddRentalRequest request) {


        this.rentalBusinessRules.checkIfStartDateBeforeToday(request.getStartDate());
        this.rentalBusinessRules.checkIfEndDateBeforeStartDate(request.getEndDate(),request.getStartDate());
        this.rentalBusinessRules.checkIfRentalDayExceed(request.getStartDate(),request.getEndDate());
        this.rentalBusinessRules.checkIfUserIdExists(request.getUserId());
        this.rentalBusinessRules.checkIfCarIdExists(request.getCarId());


        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);

        GetByIdCarResponse carId = carService.getById(request.getCarId());
        rental.setStartKilometer(carId.getKilometer());

        Double totalPrice;
        if(rental.getReturnDate() == null){
            totalPrice = ChronoUnit.DAYS.between(rental.getStartDate(),rental.getEndDate())* carId.getDailyPrice();
            rental.setTotalPrice(totalPrice);
        } else{
            totalPrice = ChronoUnit.DAYS.between(rental.getStartDate(),rental.getReturnDate())* carId.getDailyPrice();
            rental.setTotalPrice(totalPrice);
        }

        Rental createdRental = this.rentalRepository.save(rental);
        Invoice createdInvoice = invoiceService.add(new AddInvoiceRequest(LocalDate.now(),createdRental.getId(),totalPrice));
        OrderResponse orderResponse = new OrderResponse(createdRental,createdInvoice,carId);
        return orderResponse;




    }


    @Override
    public void update(UpdateRentalRequest request) {


        this.rentalBusinessRules.checkIfRentalIdExists(request.getId());
        this.rentalBusinessRules.checkIfStartDateBeforeToday(request.getStartDate());
        this.rentalBusinessRules.checkIfEndDateBeforeStartDate(request.getEndDate(),request.getStartDate());
        this.rentalBusinessRules.checkIfRentalDayExceed(request.getStartDate(),request.getEndDate());
        this.rentalBusinessRules.checkIfUserIdExists(request.getUserId());
        this.rentalBusinessRules.checkIfCarIdExists(request.getCarId());


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

    @Override
    public List<GetAllRentalResponse> getByUserId(int id) {

        List<Rental> rentals =  rentalRepository.findByUserId(id);

        List<GetAllRentalResponse> rentalResponses = rentals.stream()
                .map(rental -> {GetAllRentalResponse getAllRentalResponse =
                        this.modelMapperService.forResponse().map(rental,GetAllRentalResponse.class);
                               Invoice invoice =  invoiceService.findByRentalId(rental.getId());
                               getAllRentalResponse.setInvoiceNo(invoice.getInvoiceNo());

                return getAllRentalResponse;
                }).toList();
        return rentalResponses;
    }
}
