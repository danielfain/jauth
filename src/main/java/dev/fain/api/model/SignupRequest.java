package dev.fain.api.model;

public class SignupRequest {

    private String email;
    private String password;

    public SignupRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

}