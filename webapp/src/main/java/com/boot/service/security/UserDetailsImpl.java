package com.boot.service.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Collection<SimpleGrantedAuthority> authorities;
    private String username;
    private String password;
    private Boolean enabled = true;
    	
    	@Autowired
        public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
                this.authorities = authorities;
        }

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}

		public Collection<SimpleGrantedAuthority> getAuthorities() {
			return authorities;
		}

		@Override
		public boolean isAccountNonExpired() {
			return enabled;
		}

		@Override
		public boolean isAccountNonLocked() {
			return enabled;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return enabled;
		}

}