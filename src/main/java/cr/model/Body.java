package cr.model;
import java.util.Date;
/**
 * Created by 小富 on 2017/12/14.
 */
public class Body {
    private int bid;
    private String body;
    private Date date;
    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Body(int bid, Date date, String body) {
    this.bid=bid;
    this.date=date;
    this.body=body;
    }

    public Body(Date date, String body) {
        this.date=date;
        this.body=body;
    }

    public Body() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Body that = (Body) o;

        if (bid != that.bid) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bid;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Body{" +
                "bid=" + bid +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }
}
