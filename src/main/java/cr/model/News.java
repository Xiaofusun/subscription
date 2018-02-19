package cr.model;


import java.util.Date;

/**
 * Created by 小富 on 2017/12/14.
 */
public class News {
    private int newsid;
    private Date newsdate;
    private String newssummary;
    private String pic;
    private String newstitle;
    private String newstype;
    private Body bodyByBid;

    public News() {
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public Date getNewsdate() {
        return newsdate;
    }

    public void setNewsdate(Date newsdate) {
        this.newsdate = newsdate;
    }

    public String getNewssummary() {
        return newssummary;
    }

    public void setNewssummary(String newssummary) {
        this.newssummary = newssummary;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News that = (News) o;

        if (newsid != that.newsid) return false;
        if (newsdate != null ? !newsdate.equals(that.newsdate) : that.newsdate != null) return false;
        if (newssummary != null ? !newssummary.equals(that.newssummary) : that.newssummary != null) return false;
        if (newstitle != null ? !newstitle.equals(that.newstitle) : that.newstitle != null) return false;
        if (newstype != null ? !newstype.equals(that.newstype) : that.newstype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newsid;
        result = 31 * result + (newsdate != null ? newsdate.hashCode() : 0);
        result = 31 * result + (newssummary != null ? newssummary.hashCode() : 0);
        result = 31 * result + (newstitle != null ? newstitle.hashCode() : 0);
        result = 31 * result + (newstype != null ? newstype.hashCode() : 0);
        return result;
    }

    public Body getBodyByBid() {
        return bodyByBid;
    }

    public void setBodyByBid(Body bodyByBid) {
        this.bodyByBid = bodyByBid;
    }

    public News(int newsid, Date newsdate, String newssummary, String pic, String newstitle, String newstype, Body bodyByBid) {
        this.newsid = newsid;
        this.newsdate = newsdate;
        this.newssummary = newssummary;
        this.pic = pic;
        this.newstitle = newstitle;
        this.newstype = newstype;
        this.bodyByBid = bodyByBid;
    }

    public News(Date newsdate, String newssummary, String pic, String newstitle, String newstype, Body bodyByBid) {
        this.newsdate = newsdate;
        this.newssummary = newssummary;
        this.pic = pic;
        this.newstitle = newstitle;
        this.newstype = newstype;
        this.bodyByBid = bodyByBid;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsid=" + newsid +
                ", newsdate=" + newsdate +
                ", newssummary='" + newssummary + '\'' +
                ", newstitle='" + newstitle + '\'' +
                ", newstype='" + newstype + '\'' +
                '}';
    }
}
