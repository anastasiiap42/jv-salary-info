package core.basesyntax;

import java.time.LocalDate;

public class SalaryInfo {

    private String getName(String[] names, String data) {
        for (String name : names) {
            if (name.equals(data)) {
                return name;
            }
        }
        return null;
    }

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {

        LocalDate from = LocalDate.parse(dateFrom);
        LocalDate to = LocalDate.parse(dateTo);
        StringBuilder builder = new StringBuilder();

        for (String row : data) {
            String[] dataLine = row.split(" ");
            LocalDate localDate = LocalDate.parse(dataLine[0]);
            String name = getName(names, dataLine[1]);
            if (name == null) {
                continue;
            }
            int hours = Integer.parseInt(dataLine[2]);
            int wage = Integer.parseInt(dataLine[3]);

            int moneyEarned = hours * wage;

            builder.append("Report for period ")
                    .append(dateFrom).append(" - ")
                    .append(dateTo).append('\n')
                    .append(name).append(" - ")
                    .append(moneyEarned)
                    .append('\n');
        }

    }
}
