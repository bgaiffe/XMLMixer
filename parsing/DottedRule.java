package parsing;


import inputDag.InputDagState;

import java.util.ArrayList;
import java.util.Iterator;

import grammar.GramSymb;
import grammar.NonTerminal;
import grammar.ProductionRule;
import xmlNodes.GenericNode;
import xmlNodes.OpenElementNode;

public class DottedRule {
	ProductionRule theRule;
	int theDot;

	DottedRule(ProductionRule r, int dot) {
		this.theRule = r;
		this.theDot = dot;
	}

	public boolean dotAtEnd() {
		return this.theDot == this.theRule.length();
	}

	public GramSymb getNext() {
		if (this.theDot < this.theRule.length()) {
			return this.theRule.getAt(this.theDot);
		}
		// nothing after the dot.
		return null;
	}

	public int getDot() {
		return this.theDot;
	}

	public GramSymb getSymbolAtDot() {
		return this.theRule.getAt(this.theDot);
	}

	public ProductionRule getRule() {
		return this.theRule;
	}

	public DottedRule dotProgress() {
		return new DottedRule(this.theRule, this.theDot + 1);
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();

		res.append(this.theRule.getLeft().toString() + " -> "); //$NON-NLS-1$
		Iterator<GramSymb> rit = this.theRule.getRight().iterator();
		for (int i = 0; i < this.theDot; i++) {
			res.append(rit.next().toString() + " "); //$NON-NLS-1$
		}
		res.append("*"); //$NON-NLS-1$
		while (rit.hasNext()) {
			res.append(rit.next().toString());
			if (rit.hasNext()) {
				res.append(" "); //$NON-NLS-1$
			}
		}
		return res.toString();
	}

	public ProductionRule instanciate(GenericNode n) {
		// we have to replace the element at dot by n.
		ProductionRule res1 = this.theRule.modifyAt(this.theDot, n);
		ProductionRule res2;
		if (n.getType() == GenericNode.OPEN_ELEMENT) {
			// we also have to modify the closingElement
			res2 = res1.modifyCloseElement(
					((OpenElementNode) n).getLocalName(),
					((OpenElementNode) n).getId());
			return res2;
		}
		return res1;
	}

	public boolean equals(DottedRule other) {
		return this.theDot == other.getDot()
				&& this.theRule.equals(other.getRule());
	}

	public String putNextOnOpeningBracket(int id) {
		return this.theRule.putNextOnOpeningBracket(id);
	}
	
	
}


