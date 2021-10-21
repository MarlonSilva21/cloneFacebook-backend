package br.com.marlon.cloneFacebook.repository;

import br.com.marlon.cloneFacebook.models.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

}
