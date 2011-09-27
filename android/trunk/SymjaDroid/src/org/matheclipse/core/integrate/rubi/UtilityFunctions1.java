package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.Apply;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Cancel;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.E;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.EvenQ;
import static org.matheclipse.core.expression.F.Expand;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.First;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.GCD;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.GreaterEqual;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.LessEqual;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Max;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Numerator;
import static org.matheclipse.core.expression.F.OddQ;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Prepend;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rest;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.SetDelayed;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Slot;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Slot2;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.fraction;
import static org.matheclipse.core.expression.F.integer;
import static org.matheclipse.core.expression.F.stringx;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AlgebraicFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialTest;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandImproperFraction;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandPolynomial;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ImproperRationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegerPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.MonomialFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.MonomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.MonomialSumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegativeCoefficientQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonpolynomialTerms;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonsumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonzeroQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalForm;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NotFalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NumericFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PerfectPowerTest;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialDivide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialFunctionOf;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialTermQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialTerms;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PositiveIntegerPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticPolynomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuotientOfLinearsParts;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuotientOfLinearsQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionExponents;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RecognizedFormQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Regularize;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerExpressionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyExpression;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SmartDenominator;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SmartLeafCount;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SmartNumerator;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SplitFreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigSimplify;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigSimplifyAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ZeroQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.AtomQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Catch;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Coefficient;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Exponent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.FactorSquareFreeList;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Head;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Map;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.PolynomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.PolynomialQuotient;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.PolynomialRemainder;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Print;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Reverse;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.SameQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Scan;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Throw;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.UnsameQ;

import org.matheclipse.core.interfaces.IAST;
/** 
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class UtilityFunctions1 { 
  public static IAST RULES = List( 
SetDelayed(LinearQ($p("u"),$p("x",$s("Symbol"))),
    And(PolynomialQ($s("u"),$s("x")),SameQ(Exponent($s("u"),$s("x")),C1))),
SetDelayed(QuadraticQ($p("u"),$p("x",$s("Symbol"))),
    And(PolynomialQ($s("u"),$s("x")),SameQ(Exponent($s("u"),$s("x")),C2))),
SetDelayed(MonomialQ($p("u"),$p("x",$s("Symbol"))),
    MatchQ($s("u"),Condition(Power($s("x"),$p("n",true)),FreeQ($s("n"),$s("x"))))),
SetDelayed(BinomialQ($p("u"),$p("x",$s("Symbol"))),
    NotFalseQ(BinomialTest($s("u"),$s("x")))),
SetDelayed(MonomialSumQ($p("u"),$p("x",$s("Symbol"))),
    And(SumQ($s("u")),Catch(CompoundExpression(Scan(Function(If(Or(FreeQ(Slot1,$s("x")),MonomialQ(Part(SplitFreeFactors(Slot1,$s("x")),C2),$s("x"))),$s("Null"),Throw(False))),$s("u")),True)))),
SetDelayed(PolynomialTermQ($p("u"),$p("x",$s("Symbol"))),
    Or(FreeQ($s("u"),$s("x")),MatchQ($s("u"),Condition(Times($p("a",true),Power($s("x"),$p("n",true))),And(And(FreeQ($s("a"),$s("x")),IntegerQ($s("n"))),Greater($s("n"),C0)))))),
SetDelayed(PolynomialTerms($p("u"),$p("x",$s("Symbol"))),
    Map(Function(If(PolynomialTermQ(Slot1,$s("x")),Slot1,C0)),$s("u"))),
SetDelayed(NonpolynomialTerms($p("u"),$p("x",$s("Symbol"))),
    Map(Function(If(PolynomialTermQ(Slot1,$s("x")),C0,Slot1)),$s("u"))),
SetDelayed(BinomialTest($p("u"),$p("x",$s("Symbol"))),
    If(SameQ($s("u"),$s("x")),List(C0,C1,C1),If(FreeQ($s("u"),$s("x")),List(C0,$s("u"),C0),If(PowerQ($s("u")),If(And(SameQ(Part($s("u"),C1),$s("x")),FreeQ(Part($s("u"),C2),$s("x"))),List(C0,C1,Part($s("u"),C2)),False),Module(List($s("lst1"),$s("lst2")),If(ProductQ($s("u")),CompoundExpression(Set($s("lst1"),BinomialTest(First($s("u")),$s("x"))),If(FalseQ($s("lst1")),False,CompoundExpression(Set($s("lst2"),BinomialTest(Rest($s("u")),$s("x"))),If(FalseQ($s("lst2")),False,Module(List($s("a"),$s("b"),$s("c"),$s("d"),$s("m"),$s("n")),CompoundExpression(CompoundExpression(Set(List($s("a"),$s("b"),$s("m")),$s("lst1")),Set(List($s("c"),$s("d"),$s("n")),$s("lst2"))),If(SameQ($s("m"),C0),List(Times($s("b"),$s("c")),Times($s("b"),$s("d")),$s("n")),If(SameQ($s("n"),C0),List(Times($s("a"),$s("d")),Times($s("b"),$s("d")),$s("m")),If(SameQ($s("a"),C0),If(SameQ($s("c"),C0),List(C0,Times($s("b"),$s("d")),Plus($s("m"),$s("n"))),If(SameQ(Plus($s("m"),$s("n")),C0),List(Times($s("b"),$s("d")),Times($s("b"),$s("c")),$s("m")),False)),If(SameQ($s("c"),C0),If(SameQ(Plus($s("m"),$s("n")),C0),List(Times($s("b"),$s("d")),Times($s("a"),$s("d")),$s("n")),False),False)))))))))),If(SumQ($s("u")),CompoundExpression(Set($s("lst1"),BinomialTest(First($s("u")),$s("x"))),If(FalseQ($s("lst1")),False,CompoundExpression(Set($s("lst2"),BinomialTest(Rest($s("u")),$s("x"))),If(FalseQ($s("lst2")),False,Module(List($s("a"),$s("b"),$s("c"),$s("d"),$s("m"),$s("n")),CompoundExpression(CompoundExpression(Set(List($s("a"),$s("b"),$s("m")),$s("lst1")),Set(List($s("c"),$s("d"),$s("n")),$s("lst2"))),If(SameQ($s("m"),C0),List(Plus($s("b"),$s("c")),$s("d"),$s("n")),If(SameQ($s("n"),C0),List(Plus($s("a"),$s("d")),$s("b"),$s("m")),If(SameQ($s("m"),$s("n")),List(Plus($s("a"),$s("c")),Plus($s("b"),$s("d")),$s("m")),False))))))))),False))))))),
SetDelayed(PerfectPowerTest($p("u"),$p("x",$s("Symbol"))),
    If(PolynomialQ($s("u"),$s("x")),Module(List(Set($s("lst"),FactorSquareFreeList($s("u"))),Set($s("gcd"),C0),Set($s("v"),C1)),CompoundExpression(CompoundExpression(If(SameQ(Part($s("lst"),C1),List(C1,C1)),Set($s("lst"),Rest($s("lst")))),Scan(Function(Set($s("gcd"),GCD($s("gcd"),Part(Slot1,C2)))),$s("lst"))),If(Greater($s("gcd"),C1),CompoundExpression(Scan(Function(Set($s("v"),Times($s("v"),Power(Part(Slot1,C1),Times(Part(Slot1,C2),Power($s("gcd"),CN1)))))),$s("lst")),Power(Expand($s("v")),$s("gcd"))),False))),False)),
SetDelayed(RationalFunctionQ($p("u"),$p("x",$s("Symbol"))),
    If(AtomQ($s("u")),True,If(IntegerPowerQ($s("u")),RationalFunctionQ(Part($s("u"),C1),$s("x")),If(Or(ProductQ($s("u")),SumQ($s("u"))),Catch(CompoundExpression(Scan(Function(If(RationalFunctionQ(Slot1,$s("x")),$s("Null"),Throw(False))),$s("u")),True)),If(FreeQ($s("u"),$s("x")),True,False))))),
SetDelayed(RationalFunctionExponents($p("u"),$p("x",$s("Symbol"))),
    If(PolynomialQ($s("u"),$s("x")),List(Exponent($s("u"),$s("x")),C0),If(IntegerPowerQ($s("u")),If(Greater(Part($s("u"),C2),C0),Times(Part($s("u"),C2),RationalFunctionExponents(Part($s("u"),C1),$s("x"))),Times(Times(CN1,Part($s("u"),C2)),Reverse(RationalFunctionExponents(Part($s("u"),C1),$s("x"))))),If(ProductQ($s("u")),Plus(RationalFunctionExponents(First($s("u")),$s("x")),RationalFunctionExponents(Rest($s("u")),$s("x"))),If(SumQ($s("u")),Module(List(Set($s("v"),Together($s("u")))),If(SumQ($s("v")),Module(List($s("lst1"),$s("lst2")),CompoundExpression(CompoundExpression(Set($s("lst1"),RationalFunctionExponents(First($s("u")),$s("x"))),Set($s("lst2"),RationalFunctionExponents(Rest($s("u")),$s("x")))),List(Max(Plus(Part($s("lst1"),C1),Part($s("lst2"),C2)),Plus(Part($s("lst2"),C1),Part($s("lst1"),C2))),Plus(Part($s("lst1"),C2),Part($s("lst2"),C2))))),RationalFunctionExponents($s("v"),$s("x")))),List(C0,C0)))))),
SetDelayed(AlgebraicFunctionQ($p("u"),$p("x",$s("Symbol"))),
    If(Or(AtomQ($s("u")),FreeQ($s("u"),$s("x"))),True,If(RationalPowerQ($s("u")),AlgebraicFunctionQ(Part($s("u"),C1),$s("x")),If(Or(ProductQ($s("u")),SumQ($s("u"))),Catch(CompoundExpression(Scan(Function(If(AlgebraicFunctionQ(Slot1,$s("x")),$s("Null"),Throw(False))),$s("u")),True)),False)))),
SetDelayed(QuotientOfLinearsQ(Times($p("a"),$p("u")),$p("x")),
    Condition(QuotientOfLinearsQ($s("u"),$s("x")),FreeQ($s("a"),$s("x")))),
SetDelayed(QuotientOfLinearsQ(Plus($p("a"),$p("u")),$p("x")),
    Condition(QuotientOfLinearsQ($s("u"),$s("x")),FreeQ($s("a"),$s("x")))),
SetDelayed(QuotientOfLinearsQ(Times(C1,Power($p("u"),CN1)),$p("x")),
    QuotientOfLinearsQ($s("u"),$s("x"))),
SetDelayed(QuotientOfLinearsQ($p("u"),$p("x")),
    Condition(True,LinearQ($s("u"),$s("x")))),
SetDelayed(QuotientOfLinearsQ(Times($p("u"),Power($p("v"),CN1)),$p("x")),
    Condition(True,And(LinearQ($s("u"),$s("x")),LinearQ($s("v"),$s("x"))))),
SetDelayed(QuotientOfLinearsQ($p("u"),$p("x")),
    Or(SameQ($s("u"),$s("x")),FreeQ($s("u"),$s("x")))),
SetDelayed(QuotientOfLinearsParts(Times($p("a"),$p("u")),$p("x")),
    Condition(Apply(Function(List(Times($s("a"),Slot1),Times($s("a"),Slot2),Slot(C3),Slot(C4))),QuotientOfLinearsParts($s("u"),$s("x"))),FreeQ($s("a"),$s("x")))),
SetDelayed(QuotientOfLinearsParts(Plus($p("a"),$p("u")),$p("x")),
    Condition(Apply(Function(List(Plus(Slot1,Times($s("a"),Slot(C3))),Plus(Slot2,Times($s("a"),Slot(C4))),Slot(C3),Slot(C4))),QuotientOfLinearsParts($s("u"),$s("x"))),FreeQ($s("a"),$s("x")))),
SetDelayed(QuotientOfLinearsParts(Times(C1,Power($p("u"),CN1)),$p("x")),
    Apply(Function(List(Slot(C3),Slot(C4),Slot1,Slot2)),QuotientOfLinearsParts($s("u"),$s("x")))),
SetDelayed(QuotientOfLinearsParts($p("u"),$p("x")),
    Condition(List(Coefficient($s("u"),$s("x"),C0),Coefficient($s("u"),$s("x"),C1),C1,C0),LinearQ($s("u"),$s("x")))),
SetDelayed(QuotientOfLinearsParts(Times($p("u"),Power($p("v"),CN1)),$p("x")),
    Condition(List(Coefficient($s("u"),$s("x"),C0),Coefficient($s("u"),$s("x"),C1),Coefficient($s("v"),$s("x"),C0),Coefficient($s("v"),$s("x"),C1)),And(LinearQ($s("u"),$s("x")),LinearQ($s("v"),$s("x"))))),
SetDelayed(QuotientOfLinearsParts($p("u"),$p("x")),
    If(SameQ($s("u"),$s("x")),List(C0,C1,C1,C0),If(FreeQ($s("u"),$s("x")),List($s("u"),C0,C1,C0),CompoundExpression(Print(stringx("QuotientOfLinearParts error!")),List($s("u"),C0,C1,C0))))),
SetDelayed(ImproperRationalFunctionQ($p("u"),$p("v"),$p("x",$s("Symbol"))),
    And(And(And(PolynomialQ($s("u"),$s("x")),PolynomialQ($s("v"),$s("x"))),Not(And(MatchQ($s("u"),Condition(Power(Plus($p("a",true),Times($p("b",true),$s("x"))),$p("n",true)),And(FreeQ(List($s("a"),$s("b")),$s("x")),IntegerQ($s("n"))))),MatchQ($s("v"),Condition(Power(Plus($p("a",true),Times($p("b",true),$s("x"))),$p("n",true)),And(FreeQ(List($s("a"),$s("b")),$s("x")),IntegerQ($s("n")))))))),Or(And(QuadraticQ($s("v"),$s("x")),GreaterEqual(Exponent($s("u"),$s("x")),C2)),MatchQ($s("v"),Condition(Plus($p("a"),Times($p("b",true),Power($s("x"),$p("n",true)))),And(And(FreeQ(List($s("a"),$s("b")),$s("x")),IntegerQ($s("n"))),And(Less(C0,$s("n")),LessEqual($s("n"),Exponent($s("u"),$s("x")))))))))),
SetDelayed(ExpandImproperFraction($p("u"),$p("x",$s("Symbol"))),
    Module(List($s("tmp")),If(NotFalseQ(Set($s("tmp"),ExpandImproperFraction(Numerator($s("u")),Denominator($s("u")),$s("x")))),$s("tmp"),If(NotFalseQ(Set($s("tmp"),ExpandImproperFraction(SmartNumerator($s("u")),SmartDenominator($s("u")),$s("x")))),$s("tmp"),If(FunctionOfQ(Sin($s("x")),$s("u"),$s("x")),CompoundExpression(Set($s("tmp"),Regularize(SubstFor(Sin($s("x")),$s("u"),$s("x")),$s("x"))),If(NotFalseQ(Set($s("tmp"),ExpandImproperFraction(Numerator($s("tmp")),Denominator($s("tmp")),$s("x")))),Subst($s("tmp"),$s("x"),Sin($s("x"))),False)),If(FunctionOfQ(Cos($s("x")),$s("u"),$s("x")),CompoundExpression(Set($s("tmp"),Regularize(SubstFor(Cos($s("x")),$s("u"),$s("x")),$s("x"))),If(NotFalseQ(Set($s("tmp"),ExpandImproperFraction(Numerator($s("tmp")),Denominator($s("tmp")),$s("x")))),Subst($s("tmp"),$s("x"),Cos($s("x"))),False)),If(FunctionOfQ(Sinh($s("x")),$s("u"),$s("x")),CompoundExpression(Set($s("tmp"),Regularize(SubstFor(Sinh($s("x")),$s("u"),$s("x")),$s("x"))),If(NotFalseQ(Set($s("tmp"),ExpandImproperFraction(Numerator($s("tmp")),Denominator($s("tmp")),$s("x")))),Subst($s("tmp"),$s("x"),Sinh($s("x"))),False)),If(FunctionOfQ(Cosh($s("x")),$s("u"),$s("x")),CompoundExpression(Set($s("tmp"),Regularize(SubstFor(Cosh($s("x")),$s("u"),$s("x")),$s("x"))),If(NotFalseQ(Set($s("tmp"),ExpandImproperFraction(Numerator($s("tmp")),Denominator($s("tmp")),$s("x")))),Subst($s("tmp"),$s("x"),Cosh($s("x"))),False)),False)))))))),
SetDelayed(ExpandImproperFraction($p("u"),$p("v"),$p("x",$s("Symbol"))),
    Module(List($s("lst1"),$s("lst2")),CompoundExpression(CompoundExpression(Set($s("lst1"),PolynomialFunctionOf($s("u"),$s("x"))),Set($s("lst2"),PolynomialFunctionOf($s("v"),$s("x")))),If(And(SameQ(Part($s("lst1"),C1),Part($s("lst2"),C1)),GreaterEqual(Exponent(Part($s("lst1"),C2),$s("x")),Exponent(Part($s("lst2"),C2),$s("x")))),ReplaceAll(PolynomialDivide(Part($s("lst1"),C2),Part($s("lst2"),C2),$s("x")),Rule($s("x"),Part($s("lst1"),C1))),False)))),
SetDelayed(PolynomialDivide($p("u"),$p("v"),$p("x",$s("Symbol"))),
    Prepend(SplitFreeFactors(Regularize(Times(PolynomialRemainder($s("u"),$s("v"),$s("x")),Power($s("v"),CN1)),$s("x")),$s("x")),PolynomialQuotient($s("u"),$s("v"),$s("x")))),
SetDelayed(SmartNumerator($p("u")),
    If(MemberQ(List($s("Cot"),$s("Sec"),$s("Csc"),$s("Coth"),$s("Sech"),$s("Csch")),Head($s("u"))),C1,If(And(And(PowerQ($s("u")),IntegerQ(Part($s("u"),C2))),MemberQ(List($s("Cot"),$s("Sec"),$s("Csc"),$s("Coth"),$s("Sech"),$s("Csch")),Head(Part($s("u"),C1)))),C1,If(And(And(PowerQ($s("u")),RationalQ(Part($s("u"),C2))),Less(Part($s("u"),C2),C0)),C1,If(ProductQ($s("u")),Map($s("Integrate::SmartNumerator"),$s("u")),$s("u")))))),
SetDelayed(SmartDenominator($p("u")),
    If(MemberQ(List($s("Cot"),$s("Sec"),$s("Csc"),$s("Coth"),$s("Sech"),$s("Csch")),Head($s("u"))),Times(C1,Power($s("u"),CN1)),If(And(And(PowerQ($s("u")),IntegerQ(Part($s("u"),C2))),MemberQ(List($s("Cot"),$s("Sec"),$s("Csc"),$s("Coth"),$s("Sech"),$s("Csch")),Head(Part($s("u"),C1)))),Times(C1,Power($s("u"),CN1)),If(And(And(PowerQ($s("u")),RationalQ(Part($s("u"),C2))),Less(Part($s("u"),C2),C0)),Times(C1,Power($s("u"),CN1)),If(ProductQ($s("u")),Map($s("Integrate::SmartDenominator"),$s("u")),C1))))),
SetDelayed(PolynomialFunctionOf($p("u"),$p("x",$s("Symbol"))),
    If(AtomQ($s("u")),If(SameQ($s("u"),$s("x")),List($s("x"),$s("x")),List(C1,$s("u"))),If(PositiveIntegerPowerQ($s("u")),Module(List(Set($s("lst"),PolynomialFunctionOf(Part($s("u"),C1),$s("x")))),List(Part($s("lst"),C1),Power(Part($s("lst"),C2),Part($s("u"),C2)))),If(ProductQ($s("u")),Module(List(Set($s("lst1"),PolynomialFunctionOf(First($s("u")),$s("x"))),Set($s("lst2"),PolynomialFunctionOf(Rest($s("u")),$s("x")))),If(SameQ(Part($s("lst1"),C1),C1),List(Part($s("lst2"),C1),Times(Part($s("lst1"),C2),Part($s("lst2"),C2))),If(SameQ(Part($s("lst2"),C1),C1),List(Part($s("lst1"),C1),Times(Part($s("lst1"),C2),Part($s("lst2"),C2))),If(SameQ(Part($s("lst1"),C1),Part($s("lst2"),C1)),List(Part($s("lst1"),C1),Times(Part($s("lst1"),C2),Part($s("lst2"),C2))),List($s("u"),$s("x")))))),If(SumQ($s("u")),Module(List(Set($s("lst1"),PolynomialFunctionOf(First($s("u")),$s("x"))),Set($s("lst2"),PolynomialFunctionOf(Rest($s("u")),$s("x")))),If(SameQ(Part($s("lst1"),C1),C1),List(Part($s("lst2"),C1),Plus(Part($s("lst1"),C2),Part($s("lst2"),C2))),If(SameQ(Part($s("lst2"),C1),C1),List(Part($s("lst1"),C1),Plus(Part($s("lst1"),C2),Part($s("lst2"),C2))),If(SameQ(Part($s("lst1"),C1),Part($s("lst2"),C1)),List(Part($s("lst1"),C1),Plus(Part($s("lst1"),C2),Part($s("lst2"),C2))),List($s("u"),$s("x")))))),If(FreeQ($s("u"),$s("x")),List(C1,$s("u")),List($s("u"),$s("x")))))))),
SetDelayed(Dist($p("u"),$p("v")),
    Condition(Times(CN1,Dist(Times(CN1,$s("u")),$s("v"))),Less(NumericFactor($s("u")),C0))),
SetDelayed(Dist($p("u"),Dist($p("v"),$p("w"))),
    Dist(Times($s("u"),$s("v")),$s("w"))),
SetDelayed(Dist($p("u"),$p("v")),
    Condition(Map(Function(Dist($s("u"),Slot1)),$s("v")),SumQ($s("v")))),
SetDelayed(Dist($p("u"),$p("v")),
    Condition(Times($s("u"),$s("v")),Or(FreeQ($s("v"),$s("Int")),UnsameQ($s("ShowSteps"),True)))),
SetDelayed(Dist($p("u"),Times($p("v"),$p("w"))),
    Condition(Dist(Times($s("u"),$s("v")),$s("w")),FreeQ($s("v"),$s("Int")))),
SetDelayed(Regularize($p("u"),$p("x",$s("Symbol"))),
    If(RecognizedFormQ($s("u"),$s("x")),$s("u"),NormalForm(NormalForm(NormalForm(Simplify($s("u")),$s("x")),$s("x")),$s("x")))),
SetDelayed(RecognizedFormQ($p("u"),$p("x",$s("Symbol"))),
    Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(FreeQ($s("u"),$s("x")),MonomialQ($s("u"),$s("x"))),MatchQ($s("u"),Condition(Times($p("a"),$p("v")),And(FreeQ($s("a"),$s("x")),RecognizedFormQ($s("v"),$s("x")))))),MatchQ($s("u"),Condition(Power($($p("f"),Plus($p("a",true),Times($p("b",true),$s("x")))),$p("n",true)),And(FreeQ(List($s("a"),$s("b"),$s("f")),$s("x")),IntegerQ($s("n")))))),MatchQ($s("u"),Condition(Power(Plus($p("a"),Times($p("b",true),Power($s("x"),$p("n",true)))),$p("p",true)),And(And(FreeQ(List($s("a"),$s("b"),$s("n"),$s("p")),$s("x")),IntegerQ($s("n"))),Greater($s("n"),C0))))),MatchQ($s("u"),Condition(Times(Power($s("x"),$p("m",true)),Power(Plus($p("a"),Times($p("b",true),Power($s("x"),$p("n",true)))),$p("p",true))),And(And(FreeQ(List($s("a"),$s("b"),$s("m"),$s("n"),$s("p")),$s("x")),IntegerQ($s("n"))),Greater($s("n"),C0))))),MatchQ($s("u"),Condition(Times(Power(Plus($p("a",true),Times($p("b",true),$s("x"))),$p("m",true)),Power(Plus($p("c",true),Times($p("d",true),$s("x"))),$p("n",true))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("m"),$s("n")),$s("x"))))),MatchQ($s("u"),Condition(Times(Times(Power($s("x"),$p("p",true)),Power(Plus($p("a",true),Times($p("b",true),$s("x"))),$p("m",true))),Power(Plus($p("c",true),Times($p("d",true),$s("x"))),$p("n",true))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("m"),$s("n"),$s("p")),$s("x"))))),MatchQ($s("u"),Condition(Times(Power($s("x"),$p("m",true)),Power(Plus(Times($p("b",true),$s("x")),Times($p("c",true),Power($s("x"),C2))),$p("n"))),And(FreeQ(List($s("b"),$s("c"),$s("m"),$s("n")),$s("x")),Not(IntegerQ($s("n"))))))),MatchQ($s("u"),Condition(Power(Plus(Plus($p("a",true),Times($p("b",true),$s("x"))),Times($p("c",true),Power($s("x"),C2))),$p("n",true)),FreeQ(List($s("a"),$s("b"),$s("c"),$s("n")),$s("x"))))),MatchQ($s("u"),Condition(Times(Power($s("x"),$p("m",true)),Power(Plus(Plus($p("a"),Times($p("b",true),$s("x"))),Times($p("c",true),Power($s("x"),C2))),$p("n",true))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("m"),$s("n")),$s("x"))))),MatchQ($s("u"),Condition(Times(Plus($p("d"),Times($p("e",true),$s("x"))),Power(Plus(Plus($p("a"),Times($p("b",true),$s("x"))),Times($p("c",true),Power($s("x"),C2))),CN1)),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e")),$s("x"))))),MatchQ($s("u"),Condition(Times(Power($s("x"),$p("m",true)),Times(Plus($p("d"),Times($p("e",true),$s("x"))),Power(Plus(Plus($p("a"),Times($p("b",true),$s("x"))),Times($p("c",true),Power($s("x"),C2))),CN1))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e")),$s("x"))))),MatchQ($s("u"),Condition(Times($p("v"),Plus($p("a"),Times($p("b",true),$s("x")))),And(FreeQ(List($s("a"),$s("b")),$s("x")),FunctionOfQ(Plus(Times($s("a"),$s("x")),Times($s("b"),Times(Power($s("x"),C2),C1D2))),$s("v"),$s("x")))))),MatchQ($s("u"),Condition(Times(Plus(Times($p("a",true),Power($p("v"),$p("m",true))),Times($p("b",true),Power($p("v"),$p("n",true)))),Power(Plus(Times($p("c",true),Power($p("v"),$p("m",true))),Times($p("d",true),Power($p("v"),$p("n",true)))),CN1)),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("m"),$s("n")),$s("x")))))),
SetDelayed(NormalForm(Times(Power($p("u"),$p("m")),Power($p("v"),$p("n"))),$p("x",$s("Symbol"))),
    Condition(NormalForm(Times(Power(Map(Function(Times(CN1,Slot1)),$s("u")),$s("m")),Power(Map(Function(Times(CN1,Slot1)),$s("v")),$s("n"))),$s("x")),And(And(And(And(OddQ(List($s("m"),$s("n"))),SumQ($s("u"))),SumQ($s("v"))),NegativeCoefficientQ($s("u"))),NegativeCoefficientQ($s("v"))))),
SetDelayed(NormalForm($p("u"),$p("x",$s("Symbol"))),
    Condition(Plus(Coefficient($s("u"),$s("x"),C0),Times(Coefficient($s("u"),$s("x"),C1),$s("x"))),LinearQ($s("u"),$s("x")))),
SetDelayed(NormalForm(Times($p("a"),$p("u")),$p("x",$s("Symbol"))),
    Condition(NormalForm(Map(Function(Times($s("a"),Slot1)),$s("u")),$s("x")),And(FreeQ($s("a"),$s("x")),SumQ($s("u"))))),
SetDelayed(NormalForm(Times(Times($p("b",true),$p("x")),Plus($p("c"),Times($p("d",true),$p("x")))),$p("x",$s("Symbol"))),
    Condition(Plus(Times(Times($s("b"),$s("c")),$s("x")),Times(Times($s("b"),$s("d")),Power($s("x"),C2))),FreeQ(List($s("b"),$s("c"),$s("d")),$s("x")))),
SetDelayed(NormalForm(Plus($p("a"),Times(Times($p("b",true),Power($p("x"),$p("n",true))),Plus($p("c"),Times($p("d",true),Power($p("x"),$p("n",true)))))),$p("x",$s("Symbol"))),
    Condition(Plus(Plus($s("a"),Times(Times($s("b"),$s("c")),Power($s("x"),$s("n")))),Times(Times($s("b"),$s("d")),Power($s("x"),Times(C2,$s("n"))))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("n")),$s("x")))),
SetDelayed(NormalForm(Plus($p("c"),Times($p("d",true),Power(Plus($p("a"),Times($p("b",true),Power($p("x"),$p("n",true)))),C2))),$p("x",$s("Symbol"))),
    Condition(Plus(Plus(Plus($s("c"),Times(Power($s("a"),C2),$s("d"))),Times(Times(Times(Times(C2,$s("a")),$s("b")),$s("d")),Power($s("x"),$s("n")))),Times(Times(Power($s("b"),C2),$s("d")),Power($s("x"),Times(C2,$s("n"))))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("n")),$s("x")))),
SetDelayed(NormalForm(Plus(Plus($p("c",true),Times($p("e",true),Power($p("x"),$p("n",true)))),Times($p("d",true),Power(Plus($p("a"),Times($p("b",true),Power($p("x"),$p("n",true)))),C2))),$p("x",$s("Symbol"))),
    Condition(Plus(Plus(Plus($s("c"),Times(Power($s("a"),C2),$s("d"))),Times(Plus($s("e"),Times(Times(Times(C2,$s("a")),$s("b")),$s("d"))),Power($s("x"),$s("n")))),Times(Times(Power($s("b"),C2),$s("d")),Power($s("x"),Times(C2,$s("n"))))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e"),$s("n")),$s("x")))),
SetDelayed(NormalForm(Plus($p("a"),Times(Times($p("b",true),Power($p("f"),Plus($p("e",true),Times($p("g",true),$p("x"))))),Plus($p("c"),Times($p("d",true),Power($p("f"),Plus($p("e",true),Times($p("g",true),$p("x")))))))),$p("x",$s("Symbol"))),
    Condition(Plus(Plus($s("a"),Times(Times($s("b"),$s("c")),Power($s("f"),Plus($s("e"),Times($s("g"),$s("x")))))),Times(Times($s("b"),$s("d")),Power($s("f"),Plus(Times(C2,$s("e")),Times(Times(C2,$s("g")),$s("x")))))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e"),$s("f"),$s("g")),$s("x")))),
SetDelayed(NormalForm(Times(Times($p("c",true),Power($p("x"),$p("m",true))),Plus($p("a"),Times($p("b",true),Power($p("x"),$p("n",true))))),$p("x",$s("Symbol"))),
    Condition(Times($s("c"),Plus($s("b"),Times($s("a"),Power($s("x"),$s("m"))))),And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("m"),$s("n")),$s("x")),ZeroQ(Plus($s("m"),$s("n")))))),
SetDelayed(NormalForm($($p("f"),Times(Times($p("c",true),Power($p("x"),$p("m",true))),Power(Plus($p("a"),Times($p("b",true),Power($p("x"),$p("n",true)))),$p("p")))),$p("x",$s("Symbol"))),
    Condition($($s("f"),Times($s("c"),Power(Plus($s("b"),Times($s("a"),Power(Power($s("x"),$s("n")),CN1))),$s("p")))),And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("f"),$s("m"),$s("n")),$s("x")),IntegerQ($s("p"))),ZeroQ(Plus($s("m"),Times($s("n"),$s("p"))))))),
SetDelayed(NormalForm(Power(Times(Times($p("e",true),Plus($p("a"),Times($p("b",true),$p("x")))),Plus($p("c"),Times($p("d",true),$p("x")))),$p("n")),$p("x",$s("Symbol"))),
    Condition(Power(Plus(Plus(Times(Times($s("a"),$s("c")),$s("e")),Times(Plus(Times(Times($s("a"),$s("d")),$s("e")),Times(Times($s("b"),$s("c")),$s("e"))),$s("x"))),Times(Times(Times($s("b"),$s("d")),$s("e")),Power($s("x"),C2))),$s("n")),And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e")),$s("x")),FractionQ($s("n"))))),
SetDelayed(NormalForm($($p("f"),$p("u")),$p("x",$s("Symbol"))),
    Condition($($s("f"),ExpandPolynomial($s("u"),$s("x"))),And(FreeQ($s("f"),$s("x")),QuadraticPolynomialQ($s("u"),$s("x"))))),
SetDelayed(NormalForm(Power($p("f"),$p("u")),$p("x",$s("Symbol"))),
    Condition(Power($s("f"),ExpandPolynomial($s("u"),$s("x"))),And(FreeQ($s("f"),$s("x")),QuadraticPolynomialQ($s("u"),$s("x"))))),
SetDelayed(NormalForm(Times(Times($p("u",true),Power($p("f"),$p("v"))),Power($p("g"),$p("w"))),$p("x",$s("Symbol"))),
    Condition(Times($s("u"),Power(E,Sum(Times(Plus(Times(Log($s("f")),Coefficient($s("v"),$s("x"),$s("k"))),Times(Log($s("g")),Coefficient($s("w"),$s("x"),$s("k")))),Power($s("x"),$s("k"))),List($s("k"),C0,C2)))),And(And(And(And(FreeQ(List($s("f"),$s("g")),$s("x")),PolynomialQ($s("v"),$s("x"))),LessEqual(LessEqual(C1,Exponent($s("v"),$s("x"))),C2)),PolynomialQ($s("w"),$s("x"))),LessEqual(LessEqual(C1,Exponent($s("w"),$s("x"))),C2)))),
SetDelayed(NormalForm(Times(Times($p("u",true),Power($p("f"),Plus($p("a",true),Times($p("b",true),Power($p("x"),$p("n",true)))))),Power($p("g"),Plus($p("c",true),Times($p("d",true),Power($p("x"),$p("n",true)))))),$p("x",$s("Symbol"))),
    Condition(Times($s("u"),Power(E,Plus(Plus(Times($s("a"),Log($s("f"))),Times($s("c"),Log($s("g")))),Times(Plus(Times($s("b"),Log($s("f"))),Times($s("d"),Log($s("g")))),Power($s("x"),$s("n")))))),FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("f"),$s("g"),$s("n")),$s("x")))),
SetDelayed(QuadraticPolynomialQ($p("u"),$p("x",$s("Symbol"))),
    And(And(PolynomialQ($s("u"),$s("x")),LessEqual(Exponent($s("u"),$s("x")),C2)),Not(MatchQ($s("u"),Condition(Times($p("a",true),Power($p("v"),C2)),FreeQ($s("a"),$s("x"))))))),
SetDelayed(ExpandPolynomial($p("u"),$p("x",$s("Symbol"))),
    Module(List($s("k")),Sum(Times(Coefficient($s("u"),$s("x"),$s("k")),Power($s("x"),$s("k"))),List($s("k"),C0,Exponent($s("u"),$s("x")))))),
SetDelayed(NormalForm(Power(Plus(Times($p("a",true),Power($p("x"),$p("m",true))),Times($p("b",true),Power($p("x"),$p("n",true)))),$p("p")),$p("x",$s("Symbol"))),
    Condition(Power(Times(Power($s("x"),$s("m")),Plus($s("a"),Times($s("b"),Power($s("x"),Plus($s("n"),Times(CN1,$s("m"))))))),$s("p")),And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),RationalQ(List($s("m"),$s("n"),$s("p")))),LessEqual($s("m"),$s("n"))),Not(Equal(Equal(Times(C2,$s("m")),$s("n")),C2))))),
SetDelayed(NormalForm(Plus(Plus($p("u",true),Times($p("a",true),$p("v"))),Times($p("b",true),$p("v"))),$p("x",$s("Symbol"))),
    Condition(Plus($s("u"),Times(Plus($s("a"),$s("b")),$s("v"))),And(FreeQ(List($s("a"),$s("b")),$s("x")),Not(FreeQ($s("v"),$s("x")))))),
SetDelayed(NormalForm(Power($p("u"),$p("n")),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("v"),Together($s("u")))),Condition(Power($s("v"),$s("n")),Not(SumQ($s("v"))))),And(And(SumQ($s("u")),FractionQ($s("n"))),Not(MonomialSumQ($s("u"),$s("x")))))),
SetDelayed(NormalForm(Times(Cos(Times(C2,$p("u"))),Power(Sec($p("u")),C2)),$p("x",$s("Symbol"))),
    Condition(Plus(C1,Times(CN1,Power(Tan($s("u")),C2))),Not(FreeQ($s("u"),$s("x"))))),
SetDelayed(NormalForm(Times($p("u",true),Times(Plus($p("c"),$p("d")),Power(Power(Plus($p("a"),$p("b")),C2),CN1))),$p("x",$s("Symbol"))),
    Condition(NormalForm(Times($s("u"),Times(Plus($s("a"),Times(CN1,$s("b"))),Power(Plus($s("a"),$s("b")),CN1))),$s("x")),And(ZeroQ(Plus($s("c"),Times(CN1,Power($s("a"),C2)))),ZeroQ(Plus($s("d"),Power($s("b"),C2)))))),
SetDelayed(NormalForm($p("u"),$p("x",$s("Symbol"))),
    If(AtomQ($s("u")),$s("u"),If(MatchQ($s("u"),Condition(Plus($p("a",true),Times($p("b",true),Power($s("x"),$p("n",true)))),FreeQ(List($s("a"),$s("b"),$s("n")),$s("x")))),$s("u"),If(MatchQ($s("u"),Condition(Plus(Plus($p("a",true),Times($p("b",true),Power($s("x"),$p("n",true)))),Times($p("c",true),Power($s("x"),$p("m",true)))),And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("m"),$s("n")),$s("x")),SameQ(Times(C2,$s("n")),$s("m"))))),$s("u"),Module(List($s("tmp")),CompoundExpression(Set($s("tmp"),MonomialFactor($s("u"),$s("x"))),If(NonzeroQ(Part($s("tmp"),C1)),Times(Power($s("x"),Part($s("tmp"),C1)),NormalForm(Part($s("tmp"),C2),$s("x"))),Map(Function(NormalForm(Slot1,$s("x"))),$s("u"))))))))),
SetDelayed(SimplifyExpression(Times(Power($p("x"),$p("m")),Power(Plus($p("a"),Times($p("b",true),Power($p("x"),$p("n")))),$p("p",true))),$p("x",$s("Symbol"))),
    Condition(Times(Power($s("x"),Plus($s("m"),Times($s("n"),$s("p")))),Power(Plus($s("b"),Times($s("a"),Power($s("x"),Times(CN1,$s("n"))))),$s("p"))),And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),IntegerQ(List($s("m"),$s("n"),$s("p")))),Less($s("n"),C0)),Or(Equal(Plus(Plus($s("m"),Times($s("n"),$s("p"))),C1),C0),And(And(Less($s("p"),CN1),Greater(Times(CN1,$s("n")),C1)),And(LessEqual(Times(CN1,$s("n")),Plus($s("m"),Times($s("n"),$s("p")))),Less(Plus($s("m"),Times($s("n"),$s("p"))),Plus(Times(integer(-2L),$s("n")),Times(CN1,C1))))))))),
SetDelayed(SimplifyExpression(Times(C1,Power(Plus(Plus(Times($p("a",true),$p("x")),Times($p("b",true),Power($p("x"),$p("m")))),Times($p("c",true),Power($p("x"),$p("n")))),CN1)),$p("x",$s("Symbol"))),
    Condition(Times(C1,Power(Times($s("x"),Plus(Plus($s("a"),Times($s("b"),Power($s("x"),Plus($s("m"),Times(CN1,C1))))),Times($s("c"),Power($s("x"),Plus($s("n"),Times(CN1,C1)))))),CN1)),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),IntegerQ(List($s("m"),$s("n")))),Greater($s("m"),C2)),Equal(Plus($s("n"),Times(CN1,C1)),Times(C2,Plus($s("m"),Times(CN1,C1))))))),
SetDelayed(SimplifyExpression(Times(Plus($p("a",true),Times($p("b",true),Power($p("x"),C2))),Power(Plus(Plus($p("c"),Times($p("d",true),Power($p("x"),C2))),Times($p("e",true),Sqrt(Plus($p("f"),Times($p("g",true),Power($p("x"),C2)))))),CN1)),$p("x",$s("Symbol"))),
    Condition(Plus(Times(Times(CN1,$s("c")),Power($s("f"),CN1)),Times($s("e"),Power(Sqrt(Plus($s("f"),Times($s("g"),Power($s("x"),C2)))),CN1))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e"),$s("f"),$s("g")),$s("x")),ZeroQ(Plus(Times($s("c"),$s("g")),Times(CN1,Times($s("f"),$s("d")))))),ZeroQ(Plus($s("b"),Times(Power($s("d"),C2),Power($s("g"),CN1))))),ZeroQ(Plus(Plus($s("a"),Times(CN1,Power($s("e"),C2))),Times(Power($s("c"),C2),Power($s("f"),CN1))))))),
SetDelayed(SimplifyExpression(Times(C1,Power(Times($p("x"),Plus(Plus(Times($p("a",true),Power($p("x"),CN1)),$p("b")),Times($p("c",true),$p("x")))),CN1)),$p("x",$s("Symbol"))),
    Condition(Times(C1,Power(Plus(Plus($s("a"),Times($s("b"),$s("x"))),Times($s("c"),Power($s("x"),C2))),CN1)),FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")))),
SetDelayed(SimplifyExpression(Times(C1,Power(Times(Power($p("x"),C2),Plus(Plus(Times($p("a",true),Power(Power($p("x"),C2),CN1)),Times($p("b",true),Power($p("x"),CN1))),$p("c"))),CN1)),$p("x",$s("Symbol"))),
    Condition(Times(C1,Power(Plus(Plus($s("a"),Times($s("b"),$s("x"))),Times($s("c"),Power($s("x"),C2))),CN1)),FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")))),
SetDelayed(SimplifyExpression(Times(Power($p("x"),$p("m",true)),Power(Plus(Plus(Times($p("a",true),Power($p("x"),$p("m",true))),Times($p("b",true),Power($p("x"),$p("p",true)))),Times($p("c",true),Power($p("x"),$p("q",true)))),CN1)),$p("x",$s("Symbol"))),
    Condition(Times(C1,Power(Plus(Plus($s("a"),Times($s("b"),$s("x"))),Times($s("c"),Power($s("x"),C2))),CN1)),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),IntegerQ(List($s("m"),$s("p"),$s("q")))),Equal($s("p"),Plus($s("m"),C1))),Equal($s("q"),Plus($s("m"),C2))))),
SetDelayed(SimplifyExpression($p("u"),$p("x",$s("Symbol"))),
    If(MatchQ($s("u"),Condition(Times(Times($p("w",true),Power(Plus($p("a",true),Times($p("b",true),$p("v"))),$p("m",true))),Power(Plus($p("c",true),Times($p("d",true),$p("v"))),$p("n",true))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d")),$s("x")),IntegerQ(List($s("m"),$s("n")))),Less($s("m"),C0)),Less($s("n"),C0)))),$s("u"),Module(List($s("v")),CompoundExpression(Set($s("v"),Regularize($s("u"),$s("x"))),If(SimplerExpressionQ($s("v"),$s("u"),$s("x")),$s("v"),CompoundExpression(Set($s("v"),Regularize(Cancel($s("u")),$s("x"))),If(SimplerExpressionQ($s("v"),$s("u"),$s("x")),$s("v"),$s("u")))))))),
SetDelayed(SimplerExpressionQ($p("u"),$p("v"),$p("x")),
    Or(LessEqual(SmartLeafCount($s("u")),Times(fraction(2L,3L),SmartLeafCount($s("v")))),And(And(And(And(And(And(PolynomialQ(Numerator($s("u")),$s("x")),PolynomialQ(Denominator($s("u")),$s("x"))),PolynomialQ(Numerator($s("v")),$s("x"))),PolynomialQ(Denominator($s("v")),$s("x"))),Less(Exponent(Numerator($s("u")),$s("x")),Exponent(Numerator($s("v")),$s("x")))),Less(Exponent(Denominator($s("u")),$s("x")),Exponent(Denominator($s("v")),$s("x")))),LessEqual(SmartLeafCount($s("u")),Plus(SmartLeafCount($s("v")),C5))))),
SetDelayed(SmartLeafCount($p("u")),
    If(AtomQ($s("u")),C1,Plus(Apply($s("Plus"),Map($s("Integrate::SmartLeafCount"),Apply($s("List"),$s("u")))),C1))),
SetDelayed(TrigSimplify($p("u")),
    If(AtomQ($s("u")),$s("u"),If(SameQ(Head($s("u")),$s("If")),$s("u"),TrigSimplifyAux(Map($s("Integrate::TrigSimplify"),$s("u")))))),
SetDelayed(TrigSimplifyAux(Times($p("u",true),Power(Plus(Times($p("a",true),Power($p("v"),$p("m",true))),Times($p("b",true),Power($p("v"),$p("n",true)))),$p("p")))),
    Condition(Times(Times($s("u"),Power($s("v"),Times($s("m"),$s("p")))),Power(TrigSimplifyAux(Plus($s("a"),Times($s("b"),Power($s("v"),Plus($s("n"),Times(CN1,$s("m"))))))),$s("p"))),And(And(And(Or(TrigQ($s("v")),HyperbolicQ($s("v"))),IntegerQ($s("p"))),RationalQ(List($s("m"),$s("n")))),Less($s("m"),$s("n"))))),
SetDelayed(TrigSimplifyAux(Plus(Plus(Times($p("u",true),Power(Cos($p("z")),C2)),Times($p("v",true),Power(Sin($p("z")),C2))),$p("w",true))),
    Condition(Plus($s("u"),$s("w")),SameQ($s("u"),$s("v")))),
SetDelayed(TrigSimplifyAux(Plus(Plus(Times($p("u",true),Power(Sec($p("z")),C2)),Times($p("v",true),Power(Tan($p("z")),C2))),$p("w",true))),
    Condition(Plus($s("u"),$s("w")),SameQ($s("u"),Times(CN1,$s("v"))))),
SetDelayed(TrigSimplifyAux(Plus(Plus(Times($p("u",true),Power(Csc($p("z")),C2)),Times($p("v",true),Power(Cot($p("z")),C2))),$p("w",true))),
    Condition(Plus($s("u"),$s("w")),SameQ($s("u"),Times(CN1,$s("v"))))),
SetDelayed(TrigSimplifyAux(Plus(Plus($p("u"),Times($p("v",true),Power(Sin($p("z")),C2))),$p("w",true))),
    Condition(Plus(Times($s("u"),Power(Cos($s("z")),C2)),$s("w")),SameQ($s("u"),Times(CN1,$s("v"))))),
SetDelayed(TrigSimplifyAux(Plus(Plus($p("u"),Times($p("v",true),Power(Cos($p("z")),C2))),$p("w",true))),
    Condition(Plus(Times($s("u"),Power(Sin($s("z")),C2)),$s("w")),SameQ($s("u"),Times(CN1,$s("v"))))),
SetDelayed(TrigSimplifyAux(Plus(Plus($p("u"),Times($p("v",true),Power(Tan($p("z")),C2))),$p("w",true))),
    Condition(Plus(Times($s("u"),Power(Sec($s("z")),C2)),$s("w")),SameQ($s("u"),$s("v")))),
SetDelayed(TrigSimplifyAux(Plus(Plus($p("u"),Times($p("v",true),Power(Cot($p("z")),C2))),$p("w",true))),
    Condition(Plus(Times($s("u"),Power(Csc($s("z")),C2)),$s("w")),SameQ($s("u"),$s("v")))),
SetDelayed(TrigSimplifyAux(Plus(Plus($p("u"),Times($p("v",true),Power(Sec($p("z")),C2))),$p("w",true))),
    Condition(Plus(Times($s("v"),Power(Tan($s("z")),C2)),$s("w")),SameQ($s("u"),Times(CN1,$s("v"))))),
SetDelayed(TrigSimplifyAux(Plus(Plus($p("u"),Times($p("v",true),Power(Csc($p("z")),C2))),$p("w",true))),
    Condition(Plus(Times($s("v"),Power(Cot($s("z")),C2)),$s("w")),SameQ($s("u"),Times(CN1,$s("v"))))),
SetDelayed(TrigSimplifyAux(Times($p("u",true),Times(Power(Sin($p("v")),C2),Power(Plus($p("a"),Times($p("b",true),Cos($p("v")))),CN1)))),
    Condition(Times($s("u"),Plus(Times(C1,Power($s("a"),CN1)),Times(CN1,Times(Cos($s("v")),Power($s("b"),CN1))))),ZeroQ(Plus(Power($s("a"),C2),Times(CN1,Power($s("b"),C2)))))),
SetDelayed(TrigSimplifyAux(Times($p("u",true),Times(Power(Cos($p("v")),C2),Power(Plus($p("a"),Times($p("b",true),Sin($p("v")))),CN1)))),
    Condition(Times($s("u"),Plus(Times(C1,Power($s("a"),CN1)),Times(CN1,Times(Sin($s("v")),Power($s("b"),CN1))))),ZeroQ(Plus(Power($s("a"),C2),Times(CN1,Power($s("b"),C2)))))),
SetDelayed(TrigSimplifyAux(Times($p("u",true),Times(Power(Tan($p("v")),$p("n",true)),Power(Plus($p("a"),Times($p("b",true),Power(Tan($p("v")),$p("n",true)))),CN1)))),
    Condition(Times($s("u"),Power(Plus($s("b"),Times($s("a"),Power(Cot($s("v")),$s("n")))),CN1)),And(And(IntegerQ($s("n")),Greater($s("n"),C0)),NonsumQ($s("a"))))),
SetDelayed(TrigSimplifyAux(Times($p("u",true),Times(Power(Cot($p("v")),$p("n",true)),Power(Plus($p("a"),Times($p("b",true),Power(Cot($p("v")),$p("n",true)))),CN1)))),
    Condition(Times($s("u"),Power(Plus($s("b"),Times($s("a"),Power(Tan($s("v")),$s("n")))),CN1)),And(And(IntegerQ($s("n")),Greater($s("n"),C0)),NonsumQ($s("a"))))),
SetDelayed(TrigSimplifyAux(Times($p("u",true),Times(Power(Sec($p("v")),$p("n",true)),Power(Plus($p("a"),Times($p("b",true),Power(Sec($p("v")),$p("n",true)))),CN1)))),
    Condition(Times($s("u"),Power(Plus($s("b"),Times($s("a"),Power(Cos($s("v")),$s("n")))),CN1)),And(And(IntegerQ($s("n")),Greater($s("n"),C0)),NonsumQ($s("a"))))),
SetDelayed(TrigSimplifyAux(Times($p("u",true),Times(Power(Csc($p("v")),$p("n",true)),Power(Plus($p("a"),Times($p("b",true),Power(Csc($p("v")),$p("n",true)))),CN1)))),
    Condition(Times($s("u"),Power(Plus($s("b"),Times($s("a"),Power(Sin($s("v")),$s("n")))),CN1)),And(And(IntegerQ($s("n")),Greater($s("n"),C0)),NonsumQ($s("a"))))),
SetDelayed(TrigSimplifyAux(Power(Plus(Times($p("a",true),Csc($p("v"))),Times($p("b",true),Cot($p("v")))),$p("n"))),
    Condition(Times(Power($s("a"),$s("n")),Power(Cot(Times($s("v"),C1D2)),$s("n"))),And(EvenQ($s("n")),ZeroQ(Plus($s("a"),Times(CN1,$s("b"))))))),
SetDelayed(TrigSimplifyAux(Power(Plus(Times($p("a",true),Csc($p("v"))),Times($p("b",true),Cot($p("v")))),$p("n"))),
    Condition(Times(Power($s("a"),$s("n")),Power(Tan(Times($s("v"),C1D2)),$s("n"))),And(EvenQ($s("n")),ZeroQ(Plus($s("a"),$s("b")))))),
SetDelayed(TrigSimplifyAux(Times(Times($p("u",true),Power(Sin($p("v")),$p("m",true))),Power(Plus($p("a",true),Times($p("b",true),Power(Cot($p("v")),$p("n",true)))),$p("p",true)))),
    Condition(Times(Times($s("u"),Power(Sin($s("v")),Plus($s("m"),Times(CN1,Times($s("n"),$s("p")))))),Power(Plus(Times($s("b"),Power(Cos($s("v")),$s("n"))),Times($s("a"),Power(Sin($s("v")),$s("n")))),$s("p"))),IntegerQ(List($s("m"),$s("n"),$s("p"))))),
SetDelayed(TrigSimplifyAux(Times(Times($p("u",true),Power(Cos($p("v")),$p("m",true))),Power(Plus($p("a",true),Times($p("b",true),Power(Tan($p("v")),$p("n",true)))),$p("p",true)))),
    Condition(Times(Times($s("u"),Power(Cos($s("v")),Plus($s("m"),Times(CN1,Times($s("n"),$s("p")))))),Power(Plus(Times($s("b"),Power(Sin($s("v")),$s("n"))),Times($s("a"),Power(Cos($s("v")),$s("n")))),$s("p"))),IntegerQ(List($s("m"),$s("n"),$s("p"))))),
SetDelayed(TrigSimplifyAux(Times(Times($p("u"),Power(Sec($p("v")),$p("m",true))),Power(Plus($p("a",true),Times($p("b",true),Power(Tan($p("v")),C2))),$p("p",true)))),
    Condition(Times($s("u"),Power(Plus(Times($s("b"),Power(Sin($s("v")),C2)),Times($s("a"),Power(Cos($s("v")),C2))),$s("p"))),And(IntegerQ(List($s("m"),$s("p"))),Equal(Plus($s("m"),Times(C2,$s("p"))),C0)))),
SetDelayed(TrigSimplifyAux(Times(Times($p("u"),Power(Csc($p("v")),$p("m",true))),Power(Plus($p("a",true),Times($p("b",true),Power(Cot($p("v")),C2))),$p("p",true)))),
    Condition(Times($s("u"),Power(Plus(Times($s("b"),Power(Cos($s("v")),C2)),Times($s("a"),Power(Sin($s("v")),C2))),$s("p"))),And(IntegerQ(List($s("m"),$s("p"))),Equal(Plus($s("m"),Times(C2,$s("p"))),C0)))),
SetDelayed(TrigSimplifyAux(Times(Times($p("u",true),Power(Cos($p("v")),$p("m",true))),Power(Plus(Plus($p("a",true),Times($p("b",true),Power(Tan($p("v")),$p("n",true)))),Times($p("c",true),Power(Sec($p("v")),$p("n",true)))),$p("p",true)))),
    Condition(Times(Times($s("u"),Power(Cos($s("v")),Plus($s("m"),Times(CN1,Times($s("n"),$s("p")))))),Power(Plus(Plus($s("c"),Times($s("b"),Power(Sin($s("v")),$s("n")))),Times($s("a"),Power(Cos($s("v")),$s("n")))),$s("p"))),IntegerQ(List($s("m"),$s("n"),$s("p"))))),
SetDelayed(TrigSimplifyAux(Times(Times($p("u",true),Power(Sec($p("v")),$p("m",true))),Power(Plus(Plus($p("a",true),Times($p("b",true),Power(Tan($p("v")),$p("n",true)))),Times($p("c",true),Power(Sec($p("v")),$p("n",true)))),$p("p",true)))),
    Condition(Times(Times($s("u"),Power(Sec($s("v")),Plus($s("m"),Times($s("n"),$s("p"))))),Power(Plus(Plus($s("c"),Times($s("b"),Power(Sin($s("v")),$s("n")))),Times($s("a"),Power(Cos($s("v")),$s("n")))),$s("p"))),IntegerQ(List($s("m"),$s("n"),$s("p")))))
  );
}