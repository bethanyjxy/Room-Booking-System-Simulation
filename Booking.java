public class Booking {
    String name, stuName;
    int cap, from, till, bookID, minFrom, maxTill;
    double price, roomCost;

    // Booking ID, Student name , Room Name, Capacity, Price Paid , (Book slot) From
    // , Till, (Slot orignally available) from, till, cost of room per hr
    public Booking(int bookID, String stuName, String name, int cap, double price, int from, int till, int minFrom,
            int maxTill, double roomCost) {
        this.bookID = bookID;
        this.name = name;
        this.stuName = stuName;
        this.cap = cap;
        setPrice(price);
        setFrom(from);
        setTill(till);
        this.minFrom = minFrom;
        this.maxTill = maxTill;
        this.roomCost = roomCost;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTill(int till) {
        this.till = till;
    }

    public int getbookID() {
        return bookID;
    }

    public int getHour() {
        return (till - from) / 100;
    }

    public double getPrice() {
        return price;
    }

    public int getFrom() {
        return from;
    }

    public int getTill() {
        return till;
    }

    public String getName() {
        return name;
    }

    public String getStuName() {
        return stuName;
    }

    public int getCap() {
        return cap;
    }

    public int getMaxTill() {
        return maxTill;
    }

    public int getMinFrom() {
        return minFrom;
    }

    // Room cost per hour
    public Double getRoomCost() {
        return roomCost;
    }

    public String toString() {
        return String.format("%-10s %-10s %-10s %-10s \t %04d \t %04d \t %-5s\n",
                String.valueOf(getbookID()), getStuName(), getName(), String.valueOf(getCap()), getFrom(), getTill(),
                String.valueOf("$" + getPrice()));
    }

}
