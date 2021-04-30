package 状态模式;

public class HrNode extends Node {
    @Override
    public void nodeHandle(FlowContext flowContext) {
        if (!flowContext.isFlag()) {
            //只有上一级审核通过才能进入hr
            if (flowContext.getState() == 0) {
                System.out.println(flowContext.getMessage() + "," + getNodeName() + "审核通过;");
                // 审核通过
                flowContext.setState(0); //HR审核通过并指向下一个节点 ,如果没有下一个节点就把状态设置为终结
                flowContext.setFlag(true);
            }
        } else {
            System.out.println("流程结束");
        }
    }

    HrNode() {
        this.setNodeName("HR");
    }
}
