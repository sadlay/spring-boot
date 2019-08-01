package com.lay.utils.util.rsa;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA非对称加密工具类
 *
 * @auther zhaogengsheng
 * @Date 2019/5/28 9:20
 */
public class RSACoder {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    private static final String CHARSET = "UTF-8";


    /**
     * base64解码
     *
     * @param data 数据
     * @return java.lang.String
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static byte[] decryptBASE64(String data) {
        return Base64.decodeBase64(data);
    }

    /**
     * base64编码
     *
     * @param bytes 加密数据
     * @return java.lang.String
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static String encryptBASE64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       加密数据
     * @param privateKey 私钥
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static String sign(String data, String privateKey) throws Exception {

        byte[] dataBytes = data.getBytes(CHARSET);

        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);

        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(dataBytes);
        return encryptBASE64(signature.sign());
    }


    /**
     * 校验数字签名
     *
     * @param data      加密数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return 校验成功返回true 失败返回false
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static boolean verify(String data, String publicKey, String sign) throws Exception {
        byte[] dataBytes = data.getBytes(CHARSET);

        // 解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);

        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(dataBytes);

        // 验证签名是否正常
        return signature.verify(decryptBASE64(sign));
    }

    /**
     * 加密<br>
     * 用公钥加密
     *
     * @param data
     * @param key
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static String encryptByPublicKey(String data, String key) throws Exception {
        byte[] dataBytes = data.getBytes(CHARSET);

        // 对公钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return new String(cipher.doFinal(dataBytes), CHARSET);
    }

    /**
     * 加密<br>
     * 用私钥加密
     *
     * @param data
     * @param key
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static String encryptByPrivateKey(String data, String key) throws Exception {

        byte[] dataBytes = data.getBytes(CHARSET);

        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return new String(cipher.doFinal(dataBytes), CHARSET);
    }


    public static String decryptByPrivateKey(String data, String key) throws Exception {
        byte[] dataBytes = data.getBytes(CHARSET);

        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(dataBytes);
        return new String(bytes, CHARSET);
    }


    /**
     * 解密<br>
     * 用公钥解密
     *
     * @param data
     * @param key
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static String decryptByPublicKey(String data, String key) throws Exception {
        byte[] dataBytes = data.getBytes(CHARSET);

        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(dataBytes), CHARSET);
    }

    /**
     * 创建并打印密钥
     *
     * @return
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static void createRSAKey() throws Exception {
        Map<String, Key> keyMap = initKey();
        System.out.println("RSA Public Key: " + getPublicKey(keyMap));
        System.out.println("RSA Private Key:" + getPrivateKey(keyMap));
    }

    /**
     * 取得私钥
     *
     * @param keyMap
     * @return
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    private static String getPrivateKey(Map<String, Key> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 取得公钥
     *
     * @param keyMap
     * @return
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    private static String getPublicKey(Map<String, Key> keyMap) throws Exception {
        Key key = keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 初始化密钥
     *
     * @return
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    private static Map<String, Key> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        Map<String, Key> keyMap = new HashMap(2);
        keyMap.put(PUBLIC_KEY, keyPair.getPublic());// 公钥
        keyMap.put(PRIVATE_KEY, keyPair.getPrivate());// 私钥
        return keyMap;
    }
}