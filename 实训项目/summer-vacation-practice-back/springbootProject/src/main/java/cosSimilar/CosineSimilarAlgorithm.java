package cosSimilar;

import com.example.summer.cosSimilar.DataVO;
import com.example.summer.cosSimilar.TfIdfAlgorithm;

import java.math.BigDecimal;
import java.util.*;

public class CosineSimilarAlgorithm {

    /**
     * @param @param  firstFile
     * @param @param  secondFile
     * @param @return
     * @return Double
     * @throws
     * @Title: cosSimilarityByFile
     * @Description: 获取两个文件相似性
     */
    public static Double cosSimilarityByFile(String firstFile, String secondFile, List<String> w) {
        try {
            Map<String, Map<String, Integer>> firstTfMap = com.example.summer.cosSimilar.TfIdfAlgorithm.wordSegCount(firstFile, w);
            Map<String, Map<String, Integer>> secondTfMap = com.example.summer.cosSimilar.TfIdfAlgorithm.wordSegCount(secondFile, w);
            if (firstTfMap == null || firstTfMap.size() == 0) {
                throw new IllegalArgumentException("firstFile not found or firstFile is empty! ");
            }
            if (secondTfMap == null || secondTfMap.size() == 0) {
                throw new IllegalArgumentException("secondFile not found or secondFile is empty! ");
            }
            Map<String, Integer> firstWords = firstTfMap.get(firstFile);
            Map<String, Integer> secondWords = secondTfMap.get(secondFile);
            if (firstWords.size() < secondWords.size()) {
                Map<String, Integer> temp = firstWords;
                firstWords = secondWords;
                secondWords = temp;
            }
            return calculateCos((LinkedHashMap<String, Integer>) firstWords, (LinkedHashMap<String, Integer>) secondWords);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0d;
    }

    public static List<com.example.summer.cosSimilar.DataVO> cosSimilarityByFiles(String firstFile, String secondFile, List<String> w) {
        try {
            List<Map<String, Object>> firstTfMap = com.example.summer.cosSimilar.TfIdfAlgorithm.wordSegCounts(firstFile, new ArrayList<>());
            List<Map<String, Object>> secondTfMap = com.example.summer.cosSimilar.TfIdfAlgorithm.wordSegCounts(secondFile, w);

            List<com.example.summer.cosSimilar.DataVO> dataVOS = new ArrayList<>();
            secondTfMap.forEach(item -> {
                firstTfMap.forEach(first -> {
                    if (firstTfMap == null || firstTfMap.size() == 0) {
                        throw new IllegalArgumentException("firstFile not found or firstFile is empty! ");
                    }
                    if (secondTfMap == null || secondTfMap.size() == 0) {
                        throw new IllegalArgumentException("secondFile not found or secondFile is empty! ");
                    }

                    Map<String, Integer> firstWords = (Map<String, Integer>) first.get("result");
                    Map<String, Integer> secondWords = (Map<String, Integer>) item.get("result");
                    if (firstWords.size() < secondWords.size()) {
                        Map<String, Integer> temp = firstWords;
                        firstWords = secondWords;
                        secondWords = temp;
                    }
                    com.example.summer.cosSimilar.DataVO dataVO = new DataVO();
                    dataVO.setFileName(first.get("fileName") + "-->" + item.get("fileName"));
                    dataVO.setResult(calculateCos((LinkedHashMap<String, Integer>) firstWords, (LinkedHashMap<String, Integer>) secondWords));
                    dataVOS.add(dataVO);
                });
            });

            return dataVOS;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @param  first
     * @param @param  second
     * @param @return
     * @return Double
     * @throws
     * @Title: cosSimilarityByString
     * @Description: 得到两个字符串的相似性
     */
    public static Double cosSimilarityByString(String first, String second, List<String> w) {
        try {
            Map<String, Integer> firstTfMap = com.example.summer.cosSimilar.TfIdfAlgorithm.segStr(first, w);
            Set<String> set = firstTfMap.keySet();
            String res = "";
            for (String i : set) {
                res = res + i;
            }
            //System.out.println(res);
            System.out.println("------------------------");

            Map<String, Integer> secondTfMap = TfIdfAlgorithm.segStr(second, new ArrayList<>());

            System.out.println("------------------------");
            if (firstTfMap.size() < secondTfMap.size()) {
                Map<String, Integer> temp = firstTfMap;
                firstTfMap = secondTfMap;
                secondTfMap = temp;

            }

            return calculateCos((LinkedHashMap<String, Integer>) firstTfMap, (LinkedHashMap<String, Integer>) secondTfMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0d;
    }

    /**
     * @param @param  first
     * @param @param  second
     * @param @return
     * @return Double
     * @throws
     * @Title: calculateCos
     * @Description: 计算余弦相似性
     */
    private static Double calculateCos(LinkedHashMap<String, Integer> first, LinkedHashMap<String, Integer> second) {

        List<Map.Entry<String, Integer>> firstList = new ArrayList<Map.Entry<String, Integer>>(first.entrySet());
        List<Map.Entry<String, Integer>> secondList = new ArrayList<Map.Entry<String, Integer>>(second.entrySet());
        //计算相似度
        double vectorFirstModulo = 0.00;//向量1的模  
        double vectorSecondModulo = 0.00;//向量2的模  
        double vectorProduct = 0.00; //向量积  
        int secondSize = second.size();
        if (firstList.size() == 0 || secondList.size() == 0) return 0.0;
        for (int i = 0; i < firstList.size(); i++) {
            if (i < secondSize) {
                vectorSecondModulo += secondList.get(i).getValue().doubleValue() * secondList.get(i).getValue().doubleValue();
                vectorProduct += firstList.get(i).getValue().doubleValue() * secondList.get(i).getValue().doubleValue();
            }
            vectorFirstModulo += firstList.get(i).getValue().doubleValue() * firstList.get(i).getValue().doubleValue();
        }
        BigDecimal bigDecimal = new BigDecimal(vectorProduct / (Math.sqrt(vectorFirstModulo) * Math.sqrt(vectorSecondModulo)));
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
