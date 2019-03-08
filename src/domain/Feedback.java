package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Feedback {
    private String feedback;
    private int rating;
    private int topicId;
    private String name;

    @JsonCreator
    public Feedback(@JsonProperty("topicId") int topicId, @JsonProperty("comment") String feedback, @JsonProperty("rating") int rating, @JsonProperty("name") String name){
        setRating(rating);
        setFeedback(feedback);
        setName(name);
        setTopicId(topicId);
    }

    private void setRating(int rating){
        if (rating > 10 || rating < 0){
            throw new IllegalArgumentException("Not between 1-10");
        }else {
            this.rating = rating;
        }
    }

    private void setFeedback(String feedback) {
        if (this.feedback != null || feedback.trim().isEmpty()){
            throw new IllegalArgumentException("not valid");
        }
        this.feedback = feedback;
    }

    private void setName(String name) {
        if (name != null || name.trim().isEmpty()){
            throw new IllegalArgumentException("not valid");
        }
        this.name = name;
    }

    private void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getName() {
        return name;
    }

    public int getTopicId() {
        return topicId;
    }
}
