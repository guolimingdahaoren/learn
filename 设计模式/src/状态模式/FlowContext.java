package 状态模式;

/**
 * @Description: 状态流转 流程
 * @Date: 2021-04-28 15:41
 * @param:
 * @return:
 **/
public class FlowContext {
    private Node node;
    //流程是否走完
    private boolean isFlag;
    //状态 0:通过  1:驳回 2:退回整改 3:已申请
    private Integer state;

    private String message;

    //流程开始
    public static  boolean start(FlowContext flowContext){
        //流程开始
        Node node = new LeaderNode();
        flowContext.setNode(node);
        flowContext.setState(3);
        flowContext.getNode().nodeHandle(flowContext);
        if("HR".equals(flowContext.getNode().getNodeName()) && 0 == flowContext.getState() && flowContext.isFlag()){
            System.out.println("审批通过,流程结束");
            return true;
        }
            System.out.println("审批不通过,流程结束");
            return false;
    }

    public Node getNode() {
        return node;
    }

    public FlowContext setNode(Node node) {
        this.node = node;
        return this;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public FlowContext setFlag(boolean flag) {
        isFlag = flag;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public FlowContext setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public FlowContext setState(Integer state) {
        this.state = state;
        return this;
    }

    public static void main(String[] args) {
        FlowContext flowContext = new FlowContext();
        flowContext.setMessage("本人王小二，因为十一家里有事情，所以要多请三天假，希望公司能够审核通过");
        start(flowContext);
    }
}
