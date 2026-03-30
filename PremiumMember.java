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

    public String calculateDiscount() { 
        if (this.isFullPayment) {
            this.discountAmount = premiumCharge * 0.10;
            return String.format("Discount calculated successfully. Discounted amount: %.2f", discountAmount);
        }
        return "No discount available. Full payment required.";
    }

    public void revertPremiumMember(String removalReason) { 
        super.resetMemberStatus();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;

        // Now using the removal reason properly
        System.out.println("Member removed for reason: " + removalReason);
    }

    @Override
    public void markAttendance() { 
        this.attendance++;
        this.loyaltyPoints += 10;
    }

    @Override
    public void displayMemberDetails() { 
        super.displayMemberDetails();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Payment Status: " + (isFullPayment ? "Complete" : "Incomplete"));
        System.out.println("Remaining Amount: " + (premiumCharge - this.paidAmount));
        if (isFullPayment && discountAmount > 0) { 
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}
