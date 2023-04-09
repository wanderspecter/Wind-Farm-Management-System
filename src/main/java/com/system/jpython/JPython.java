package com.system.jpython;

import com.system.data.ForecastData;

import java.io.*;
import java.util.List;

public class JPython {
    public static String getPythonResult(String cmd) {
        Process proc;
        String result = "";
        try {
            proc = Runtime.getRuntime().exec(cmd);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[] getForecast(List list, String chosen) {
        StringBuilder cmd = new StringBuilder("\"" + System.getProperty("user.dir") + "\\Python311\\python.exe\" ");
        String curDir = System.getProperty("user.dir") + "\\WindFarm";
        StringBuilder args = new StringBuilder();
        switch (chosen) {
            case "j00252":
                cmd.append("\"").append(curDir).append("\\src\\forecast\\prd252.py\"");
                for (Object o : list) {
                    ForecastData forecastData = (ForecastData) o;
                    args.append(forecastData.getC_DIRECTION110()).append(" ");
                    args.append(forecastData.getC_DIRECTION70()).append(" ");
                    args.append(forecastData.getC_DIRECTION80()).append(" ");
                    args.append(forecastData.getC_DIRECTION90()).append(" ");
                    args.append(forecastData.getC_SPEED110()).append(" ");
                    args.append(forecastData.getC_SPEED70()).append(" ");
                    args.append(forecastData.getC_SPEED80()).append(" ");
                    args.append(forecastData.getC_SPEED90()).append("\n");
                }
                break;
            case "j00267":
                cmd.append("\"").append(curDir).append("\\src\\forecast\\prd267.py\"");
                for (Object o : list) {
                    ForecastData forecastData = (ForecastData) o;
                    args.append(forecastData.getC_DIRECTION110()).append(" ");
                    args.append(forecastData.getC_DIRECTION70()).append(" ");
                    args.append(forecastData.getC_DIRECTION80()).append(" ");
                    args.append(forecastData.getC_DIRECTION90()).append(" ");
                    args.append(forecastData.getC_SPEED110()).append(" ");
                    args.append(forecastData.getC_SPEED70()).append(" ");
                    args.append(forecastData.getC_SPEED80()).append(" ");
                    args.append(forecastData.getC_SPEED90()).append("\n");
                }
                break;
            case "j00293":
                cmd.append("\"").append(curDir).append("\\src\\forecast\\prd293.py\"");
                for (Object o : list) {
                    ForecastData forecastData = (ForecastData) o;
                    args.append(forecastData.getC_DIRECTION110()).append(" ");
                    args.append(forecastData.getC_DIRECTION90()).append(" ");
                    args.append(forecastData.getC_SPEED110()).append(" ");
                    args.append(forecastData.getC_SPEED90()).append("\n");
                }
                break;
            default:
                break;
        }
        File file = new File(curDir + "\\src\\forecast\\result.txt");
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        cmd.append(" ").append("\"").append(curDir + "\\src\\forecast").append("\"");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.write(args.toString());
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(cmd.toString());
        return getPythonResult(cmd.toString()).split(" ");
    }
}