package com.tedu.manager;

import com.tedu.element.*;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/*
* 加载器(用于读取配置文件的工具)工具类,大多static
* */
public class GameLoad {
    private static ElementManager em=ElementManager.getManager();
    //图片集合
    public static Map<String, ImageIcon> imgMap=new HashMap<>();
    public static Map<String, ImageIcon> imgMap2=new HashMap<>();
    public static Map<String, ImageIcon> imgMap3=new HashMap<>();
//    public static Map<String, List<ImageIcon>> imgMaps;


    private static Properties pro=new Properties();

    /*
    * 传入地图id由加载方法依据文件规则自动生成地图文件名称，加载文件
    * */
    public static void MapLoad(int mapId){
        String mapName="com/tedu/text/"+mapId+".map";
        //io流获取文件对象
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream maps = classLoader.getResourceAsStream(mapName);
        if(maps==null){
            System.out.println("配置文件读取异常,请重新安装");
            return;
        }
        try {
            pro.clear();
            pro.load(maps);
            //动态获取所有的key
            Enumeration<?> names = pro.propertyNames();
            while (names.hasMoreElements()){
                String key=names.nextElement().toString();

                //自动创建地图
                String [] arrs=pro.getProperty(key).split(";");
                for (int i=0;i<arrs.length;i++) {
                    ElementObj element = new MapObj().createElement(key + "," + arrs[i]);
                    em.addElement(element,GameElement.MAPS);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /*
    * 加载图片代码
    * */
    public static void LoadImg(){//可以带参数，不同关卡
        String texturl="com/tedu/text/GameData.pro";//可以重新命名
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream texts = classLoader.getResourceAsStream(texturl);
        //imgMap用于储存数据
        pro.clear();
        try {
            pro.load(texts);
            Set<Object> set = pro.keySet();
            for (Object o:set
                 ) {
                String url = pro.getProperty(o.toString());
                imgMap.put(o.toString(),new ImageIcon(url));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void LoadImg2(){
        String texturl="com/tedu/text/GameData2.pro";//可以重新命名
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream texts = classLoader.getResourceAsStream(texturl);
        //imgMap用于储存数据
        pro.clear();
        try {
            pro.load(texts);
            Set<Object> set = pro.keySet();
            for (Object o:set
            ) {
                String url = pro.getProperty(o.toString());
                imgMap2.put(o.toString(),new ImageIcon(url));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    
    public static void LoadImg3(){
        String texturl="com/tedu/text/GameData3.pro";//可以重新命名
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream texts = classLoader.getResourceAsStream(texturl);
        //imgMap用于储存数据
        pro.clear();
        try {
            pro.load(texts);
            Set<Object> set = pro.keySet();
            for (Object o:set
            ) {
                String url = pro.getProperty(o.toString());
                imgMap3.put(o.toString(),new ImageIcon(url));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    

    /*
    * 加载玩家
    * */
    public static void loadPlay() {
        String playStr="750,30,up";
        ElementObj play = new Play().createElement(playStr);
        em.addElement(play,GameElement.PLAY);
    }

    public static void loadEnemy() {
        String playStr="500,500,up";
        for(int i=0;i<5;i++) {
            ElementObj enemy = new Enemy().createElement(playStr);
            em.addElement(enemy, GameElement.ENEMY);
        }
    }

    public static void loadMan() {
        String playStr="";
        ElementObj man = new Man().createElement(playStr);
        em.addElement(man,GameElement.MAN);
    }
    
    public static void loadPeach() {
        String playStr="500,500,up";
        for(int i=0;i<5;i++) {
            ElementObj enemy = new Peach().createElement(playStr);
            em.addElement(enemy, GameElement.PEACH);
        }
    }
    
	/*
	 * public static void loadTool() { String playStr="213,500"; ElementObj tool =
	 * new Tool().createElement(playStr); em.addElement(tool,GameElement.TOOL); }
	 */

    //测试
/*    public static void main(String[] args) {
        MapLoad(5);
    }*/


}
