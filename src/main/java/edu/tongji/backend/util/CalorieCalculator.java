package edu.tongji.backend.util;

import java.util.HashMap;

import static org.eclipse.persistence.expressions.ExpressionOperator.ceil;

public class CalorieCalculator {
    //定义一个哈希集合，它的键是运动的名称，值是每小时消耗的卡路里
    private static HashMap<String,Double> METMap=new HashMap<>();
    public static int getCalorie(String key, double weight,int duration) {
        if (METMap.isEmpty())
            initMETMap();
        double MET = METMap.get(key);
        double calorie = MET * weight * duration / 60.0;
        return (int) Math.ceil(calorie);
    }

    private static void initMETMap() {
        METMap.put("Jogging", 8.8);//慢跑
        METMap.put("rope", 10.5);//跳绳
        METMap.put("Yoga", 3.3);//瑜伽
        METMap.put("Walking", 2.0);//散步

    }
}
