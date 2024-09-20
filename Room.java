public class Room {

    private String name;
    private int cap, from, till, price;
    private Boolean avail;

    public Room(String name, int cap, Boolean avail, int from, int till, int price) {
        this.name = name;
        setCap(cap);
        setAvail(avail);
        setFrom(from);
        setTill(till);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public int getCap() {
        return cap;
    }

    public int getFrom() {
        return from;
    }

    public int getTill() {
        return till;
    }

    public int getPrice() {
        return price;
    }

    public Boolean getAvail() {
        return avail;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setAvail(Boolean avail) {
        this.avail = avail;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTill(int till) {
        this.till = till;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
