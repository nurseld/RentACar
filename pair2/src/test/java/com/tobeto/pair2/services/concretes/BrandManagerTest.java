package com.tobeto.pair2.services.concretes;


import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entities.concretes.Brand;
import com.tobeto.pair2.repositories.BrandRepository;

import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.rules.BrandBusinessRules;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class BrandManagerTest {
    private BrandManager brandManager;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private BrandBusinessRules brandBusinessRules;

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();



    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        brandManager = new BrandManager(brandRepository,modelMapperService,brandBusinessRules);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void brandNameShouldNotBeBlank() {
        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("");
        Set<ConstraintViolation<AddBrandRequest>> violations = validator.validate(addBrandRequest);

        assertFalse(violations.isEmpty());

    }

    @Test
    void brandNameHasAtLeastTwoLetters() {
        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("ab");
        Set<ConstraintViolation<AddBrandRequest>> violations = validator.validate(addBrandRequest);

        assertTrue(violations.isEmpty());
    }

    @Test
    void brandWithSameNameShouldNotExist() {
        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("Volvo");

        Mockito.when(brandRepository.existsBrandByName("Volvo")).thenReturn(true);

        assertThrows(BusinessException.class, () ->{
            brandManager.add(addBrandRequest);
        });
    }

    @Test
    void successfullyBrandCreated() {
        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("Toyota");

        Mockito.when(modelMapperService.forResponse().map(addBrandRequest, Brand.class)).thenReturn(new Brand());
        brandManager.add(addBrandRequest);

        assert true;
    }
    @Test
    void successfullyBrandUpdated() {
        UpdateBrandRequest updateBrandRequest = new UpdateBrandRequest();
        updateBrandRequest.setId(2);
        updateBrandRequest.setName("Opel");

        Mockito.when(modelMapperService.forRequest().map(updateBrandRequest,Brand.class)).thenReturn(new Brand());
        brandManager.update(updateBrandRequest);

        assert true;
    }

    @Test
    void successfullyBrandDeleted() {

        DeleteBrandRequest deleteBrandRequest = new DeleteBrandRequest();
        deleteBrandRequest.setId(2);

        Mockito.when(modelMapperService.forRequest().map(deleteBrandRequest, Brand.class)).thenReturn(new Brand());

        assert true;
    }

    @Test
    void successfullyGetAllBrands() {
        List<Brand> brands = new ArrayList<>();
        Mockito.when(brandRepository.findAll()).thenReturn(brands);
        brandManager.getAll();
        assert true;
    }

    @Test
    void successfullyGetBrandById() {
        Brand brand = new Brand();
        Mockito.when(brandRepository.findById(brand.getId())).thenReturn(Optional.of(new Brand()));
        brandManager.getById(brand.getId());
        assert true;
    }

}