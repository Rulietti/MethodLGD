package ruslan.reminnyi.metodlgd;

import android.app.Application;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ruslan Reminnyi
 * @version 1.0
 */
public class LGDApplication extends Application {

    /**
     * equationsList contains coefficients of the equations
     */
    private static ArrayList<Equation> equationsList;

    /**
     * A first coefficient of the equation
     * */
    private static Double A;

    /**
     * B second coefficient of the equation
     * */
    private static Double B;

    /**
     * C third coefficient of the equation
     * */
    private static Double C;

    /**
     * D fourth coefficient of the equation
     * */
    private static Double D;

    /**
     * matrix values of the matrix
     */
    private static List<Double> matrix;

    /**
     * counterRow amount rows of the matrix
     */
    private static int counterRow;

    /**
     * X1 first root of the equation
     */
    private static Double X1;

    /**
     * X2 second root of the equation
     */
    private static Double X2;

    /**
     * X3 third root of the equation
     */
    private static Double X3;

    /**
     * stringEquation full equation
     */
    private static String stringEquation;

    /**
     * userList values which user entered
     */
    private static List<Double> userList;

    /**
     * positionValue index of the current cell of the table
     */
    private static Integer positionValue;

    /**
     * flagButtonVisibility visibility of the button
     */
    private static boolean flagButtonVisibility;
//    private Double result1 = 0.0, result2 = 0.0, result3 = 0.0;

    @Override
    public void onCreate() {
        super.onCreate();

        Random rand = new Random();
        int r = rand.nextInt(29 + 1) + 0;    // for random equation

        positionValue = 0;

        equationsList = new ArrayList<>();
        equationsList.add(new Equation(-9, 2, 7, 1));
        equationsList.add(new Equation(1, -6, -4, 2));
        equationsList.add(new Equation(1, 3, -9, -6));
        equationsList.add(new Equation(-1, -3, 7, -1));
        equationsList.add(new Equation(-1, 9, -6, -3));
        equationsList.add(new Equation(1, -2, -9, 6));
        equationsList.add(new Equation(-3, 3, 5, -4));
        equationsList.add(new Equation(-2, 9, 6, -2));
        equationsList.add(new Equation(-1, -9, -3, 9));
        equationsList.add(new Equation(4, 9, -1, -5));
        equationsList.add(new Equation(-3, -7, 7, 9));
        equationsList.add(new Equation(-4, 1, 8, -4));
        equationsList.add(new Equation(1, -7, -5, 5));
        equationsList.add(new Equation(9, -8, -4, 2));
        equationsList.add(new Equation(1, -6, -9, -3));
        equationsList.add(new Equation(-3, -2, 9, 3));
        equationsList.add(new Equation(5, 8, -9, -9));
        equationsList.add(new Equation(9, -3, -6, 1));
        equationsList.add(new Equation(-6, -8, 5, 4));
        equationsList.add(new Equation(-1, -5, 8, 6));
        equationsList.add(new Equation(-7, -9 , 8, -1));
        equationsList.add(new Equation(9, 9, -5, -1));
        equationsList.add(new Equation(-1, -5, -4, 5));
        equationsList.add(new Equation(-3, -8, 3, 2));
        equationsList.add(new Equation(7, 3, -8, -4));
        equationsList.add(new Equation(2, 8, -7, -4));
        equationsList.add(new Equation(-1, 6, -1, -3));
        equationsList.add(new Equation(4, -2, -4, 1));
        equationsList.add(new Equation(-6, -7, 9, 3));
        equationsList.add(new Equation(6, -6, -3, 2));

        A = (double) equationsList.get(r).getA();    // first coefficient
        B = (double) equationsList.get(r).getB();    // second coefficient
        C = (double) equationsList.get(r).getC();    // third coefficient
        D = (double) equationsList.get(r).getD();    // fourth coefficient

        matrix = new ArrayList<>();
        matrix.add(A);
        matrix.add(B);
        matrix.add(C);
        matrix.add(D);

        counterRow = createMatrix(matrix);

        stringEquation = equationToString(A, B, C, D);

        X1 = calculateRoots(1);
        X2 = calculateRoots(2);
        X3 = calculateRoots(3);

        userList = new ArrayList<>();
        userList.add(A);
        userList.add(B);
        userList.add(C);
        userList.add(D);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);

//        result1 = substitutionRootToEquation(X1);
//        result2 = substitutionRootToEquation(X2);
//        result3 = substitutionRootToEquation(X3);
//        Log.v("TAG", "result1 " + result1);
//        Log.v("TAG", "result2 " + result2);
//        Log.v("TAG", "result3 " + result3);

    }

    public static List<Double> getUserList() {
        return userList;
    }

    /**
     * to display equation
     *
     * @param a first coefficient
     * @param b second coefficient
     * @param c third coefficient
     * @param d fourth coefficient
     * @return full string equation
     */
    public static String equationToString(Double a, Double b, Double c, Double d) {
        StringBuilder stringBuilder = new StringBuilder();
        int tempA, tempB, tempC, tempD;

        tempA = a.intValue();
        if (tempA == 1)
            stringBuilder.append("X" + "\u00b3 ");
        else if (tempA == -1)
            stringBuilder.append("- X" + "\u00b3 ");
        else if (tempA < 0)
            stringBuilder.append("- " + Math.abs(tempA) + "X" + "\u00b3 ");
        else if (tempA > 1)
            stringBuilder.append(tempA + "X" + "\u00b3 ");

        tempB = b.intValue();
        if (tempB == 1)
            stringBuilder.append("+ X" + "\u00b2 ");
        else if (tempB == -1)
            stringBuilder.append("- X" + "\u00b2 ");
        else if (tempB < 0)
            stringBuilder.append("- " + Math.abs(tempB) + "X" + "\u00b2 ");
        else if (tempB > 1)
            stringBuilder.append("+ " + tempB + "X" + "\u00b2 ");

        tempC = c.intValue();
        if (tempC == 1)
            stringBuilder.append("+ X ");
        else if (tempC == -1)
            stringBuilder.append("- X ");
        else if (tempC < 0)
            stringBuilder.append("- " + Math.abs(tempC) + "X ");
        else if (tempC > 1)
            stringBuilder.append("+ " + tempC + "X ");

        tempD = d.intValue();
        stringBuilder.append((tempD < 0) ? "- " + Math.abs(tempD) : "+ " + tempD);

        stringBuilder.append(" = 0");

        return stringBuilder.toString();
    }

    public static String getStringEquation() {
        return stringEquation;
    }

    public static void setPositionValue(Integer t) { positionValue = t; }
    public static Integer getPositionValue() { return positionValue; }

    /**
     * to round value to 4 signs
     *
     * @param temp full value
     * @return round value
     */
    public static Double roundValue(Double temp) {
        BigDecimal bigDecimal = new BigDecimal(temp);
        bigDecimal = bigDecimal.round(new MathContext(4));

        return bigDecimal.doubleValue();
    }

    /**
     * creating matrix
     *
     * @param matrix list for values of the matrix
     * @return amount of rows of the matrix
     */
    public static int createMatrix(List<Double> matrix) {
        boolean stopMatrix = false;
        Double a=0.0, b=0.0, c=0.0, d=0.0;
        Double temp;

        int j = 1;

        for (; stopMatrix != true; j++) {
            for (int i = 0; i < 4; i++) {

                int currentIndex = j * 4 + i;

                switch (i) {
                    case 0:
                        temp = matrix.get(currentIndex - 4) * matrix.get(currentIndex - 4);
                        a = roundValue(temp);
                        matrix.add(a);
                        break;
                    case 1:
                        temp = roundValue((matrix.get(currentIndex - 4) * matrix.get(currentIndex - 4)))
                                - roundValue(2 * matrix.get(currentIndex - 5) * matrix.get(currentIndex - 3));
                        b = roundValue(temp);
                        matrix.add(b);
                        if (b.equals(roundValue(matrix.get(currentIndex - 4) * matrix.get(currentIndex - 4)))) {
                            stopMatrix = true;
                        }
                        break;
                    case 2:
                        temp = roundValue((matrix.get(currentIndex - 4) * matrix.get(currentIndex - 4)))
                                - roundValue(2 * matrix.get(currentIndex - 5) * matrix.get(currentIndex - 3));
                        c = roundValue(temp);
                        matrix.add(c);

                        if (c.equals(roundValue(matrix.get(currentIndex - 4) * matrix.get(currentIndex - 4)))) {
                            stopMatrix = true;
                        }
                        break;
                    case 3:
                        temp = matrix.get(currentIndex - 4) * matrix.get(currentIndex - 4);
                        d = roundValue(temp);
                        matrix.add(d);
                        break;
                }
            }
        }

        return j-1;

    }

    public static List<Double> getMatrix() {
        return matrix;
    }

    /**
     * calculating root
     *
     * @param numberRoot number of the root from 1 till 3
     * @return root with a correct sign
     */
    public static Double calculateRoots(int numberRoot) {
        Double power = 1 / (Math.pow(2, counterRow));
        Double resultWithPositiveRoot, resultWithNegativeRoot, signRoot = 0.0;

        int sizeMatrix = matrix.size();
        Double x = 0.0;
        switch (numberRoot) {
            case 1:
                x = matrix.get(sizeMatrix - 3) / matrix.get(sizeMatrix - 4);
                break;
            case 2:
                x = matrix.get(sizeMatrix - 2) / matrix.get(sizeMatrix - 3);
                break;
            case 3:
                x = matrix.get(sizeMatrix - 1) / matrix.get(sizeMatrix - 2);
                break;
        }

        Double root = Math.pow(x, power);
        root = Math.round(root*1000d)/1000d;

        resultWithPositiveRoot = (matrix.get(0) * Math.pow(root, 3))
                + (matrix.get(1) * Math.pow(root, 2))
                + (matrix.get(2) * root)
                + matrix.get(3);

        resultWithNegativeRoot = (matrix.get(0) * Math.pow(-root, 3))
                + (matrix.get(1) * Math.pow(-root, 2))
                + (matrix.get(2) * -root)
                + matrix.get(3);

        if ((resultWithPositiveRoot < 0.1) & (resultWithPositiveRoot > -0.1)) {
            /* if substitution positive root to the equation is about 0 */
            signRoot = root;
        } else if ((resultWithNegativeRoot < 0.1) & (resultWithNegativeRoot > -0.1)) {
            /* if substitution negative root to the equation is about 0 */
            signRoot = -root;
        }

        return signRoot;
    }

//    public static Double substitutionRootToEquation(Double root) {
//        Double r = (matrix.get(0) * Math.pow(root, 3))
//                + (matrix.get(1) * Math.pow(root, 2))
//                + (matrix.get(2) * root)
//                + matrix.get(3);
//
//        return roundValue(r);
//    }

    public static Double getX1() {
        return X1;
    }

    public static Double getX2() {
        return X2;
    }

    public static Double getX3() {
        return X3;
    }

    /**
     * checking of filling the matrix out
     *
     * @return true if user filled out all cells of the matrix
     *         false if user did not fill out all cells of the matrix
     */
    public static boolean matchMatrix() {
        for (int i = 0; i < matrix.size(); i++) {
            if (userList.get(i).equals(0.0)) {
                flagButtonVisibility = false;
                return false;
            }
        }
        flagButtonVisibility = true;
        return true;
    }

    public static boolean isFlagButtonVisibility() {
        return flagButtonVisibility;
    }
}
