package inputDag;



import inputDag.InputDagState;
import xmlNodes.GenericNode;
import xmlNodes.GenericNode;

	// A DagTransition goes through a GenericNode (OpnElementNode or CloseElementNode or TextNode or ... towards an image state.

	public class InputDagTransition {
		GenericNode n;
		InputDagState image;

		InputDagTransition(GenericNode node, InputDagState img) {
			this.n = node;
			this.image = img;
		}

		public InputDagState getSucc() {
			return this.image;
		}

		public GenericNode getNode() {
			return this.n;
		}

		@Override
		public String toString() {
			StringBuffer res = new StringBuffer();

			res.append(this.n.toString() + "->" + this.image.getId()); //$NON-NLS-1$
			return res.toString();
		}
	}


