public class HornerScheme {
    public static double evaluatePolynomial(double x) {
        double result = 0;  // Начинаем с нулевого результата
        double[] coefficients = {0.2, 0.6, 0.4};  // Коэффициенты многочлена

        // Проходим по всем коэффициентам с конца
        for (int i = coefficients.length - 1; i >= 0; i--) {
            result = result * x + coefficients[i];  // Применяем схему Горнера
        }
        return result;  // Возвращаем вычисленное значение многочлена
    }
}