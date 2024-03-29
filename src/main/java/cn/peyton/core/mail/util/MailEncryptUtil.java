package cn.peyton.core.mail.util;


import cn.peyton.core.cipher.child.SymmetricCipherUtil;
import cn.peyton.core.cipher.enums.SymmetricCipher;

import java.io.Serializable;

/**
 * <h3>邮箱加密工具类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:43
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class MailEncryptUtil implements Serializable {

    private final static String ENCRYPT_KEY = "mail.user.password";

    /**
     * <h4>加密[]</h4>
     * @param content 要加密内容
     * @return 加密后内容
     */
    public static String encoder(String content) {
        return SymmetricCipherUtil.encoder(content, ENCRYPT_KEY, SymmetricCipher.DES);
    }

    /**
     * <h4>解密</h4>
     * @param encryptContent 要解密内容
     * @return 解密后内容
     */
    public static String decoder(String encryptContent) {
        return SymmetricCipherUtil.decoder(encryptContent, ENCRYPT_KEY, SymmetricCipher.DES);
    }

}
