package xmlNodes;


import xmlNodes.GenericNode;

public class CDataNode implements GenericNode {
	String content;

	CDataNode(String c) {
		this.content = c;
	}

	@Override
	public int getType() {
		return GenericNode.CDATA;
	}

	@Override
	public boolean equals(GenericNode other) {
		return (other.getType() == GenericNode.CDATA)
				&& (this.content.compareTo(((CDataNode) other).content) == 0);
	}

	@Override
	public String getStringValue() {
		return this.content;
	}

	@Override
	public String toString() {
		return "<![CDATA[" + this.content + "]]"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
