package com.example.practice66ezhikov.service.db;

import com.example.practice66ezhikov.dto.FootballerForm;
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
     * Add new footballer to db
     *
     * @param form required data about footballer
     */
    @Transactional
    public void addFootballer(FootballerForm form) {
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

    @Transactional
    public Optional<FootballerEntity> getFootballer(Integer id) {
        return repo.findById(id);
    }

    @Transactional
    public boolean updateFootballerInfo(FootballerForm form) {
        Optional<FootballerEntity> footballerOptional = repo.findById(form.getId());
        if (footballerOptional.isPresent()) {
            FootballerEntity footballer = footballerOptional.get();
            footballer.setFirstName(form.getFirstName());
            footballer.setSecondName(form.getSecondName());
            footballer.setSex(form.getSex());
            footballer.setBirthday(form.getBirthday());
            footballer.setTeamName(form.getTeamName());
            footballer.setCountry(form.getCountry());
            repo.save(footballer);
            return true;
        }
        return false;
    }

    /**
     * Get all football players
     *
     * @return list of all football players
     */
    @Transactional
    public List<FootballerEntity> getAllFootballers() {
        return repo.findAll();
    }

    /**
     * Get all unique football teams
     *
     * @return list of all football teams
     */
    @Transactional
    public List<String> getAllTeamNames() {
        return repo.findAllTeams();
    }
}
