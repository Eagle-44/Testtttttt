package org.alex.rest.dal;

import org.alex.rest.models.Circus;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CircusRepository extends JpaRepository<Circus,Integer> {

}
