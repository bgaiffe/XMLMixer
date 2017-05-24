package inputsReading;

import java.util.ArrayList;
import java.util.Iterator;

import xmlNodes.GenericNode;

// une ligne du fichier compagnon

public class LigneComp implements Comparable<LigneComp> {
	private int idTexte;
	private ArrayList<GenericNode> theNodes;

	LigneComp(int i, ArrayList<GenericNode> l) {
		this.idTexte = i;
		this.theNodes = l;
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();

		res.append("" + this.idTexte); //$NON-NLS-1$
		Iterator<GenericNode> i = this.theNodes.iterator();
		while (i.hasNext()) {
			res.append(" "); //$NON-NLS-1$
			res.append(i.next().toString());
		}

		return res.toString();
	}

	public int getIdTexte() {
		return this.idTexte;
	}

	public ArrayList<GenericNode> getTheNodes() {
		return this.theNodes;
	}

	@Override
	public int compareTo(LigneComp o) {

		if (this.idTexte == o.getIdTexte()) {
			return 0;
		}
		if (this.idTexte < o.getIdTexte()) {
			return -1;
		}
		return 1;
	}
}
