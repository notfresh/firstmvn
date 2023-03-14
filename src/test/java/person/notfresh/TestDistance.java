package person.notfresh;

import org.junit.Assert;
import org.junit.Test;
import person.notfresh.Distance;
import person.notfresh.Pair;

public class TestDistance {

    @Test
    public void testDis(){
        Distance d = new Distance();
//        Pair<Double, Double> p1 = new Pair<>(108.84, 34.28); // my home
        Pair<Double, Double> p1 = new Pair<>(108.95,34.26); // xi'an Bell Tower
        Pair<Double, Double> p2 = new Pair<>(108.89,34.23);// shaagu
        double ret = d.dis(p1.second, p1.first, p2.second
                , p2.first);
        System.out.println(ret);
        Assert.assertTrue(Math.abs(ret - 6445) < 1);
        // 440081.072156389
    }

}
