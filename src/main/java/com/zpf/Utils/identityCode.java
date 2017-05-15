package com.zpf.Utils;

import java.util.Random;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description : 产生六位验证码
 * @date :2017/5/4 16:15
 */
public class identityCode {
    public String getIC(){

        //  产生随机数
        Random rad = new Random();
        //  存储验证码字符串
        String result = "";
        //  循环产生6位验证码
        for(int i = 0 ;i <6; ++i){
            result = result + rad.nextInt(10);
        }
        //  返回验证码
        return result;
    }

}
