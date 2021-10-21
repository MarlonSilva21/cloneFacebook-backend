package br.com.marlon.cloneFacebook.security;

import br.com.marlon.cloneFacebook.models.UsuarioModel;
import br.com.marlon.cloneFacebook.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<UsuarioModel> user = usuarioRepository.findByEmail(userName);

        user.orElseThrow(() -> new UsernameNotFoundException(userName + "Not found"));

        return user.map(UserDetailsImpl::new).get();
    }
}
