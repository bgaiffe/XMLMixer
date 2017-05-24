package xmlNodes;

import java.util.ArrayList;

import xmlNodes.Attribute;
import xmlNodes.GenericNode;
import xmlNodes.OpenElementNode;

public class CloseElementNode implements GenericNode {
	String localName;
	String id;
	String qName;

	public CloseElementNode(String ln, String i) {
		this.localName = ln;
		this.id = i;
	}

	public CloseElementNode(String ln) {
		super();
		// localName = ln.substring(2);
		this.localName = ln;
		this.id = ""; //$NON-NLS-1$
	}

	@Override
	public String toString() {
		// return "</"+localName+"_"+id+">";
		return "</" + this.localName + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public String getLocalName() {
		return this.localName;
	}

	@Override
	public int getType() {
		return GenericNode.CLOSE_ELEM;
	}

	public void setId(String i) {
		this.id = i;
	}

	@Override
	public String getStringValue() {
		return this.localName;
	}

	public CloseElementNode replaceName(String newName) {
		return new CloseElementNode(newName, this.id);
	}

	@Override
	public boolean equals(GenericNode other) {
		// System.out.println("CloseElementNode.equals entre "+this+" et "+other);
		boolean res = other.getType() == GenericNode.CLOSE_ELEM;
		CloseElementNode otCE = (CloseElementNode) other;
		// System.out.println("id = "+id+" other.id = "+otCE.id);

		return res && this.localName.compareTo(otCE.localName) == 0
				&& this.id.compareTo(otCE.id) == 0;
	}

	// Pb we need the associated namespace from the opening bracket
	public OpenElementNode openFromClosing(int nbCorr, String namespace) {
		@SuppressWarnings("unused")
		ArrayList<Attribute> lAtt = new ArrayList<Attribute>();
		Attribute a = new Attribute("xml:id", "", "Repair_new" + nbCorr); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		lAtt.add(a);
		return new OpenElementNode(this.localName, namespace, this.id, lAtt,
				false);
	}
}




