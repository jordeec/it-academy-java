package itinerari.jordic.video;

public class Video {

    private String id;
    private String url;
    private String name;
    private String title;

    public Video(String id, String url, String name, String title){
        super();
        this.id = id;
        this.url = url;
        this.name = name;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}