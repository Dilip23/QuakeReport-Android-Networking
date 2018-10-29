package quakereport.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("wearer_fire_id")
    @Expose
    private String wearer_fire_id;
    @SerializedName("blood_grp")
    @Expose
    private String blood_grp;
    @SerializedName("caretaker_number")
    @Expose
    private String caretaker_number;

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getBody() {
        return age;
    }

    public void setBody(String body) {
        this.age = body;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return wearer_fire_id;
    }

    public void setId(Integer id) {
        this.wearer_fire_id = wearer_fire_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                ", user_id=" + user_id +'\''+
                "names='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ",blood_grp=" + blood_grp +'\''+
        ", wearer_fire_id=" + wearer_fire_id +'\''+
        ", caretaker_number=" + caretaker_number+
                '}';
    }
}

