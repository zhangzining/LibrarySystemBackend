package com.zzn.librarysystem.common.util;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KeypairUtil {
    public static KeyPair loadKeyPair(File publicKeyFile, File privateKeyFile) throws Exception {
        return new KeyPair(loadPublicKey(publicKeyFile), loadPrivateKey(privateKeyFile));
    }

    public static PublicKey loadPublicKey(File file) throws Exception {
        byte[] bytes = readFile(file);
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }

    public static PrivateKey loadPrivateKey (File file) throws Exception {
        byte[] bytes = readFile(file);
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
    }

    private static byte[] readFile(File file) throws Exception {
        return Files.readAllBytes(file.toPath());
    }
}
