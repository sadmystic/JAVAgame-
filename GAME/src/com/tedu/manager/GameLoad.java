package com.tedu.manager;

import com.tedu.element.*;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/*
* ������(���ڶ�ȡ�����ļ��Ĺ���)������,���static
* */
public class GameLoad {
    private static ElementManager em=ElementManager.getManager();
    //ͼƬ����
    public static Map<String, ImageIcon> imgMap=new HashMap<>();
    public static Map<String, ImageIcon> imgMap2=new HashMap<>();
    public static Map<String, ImageIcon> imgMap3=new HashMap<>();
//    public static Map<String, List<ImageIcon>> imgMaps;


    private static Properties pro=new Properties();

    /*
    * �����ͼid�ɼ��ط��������ļ������Զ����ɵ�ͼ�ļ����ƣ������ļ�
    * */
    public static void MapLoad(int mapId){
        String mapName="com/tedu/text/"+mapId+".map";
        //io����ȡ�ļ�����
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream maps = classLoader.getResourceAsStream(mapName);
        if(maps==null){
            System.out.println("�����ļ���ȡ�쳣,�����°�װ");
            return;
        }
        try {
            pro.clear();
            pro.load(maps);
            //��̬��ȡ���е�key
            Enumeration<?> names = pro.propertyNames();
            while (names.hasMoreElements()){
                String key=names.nextElement().toString();

                //�Զ�������ͼ
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
    * ����ͼƬ����
    * */
    public static void LoadImg(){//���Դ���������ͬ�ؿ�
        String texturl="com/tedu/text/GameData.pro";//������������
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream texts = classLoader.getResourceAsStream(texturl);
        //imgMap���ڴ�������
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
        String texturl="com/tedu/text/GameData2.pro";//������������
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream texts = classLoader.getResourceAsStream(texturl);
        //imgMap���ڴ�������
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
        String texturl="com/tedu/text/GameData3.pro";//������������
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream texts = classLoader.getResourceAsStream(texturl);
        //imgMap���ڴ�������
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
    * �������
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

    //����
/*    public static void main(String[] args) {
        MapLoad(5);
    }*/


}
