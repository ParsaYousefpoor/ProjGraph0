package Source;

import java.util.ArrayList;

public class Chat {
    private User user1;
    private User user2;
    private String id;
    private ArrayList<Object[]> datas = new ArrayList<>();
    private static int a = 0;
    public static ArrayList<Chat> chatArrayList = new ArrayList<>();

    Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        chatArrayList.add(this);
        id = "chat" + Integer.toString(a);
        a++;
    }

    public String getId() {
        return id;
    }

    //Data -> chat/group id - user - connected message - text
    public void sendData(String id1, User user, Object[] objects1, String text) {
        if (datas.isEmpty()) {
            Object[] objects = {id1, user, null, text};
            datas.add(objects);
        } else if (user == user1 || user == user2) {
            Object[] objects = {id1, user, objects1, text};
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

    // 0 - n-1
    public void removeData(int i) {
        datas.remove(i);
    }

    // 0 - n-1
    public void editData(int i, String text) {
        Object[] objects = datas.get(i);
        objects[3] = text;
        datas.remove(i);
        datas.add(i, objects);
    }
}
