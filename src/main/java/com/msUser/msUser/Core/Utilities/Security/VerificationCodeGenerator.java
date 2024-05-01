package com.msUser.msUser.Core.Utilities.Security;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class VerificationCodeGenerator {

    private static final int CODE_LENGTH = 6; // Doğrulama kodunun uzunluğu
    private static final SecureRandom secureRandom = new SecureRandom();

    public  String generateVerificationCode() {
        // Rasgele bir byte dizisi oluştur
        byte[] randomBytes = new byte[CODE_LENGTH];
        secureRandom.nextBytes(randomBytes);

        // Byte dizisini Base64 ile kodla
        String code = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);

        // Kodun son 4 karakterini zaman damgası ile değiştir
        
        return code;
    }

 }
