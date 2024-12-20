import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PolynomialTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Значение", "Точка", "Максимальное число?"};
    private final List<PolynomialData> data;
    private final double maxValue;

    public PolynomialTableModel(List<PolynomialData> data) {
        this.data = data;
        this.maxValue = findMaxValue(data);  // Находим максимальное значение
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PolynomialData polynomialData = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return polynomialData.getValue();
            case 1:
                return polynomialData.getPoint();
            case 2:
                return polynomialData.getValue() == maxValue;  // Проверяем, является ли это значение максимальным
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Boolean.class;
        }
        return String.class;
    }

    private double findMaxValue(List<PolynomialData> data) {
        double max = Double.NEGATIVE_INFINITY;  // Начальное значение для максимума
        for (PolynomialData d : data) {
            if (d.getValue() > max) {
                max = d.getValue();
            }
        }
        return max;
    }
}