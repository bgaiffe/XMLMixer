package grammar;

import java.util.ArrayList;
import java.util.Iterator;

import inputDag.InputDagState;

public class XmlGrammarProductionRule extends ProductionRule{

	public XmlGrammarProductionRule(NonTerminal l, ArrayList<GramSymb> r) {
		super(l, r);
		// TODO Auto-generated constructor stub
	}

	// What is this for ????
	public ProductionRule replaceNTat(InputDagState i, InputDagState j, int place) {
		Iterator<GramSymb> rightIt = this.right.iterator();
		@SuppressWarnings("unused")
		ArrayList<GramSymb> newRight = new ArrayList<GramSymb>();
		NonTerminal oldNT, newNT;

		for (int a = 0; a < place; a++) {
			newRight.add(rightIt.next());
		}
		oldNT = (NonTerminal) rightIt.next();
		if (oldNT.isTerminal()) {
			System.out.println("Pb : ProductionRule.replaceAt(" + this
					+ " index = " + place);
		}
		StringBuffer sb = new StringBuffer();
		sb.append(oldNT.getName())
				.append("_").append(i.getId()).append("_").append(j.getId()); //$NON-NLS-1$ //$NON-NLS-2$
		// newNT = new NonTerminal(oldNT.getName()+"_"+i.getId()+"_"+j.getId());
		newNT = new NonTerminal(sb.toString());
		newRight.add(newNT);
		while (rightIt.hasNext()) {
			newRight.add(rightIt.next());
		}
		return new ProductionRule(this.left, newRight);
	}

	
}
