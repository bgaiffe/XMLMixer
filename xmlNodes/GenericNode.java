package xmlNodes;



public interface GenericNode {
	   public static int TEXT_NODE = 1;
	    public static int OPEN_ELEMENT = 2;
	    public static int INT_NODE = 3;
	    public static int COMMENT_NODE = 4;
	    public static int PI_NODE = 5;
	    public static int CLOSE_ELEM = 6;
	    public static int AUTO_CLOSE = 7;
	    public static int CDATA = 8;

	    public int getType();
	    public String getStringValue();
	    public boolean equals(GenericNode other);
}
