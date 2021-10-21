package br.com.marlon.cloneFacebook.repository;

import br.com.marlon.cloneFacebook.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    public List<UsuarioModel> findByNameContainingIgnoreCase(String name);

    public Optional<UsuarioModel> findByEmail(String user);
}
