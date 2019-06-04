package edu.hbuas.cb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 18:24
 **/
@Document(collection = "temp51")
public class Article {
    @Id
    @JsonIgnore
    private String _id;
    private String id;
    private String name;
    private String title;
    private String time;
    private String cook;
    private String amount;
    private String description;
    private Map<String, Object> other;
    private String video_src;
    private String title_img;
    private List<Map<String, Object>> food;
    private List<String> skill;
    private List<String> flow;
    private List<String> flow_img;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCook() {
        return cook;
    }

    public void setCook(String cook) {
        this.cook = cook;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getVideo_src() {
        return video_src;
    }

    public void setVideo_src(String video_src) {
        this.video_src = video_src;
    }

    public String getTitle_img() {
        return title_img;
    }

    public void setTitle_img(String title_img) {
        this.title_img = title_img;
    }

    public List<Map<String, Object>> getFood() {
        return food;
    }

    public void setFood(List<Map<String, Object>> food) {
        this.food = food;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    public List<String> getFlow() {
        return flow;
    }

    public void setFlow(List<String> flow) {
        this.flow = flow;
    }

    public List<String> getFlow_img() {
        return flow_img;
    }

    public void setFlow_img(List<String> flow_img) {
        this.flow_img = flow_img;
    }

    public Map<String, Object> getOther() {
        return other;
    }

    public void setOther(Map<String, Object> other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Article{" +
                "_id='" + _id + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", cook='" + cook + '\'' +
                ", amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", other=" + other +
                ", video_src='" + video_src + '\'' +
                ", title_img='" + title_img + '\'' +
                ", food=" + food +
                ", skill=" + skill +
                ", flow=" + flow +
                ", flow_img=" + flow_img +
                '}';
    }
}
