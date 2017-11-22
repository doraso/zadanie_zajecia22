import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class General_Home_Budget {

    public static void main(String[] args) throws SQLException {

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2017, 10, 24);
        LocalDate localDate2 = LocalDate.of(2017, 11, 20);
        LocalDate localDate3 = LocalDate.of(2017, 11, 2);
        LocalDate localDate4 = LocalDate.of(2017, 10, 28);



        Home_Budget hb1 = new Home_Budget("wydatek", "zmywarka", 2340.56, localDate);
        Home_Budget hb2 = new Home_Budget("przychód", "wypłata", 9340.56, localDate1);
        Home_Budget hb3 = new Home_Budget("wydatek", "żywność", 200.66, localDate2);
        Home_Budget hb4 = new Home_Budget("wydatek", "kredyt", 1800.00, localDate3);
        Home_Budget hb5 = new Home_Budget("wydatek", "prąd", 234.56, localDate4);
        Home_Budget hb6 = new Home_Budget("przychód", "pożyczka", 15000.00, localDate);

        Home_BudgetDao dao = new Home_BudgetDao();
        dao.save(hb1);
        dao.save(hb2);
        dao.save(hb3);
        dao.save(hb4);
        dao.save(hb5);
        dao.save(hb6);

        List<Home_Budget> fromAllExpenses = dao.allExpenses(hb1);

        for (Home_Budget fromAllExpens : fromAllExpenses) {
            System.out.println(fromAllExpens);

        }

        System.out.println(" ");

        List<Home_Budget> fromAllExpensesByAmount = dao.allExpensesByAmount(hb3);
        for (Home_Budget fromAllExpensByAmount : fromAllExpensesByAmount) {
            System.out.println(fromAllExpensByAmount);
        }

        System.out.println(" ");

        List<Home_Budget> fromAllExpensesByDate = dao.allExpensesByDate(hb1,hb4);
        for (Home_Budget home_budget : fromAllExpensesByDate) {
            System.out.println(home_budget);
        }


        dao.close();



    }


}
