package 状态模式;

public abstract class Node {
    private String nodeName;

    public abstract void nodeHandle(FlowContext flowContext);

    public String getNodeName() {
        return nodeName;
    }

    public Node setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }
}
