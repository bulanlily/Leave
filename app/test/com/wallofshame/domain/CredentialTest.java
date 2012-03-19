package com.wallofshame.domain;

import com.wallofshame.domain.Credential;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: twer
 * Date: 3/15/12
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class CredentialTest {

    @Test
    public void canSaveUserCredential(){
        Credential credential = Credential.getInstance();
        String username = "username";
        String password = "password";
        credential.save(username, password);
        assertEquals(username,credential.username());
        assertEquals(password,credential.password());
    }
}
