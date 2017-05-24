package xmlNodes;

import xmlNodes.GenericNode;

public class IntNode implements GenericNode {
	int value;

	public IntNode(String s) {
		this.value = Integer.parseInt(s);
	}

	@Override
	public int getType() {
		return GenericNode.INT_NODE;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String getStringValue() {
		return "" + this.value; //$NON-NLS-1$
	}

	@Override
	public boolean equals(GenericNode other) {
		return other.getType() == GenericNode.INT_NODE
				&& this.value == ((IntNode) other).value;
	}
}