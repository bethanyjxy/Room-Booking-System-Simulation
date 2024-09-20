public class Promo 
{
    private String name;
    private int discount, minSpend;

    public Promo (String name, int discount, int minSpend)
    {
        this.name = name;
        this.discount = discount;
        this.minSpend = minSpend;
        
    }

    public String getPromoName()
    {
        return name;
    }

    public int getDiscount()
    {
        return discount;
    }

    public int getMinSpend()
    {
        return minSpend;
    }

    public String toString()
    {
        return String.format("Promo Code Name: %s, %d%s Off with Min Spending of $%d", name, discount, "%", minSpend);
    }
}

