package org.matheclipse.core.expression;

import org.matheclipse.core.interfaces.IExpr;

public class ASTDelegate {

	protected AST fAst;


	protected ASTDelegate() {
		this(null);
	}

	public ASTDelegate(AST ast) {
		super();
		fAst=ast;
	}

	/**
	 * Create a new AST List instance
	 * 
	 * @param size
	 *          the initial number of elements
	 * @return a new AST List instance
	 */
	protected AST createAST(int size) {
		return (AST) F.ast(F.List, size, false);
	}

	protected AST createAST(int[] values) {
		AST ast = (AST) F.ast(F.List, values.length, true);
		for (int i = 0; i < values.length; i++) {
			ast.set(i + 1, F.integer(values[i]));
		}
		return ast;
	}
	
	/**
	 * Get the number of rows (i.e. size()-1)
	 * 
	 * @return
	 */
	public int getRows() {
		return fAst.size()-1;
	}

	public IExpr getAt(final int index) {
		return fAst.get(index);
	}

	public int size() {
		return fAst.size();
	}

	public int hashCode() {
		return fAst.hashCode();
	}

	public String toFullForm() {
		return fAst.toFullForm();
	}

	public String toString() {
		return fAst.toString();
	}

//	public Text toText() {
//		return fAst.toText();
//	}

	public AST getAST() {
		return fAst;
	}
}