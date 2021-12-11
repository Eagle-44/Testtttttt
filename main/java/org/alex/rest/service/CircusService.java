package org.alex.rest.service;

import org.alex.rest.dal.CircusRepository;
import org.alex.rest.models.Circus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@ApplicationScope
public class CircusService {

    @Autowired
    private CircusRepository circusRepository;

    public Circus addCircus(final Circus circus) {
        return circusRepository.save(circus);
    }

    public Circus updateCircus(final Circus circus) {
        return circusRepository.save(circus);
    }

    public List<Circus> getCircus() {
        return circusRepository.findAll();
    }

    public Circus getCircusById(final Integer id) {
        return circusRepository.findById(id).orElse(null);
    }

    public void deleteCircusById(final Integer id) {
        circusRepository.deleteById(id);
    }
}
