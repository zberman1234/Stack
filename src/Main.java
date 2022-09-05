import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    
    private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    static int pass = 0;
    static int fail = 0;

    public static void main(String[] args) {
        //System.out.println("Hello World");
        testConstructStack();
        testPush();
        testPushPushPopPushPushPop();
        testPopWhenEmpty();
        testAlmostTooMuchPushing();
        testTooMuchPushing();
        System.out.println(" Passed " + pass +  " Failed " + fail);
    }

    static void testTooMuchPushing() {
        Stack dishes = new Stack(5);
        boolean hadException = false;
        try {
            dishes.push(3);
            dishes.push(3);
            dishes.push(3);
            dishes.push(3);
            dishes.push(3);
            dishes.push(3);
        }
        catch(RuntimeException e) {
            hadException = true;
        }
        if(!hadException) {
            fail++;
            LOGGER.log(Level.WARNING, "Failed test tooMuchPushing, " +
            "expected overflow exception was not thrown");
        } else {
            pass++;
        }
    }

    static void testAlmostTooMuchPushing() {
        Stack dishes = new Stack(5);
        boolean hadException = false;
        try {
            dishes.push(3);
            dishes.push(3);
            dishes.push(3);
            dishes.push(3);
            dishes.push(3);
        }
        catch(RuntimeException e) {
            hadException = true;
        }
        if(hadException) {
            fail++;
            LOGGER.log(Level.WARNING, "Failed test AlmostTooMuchPushing, " +
            "probably overflowed too early");
        } else {
            pass++;
        }
        
    }

    static void testPopWhenEmpty() {
        Stack dishes = new Stack(5);
        boolean hadException = false;
        try {
            dishes.pop();
        }
        catch(RuntimeException e) {
            pass++;
            hadException = true;
        }
        if(!hadException) {
            fail++;
            LOGGER.log(Level.WARNING, "Failed test PopWhenEmpty, " +
            "expected and exception but DID NOT get one.");
        }
        
    }

    static void testPushPushPopPushPushPop() {
        Stack dishes = new Stack(5);


        dishes.push(1);
        dishes.push(2);
        int actual = dishes.pop();
        int expected = 2;

        if(actual == expected) pass++;
        else {
            LOGGER.log(Level.WARNING, "Failed multi push test, " +
            "expected " + expected + " got " + actual);
        }

        dishes.push(3);
        dishes.push(4);
        actual = dishes.pop();
        expected = 4;

        if(actual == expected) pass++;
        else {
            LOGGER.log(Level.WARNING, "Failed multi push test, " +
            "expected " + expected + " got " + actual);
        }
    }

    static void testPush() {
        Stack dishes = new Stack(5);
        dishes.push(31);
        if(!dishes.empty()) pass++;
        else LOGGER.log(Level.WARNING, "Failed stack push, expected not empty got empty");

        int actual = dishes.pop();
        if(actual == 31) pass++;
        else {
            LOGGER.log(Level.WARNING, "Failed stack pop (testing push), " +
            "expected 31 got " + actual);
        }
    }
    static void testConstructStack() {
        Stack dishes = new Stack(5);
        if(dishes.empty()) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed stack construction, expected empty got not empty");
        }
    }
}