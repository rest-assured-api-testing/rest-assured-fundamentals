package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "color"})
public class Project {
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer color;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean favorite;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer order;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer comment_count;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean shared;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer sync_id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public Integer getSync_id() {
        return sync_id;
    }

    public void setSync_id(Integer sync_id) {
        this.sync_id = sync_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }
}
