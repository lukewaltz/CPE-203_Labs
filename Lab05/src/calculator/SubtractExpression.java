package calculator;

class SubtractExpression
   extends BinaryExpression
{
//   private final Expression lft;
//   private final Expression rht;

   public SubtractExpression(final Expression lft, final Expression rht)
   {
      super(lft, rht, "-");
   }
   public double _applyOperator(double op1, double op2){
      return op1 - op2;
   }

//   public String toString()
//   {
//      return "(" + lft + " - " + rht + ")";
//   }
//
//   public double evaluate(final Bindings bindings)
//   {
//      return lft.evaluate(bindings) - rht.evaluate(bindings);
//   }
}

