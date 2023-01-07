package com.example.practice66ezhikov.service.db;

import com.example.practice66ezhikov.dto.FootballerFormDto;
import com.example.practice66ezhikov.dto.FootballerFormForChangeDataDto;
import com.example.practice66ezhikov.entity.FootballerEntity;
import com.example.practice66ezhikov.repo.FootballerEntityRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FootballerEntityService {
    FootballerEntityRepository repo;

    /**
     * Добавить нового футболиста в БД
     *
     * @param form необходимая информация о футболисте
     */
    @Transactional
    public void addFootballer(FootballerFormDto form) {
        FootballerEntity footballer = FootballerEntity.builder()
                .firstName(form.getFirstName())
                .secondName(form.getSecondName())
                .sex(form.getSex())
                .birthday(form.getBirthday())
                .teamName(form.getTeamName())
                .country(form.getCountry())
                .build();

        repo.save(footballer);
    }

    /**
     *
     * @param form обновленная информация о футболисте
     * @return true, если футболист был найден, false, если нет
     */
    @Transactional
    public boolean updateFootballerInfo(FootballerFormForChangeDataDto form) {
        Optional<FootballerEntity> footballerOptional = repo.findById(form.getId());
        if (footballerOptional.isEmpty()) {
            return false;
        }
        FootballerEntity footballer = footballerOptional.get();
        String firstName = form.getFirstName();
        if (firstName != null && !firstName.isBlank())
            footballer.setFirstName(firstName);
        String secondName = form.getSecondName();
        if (secondName != null && !secondName.isBlank())
            footballer.setSecondName(form.getSecondName());
        if (form.getSex() != null)
            footballer.setSex(form.getSex());
        if (form.getBirthday() != null)
            footballer.setBirthday(form.getBirthday());
        String teamName = form.getTeamName();
        if (teamName != null && !teamName.isBlank())
            footballer.setTeamName(teamName);
        if (form.getCountry() != null)
            footballer.setCountry(form.getCountry());
        repo.save(footballer);
        return true;
    }

    /**
     * Получить всех футболистов из БД
     *
     * @return список всех футболистов
     */
    @Transactional
    public List<FootballerEntity> getAllFootballers() {
        return repo.findAll();
    }

    /**
     * Получить все названия футбольных команд
     *
     * @return список футбольных команд
     */
    @Transactional
    public List<String> getAllTeamNames() {
        return repo.findAllTeams();
    }
}
