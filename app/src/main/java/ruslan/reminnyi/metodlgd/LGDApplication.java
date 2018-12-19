package ruslan.reminnyi.metodlgd;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class LGDApplication extends Application {

    private static List<Double> userList;
    private static Integer positionValue;


    @Override
    public void onCreate() {
        super.onCreate();

        userList = new ArrayList<>();
        userList.add(-5.0);
        userList.add(5.0);
        userList.add(8.0);
        userList.add(2.0);
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
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);
        userList.add(0.0);

        positionValue = 0;

    }

    public static List<Double> getUserList() {
        return userList;
    }

    public static void setPositionValue(Integer t) { positionValue = t; }
    public static Integer getPositionValue() { return positionValue; }

}
