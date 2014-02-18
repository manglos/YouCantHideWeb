/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package youcanthide;

import java.util.ArrayList;

/**
 *
 * @author Christopher Manglos
 */
public class Database {
    
    static ArrayList<Player> list = new ArrayList<Player>();;
    
    public Database(){
        
    }
    
    public static Player getPlayerByUsername(String u){
        
        for(Player p : list){
            if(p.getUsername().equals(u))
                return p;
        }
        
        return null;
        
    }
    
    public boolean addPlayer(Player p){
        if(list.contains(p))
            return false;
        
        list.add(p);
        return true;
    }
    
    public static boolean isSame(String username, Player user){
        if(username==null || user == null)
            return false;
        System.out.println(username.equals(user.getUsername()));
        return username.equals(user.getUsername());
        
    }
    
    public static ArrayList<Player> getList(){
        return list;
    }
    
    public static void setList(ArrayList<Player> l){
        list=l;        
    }    
}
