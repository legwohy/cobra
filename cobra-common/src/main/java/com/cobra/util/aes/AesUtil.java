package com.cobra.util.aes;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AesUtil {

    private static final String defaultCharset = "UTF-8";
    private static final String KEY_AES = "AES";
    /**
     * 位数不限
     */
    private static final String KEY = "test";

    /**
     * 加密
     *
     * @param-data 需要加密的内容
     * @param-key 加密密码
     * @return
     */
    public static String encrypt(String data) {
        return doAES(data, KEY, Cipher.ENCRYPT_MODE);
    }

    /**
     * 解密
     *
     * @param-data 待解密内容
     * @param-key 解密密钥
     * @return
     */
    public static String decrypt(String data) {
        return doAES(data, KEY, Cipher.DECRYPT_MODE);
    }

    /**
     * 加解密
     *
     * @param-data 待处理数据
     * @param-password  密钥
     * @param-mode 加解密mode
     * @return
     */
    private static String doAES(String data, String key, int mode) {
        try {
            if (StringUtils.isBlank(data) || StringUtils.isBlank(key)) {
                return null;
            }
            boolean encrypt = mode == Cipher.ENCRYPT_MODE;
            byte[] content;
            if (encrypt) {
                content = data.getBytes(defaultCharset);
            } else {
                content = parseHexStr2Byte(data);
            }
            KeyGenerator keygen = KeyGenerator.getInstance(KEY_AES);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            keygen.init(128, random);
            SecretKey secretKey = keygen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, KEY_AES);
            Cipher cipher = Cipher.getInstance(KEY_AES);
            cipher.init(mode, keySpec);
            byte[] result = cipher.doFinal(content);
            if (encrypt) {
                return parseByte2HexStr(result);
            } else {
                return new String(result, defaultCharset);
            }
        } catch (Exception e) {
        }
        return null;
    }
    /**
     * 将二进制转换成16进制
     *
     * @param-buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    /**
     * 将16进制转换为二进制
     *
     * @param-hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) {
        String content=encrypt("小明");
        System.out.println("content:"+content);
        String decrypt = decrypt(content);

        System.out.println("decrypt:"+decrypt);
    }

}