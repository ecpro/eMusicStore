package com.eMusicStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by eccspro on 23/07/16.
 */
@Entity
public class Authorities implements Serializable {


    private static final long serialVersionUID = -5867776245584054661L;

    @Id
    @GeneratedValue
    private int authoritesId;
    private int username;
    private String authority;

    public int getAuthoritesId() {
        return authoritesId;
    }

    public void setAuthoritesId(int authoritesId) {
        this.authoritesId = authoritesId;
    }

    public int getUserName() {
        return username;
    }

    public void setUserName(int userName) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
