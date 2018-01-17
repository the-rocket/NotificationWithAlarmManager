package demo.natification.com.notification_demo.Times;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by daniyar on 16/01/2018.
 */


public class MyClass {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws IOException {
        Files.list(Paths.get("./App")).forEach(System.out::println);
        //System.out.print("Hello World!");
    }
}
