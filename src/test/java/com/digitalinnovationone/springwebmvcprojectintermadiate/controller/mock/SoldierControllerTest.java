package com.digitalinnovationone.springwebmvcprojectintermadiate.controller.mock;

import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.SoldierController;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.request.SoldierEditRequest;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.request.SoldierRequest;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.dto.Soldier;
import com.digitalinnovationone.springwebmvcprojectintermadiate.entity.SoldierEntity;
import com.digitalinnovationone.springwebmvcprojectintermadiate.repository.SoldierRepository;
import com.digitalinnovationone.springwebmvcprojectintermadiate.resource.ResourceSoldier;
import com.digitalinnovationone.springwebmvcprojectintermadiate.service.SoldierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SoldierController.class)
public class SoldierControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Spy
    private ObjectMapper objectMapper;

    @MockBean
    private SoldierService soldierService;

    @Test
    public void callGet() throws Exception {
        SoldierEntity soldierEntity = SoldierEntity.create();
        ResourceSoldier resourceSoldier = new ResourceSoldier(objectMapper);
        SoldierResponse soldierResponse = resourceSoldier.createLinkDetail(soldierEntity);
        String jsonOutString = objectMapper.writerWithView(Soldier.class).writeValueAsString(soldierResponse);
        //precisa mockar pois necessita de um retorno
        when(soldierService.findSoldier(1L)).thenReturn(soldierResponse);

        mockMvc.perform(
                get("/v1/soldier/1")
                    .header("authorization", "test")
                    .content(jsonOutString)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "application/hal+json"));
    }

    @Test
    public void callPost() throws Exception {
        SoldierRequest soldierRequest = SoldierRequest.create();
        String jsonOutString = objectMapper.writerWithView(Soldier.class).writeValueAsString(soldierRequest);
        //se a classe estiver mockada pelo mockido não é necessário fazer essa declaração
        doNothing().when(soldierService).createSoldier(any());

        mockMvc.perform(
                post("/v1/soldier")
                    .header("authorization", "test")
                    .content(jsonOutString)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void callPut() throws Exception {
        SoldierRequest soldierRequest = SoldierRequest.create();
        String jsonOutString = objectMapper.writerWithView(Soldier.class).writeValueAsString(soldierRequest);
        mockMvc.perform(
                put("/v1/soldier/1")
                    .header("authorization", "test")
                    .content(jsonOutString)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void callDelete() throws Exception {
        mockMvc.perform(
                delete("/v1/soldier/1")
                    .header("authorization", "test")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
