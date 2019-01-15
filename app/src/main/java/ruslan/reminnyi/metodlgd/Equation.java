package ruslan.reminnyi.metodlgd;

public class Equation {
    private Integer A;
    private Integer B;
    private Integer C;
    private Integer D;

    public Equation(Integer a, Integer b, Integer c, Integer d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public Integer getA() {
        return A;
    }

    public Integer getB() {
        return B;
    }

    public Integer getC() {
        return C;
    }

    public Integer getD() {
        return D;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                ", D=" + D +
                '}';
    }
}
