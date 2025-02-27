package telran.employees;

import telran.io.Persistable;
import telran.view.Item;
import telran.view.Menu;
import telran.view.StandardIO;

public class Main {
    public static void main(String[] args) {
        try {
            Company company = new CompanyImpl();

            if (company instanceof Persistable persistable) {
                persistable.restoreFromFile("employees.data");
            }

            Item[] items = CompanyItems.getItems(company);
            Menu menu = new Menu("Company Application", items);
            menu.perform(new StandardIO());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}