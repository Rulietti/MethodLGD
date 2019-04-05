package ruslan.reminnyi.metodlgd;

/**
 * @author Ruslan Reminnyi
 * @version 1.0
 */
public class Equation {
    /* Class for coefficients of equation */

    /**
     * A first coefficient of the equation
     * */
    private Integer A;

    /**
     * B second coefficient of the equation
     * */
    private Integer B;

    /**
     * C third coefficient of the equation
     * */
    private Integer C;

    /**
     * D fourth coefficient of the equation
     * */
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
