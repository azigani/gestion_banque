package com.alphonse.banque.config.securite;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyPassWordEncoder extends BCryptPasswordEncoder {
    public String encode(CharSequence rawPassword) {
        return "";
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
           return  true;
        }
}
