package Source;

import com.example.projgraph.HelloApplication;

import java.time.LocalDate;
import java.util.ArrayList;

public class Group {
    private String name;
    private String id;
    private int id_number;
    private User admin;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Object[]> datas = new ArrayList<>();
    public static ArrayList<Group> groups = new ArrayList<>();

    public Group(User admin, String name) {
        this.name = name;
        this.admin = admin;
        groups.add(this);
    }

    //group information
    public User getAdmin() {
        return admin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_number() {
        return id_number;
    }

    //data

    //Data -> id - user - connected message - text - time
    public void addData(String id1, User user, Object[] objects1, String text) {
        if (datas.isEmpty()) {
            Object[] objects = {id1, user, null, text, LocalDate.now()};
            datas.add(objects);
        } else if (users.contains(user)) {
            Object[] objects = {id1, user, objects1, text, LocalDate.now()};
            datas.add(objects);
        }
    }

    // 0 - n-1
    public Object[] getOneData(int i) {
        return datas.get(i);
    }

    public ArrayList<Object[]> getDatas() {
        return datas;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        String temp = "";
        temp += name;
        temp += "\n";
        if (datas.size() != 0) {
            Object[] objs = datas.get(datas.size()-1);
            User user1 = (User) objs[1];
            if (user1.getId() == HelloApplication.user.getId()) {
                temp += "You";
            } else {
                temp += user1.getName();
            }
            temp += " : ";
            String temp1 = (String) objs[3];
            if (temp1.length() < 10) {
                temp += temp1;
            } else {
                String temp2 = "";
                for (int i = 0; i<10;i++) {
                    temp2 += temp1.charAt(i);
                }
                temp += temp2;
            }
        } else {
            temp = "No message";
        }
        return temp;
    }
}
