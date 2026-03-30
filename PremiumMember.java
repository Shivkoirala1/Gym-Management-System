 public class PremiumMember extends GymMember { // PremiumMember class that extends GymMember
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    // Accessor methods
    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public String payDueAmount(double amount) { 
        if (this.isFullPayment) {
            return "Your dues are clear.";
        }

        if (amount <= 0) {
            return "Payment amount must be positive.";
        }

        double totalPaid = this.paidAmount + amount;

        if (totalPaid > premiumCharge) {
            double excess = totalPaid - premiumCharge;
            return String.format("Payment successful, but you overpaid by %.2f. Please claim your refund.", excess);
        }

        this.paidAmount = totalPaid;
        this.isFullPayment = (this.paidAmount == premiumCharge);

        double remainingAmount = premiumCharge - this.paidAmount;
        return String.format("Payment successful. Remaining amount to be paid: %.2f", remainingAmount);
    }

    