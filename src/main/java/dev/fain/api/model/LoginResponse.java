package dev.fain.api.model;

public class LoginResponse {

  private String accessToken;
  private String refreshToken;

  public LoginResponse(String accessToken, String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }

  /**
   * @return the accessToken
   */
  public String getAccessToken() {
    return accessToken;
  }

  /**
   * @return the refreshToken
   */
  public String getRefreshToken() {
    return refreshToken;
  }

}