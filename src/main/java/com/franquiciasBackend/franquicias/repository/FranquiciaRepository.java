package com.franquiciasBackend.franquicias.repository;

import com.franquiciasBackend.franquicias.entitys.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}
