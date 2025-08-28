package org.example.business;

import cn.hutool.crypto.digest.DigestUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author chuhao
 * @Date 2025/7/25
 * @Version 1.0.0
 */
public class Sm3Demo {

    public static void main(String[] args) {
        List<String> certificateNoList = Arrays.asList(
                "12100000425004525T"
        );
        for (String certificateNo : certificateNoList) {
            System.out.println(DigestUtil.md5Hex(certificateNo));
//            System.out.println(SmUtil.sm3(certificateNo));
        }
    }
}
