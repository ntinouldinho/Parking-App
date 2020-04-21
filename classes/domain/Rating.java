public class Rating {
    private int thumbsUp;
    private int thumbsDown;

    public Rating(int thumbsUp, int thumbsDown) {
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
    }

    public Rating() {
        this.thumbsUp = 0;
        this.thumbsDown = 0;
    }

    public int getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(int thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public int getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsDown(int thumbsDown) {
        this.thumbsDown = thumbsDown;
    }
}
