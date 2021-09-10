package com.digitalinnovationone.springwebmvcprojectintermadiate.config;

import com.digitalinnovationone.springwebmvcprojectintermadiate.enums.Race;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Jackson {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //PROPIEDADES NÂO MAPEADAS Não quebram
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //FALHA SE ALGUMA PROPIEDADE ESTIVER VAZIA
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // SERVE Para compatiblidade de arrays, quando tem um array com um item, caso não tenha essa config ele se perde
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        //Serelize datas
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(raceModuleMapper());
        return objectMapper;
    }

    public SimpleModule raceModuleMapper() {
        SimpleModule dateModule = new SimpleModule("JSONRaceModule", PackageVersion.VERSION);
        dateModule.addSerializer(Race.class, new RaceSerialize());
        dateModule.addDeserializer(Race.class, new RaceDeserialize());
        return dateModule;
    }

    class RaceSerialize extends StdSerializer<Race> {

        public RaceSerialize() {
            super(Race.class);
        }

        @Override
        public void serialize(Race race, JsonGenerator json, SerializerProvider provider) throws IOException {
            json.writeString(race.getValue());
        }
    }

    class RaceDeserialize extends StdDeserializer<Race> {
        public RaceDeserialize() {
            super(Race.class);
        }

        @Override
        public Race deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String value =  p.getText();
            return Race.of(p.getText());
        }
    }
}
