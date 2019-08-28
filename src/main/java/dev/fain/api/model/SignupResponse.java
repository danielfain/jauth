package dev.fain.api.model;

public class SignupResponse {

    private String accessToken;
    private String refreshToken;

    public SignupResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

}