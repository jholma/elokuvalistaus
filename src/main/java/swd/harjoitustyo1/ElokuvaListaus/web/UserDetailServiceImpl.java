package swd.harjoitustyo1.ElokuvaListaus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import swd.harjoitustyo1.ElokuvaListaus.domain.User;
import swd.harjoitustyo1.ElokuvaListaus.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository urepository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.urepository = userRepository;
	}

	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
	    	User curruser = urepository.findByUsername(username);
	        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
	        		AuthorityUtils.createAuthorityList(curruser.getRole()));
	        return user;
	    }   
}