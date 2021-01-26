package com.lee.pg.view;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;


public class SearchWeather {
    private static final String TAG = "MainActivity";
    public static void main(String[] args) throws IOException, ParseException {
        System.out.print("hello");
        String result;
        String regTop = "서울특별시";
        String regMid = "광진구";
        String regLeaf = "자양동";
        String code = " ";
        String x;
        String y;

        URL url;
        BufferedReader br;
        URLConnection conn;

        JSONParser parser;
        JSONArray jArr;
        JSONObject jobj = null;

        url = new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/top.json.txt");
        conn = url.openConnection();
        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        result = br.readLine().toString();
        br.close();

        parser = new JSONParser();
        jArr = (JSONArray) parser.parse(result);
        for(int i = 0; i<jArr.size(); i++)
        {
            jobj = (JSONObject) jArr.get(i);
            if(jobj.get("value").equals(regTop))
            {
                code = (String)jobj.get("code");
                //System.out.println(regTop + "코드 : " + code);
                Log.d(TAG, regTop + "코드 : " + code);
                break;
            }
        }
        url = new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/mdl." + code + ".json.txt");
        conn = url.openConnection();
        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        result = br.readLine().toString();
        br.close();
        parser = new JSONParser();
        jArr = (JSONArray) parser.parse(result);
        for(int i = 0; i<jArr.size(); i++)
        {
            jobj = (JSONObject) jArr.get(i);
            if(jobj.get("value").equals(regMid))
            {
                code = (String)jobj.get("code");
                System.out.println(regMid + "코드 : " + code);
                break;
            }
        }
        url = new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/leaf." + code + ".json.txt");
        conn = url.openConnection();
        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        result = br.readLine().toString();
        br.close();

        parser = new JSONParser();
        jArr = (JSONArray) parser.parse(result);

        if(regMid.equals("광진구"))
        {
            for(int i = 0; i<jArr.size(); i++)
            {
                jobj = (JSONObject) jArr.get(i);
                String leaf1 = regLeaf.substring(0,regLeaf.length()-3);
                String leaf2 = regLeaf.substring(regLeaf.length()-3,regLeaf.length()-2);
                String leaf3 = regLeaf.substring(regLeaf.length()-2,regLeaf.length());

                Pattern pattern = Pattern.compile(leaf1 + "[1-9. ]{0,8}" + leaf2 + "[1-9. ]{0,8}" + leaf3);
                Matcher matcher = pattern.matcher((String) jobj.get("value"));
                if(matcher.find())
                {
                    x=(String)jobj.get("x");
                    y=(String)jobj.get("y");
                    System.out.println(regLeaf+"의 x값 : "+x+", y값 : "+y);
                    break;
                }
            }
        }
        else
        {
            for(int i = 0; i<jArr.size(); i++)
            {
                jobj = (JSONObject) jArr.get(i);
                if(jobj.get("value").equals(regLeaf))
                {
                    x=(String)jobj.get("x");
                    y=(String)jobj.get("y");
                    System.out.println(regLeaf+"의 x값 : "+x+", y값 : "+y);
                    break;
                }
            }
        }
    }
}
