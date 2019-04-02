import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        // generate a unique identifier
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
