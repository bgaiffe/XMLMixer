package xmlNodes;

import xmlNodes.GenericNode;



public class ProcessingInstructionNode implements GenericNode {
	String content;
	String target;
	String data;

	public ProcessingInstructionNode(String c) {
		this.content = c;
		String[] sp = c.split(" "); //$NON-NLS-1$
		this.target = sp[0];
		this.data = c.substring(this.target.length());
	}

	@Override
	public int getType() {
		return GenericNode.PI_NODE;
	}

	@Override
	public String toString() {
		return "<?" + this.content + " ?>"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public String getStringValue() {
		return this.content;
	}

	@Override
	public boolean equals(GenericNode other) {
		return (other.getType() == GenericNode.PI_NODE)
				&& (this.content
						.compareTo(((ProcessingInstructionNode) other).content) == 0);
	}

	public String getTarget() {
		return this.target;
	}

	public String getData() {
		return this.data;
	}
}



