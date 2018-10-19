package mathquiz2;

import java.io.*;
import java.util.*;

public class UserList {
    private HashMap<String,User> userList;

    public User addUser(String userName) throws IOException {
        User user=new User(userName,0);
        userList.put(userName,user);
        write(user.toString());
        return user;
    }

    public User userLogin(String username) throws IOException {
        this.userList=getUserList();
        if(check(username))
        {
            User user=userList.get(username);
            System.out.println("you score is"+user.getScore());
            return user;
        }
        else {
            User u=addUser(username);
            System.out.println("注册成功 进入答题游戏");
            return u;
        }
    }

    public static void write(String content) throws IOException {
        File file=new File("user.txt");
        FileWriter writer=new FileWriter(file,true);
        writer.write(content);
        writer.close();
    }
    public static void rewrite(String content) throws IOException {
        File file=new File("user.txt");
        FileWriter writer=new FileWriter(file);
        writer.write(content);
        writer.close();
    }

    public HashMap<String, User> getUserList() throws FileNotFoundException {
        HashMap<String,User> ulist=new HashMap<>();
        File file=new File("user.txt");
        Scanner sc=new Scanner(file);
        while(sc.hasNext()){
            String line=sc.nextLine();
            String results[]=line.split(":");
            String userName=results[0];
            int score=Integer.parseInt(results[1]);
            User u=new User(userName,score);
            ulist.put(userName,u);
        }
        return ulist;
    }
    public boolean check(String userName){
        if(userList.containsKey(userName))
            return true;
        else
            return false;
    }

    public void updateScore(User user) throws IOException {
        HashMap<String,User> ulist=getUserList();
        ulist.put(user.getUsername(),user);
        Set<Map.Entry<String, User>> map=ulist.entrySet();
        Iterator<Map.Entry<String,User>> it=map.iterator();
        rewrite("");
        while (it.hasNext()){
            User u=it.next().getValue();
            write(u.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        UserList userList=new UserList();
        User user=userList.userLogin("mix");
        user.setScore(100);
        userList.updateScore(user);
        userList.userLogin("baogege");

    }
}
