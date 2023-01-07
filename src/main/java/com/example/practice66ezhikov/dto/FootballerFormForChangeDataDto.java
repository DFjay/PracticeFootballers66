package com.example.practice66ezhikov.dto;

import com.example.practice66ezhikov.enums.Countries;
import com.example.practice66ezhikov.enums.Sexes;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FootballerFormForChangeDataDto {
    @NotNull(message = "ID не может быть null")
    Integer id;

    @Size(max = 255)
    String firstName;

    @Size(max = 255)
    String secondName;

    Sexes sex;

    @Past
    LocalDate birthday;

    @Size(max = 255)
    String teamName;

    @Size(max = 255)
    String insteadTeamName;

    Countries country;
}
