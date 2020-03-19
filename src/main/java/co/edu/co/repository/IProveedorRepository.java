package co.edu.co.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.co.entity.ProveedorEntity;

@Repository
public interface IProveedorRepository extends JpaRepository<ProveedorEntity, Serializable>{

}
