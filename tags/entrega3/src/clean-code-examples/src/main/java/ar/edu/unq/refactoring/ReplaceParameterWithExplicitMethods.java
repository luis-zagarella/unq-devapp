package ar.edu.unq.refactoring;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;

/**
 * A veces tenemos metodos que en base a un parametro tiene un comportamiento
 * diferente.
 */
@SuppressWarnings("unused")
public class ReplaceParameterWithExplicitMethods {

    static class FormatterFactory_v1 {

        public static Formatter create(final FormatterType type) {
            switch (type) {
            case PDF:
                return new PDFFormatter();
            case CSV:
                return new CSVFormatter();
            case PLAIN:
                return new PlainFormatter();
            default:
                throw new IllegalArgumentException("Incorrect type ... etc");
            }
        }

    }

    public void uso_v1() {
        Formatter pdfFormatter = FormatterFactory_v1.create(FormatterType.PDF);
    }

    static class FormatterFactory_v2 {

        public static Formatter createPDFFormatter() {
            return new PDFFormatter();
        }

        public static Formatter createCSVFormatter() {
            return new CSVFormatter();
        }

        public static Formatter createPLAINFormatter() {
            return new PlainFormatter();
        }

    }

    public void uso_v2() {
        Formatter pdfFormatter = FormatterFactory_v2.createPDFFormatter();
    }

    public int calculateWeeklyPay(final boolean overtime) {
        int straightTime = Math.min(400, this.getHoursWorked());
        int straightPay = straightTime * this.getHoursRate();

        int overTime = Math.max(0, this.getHoursWorked() - straightTime);
        double overtimeRate = overtime ? 1.5 : 1.0 * this.getHoursRate();
        int overtimePay = (int) Math.round(overTime * overtimeRate);

        return straightPay + overtimePay;
    }

    public int straightPay() {
        throw new UnsupportedOperationException();
    }

    public int overtimePay() {
        throw new UnsupportedOperationException();
    }

    private int getHoursWorked() {
        throw new UnsupportedOperationException();
    }

    private int getHoursRate() {
        throw new UnsupportedOperationException();
    }

    public void uso() {
        this.calculateWeeklyPay(true);
    }

    static class SaveAsWindow_v1 {
        private Formatter formatter;

        private Report report;

        String[] options = { "PDF", "CSV", "PLAIN" };

        JComboBox comboBox = new JComboBox(options);

        public SaveAsWindow_v1() {
            this.bindComboActions();
        }

        private void bindComboActions() {
            comboBox.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent e) {
                    String selectedItem = (String) comboBox.getSelectedItem();
                    if (selectedItem.equals("PDF")) {
                        formatter = FormatterFactory_v2.createPDFFormatter();
                    } else if (selectedItem.equals("CSV")) {
                        formatter = FormatterFactory_v2.createCSVFormatter();
                    } else {
                        formatter = FormatterFactory_v2.createPLAINFormatter();
                    }
                    formatter.format(report);
                }
            });
        }

    }

    static class SaveAsWindow_v2 {
        private Report report;

        List<Command> formatters;

        JComboBox comboBox;

        public SaveAsWindow_v2() {
            this.initCombo();
            this.bindComboActions();
        }

        private void initCombo() {
            formatters = new ArrayList<Command>();

            formatters.add(new PDFFormatCmd(report));
            formatters.add(new CSVFormatCmd(report));
            formatters.add(new PLAINFormatCmd(report));

            comboBox = new JComboBox(new ListComboBoxModelWrapper(formatters));
        }

        private void bindComboActions() {
            comboBox.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent e) {
                    Command selectedCmd = (Command) comboBox.getSelectedItem();
                    selectedCmd.execute();
                }
            });
        }
    }

    static interface Command {

        void execute();

        String description();

    }

    static class PDFFormatCmd implements Command {

        private final Report report;

        public PDFFormatCmd(final Report aReport) {
            report = aReport;
        }

        @Override
        public void execute() {
            FormatterFactory_v2.createPDFFormatter().format(report);
        }

        @Override
        public String description() {
            return "PDF";
        }

    }

    static class CSVFormatCmd implements Command {

        private final Report report;

        public CSVFormatCmd(final Report aReport) {
            report = aReport;
        }

        @Override
        public void execute() {
            FormatterFactory_v2.createCSVFormatter().format(report);
        }

        @Override
        public String description() {
            return "CSV";
        }

    }

    static class PLAINFormatCmd implements Command {

        private final Report report;

        public PLAINFormatCmd(final Report aReport) {
            report = aReport;
        }

        @Override
        public void execute() {
            FormatterFactory_v2.createPLAINFormatter().format(report);
        }

        @Override
        public String description() {
            return "PLAIN";
        }

    }

    static enum FormatterType {
        PDF, CSV, PLAIN
    }

    static class PDFFormatter implements Formatter {

        @Override
        public void format(final Object report) {
            throw new UnsupportedOperationException();
        }

    }

    static class CSVFormatter implements Formatter {

        @Override
        public void format(final Object report) {
            throw new UnsupportedOperationException();
        }

    }

    static class PlainFormatter implements Formatter {

        @Override
        public void format(final Object report) {
            throw new UnsupportedOperationException();
        }

    }

    static interface Formatter {

        void format(Object report);

    }

    static class Report {

    }

    static class ListComboBoxModelWrapper implements ComboBoxModel {

        public ListComboBoxModelWrapper(final List<Command> formatters) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getSize() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object getElementAt(final int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addListDataListener(final ListDataListener l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void removeListDataListener(final ListDataListener l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setSelectedItem(final Object anItem) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object getSelectedItem() {
            throw new UnsupportedOperationException();
        }

    }

}
