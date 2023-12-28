package com.shop.inventorymanager.service.security;

import com.shop.inventorymanager.entity.User;
import com.shop.inventorymanager.mapper.DTOMapper;
import com.shop.inventorymanager.model.UserDTO;
import com.shop.inventorymanager.model.security.UserLoginDetails;
import com.shop.inventorymanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

    @Autowired
    private DTOMapper dtoMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
        UserDTO userDTO = dtoMapper.mapUserEntityToUserDTO(user);
        return new UserLoginDetails(userDTO);
	}

}