import java.sql.Date;
import java.time.LocalDate;

public class Home_Budget {

    private long id;
    private String type;
    private String description;
    private double amount;
    private LocalDate date_transaction;

    public Home_Budget() {
    }

    public Home_Budget(String type, String description, double amount, LocalDate date_transaction) {

        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date_transaction = date_transaction;
    }

    public Home_Budget(long id, String type, String description, double amount, LocalDate date_transaction) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date_transaction = date_transaction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate_transaction() {
        return Date.valueOf(date_transaction);
    }

    public void setDate_transaction(LocalDate date_transaction) {
        this.date_transaction = date_transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Home_Budget that = (Home_Budget) o;

        if (id != that.id) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return date_transaction != null ? date_transaction.equals(that.date_transaction) : that.date_transaction == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date_transaction != null ? date_transaction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Home_Budget{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date_transaction=" + date_transaction +
                '}';
    }

    public void setDate_transaction(Date date_transaction) {
        this.date_transaction = date_transaction.toLocalDate();
    }


//    public void setDate_transaction(Date date_transaction) {
//      this.date_transaction = java.sql.Date.valueOf(date_transaction);


}
