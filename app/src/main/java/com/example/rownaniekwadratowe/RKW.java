package com.example.rownaniekwadratowe;

public class RKW {
    private String a;
    private String b;
    private String c;
    private String result = "Nie wykonano obliczeń";

    public void setA(String s) {a = s;}
    public void setB(String s) {b = s;}
    public void setC(String s) {c = s;}

    public static boolean isFinite(double v) {
        return !(Double.isNaN(v) || Double.isInfinite(v));
    }

    public static double convertToDouble(String s) {
        double v = Double.parseDouble(s);
        if (!isFinite(v))
            throw new NumberFormatException();
        return v;
    }

    public void calculate() {
        double a, b, c;

        try {
            a = convertToDouble(this.a);
        } catch (NullPointerException | NumberFormatException e) {
            result = "Niepoprawny parametr a";
            return;
        }
        try {
            b = convertToDouble(this.b);
        } catch (NullPointerException | NumberFormatException e) {
            result = "Niepoprawny parametr b";
            return;
        }
        try {
            c = convertToDouble(this.c);
        } catch (NullPointerException | NumberFormatException e) {
            result = "Niepoprawny parametr c";
            return;
        }
        if (a > 0.0 || a < 0.0) {
            final double delta = b * b - 4.0 * a * c;
            if (!isFinite(delta))
                result = "Za duże liczby";
            else if (delta < 0.0)
                result = "Równanie nie ma pierwiastków rzeczywistych";
            else if (delta > 0.0) {
                final double sqrtd = Math.sqrt(delta);
                final double x1 = 0.5 * (-b + sqrtd) / a;
                final double x2 = 0.5 * (-b - sqrtd) / a;
                result = isFinite(x1) && isFinite(x2)
                        ? "Równanie ma dwa pierwiastki: "
                        + String.valueOf(x1) + " i "
                        + String.valueOf(x2)
                        : "Za duże liczby";
            } else {
                final double x = 0.5 * -b / a;
                result = isFinite(x)
                        ? "Równanie ma jeden pierwiastek: "
                        + String.valueOf(x)
                        : "Za duże liczby";
            }
        } else if (b > 0.0 || b < 0.0) {
            final double x = -c / b;
            result = isFinite(x)
                    ? "Równanie ma jeden pierwiastek: "
                    + String.valueOf(x)
                    : "Za duże liczby";
        } else if (c > 0.0 || c < 0.0)
            result = "Równanie nie ma pierwiastków rzeczywistych";
        else
            result = "Wszystkie liczby rzeczywiste są pierwiastkami tego równania";
    }

    public String getResult() {
        return result;
    }
}
