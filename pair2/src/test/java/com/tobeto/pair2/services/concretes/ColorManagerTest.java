package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entities.concretes.Color;
import com.tobeto.pair2.repositories.ColorRepository;
import com.tobeto.pair2.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair2.services.dtos.color.responses.GetAllColorResponse;
import com.tobeto.pair2.services.rules.ColorBusinessRules;
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

import static org.junit.jupiter.api.Assertions.*;

class ColorManagerTest {

    private ColorManager colorManager;
    @Mock
    private ColorRepository colorRepository;
    @Mock
    private ModelMapperService modelMapperService;
    @Mock
    private ColorBusinessRules colorBusinessRules;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        colorManager = new ColorManager(colorRepository, modelMapperService,colorBusinessRules);
    }

    @AfterEach
    void tearDown () {

    }

    @Test
    void colorWithSameNameShouldNotExist () {
        AddColorRequest addColorRequest = new AddColorRequest();
        addColorRequest.setName("Blue");

        Mockito.when(colorRepository.existsColorByName("Blue")).thenReturn(true);

         assertThrows(RuntimeException.class, () -> {
            colorManager.add(addColorRequest);
        });
    }

    @Test
    void colorSuccessfullyAdded() {
        AddColorRequest addColorRequest = new AddColorRequest();
        addColorRequest.setName("Black");

        Mockito.when(modelMapperService.forRequest().map(addColorRequest, Color.class)).thenReturn(new Color());
        colorManager.add(addColorRequest);

        assert true;
    }

    @Test
    void colorSuccessfullyDeleted() {

        DeleteColorRequest deleteColorRequest = new DeleteColorRequest();
        deleteColorRequest.setId(1);

        Mockito.when(colorRepository.findById(1)).thenReturn(Optional.of(new Color()));
        colorManager.delete(deleteColorRequest.getId());
        assert true;

    }

    @Test
    void colorSuccessfullyUpdated() {
        UpdateColorRequest updateColorRequest = new UpdateColorRequest();
        updateColorRequest.setId(4);
        updateColorRequest.setName("Green");

        Mockito.when(modelMapperService.forRequest().map(updateColorRequest,Color.class)).thenReturn(new Color());
        colorManager.update(updateColorRequest);

        assert true;

    }

    @Test
    void getAllColorMethod() {
        List<Color> colors = new ArrayList<>();
        Mockito.when(colorRepository.findAll()).thenReturn(colors);
        colorManager.getAll();
        assert true;
    }

    @Test
    void colorGetByIdMethod() {
        Color color = new Color();
        Mockito.when(colorRepository.findById(color.getId())).thenReturn(Optional.of(new Color()));
        colorManager.getById(color.getId());
        assert true;
    }

    @Test
    void colorIdShouldExistsExceptionCase() {
        Color color = new Color();
        color.setId(2);
        Mockito.when(colorRepository.findById(color.getId())).thenReturn(Optional.empty());
        Mockito.when(modelMapperService.forResponse().map(color, GetAllColorResponse.class));
        assertThrows(RuntimeException.class, () -> colorManager.getById(color.getId()));
    }


}