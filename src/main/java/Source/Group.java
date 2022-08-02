package Source;

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

    //Data -> id - user - connected message - text
    public void addData(String id1, User user, Object[] objects1, String text) {
        if (datas.isEmpty()) {
            Object[] objects = {id1, user, null, text};
        } else if (users.contains(user)) {
            Object[] objects = {id1, user, objects1, text};
        }
    }

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
}
