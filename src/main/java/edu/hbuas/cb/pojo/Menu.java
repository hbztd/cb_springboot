package edu.hbuas.cb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 18:25
 **/
@Document(collection = "prod")
public class Menu {
    @Id
    @JsonIgnore
    private String id;
    private int catalogId;
    private String catalogName;
    private String catalogUrl;
    private List<Map<String, Object>> sub;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogUrl() {
        return catalogUrl;
    }

    public void setCatalogUrl(String catalogUrl) {
        this.catalogUrl = catalogUrl;
    }

    public List<Map<String, Object>> getSub() {
        return sub;
    }

    public void setSub(List<Map<String, Object>> sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "Prod{" +
                "id='" + id + '\'' +
                ", catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", sub=" + sub +
                '}';
    }
}
