/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FBLT.domain.register;

/**
 *
 * @author Admin
 */
public class RegisteredUserVerification {

    private long id;
    private String username;
    private String email;
    private String verificationCode;

    public RegisteredUserVerification(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.verificationCode = builder.verificationCode;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public static class Builder {
    
        private long id;
        private String username;
        private String email;
        private String verificationCode;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }
        
        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }
        
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        
        public Builder copyVerification(RegisteredUserVerification verifyUser) {
            this.id = verifyUser.id;
            this.username = verifyUser.username;
            this.email = verifyUser.email;
            return this;
        }
        
        public RegisteredUserVerification build() {
            return new RegisteredUserVerification(this);
        }

        public Builder setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
            return this;
        }
    }
}
