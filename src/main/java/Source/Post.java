package Source;

import com.example.projgraph.HelloApplication;

import java.time.LocalDate;
import java.util.ArrayList;

public class Post {
    private User user;
    private String text;
    private LocalDate time;
    ArrayList<Like> likes = new ArrayList<>();
    ArrayList<Replay> replays = new ArrayList<>();

    Post(User user1, String text) {
        user = user1;
        this.text = text;
        time = LocalDate.now();
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public LocalDate getTime() {
        return time;
    }

    public void addLike(User user1) {
        Like like = new Like(user1);
        user1.addLikes(this);
        likes.add(like);
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void addReplay(User user1, String text) {
        Replay replay = new Replay(user1, text);
        replays.add(replay);
    }

    @Override
    public String toString() {
        String temp = getText();
        temp += "\nLikes: ";
        temp += HelloApplication.numToStr(likes.size());
        temp += "\nComments: ";
        temp += HelloApplication.numToStr(replays.size());
        return temp;
    }
}
