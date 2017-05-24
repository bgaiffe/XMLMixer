package xmlNodes;


import xmlNodes.GenericNode;

public class CommentNode implements GenericNode {
	String content;

	public CommentNode(String c) {
		this.content = c;
	}

	@Override
	public int getType() {
		return GenericNode.COMMENT_NODE;
	}

	@Override
	public String toString() {
		return "<!--" + this.content + "-->"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public String getStringValue() {
		return this.content;
	}

	@Override
	public boolean equals(GenericNode other) {
		return other.getType() == GenericNode.COMMENT_NODE
				&& this.content.compareTo(((CommentNode) other).content) == 0;
	}
}

