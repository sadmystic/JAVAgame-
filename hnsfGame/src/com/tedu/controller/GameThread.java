package com.tedu.controller;

import com.tedu.element.ElementObj;
import com.tedu.element.Enemy;
import com.tedu.element.Play;
import com.tedu.game.GameStart;
import com.tedu.manager.ElementManager;
import com.tedu.manager.GameElement;
import com.tedu.manager.GameLoad;
import com.tedu.show.GameJFrame;
import com.tedu.show.GameMainJPanel;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
* 游戏的主线程，游戏加载，游戏关卡，游戏自动化
* 游戏地图切换，资源释放，重新读取
* */
public class GameThread extends Thread {
        private ElementManager em;

        int mapid=2;

    public int getGg() {
        return gg;
    }

    public void setGg(int gg) {
        this.gg = gg;
    }

    int gg=0;

        public GameThread(int mapid){
            this.mapid=mapid;
            em =ElementManager.getManager();
    }
    @Override
    public void run() {

        while(true){
            if (getGg()==0){

            }
            else mapid++;
            //游戏开始前 加载游戏资源
            gameLoad(mapid);

            gg=0;
            //游戏进行时
            gameRun();
            //游戏场景结束
            gameOver();



            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    /*
    * 游戏的加载
    * */
    public void gameLoad(int mapid) {
        em.getElementsByKey(GameElement.MAPS).clear();
        GameLoad.MapLoad(mapid);

        GameLoad.LoadImg();//加载图片
        GameLoad.LoadImg2();
        //加载主角
        em.getElementsByKey(GameElement.PLAY).clear();
            GameLoad.loadPlay();
        //加载敌人npc
        em.getElementsByKey(GameElement.ENEMY).clear();
            GameLoad.loadEnemy();
        GameLoad.loadMan();


        //全部加载完成，游戏启动
    }
    /*
    * 游戏进行
    *   1.自动化玩家移动，碰撞，死亡
    *   2.新元素的增加(NPC死亡出现道具)
    *   3.暂停
    * */

    private void gameRun() {

        long gameTime=0L;
        while (true){
            Map<GameElement, List<ElementObj>> all = em.getGameElements();
            List<ElementObj> enemys = em.getElementsByKey(GameElement.ENEMY);
            List<ElementObj> files = em.getElementsByKey(GameElement.PLAYFILE);
            List<ElementObj> maps = em.getElementsByKey(GameElement.MAPS);
            List<ElementObj> plays = em.getElementsByKey(GameElement.PLAY);
            List<ElementObj> mans=em.getElementsByKey(GameElement.MAN);

            moveUpdate(all,gameTime);//游戏自动化方法

            ElementPK(enemys,files);
            ElementPK(plays,files);
            ElementPK(mans,files);
            ElementPK(plays,enemys);
            ElementPK(mans,enemys);

            ElementPK(maps,files);

            ElementPK2(maps,plays);

            if(gameTime>100) {
                ElementPK2(maps, enemys);
            }

            gameTime++;//唯一的时间控制
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (mans.isEmpty())break;
            if (plays.isEmpty())break;
            if (enemys.isEmpty())break;
        }
    }

    //子弹碰撞
    public void ElementPK(List<ElementObj> listA,List<ElementObj> listB) {
        //如果为真，就设置两个对象的死亡状态
        for (int i=0;i<listA.size();i++){
            ElementObj enemy=listA.get(i);

            for (int j=0;j<listB.size();j++){
                ElementObj file=listB.get(j);
                if (enemy.pk(file)){
                    //加入受攻击方法
                    if ("play".equals(file.getName()) && "play".equals(enemy.getName())){
                        break;
                    }
                    if ("enemy".equals(file.getName()) && "enemy".equals(enemy.getName())){
                        break;
                    }
                    if("GRASS".equals(enemy.getName())) {
                        break;
                    }
                    if("RIVER".equals(enemy.getName())) {
                        break;
                    }
                    enemy.setLive(false);
                    file.setLive(false);
                    break;
                }
            }
        }
    }

    //地图碰撞
    public void ElementPK2(List<ElementObj> listA,List<ElementObj> listB) {
        //如果为真，就设置两个对象的死亡状态
        for (int i=0;i<listA.size();i++){
            ElementObj map=listA.get(i);

            for (int j=0;j<listB.size();j++){
                ElementObj play=listB.get(j);
                //碰撞
                if (play.pk(map)){
                    if("GRASS".equals(map.getName())) {
                        break;
                    }

                    if("enemy".equals(play.getName())){
                        Random r=new Random();
                        int q=r.nextInt(2);
                        if(play.getFx()=="up"){
                            if(q==0)
                                play.setFx("right");
                            else
                                play.setFx("left");
                        }
                        else if(play.getFx()=="right"){
                            if(q==0)
                                play.setFx("down");
                            else
                                play.setFx("up");
                        }
                        else if(play.getFx()=="down"){
                            if(q==0)
                                play.setFx("left");
                            else
                                play.setFx("right");
                        }
                        else if(play.getFx()=="left"){
                            if(q==0)
                                play.setFx("up");
                            else
                                play.setFx("down");
                        }
                    }

                    play.setX(play.getOldx());
                    play.setY(play.getOldy());
                    break;
                }
            }
        }
    }





    //游戏元素自动化方法
    public void moveUpdate(Map<GameElement, List<ElementObj>> all,long gameTime){
        //		GameElement.values();//定义枚举的顺序
        for(GameElement ge:GameElement.values()) {
            List<ElementObj> list = all.get(ge);
            for(int i=list.size()-1;i>=0;i--){
                ElementObj obj = list.get(i);
                if(!obj.isLive()){
                    //启动死亡方法
                    obj.die();
                    list.remove(i);
                    continue;
                }

                obj.model(gameTime);
            }
        }
    }
    /*
    游戏切换关卡
    * */
    private void gameOver() {
        List<ElementObj> enemys = em.getElementsByKey(GameElement.ENEMY);
        List<ElementObj> plays = em.getElementsByKey(GameElement.PLAY);
        List<ElementObj> mans = em.getElementsByKey(GameElement.MAN);


        if (mans.isEmpty() || plays.isEmpty()) {
            System.out.println("输了");
            new GameJFrame().addJOptionPane(1);
            setGg(0);
        }

        if (enemys.isEmpty()) {
            System.out.println("赢了");
            new GameJFrame().addJOptionPane(0);
            setGg(1);
        }
        //em.getGameElements().clear();
//        new GameJFrame().stop();


//        em.getGameElements().clear();
//        this.gameLoad(5);


        //实现子弹发射，移动和元素死亡

    }
}
