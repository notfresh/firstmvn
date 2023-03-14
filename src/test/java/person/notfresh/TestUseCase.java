package person.notfresh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUseCase {


    public static void main(String[] args) {
        List<Integer> cases = new ArrayList<Integer>();
        Collections.addAll(cases, 47, 48, 49, 50);
        UseCaseTracker.track(cases, PwdUtil.class);
    }

}
