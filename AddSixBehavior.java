public class AddSixBehavior extends MathBehavior
{
    @Override
    protected int  delegateMath(int x)
    {
        x = x + 6;
        return x;
    }
}
