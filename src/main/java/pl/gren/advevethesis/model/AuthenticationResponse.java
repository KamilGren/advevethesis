package pl.gren.adveve.model;

public class AuthenticationResponse {


    private String authenticationToken;
    private String username;

    public AuthenticationResponse(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }
}
