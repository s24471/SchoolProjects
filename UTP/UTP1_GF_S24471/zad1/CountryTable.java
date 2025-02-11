package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryTable {
    String countriesFileName;

    public CountryTable(String countriesFileName) {
        this.countriesFileName = countriesFileName;
    }

    public JTable create() throws FileNotFoundException {
        DefaultTableModel model = new DefaultTableModel() {
            public Class getColumnClass(int column) {
                if (column == 2) return Integer.class;
                if (column == 3) return Icon.class;
                return super.getColumnClass(column);
            }

        };
        List<Country> countries = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader(countriesFileName)).useDelimiter("\t");
        model.addColumn(sc.next());
        model.addColumn(sc.next());
        model.addColumn(sc.next());
        model.addColumn(sc.next());
        while (sc.hasNextLine()) {
            String co = sc.next();
            String ca = sc.next();
            Integer po = sc.nextInt();
            String fl = sc.next();
            countries.add(new Country(co, ca, po, fl));
        }
        sc.close();
        for (Country i: countries) {
            model.addRow(new Object[] { i.getCountry(), i.getCapital(), i.getPopulation(), i.getFlag()});
        }
        JTable table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                if(column == 2){
                    Component a = super.prepareRenderer(renderer, row, column);
                    Integer b = (Integer)model.getValueAt(row, column);
                    if(b>20000)
                        a.setForeground(Color.red);
                    else {
                        a.setForeground(Color.black);
                    }
                }
                return super.prepareRenderer(renderer, row, column);
            }
        };



        return table;

    }
}
