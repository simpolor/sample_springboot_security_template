package com.simpolor.cms.security.remember;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import com.simpolor.cms.security.service.TokenService;

@Component
public class RememberMeRepository implements PersistentTokenRepository{

	@Autowired
	TokenService tokenService;
	
	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		return tokenService.getTokenForSeries(seriesId);
	}
	
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		tokenService.createNewToken(token.getUsername(), token.getSeries(), token.getTokenValue(), token.getDate());
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		tokenService.updateToken(series, tokenValue, lastUsed);
	}

	@Override
	public void removeUserTokens(String username) {
		tokenService.removeUserTokens(username);
	}

}
