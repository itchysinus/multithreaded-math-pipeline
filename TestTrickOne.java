import java.lang.reflect.InvocationTargetException;

public class TestTrickOne {
    public static void main(String[] args) {
        try {
            testPipeline();
            testBuffer();
            testUnsharedBuffer();
            testBehaviors();
            testModifier();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testPipeline() throws ClassNotFoundException, InterruptedException,
            InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException
    {
        System.out.println("Testing Pipeline of Behaviors");
        // Defined set of behaviors that always ends in 2
        String[] behaviorSet = {
                "RandomNumberBehavior",
                "MultiplyBehavior",
                "AddBehavior",
                "DivideBehavior",
                "SubtractBehavior",
                "CheckEqualsTwo"
        };
        new Starter(behaviorSet);
//        Starter testPipeline = new Starter(behaviorSet);
//        Buffer  finalBuffer  = testPipeline.finalBuffer();
//        new FinalChecker(finalBuffer).check();
    }

    private static void testBuffer()
    {
        System.out.println("Testing Buffer");
        Buffer b = new Buffer();
        b.write(-7);
        int result = b.read();
        assert result == -7 : "Expected -7, got " + result;

        b.setOriginalValue(2147483647);
        result = b.getOriginalValue();
        assert result == 2147483647 : "Expected 2,147,483,647, got " + b.getOriginalValue();
    }

    private static void testUnsharedBuffer()
    {
        System.out.println("Testing Unshared Buffer");
        UnsharedBuffer ub = new UnsharedBuffer();
        ub.write(67);
        int result = ub.read();
        assert result == 67 : "Expected 67 but got " + result;
//        System.out.println("Expected 67, got " + result);

        ub.setOriginalValue(2147483647);
        assert ub.getOriginalValue() == 2147483647 :  "Expected 2147483647, got " + ub.getOriginalValue();
//        System.out.println("Expected 2147483647, got " + ub.getOriginalValue());
    }

    private static void testBehaviors()
    {
        Buffer in = new Buffer();
        Buffer out = new Buffer();

        in.write(2);
        new MultiplyByThreeBehavior().doTheMath(in, out);
        assert out.read() == 6 : "Expected 6, got " + out.read();
//        System.out.println("Expected 6, got " + out.read());

        in.write(4);
        new AddSixBehavior().doTheMath(in, out);
        assert out.read() == 10 : "Expected 10, got " + out.read();
//        System.out.println("Expected 10, got " + out.read());

        in.write(15);
        in.setOriginalValue(5);
        new SubtractOriginalBehavior().doTheMath(in, out);
        assert out.read() == 10 : "Expected 10, got " + out.read();
//        System.out.println("Expected 10, got " + out.read());

        in.write(6);
        new DivideByThreeBehavior().doTheMath(in, out);
        assert out.read() == 2 : "Expected 2, got " + out.read();
//        System.out.println("Expected 2, got " + out.read());
    }

    private static void testModifier() throws InterruptedException {
        System.out.println("Testing Modifier");
        Buffer in = new Buffer();
        Buffer out  = new Buffer();
        in.write(2);
        in.read();


        Modifier m = new Modifier(new MultiplyByThreeBehavior(), 0, in, out);
        m.start();
        m.join();

        assert out.read() == 6 : "Expected 6, got " + out.read();
//        System.out.println("Expected 6, got " + out.read());
    }

}
