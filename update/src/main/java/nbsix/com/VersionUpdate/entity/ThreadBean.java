package nbsix.clpays.VersionUpdate.entity;

import java.io.Serializable;

/**
 * Name: ThreadBean
 * Author: Dusky
 * QQ: 1042932843
 * Comment: //线程Bean
 * Date: 2017-09-25 16:32
 */

public class ThreadBean implements Serializable{

    private int id;
    private String url;
    private int start;
    private int end;
    private int finished;

    public ThreadBean(){

    }

    public ThreadBean(int id, String url, int start, int end, int finished) {
        this.id = id;
        this.url = url;
        this.start = start;
        this.end = end;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }
}
