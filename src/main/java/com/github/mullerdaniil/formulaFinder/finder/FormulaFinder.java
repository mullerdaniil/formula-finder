package com.github.mullerdaniil.formulaFinder.finder;

import com.github.mullerdaniil.formulaFinder.exceptions.FormulaFinderException;
import com.github.mullerdaniil.formulaFinder.syntaxTree.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FormulaFinder {
    /**
     * allowed node types in the formula syntax tree
     */
    private final static int VARIABLE = 0;
    public final static int ADDITION = 1;
    public final static int SUBTRACTION = 2;
    public final static int MULTIPLICATION = 3;
    public final static int DIVISION = 4;
    public final static int SQUARE_ROOT = 5;
    public final static int SQUARE = 6;
    public final static int POWER = 7;
    public final static int SIN = 8;
    public final static int COS = 9;
    public final static int TAN = 10;
    public final static int UNARY_MINUS = 11;
    public final static int ABS = 12;
    public final static int LN = 13;
    public final static int LOG = 14;

    private final static int SYNTAX_TREE_MAX_HEIGHT = 20;

    private List<String> variables;
    private List<Integer> allowedNodeTypes;

    public FormulaFinder(List<String> variables, List<Integer> allowedNodeTypes) {
        setVariables(variables);
        setAllowedNodeTypes(allowedNodeTypes);
    }

    public void setVariables(List<String> variables) {
        this.variables = List.copyOf(variables);
    }

    public void setAllowedNodeTypes(List<Integer> allowedNodeTypes) {
        this.allowedNodeTypes = new ArrayList<>();
        this.allowedNodeTypes.addAll(allowedNodeTypes);
        this.allowedNodeTypes.add(VARIABLE);
    }

    /**
     * Looks over random-generated formulas and chooses the formula that satisfies the solutions if it was generated
     * @param solutions - list of known solutions to the formula
     * @param accuracy - accuracy to find the correct formula
     * @param syntaxTreeHeight - the allowed height of the formula syntax tree
     * @param experiments - number of random experiments to do
     * @return list of formulas or null if nothing was found
     */
    public List<FormulaSyntaxTreeNode> findFormulasRandomly(List<FormulaSolution> solutions,
                                                   double accuracy,
                                                   int syntaxTreeHeight,
                                                   int experiments) {

        if (!(syntaxTreeHeight >= 1 && syntaxTreeHeight <= SYNTAX_TREE_MAX_HEIGHT)) {
            throw new FormulaFinderException("Syntax tree height must be between 1 and " + SYNTAX_TREE_MAX_HEIGHT + ".");
        }

        List<FormulaSyntaxTreeNode> result = new ArrayList<>();


        FormulaSyntaxTreeNode randomFormula;
        for (int i = 0; i < experiments; i++) {
            randomFormula = generateRandomFormula(syntaxTreeHeight);
            if (checkFormula(randomFormula, solutions, accuracy)) {
                result.add(randomFormula);
            }
        }

        return result.size() == 0 ? null : result;
    }

    /**
     * Looks over random-generated formulas and chooses the formula that satisfies the solutions if it was generated
     * @param solutions - list of known solutions to the formula
     * @param accuracy - accuracy to find the correct formula
     * @param syntaxTreeHeight - the allowed height of the formula syntax tree
     * @param experiments - number of random experiments to do
     * @return any formula or null if nothing was found
     */
    public FormulaSyntaxTreeNode findAnyFormulaRandomly(List<FormulaSolution> solutions,
                                                        double accuracy,
                                                        int syntaxTreeHeight,
                                                        int experiments) {
        if (!(syntaxTreeHeight >= 1 && syntaxTreeHeight <= SYNTAX_TREE_MAX_HEIGHT)) {
            throw new FormulaFinderException("Syntax tree height must be between 1 and " + SYNTAX_TREE_MAX_HEIGHT + ".");
        }

        FormulaSyntaxTreeNode randomFormula;
        for (int i = 0; i < experiments; i++) {
            randomFormula = generateRandomFormula(syntaxTreeHeight);
            if (checkFormula(randomFormula, solutions, accuracy)) {
                return randomFormula;
            }
        }

        return null;
    }

    private FormulaSyntaxTreeNode generateRandomFormula(int syntaxTreeHeight) {
        int maximumNumberOfLeaves = 1 << (syntaxTreeHeight - 1);
        FormulaSyntaxTreeNode[] nodes = new FormulaSyntaxTreeNode[maximumNumberOfLeaves];

        for (int i = 0; i < maximumNumberOfLeaves; i++) {
            nodes[i] = chooseRandomVariable();
        }

        int numberOfNodes = maximumNumberOfLeaves / 2;
        while (numberOfNodes >= 1) {

            for (int i = 0; i < numberOfNodes; i++) {
                int randomNodeType = allowedNodeTypes.get(randomInteger(allowedNodeTypes.size() - 1));
                FormulaSyntaxTreeNode argument1 = nodes[2 * i];
                FormulaSyntaxTreeNode argument2 = nodes[2 * i + 1];
                switch (randomNodeType) {
                    case VARIABLE:
                        String randomVariableName = variables.get(randomInteger(variables.size() - 1));
                        nodes[i] = new Variable(randomVariableName);
                        break;
                    case ADDITION:
                        nodes[i] = new Addition(argument1, argument2);
                        break;
                    case SUBTRACTION:
                        nodes[i] = new Subtraction(argument1, argument2);
                        break;
                    case MULTIPLICATION:
                        nodes[i] = new Multiplication(argument1, argument2);
                        break;
                    case DIVISION:
                        nodes[i] = new Division(argument1, argument2);
                        break;
                    case SQUARE_ROOT:
                        nodes[i] = new SquareRoot(argument1);
                        break;
                    case SQUARE:
                        nodes[i] = new Square(argument1);
                        break;
                    case POWER:
                        nodes[i] = new Power(argument1, argument2);
                        break;
                    case SIN:
                        nodes[i] = new Sin(argument1);
                        break;
                    case COS:
                        nodes[i] = new Cos(argument1);
                        break;
                    case TAN:
                        nodes[i] = new Tan(argument1);
                        break;
                    case UNARY_MINUS:
                        nodes[i] = new UnaryMinus(argument1);
                        break;
                    case ABS:
                        nodes[i] = new Abs(argument1);
                        break;
                    case LN:
                        nodes[i] = new Ln(argument1);
                        break;
                    case LOG:
                        nodes[i] = new Log(argument1);
                        break;
                    default:
                        break;
                }
            }

            numberOfNodes /= 2;
        }

        return nodes[0];
    }

    private Variable chooseRandomVariable() {
        return new Variable(variables.get(randomInteger(variables.size() - 1)));
    }

    private static int randomInteger(int max) {
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }

    private boolean checkFormula(FormulaSyntaxTreeNode formula, List<FormulaSolution> solutions, double accuracy) {
        for (FormulaSolution solution : solutions) {
            double difference = Math.abs(formula.evaluate(solution) - solution.getFormulaValue());
            if (Double.isNaN(difference) || difference > accuracy) {
                return false;
            }
        }
        return true;
    }




}
