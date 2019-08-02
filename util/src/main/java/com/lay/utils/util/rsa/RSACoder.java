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
public final class RSACoder {

    public static final String RSA_KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    // RSA密钥长度
    private static final int KEY_SIZE = 1024;

    private static final String CHARSET = "UTF-8";


    /**
     * base64解码
     *
     * @param data 数据
     * @return java.lang.String
     * @auther zhaogengsheng
     * @Date 2019/5/28 9:11
     */
    public static byte[] decodeBase64(String data) {
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
    public static String encodeBase64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 初始化RSA密钥对
     *
     * @return RSA密钥对
     * @throws Exception 抛出异常
     */
    private static Map<String, String> initKey() throws Exception {
        KeyPairGenerator keygen = KeyPairGenerator
                .getInstance(RSA_KEY_ALGORITHM);
        SecureRandom secrand = new SecureRandom();
        secrand.setSeed("hahaha".getBytes());// 初始化随机产生器
        keygen.initialize(KEY_SIZE, secrand); // 初始化密钥生成器
        KeyPair keys = keygen.genKeyPair();
        String pub_key = encodeBase64(keys.getPublic().getEncoded());
        String pri_key = encodeBase64(keys.getPrivate().getEncoded());
        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put(PUBLIC_KEY, pub_key);
        keyMap.put(PRIVATE_KEY, pri_key);
        System.out.println("公钥：" + pub_key);
        System.out.println("私钥：" + pri_key);
        return keyMap;
    }

    /**
     * 得到公钥
     *
     * @param keyMap RSA密钥对
     * @return 公钥
     * @throws Exception 抛出异常
     */
    public static String getPublicKey(Map<String, String> keyMap) throws Exception {
        return keyMap.get(PUBLIC_KEY);
    }

    /**
     * 得到私钥
     *
     * @param keyMap RSA密钥对
     * @return 私钥
     * @throws Exception 抛出异常
     */
    public static String getPrivateKey(Map<String, String> keyMap) throws Exception {
        return keyMap.get(PRIVATE_KEY);
    }

    /**
     * 数字签名
     *
     * @param data    待签名数据
     * @param pri_key 私钥
     * @return 签名
     * @throws Exception 抛出异常
     */
    private static String sign(byte[] data, String pri_key) throws Exception {
        // 取得私钥
        byte[] pri_key_bytes = decodeBase64(pri_key);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pri_key_bytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 生成私钥
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initSign(priKey);
        // 更新
        signature.update(data);

        return encodeBase64(signature.sign());
    }

    public static String sign(String data, String pri_key) throws Exception {
        // 取得私钥
        byte[] pri_key_bytes = decodeBase64(pri_key);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pri_key_bytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 生成私钥
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initSign(priKey);
        // 更新
        signature.update(data.getBytes());

        return encodeBase64(signature.sign());
    }

    /**
     * RSA校验数字签名
     *
     * @param data    数据
     * @param sign    签名
     * @param pub_key 公钥
     * @return 校验结果，成功为true，失败为false
     * @throws Exception 抛出异常
     */
    private static boolean verify(byte[] data, byte[] sign, String pub_key) throws Exception {
        // 转换公钥材料
        // 实例化密钥工厂
        byte[] pub_key_bytes = decodeBase64(pub_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 初始化公钥
        // 密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pub_key_bytes);
        // 产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initVerify(pubKey);
        // 更新
        signature.update(data);
        // 验证
        return signature.verify(sign);
    }

    public static boolean verify(String data, String sign, String pub_key) throws Exception {
        // 转换公钥材料
        // 实例化密钥工厂
        byte[] pub_key_bytes = decodeBase64(pub_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 初始化公钥
        // 密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pub_key_bytes);
        // 产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initVerify(pubKey);
        // 更新
        signature.update(data.getBytes());
        // 验证
        return signature.verify(decodeBase64(sign));
    }

    /**
     * 公钥加密
     *
     * @param data    待加密数据
     * @param pub_key 公钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    private static byte[] encryptByPubKey(byte[] data, byte[] pub_key) throws Exception {
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pub_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥加密
     *
     * @param data    待加密数据
     * @param pub_key 公钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    public static String encryptByPubKey(String data, String pub_key) throws Exception {
        // 私匙加密
        byte[] pub_key_bytes = decodeBase64(pub_key);
        byte[] enSign = encryptByPubKey(data.getBytes(), pub_key_bytes);
        return encodeBase64(enSign);
    }

    /**
     * 私钥加密
     *
     * @param data    待加密数据
     * @param pri_key 私钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    private static byte[] encryptByPriKey(byte[] data, byte[] pri_key) throws Exception {
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pri_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥加密
     *
     * @param data    待加密数据
     * @param pri_key 私钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    public static String encryptByPriKey(String data, String pri_key) throws Exception {
        // 私匙加密
        byte[] pri_key_bytes = decodeBase64(pri_key);
        byte[] enSign = encryptByPriKey(data.getBytes(), pri_key_bytes);
        return encodeBase64(enSign);
    }

    /**
     * 公钥解密
     *
     * @param data    待解密数据
     * @param pub_key 公钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    private static byte[] decryptByPubKey(byte[] data, byte[] pub_key) throws Exception {
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pub_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data    待解密数据
     * @param pub_key 公钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    public static String decryptByPubKey(String data, String pub_key) throws Exception {
        // 公匙解密
        byte[] pub_key_bytes = decodeBase64(pub_key);
        byte[] design = decryptByPubKey(decodeBase64(data), pub_key_bytes);
        return new String(design);
    }

    /**
     * 私钥解密
     *
     * @param data    待解密数据
     * @param pri_key 私钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    private static byte[] decryptByPriKey(byte[] data, byte[] pri_key) throws Exception {
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pri_key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param data    待解密数据
     * @param pri_key 私钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    public static String decryptByPriKey(String data, String pri_key) throws Exception {
        // 私匙解密
        byte[] pri_key_bytes = decodeBase64(pri_key);
        byte[] design = decryptByPriKey(decodeBase64(data), pri_key_bytes);
        return new String(design);
    }

    /**
     * @param args
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {

        //获取密钥对
        Map<String, String> keyMap = initKey();
        String pub_key = (String) keyMap.get(PUBLIC_KEY);
        String pri_key = (String) keyMap.get(PRIVATE_KEY);


        String datastr = "天街小雨润如酥，草色遥看近却无。最是一年春好处，绝胜烟柳满皇都。";
        System.out.println("待加密数据：\n" + datastr);


        // 公匙加密
        String pubKeyStr = encryptByPubKey(datastr , pub_key);
        System.out.println("公匙加密结果：\n" + pubKeyStr);
        // 私匙解密
        String priKeyStr = decryptByPriKey(pubKeyStr, pri_key);
        System.out.println("私匙解密结果：\n" + priKeyStr);

        //换行
        System.out.println();

        // 数字签名
        String str1 = "汉兵已略地";
        String str2 = "四面楚歌声";

        System.out.println("正确的签名：" + str1 + "\n错误的签名：" + str2);
        String sign = sign(str1, pri_key);
        System.out.println("数字签名：\n" + sign);
        boolean vflag1 = verify(str1, sign, pub_key);
        System.out.println("数字签名验证结果1：\n" + vflag1);
        boolean vflag2 = verify(str2, sign, pub_key);
        System.out.println("数字签名验证结果2：\n" + vflag2);
    }

}