package com.example.summer.controller;

import com.example.summer.cosSimilar.CosineSimilarAlgorithm;
import com.example.summer.cosSimilar.DataVO;
import com.example.summer.cosSimilar.SegVO;
import com.example.summer.cosSimilar.TfIdfAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class IndexController {

    @ResponseBody
    @RequestMapping("/segStr")
    public String segStr(@RequestBody SegVO segVO) {
        Map<String, Integer> stringIntegerMap = TfIdfAlgorithm.segStrTxt(segVO.getText(), new ArrayList<>());
        Set<String> words = stringIntegerMap.keySet();
        List<String> str = new ArrayList<>();
        for (String word : words) {
            str.add(word);
        }
        return str.stream().collect(Collectors.joining(","));

    }

    @ResponseBody
    @RequestMapping("/cosSimilarity")
    public List<DataVO> cosSimilarity(@RequestBody SegVO segVO) {
        String[] split = segVO.getW().split(",");
        List<String> collect = Arrays.stream(split).collect(Collectors.toList());
        File file = new File(segVO.getUrl2());
        if (file.isDirectory()) {
            List<DataVO> dataVOS = CosineSimilarAlgorithm.cosSimilarityByFiles(segVO.getUrl1()
                    , segVO.getUrl2(), collect);
            if (segVO.getDbd() != null && segVO.getDbd() > 0) {
                dataVOS = dataVOS.stream().filter(item -> item.getResult() >= segVO.getDbd() / 100).collect(Collectors.toList());
            }
            if (segVO.getMaxDbd() != null && segVO.getMaxDbd() > 0) {
                dataVOS = dataVOS.stream().filter(item -> item.getResult() <= segVO.getMaxDbd() / 100).collect(Collectors.toList());
            }
            return dataVOS;
        } else {
            Double aDouble = CosineSimilarAlgorithm.cosSimilarityByString(segVO.getUrl1()
                    , segVO.getUrl2(), collect);
            DataVO dataVO = new DataVO();
            List<DataVO> dataVOS = new ArrayList<>();
            if (aDouble >= segVO.getDbd() / 100 && aDouble <= segVO.getMaxDbd() / 100) {
                dataVO.setFileName("当前查重");
                dataVO.setResult(aDouble);
                dataVOS.add(dataVO);
            }
            return dataVOS;
        }
    }

    @RequestMapping("/s")
    @ResponseBody
    public Map<String, Object> getUrl(MultipartFile file) throws IOException {
        Map<String, Integer> stringIntegerMap = TfIdfAlgorithm.wordSegCounts(file.getOriginalFilename(), file.getInputStream());
        Set<String> words = stringIntegerMap.keySet();
        List<String> str = new ArrayList<>();
        for (String word : words) {
            str.add(word);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", str.stream().collect(Collectors.joining(",")));
        Map<String, String> src = new HashMap<>();
        src.put("src", "");
        data.put("data", src);

        return data;

    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<>();

        if (null != file) {
            String myFileName = file.getOriginalFilename();// 文件原名称
//            String fileName = System.currentTimeMillis() +
//                    Integer.toHexString(new Random().nextInt()) +"."+ myFileName.
//                    substring(myFileName.lastIndexOf(".") + 1);

//            String pat = "/tempFile/";//获取文件保存路径
            String pat = "D:/tempFile/";//获取文件保存路径

            String sqlPath = System.currentTimeMillis() + "/";
            File fileDir = new File(pat + sqlPath);
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
            }
            String path = pat + sqlPath + myFileName;
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
                map.put("path", pat + sqlPath);
                return map;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件为空");
        }
        return map;
    }

}
