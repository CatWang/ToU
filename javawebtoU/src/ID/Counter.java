package ID;

/**
 * Created by lenovo on 2015/12/4.
 */
public class Counter {
    private long messageCounter;
    private long spaceCounter;
    private long articleCounter;
    private long imageCounter;
    private long remianderCounter;
    private long commentCounter;
    private static Counter counter = null;

    public static Counter getInstance() {
        if (counter == null) {
            counter = new Counter();
        }
        return counter;
    }

    public Counter() {
        messageCounter = 0;
        spaceCounter = 0;
        articleCounter = 0;
        imageCounter = 0;
        remianderCounter = 0;
    }

    public long getCommentCounter() {
        return commentCounter;
    }

    public void setCommentCounter(long commentCounter) {
        this.commentCounter = commentCounter;
    }

    public long getArticleCounter() {
        return articleCounter;
    }

    public void setArticleCounter(long articleCounter) {
        this.articleCounter = articleCounter;
    }

    public long getSpaceCounter() {
        return spaceCounter;
    }

    public void setSpaceCounter(long spaceCounter) {
        this.spaceCounter = spaceCounter;
    }

    public long getImageCounter() {
        return imageCounter;
    }

    public void setImageCounter(long imageCounter) {
        this.imageCounter = imageCounter;
    }

    public long getRemianderCounter() {
        return remianderCounter;
    }

    public void setRemianderCounter(long remianderCounter) {
        this.remianderCounter = remianderCounter;
    }

    public long getMessageCounter() {
        return messageCounter;
    }

    public void setMessageCounter(long messageCounter) {
        this.messageCounter = messageCounter;
    }
}
