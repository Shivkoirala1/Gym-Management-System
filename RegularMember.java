public class RegularMember extends GymMember { // RegularMember class which extends GymMember
    private static final int attendanceLimit = 30; 
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) { 
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
    }

    // Accessor methods
    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    @Override 
    public void markAttendance() { 
        this.attendance++;
        this.loyaltyPoints += 5;
        if (this.attendance >= attendanceLimit) { 
            this.isEligibleForUpgrade = true;
        }
    }

    public double getPlanPrice(String plan) { 
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                System.err.println("Invalid plan selected: " + plan);
                return 0;
        }
    }

    public String upgradePlan(String newPlan) { 
        if (!isEligibleForUpgrade) {
            return "Not eligible for plan upgrade.";
        }

        if (newPlan.equalsIgnoreCase(this.plan)) { 
            return "You are already subscribed to this plan.";
        }

        double newPrice = getPlanPrice(newPlan);
        if (newPrice == 0) { 
            return "Invalid plan selected.";
        }

        if (newPrice < getPlanPrice(this.plan)) { 
            return "Downgrading is not allowed. Please select a higher-tier plan.";
        }

        this.plan = newPlan.toLowerCase();
        this.price = newPrice;
        return "Plan successfully upgraded to " + newPlan;
    }

    public void revertRegularMember(String removalReason) { 
        super.resetMemberStatus();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;

        // Display removal reason
        System.out.println("Member reverted due to: " + removalReason);
    }

    @Override 
    public void displayMemberDetails() { 
        super.displayMemberDetails();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) { 
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}
