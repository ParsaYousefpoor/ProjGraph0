package Source;

import java.time.LocalDate;

public class Replay extends Post {

    Replay(User user1, String text) {
        super(user1, text);
    }

    public User getUser() {
        return super.getUser();
    }

    public String getText() {
        return super.getText();
    }

    public LocalDate getTime() {
        return super.getTime();
    }

    public void addLike(User user1) {
        super.addLike(user1);
    }

    public void addReplay(User user1, String text) {
        super.addReplay(user1, text);
    }
}
