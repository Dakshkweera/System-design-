
public class Test{
    void show(){
        System.out.println(" this is non-static");
    }

    static void showw(){
        System.out.println(" this is static");
    }

    public static void main(String[] arg){
        Test t = new Test();
        showw();
        t.show();
    }
}