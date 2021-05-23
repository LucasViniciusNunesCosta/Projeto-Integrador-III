package com.projeto.uteis;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 *
 * @author Icaro
 */
public class CryptoUtils {
    
    public static String HashSenha(String password){
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
    
    public static boolean ValidaSenha(String SenhaAberta, String SenhaFechada){
        BCrypt.Result res = BCrypt.verifyer().verify(SenhaAberta.toCharArray(), SenhaFechada.toCharArray());
        return res.verified;
    }
}
