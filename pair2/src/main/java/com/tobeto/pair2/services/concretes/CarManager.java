package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entities.concretes.Car;
import com.tobeto.pair2.entities.concretes.Rental;
import com.tobeto.pair2.repositories.CarRepository;
import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.dtos.rental.requests.AvailableCarRentalRequest;
import com.tobeto.pair2.services.rules.CarBusinessRules;
import com.tobeto.pair2.services.rules.RentalBusinessRules;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service

public class CarManager implements CarService {
    private  CarRepository carRepository;
    private  ModelMapperService modelMapperService;
    private  CarBusinessRules carBusinessRules;
    private  RentalBusinessRules rentalBusinessRules;

    public CarManager(CarRepository carRepository, ModelMapperService modelMapperService, CarBusinessRules carBusinessRules, @Lazy RentalBusinessRules rentalBusinessRules) {
        this.carRepository = carRepository;
        this.modelMapperService = modelMapperService;
        this.carBusinessRules = carBusinessRules;
        this.rentalBusinessRules = rentalBusinessRules;
    }

    @Override
    public void add(AddCarRequest request) {

       this.carBusinessRules.checkIfCarPlateExists(request.getPlate());
       this.carBusinessRules.checkIfModelIdExists(request.getModelId());
       this.carBusinessRules.checkIfColorIdExists(request.getColorId());

        Car car = this.modelMapperService.forRequest().map(request, Car.class);
        this.carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest request) {

        Car car = this.modelMapperService.forRequest().map(request, Car.class);
        this.carRepository.save(car);

    }

    @Override
    public void delete(Integer id) {

        Car car = this.carRepository.findById(id).orElseThrow();
        this.carRepository.delete(car);
    }


    @Override
    public List<GetAllCarResponse> getAll() {

        List<Car> cars = carRepository.findAll();
        List<GetAllCarResponse> carResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car,GetAllCarResponse.class)).toList();
        return carResponses;
    }

    @Override
    public GetByIdCarResponse getById(int id) {

        Car car = carRepository.findById(id).orElseThrow();
        GetByIdCarResponse response = this.modelMapperService.forResponse().map(car,GetByIdCarResponse.class);
        return response;

    }

    @Override
    public boolean existsByCarId(int carId) {

        return carRepository.existsById(carId);
    }

    @Override
    public List<GetAllCarResponse> listAvailableCarsForRent(AvailableCarRentalRequest request) {

        this.rentalBusinessRules.checkIfStartDateBeforeToday(request.getStartDate());
        this.rentalBusinessRules.checkIfEndDateBeforeStartDate(request.getEndDate(),request.getStartDate());
        this.rentalBusinessRules.checkIfRentalDayExceed(request.getStartDate(),request.getEndDate());

        LocalDate startDate = request.getStartDate();
        LocalDate endDate = request.getEndDate();

        List<Car> cars = carRepository.findAll(); // Tüm arabaları getir
        List<GetAllCarResponse> availableCars = new ArrayList<>();

        for (Car car : cars) {
            // Araba, verilen tarih aralığında kiralanabilir mi kontrol et
            if (isCarAvailableForRent(car, startDate, endDate)) {
                GetAllCarResponse carResponse = modelMapperService.forResponse().map(car, GetAllCarResponse.class);
                availableCars.add(carResponse);
            }
        }

        return availableCars;
    }

    private boolean isCarAvailableForRent(Car car, LocalDate startDate, LocalDate endDate) {

        List<Rental> rentals = car.getRentals();
        for (Rental rental : rentals) {
            // Verilen tarih aralığı, mevcut kiralama aralığı ile çakışıyor mu kontrol et
            if (isDateRangeOverlap(rental.getStartDate(), rental.getEndDate(), startDate, endDate)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDateRangeOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }

}



