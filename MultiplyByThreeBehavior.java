public class MultiplyByThreeBehavior extends MathBehavior
{
    @Override
    protected int delegateMath(int x)
    {
        x = x * 3;
        return x;
    }
}
