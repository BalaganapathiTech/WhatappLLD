package Practice.whatsapp;

public class Story {
    private int storyId;
    private int userId;
    private String storyText;

    public Story(int userId, String storyText) {
        this.userId = userId;
        this.storyText = storyText;
    }

    public int getUserId() { return userId; }
    public String getStoryText() { return storyText; }
}
