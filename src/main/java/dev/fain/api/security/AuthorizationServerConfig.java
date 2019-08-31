package dev.fain.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;
  private TokenStore tokenStore;
  private UserApprovalHandler userApprovalHandler;
  private PasswordEncoder encoder;
  @Value("${secretId}")
  private String secretId;

  @Autowired
  public AuthorizationServerConfig(AuthenticationManager authenticationManager, TokenStore tokenStore, UserApprovalHandler userApprovalHandler, PasswordEncoder encoder) {
    this.authenticationManager = authenticationManager;
    this.tokenStore = tokenStore;
    this.userApprovalHandler = userApprovalHandler;
    this.encoder = encoder;
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
      .withClient("jKk3cytfbNu1bQI")
        .authorizedGrantTypes("password", "refresh_token")
        .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
        .scopes("read", "write")
        .secret(encoder.encode(secretId))
        .accessTokenValiditySeconds(120)
        .refreshTokenValiditySeconds(600);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
      .authenticationManager(authenticationManager);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
      .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
  }

}
