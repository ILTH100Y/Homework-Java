// 电影票父类
class MovieTicket {
    protected double originalPrice;
    protected double actualPrice;
    protected String ticketType;

    public MovieTicket(double originalPrice) {
        this.originalPrice = originalPrice;
        this.ticketType = "普通电影票";
    }

    // 计算折后票价
    public double calcPrice() {
        actualPrice = originalPrice;
        return actualPrice;
    }

    public void showTicketInfo() {
        System.out.println("【" + ticketType + "】原始票价：" + originalPrice + "元");
    }
}

// 儿童票子类
class ChildTicket extends MovieTicket {
    private double freeTicketPrice;
    private double discountAmount;

    public ChildTicket(double originalPrice, double freeTicketPrice, double discountAmount) {
        super(originalPrice);
        this.freeTicketPrice = freeTicketPrice;
        this.discountAmount = discountAmount;
        this.ticketType = "儿童票";
    }

    @Override
    public double calcPrice() {
        if (originalPrice <= freeTicketPrice) {
            this.actualPrice = 0;
        } else {
            this.actualPrice = originalPrice - discountAmount;
        }
        return actualPrice;
    }

    @Override
    public void showTicketInfo() {
        calcPrice();
        System.out.println("【" + ticketType + "】原始票价：" + originalPrice + "元，优惠后，需实付票价：" + actualPrice + "元");
    }
}

// 学生票子类
class StudentTicket extends MovieTicket {
    private double discountRate;

    public StudentTicket(double originalPrice, double discountRate) {
        super(originalPrice);
        this.discountRate = discountRate;
        this.ticketType = "学生票";
    }

    @Override
    public double calcPrice() {
        this.actualPrice = originalPrice * discountRate;
        return actualPrice;
    }

    @Override
    public void showTicketInfo() {
        calcPrice();
        System.out.println("【" + ticketType + "】原始票价：" + originalPrice + "元，折后，需实付票价：" + actualPrice + "元");
    }
}

// VIP票子类
class VipTicket extends MovieTicket {
    public VipTicket(double originalPrice) {
        super(originalPrice);
        this.ticketType = "VIP票";
    }

    @Override
    public double calcPrice() {
        this.actualPrice = originalPrice * 0.5;
        return actualPrice;
    }

    @Override
    public void showTicketInfo() {
        calcPrice();
        System.out.println("【" + ticketType + "】原始票价：" + originalPrice + "元，半价后，需实付票价：" + actualPrice + "元");
    }
}

public class Expr5_2 {
    public static void main(String[] args) {
        System.out.println("原始票价为50元");
        MovieTicket childTicket1 = new ChildTicket(50, 30, 15);
        childTicket1.showTicketInfo();
        MovieTicket studentTicket1 = new StudentTicket(50, 0.8);
        studentTicket1.showTicketInfo();
        MovieTicket vipTicket1 = new VipTicket(50);
        vipTicket1.showTicketInfo();

        System.out.println("\n原始票价为30元");
        MovieTicket childTicket2 = new ChildTicket(30, 30, 15);
        childTicket2.showTicketInfo();
        MovieTicket studentTicket2 = new StudentTicket(30, 0.8);
        studentTicket2.showTicketInfo();
        MovieTicket vipTicket2 = new VipTicket(30);
        vipTicket2.showTicketInfo();
    }
}
