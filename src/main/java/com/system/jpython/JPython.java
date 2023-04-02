package com.system.jpython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JPython {
    public static String getForecast() {
        Process proc;
        String dir = "\"" + System.getProperty("user.dir") + "\\src\\forecast_module\\forecast_module\\main.py\"";
        String cmd = "python " + dir;
        try {
            proc = Runtime.getRuntime().exec(cmd);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
            System.out.println(result);
            in.close();
            proc.waitFor();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}