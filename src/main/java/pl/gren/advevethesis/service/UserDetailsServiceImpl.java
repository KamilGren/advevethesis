package pl.gren.advevethesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.gren.advevethesis.model.User;
import pl.gren.advevethesis.model.UserDetailsImpl;
import pl.gren.advevethesis.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found" + username));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                true, true, true, true, getAuthorities("ROLE_USER"));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("No user found" + username));
        return user.map(UserDetailsImpl::new).get();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user)
    {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
}
