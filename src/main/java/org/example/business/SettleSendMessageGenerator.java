package org.example.business;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author chuhao
 * @Date 2024/9/7
 * @Version 1.0.0
 */
public class SettleSendMessageGenerator {

    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("identificationNumber", "310113199604220823");
        map.put("timestamp", System.currentTimeMillis());
        map.put("secretKey", "talentService");
        String sign = DigestUtils.md5Hex(JSONObject.toJSONString(map));
        map.remove("secretKey");
        map.put("sign", sign);
        String publicKey = "047698C0BA2DB2CEEB53BF7A09E44F01F95EF58CAFD2774CCF089F5345AC1E0B7B0ECDC7C076FDAD7227D4CB5C337D3D470B093C62C52FDD7F070CA5307059C86F";
        SM2 sm2 = SmUtil.sm2(null, publicKey);
        String encrypted = sm2.encryptHex(JSONObject.toJSONString(map), KeyType.PublicKey);
        System.out.println(encrypted);

        SM2 sm2New = SmUtil.sm2("00DD7C8FE972D6A223D854DCFEDD264B4981D7AB443F63172948754974DBB60520", null);
        String encrypted1 = "041eb6751ad36126412d23f48bfda82008646ec495cae2a3aef2c5273b2fe2fbb35dab837645b8c74da8f5198fc9e6330abc00375a63fa51bbfd1f202bd34b0ddb3b275f08214598560e9b09d372ca093f7015016780b65ae4280c5e26172f898de4810c97ae7b56ce11dc20172be3fea119e69d9876a9c7c9dfcd7dc2e5345d55961550b05c8ee4bf59a326c125e3b3e65bdf5accd240e64acfa5eb014d0ef75e7e5165d98ddbb0a8a7d72fd3f50ab7e5031026051ae7a4735bf5f8b5892217323736ad4fa8a28e862f76175e1c787ff615b5e742dc5162179b1b74cc9b77d667d8ad8092d6bbab8b778b2fafab2221f0dbb03aa7b3a5a7f08059595ffa821dc7f8bb048515bb01dead2c3452e12ccd2cb2a19f057435535e66918669922b045e1c47285319fbfb431f7a2a0a278c1113a4a7e77cda73043ac2a1bcac8d5623f2cc079a54d6ebf09a0436a18f1365090599a03daa43354f6879da6aa756c3eb32e6b5afe909683cef15c87a673f44654a1e6b6a6ba0bdaeb69bb0bcda582ef57a2bd5a52fc530d81c4706c9";
        System.out.println(sm2New.decryptStr(encrypted1, KeyType.PrivateKey));
    }
}
