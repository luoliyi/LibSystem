package Entity;

public class Categories {
    private int cid;
    private String cname;

    public  Categories(){}
    public Categories( String cname) {
        this.cname = cname;
    }
    public Categories(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "cid=" + cid +
                ", cname=" + cname +
                '}';
    }
}
