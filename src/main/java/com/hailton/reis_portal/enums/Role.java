package com.hailton.reis_portal.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
	
	   ROLE_ADMIN,
	    ROLE_USER;
	    
	public SimpleGrantedAuthority getAuthority() {
        return new SimpleGrantedAuthority(name());
    }
	    
}

