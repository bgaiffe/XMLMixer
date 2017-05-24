package xmlNodes;

import xmlNodes.GenericNode;



public class TextNode implements GenericNode {
	String content;

	public TextNode(String cont) {
		this.content = cont;
	}

	public String getContent() {
		return this.content;
	}

	@Override
	public int getType() {
		return GenericNode.TEXT_NODE;
	}

	@Override
	public String toString() {
		return this.content;
	}

	@Override
	public String getStringValue() {
		return this.content;
	}

	@Override
	public boolean equals(GenericNode other) {
		return (other.getType() == GenericNode.TEXT_NODE)
				&& this.content.compareTo(((TextNode) other).content) == 0;
	}
}


