public class CheckEqualsTwo extends MathBehavior
{
//    private Buffer finalBuffer;
//    public FinalChecker(Buffer finalBuffer)
//    {
//        this.finalBuffer = finalBuffer;
//    }

    @Override
    public int delegateMath(int x)
    {
        if (x != 2)
        {
            System.out.println("FinalChecker error: expected 2 but got " + x);
        }
        return x;
    }
}
