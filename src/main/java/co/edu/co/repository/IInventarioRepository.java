package co.edu.co.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.co.entity.InventarioEntity;

@Repository
public interface IInventarioRepository extends JpaRepository<InventarioEntity, Serializable>{

}
