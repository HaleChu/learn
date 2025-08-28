package org.example.business;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author chuhao
 * @Date 2024/9/9
 * @Version 1.0.0
 */
public class BigDataDecryptDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<String> list = Arrays.asList(
                "[{\"uuid\":{\"algorithm\":\"SM4\",\"destroyed\":false,\"encoded\":\"pEmXqGTg+jGB9nnvDt+S5w==\",\"format\":\"RAW\",\"keyIndex\":0}},{\"encode\":\"E20378C86F8CEF78FCBAAAFAF77CD1AD\"}]"
        );
        String url = "https://shrctcpt.sh-italent.cn/talent-unified/api/talent-util/decryptdata/decryptDataAndVerifySigned?encode=";
        for (String s : list) {
            String urlString = url + URLEncoder.encode(s, "utf-8");
            String result = HttpUtil.post(urlString, "");
            Map map = JSONObject.parseObject(result, Map.class);
            String password = map.get("data").toString().trim();
            System.out.println(password);
        }
    }
}
