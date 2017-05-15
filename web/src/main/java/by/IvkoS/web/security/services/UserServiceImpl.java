package by.IvkoS.web.security.services;

import by.IvkoS.database.models.clients.User;
import by.IvkoS.database.models.clients.security.UserProfile;
import by.IvkoS.database.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userService.findUserByLogin(login);

        if (user == User.EMPTY_USER) {
            logger.info(String.format("User not found with login: %s", login));
            throw new UsernameNotFoundException("Username not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<UserProfile> userProfiles = user.getUserProfiles();
        for(UserProfile userProfile : userProfiles){
            logger.info(userProfile.getType());
            authorities.add(new SimpleGrantedAuthority(userProfile.getType()));
        }
        logger.info(authorities.toString());
        return authorities;
    }
}
