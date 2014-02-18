package youcanthide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christopher Manglos
 */
public class LeaderBoard {
    static ArrayList<Player> list = new ArrayList<Player>();
    int length;
    int index;
    int highestXPNum;
    
    public LeaderBoard(){
        index=0;
        length=10;
        highestXPNum=0;
    }
    
    public void addPlayer(Player p){
        if(list.size()<length){
            list.add(p);
        }
        else{
            Player bottom = lowestXP();
            System.out.print(bottom);
            
            if(p.getExperience()>bottom.getExperience()){
                list.remove(bottom);
                list.add(p);
            }
        }
    }
    
    Player highestXP (){
        Player top=null;
        int x=0;
        
        for(Player p : list){
            if(p.getExperience()>=x){
                top=p;
            }
        }
        
        return top;
    }
    
    Player lowestXP (){
        Player bottom=null;
        int x=0;
        
        if(!list.isEmpty()) {
            x=list.get(0).getExperience();
        }
        else {
            return null;
        }
        
        for(Player p : list){
            if(p.getExperience()<=x){
                bottom=p;
            }
        }
        
        return bottom;
    }
    
    public static ArrayList<Player> getList(){
        return list;
    }
    
    public static void sortBy(String s){
        Comparator c=null;
        if(s.equals("firstName")){
            c = new CompairByFirstName();
        }
        else if(s.equalsIgnoreCase("lastName")){
            c = new CompairByLastName();
        }
        else if(s.equals("username")){
            c = new CompairByUsername();
        }
        else if(s.equals("xp")){
            c = new CompairByXP();
        }
        else
            return;
       
        Collections.sort(list, c);
    }
    
    public static String print(){
        String result="";
        for(Player p : list){
            result+=p.getName() + " : " + p.getExperience() + "\n";
        }
        return result;
    }
    
    public String toString(){
        String result="";
        for(Player p : list){
            result+=p.getName() + " : " + p.getExperience() + "\n";
        }
        return result;
    }
}
