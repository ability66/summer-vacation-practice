package com.example.summer.cosSimilar;

import lombok.Data;

@Data
public class SegVO {

    private String text;

    private String url1;

    private String url2;

    /**
     * 白名单
     */
    private String w;

    private Double dbd;

    private Double maxDbd;

}
