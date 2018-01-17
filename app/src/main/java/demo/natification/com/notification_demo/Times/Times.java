package demo.natification.com.notification_demo.Times;

/**
 * Created by daniyar on 15/01/2018.
 */

public class Times  {

    Times() {

    }

    abstract class PrayTime {
        protected PrayTime comingTime;
        protected boolean turnOn = false;
        void setTime() {

        }
    }

    class Fajr extends PrayTime {

    }

    class Sunrise extends PrayTime {

    }

    class Dhuhr extends PrayTime {

    }

    class Maghrib extends PrayTime {

    }

    class Isha extends PrayTime {

    }
}
