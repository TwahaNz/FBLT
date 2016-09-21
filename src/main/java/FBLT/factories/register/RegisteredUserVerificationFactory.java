/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FBLT.factories.register;

import FBLT.domain.register.RegisteredUserVerification;

/**
 *
 * @author Admin
 */
public class RegisteredUserVerificationFactory {
    
    public static RegisteredUserVerification getRegisteredUser(long id,
                                                               String username, String email, String verification) {
        
        return new RegisteredUserVerification.Builder()
                .setId(id)
                .setUsername(username)
                .setEmail(email)
                .setVerificationCode(verification)
                .build();
    }
    
    public static RegisteredUserVerification getRegisteredUser(String username,
            String email, String verification) {
        
        return new RegisteredUserVerification.Builder()
                .setUsername(username)
                .setEmail(email)
                .setVerificationCode(verification)
                .build();
    }
}
