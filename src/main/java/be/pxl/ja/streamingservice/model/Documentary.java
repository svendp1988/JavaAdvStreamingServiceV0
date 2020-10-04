package be.pxl.ja.streamingservice.model;


import static be.pxl.ja.streamingservice.model.Genre.DOCUMENTARY;

public class Documentary extends Movie {
    private String topic;
    public Documentary(String title, Rating maturityRating) {
        super(title, maturityRating);
        setGenre(DOCUMENTARY);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Topic: " + topic);
    }

    @Override
    public void pause() {
        super.pause();
        System.out.println("Topic: " + topic);

    }
}
