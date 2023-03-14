package person.notfresh;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.List;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    public int id();
    public String desc() default "No description";
}

class PwdUtil{

    @UseCase(id=47, desc = "password is alway true")
    public boolean validatePwd(String pwd){
        return true;
    }

    @UseCase(id=49, desc = "password is alway false")
    public boolean validatePwd2(String pwd){
        return false;
    }

    @UseCase(id=50, desc = "password validity is unknown")
    public boolean validatePwd3(String pwd){
        return false;
    }
}

class UseCaseTracker{
    public static void track(List<Integer> useCases, Class<?> cl){
        for(Method m: cl.getDeclaredMethods()){
            System.out.println(m.getName());
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found Usecase: " + uc.id() + " " + uc.desc());
                useCases.remove(new Integer(uc.id()));
            }

        }
        System.out.println();

        for(int i: useCases){
            System.out.println("Missing use case-" + i);
        }
    }
}
