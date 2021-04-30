package 状态模式;

public class LeaderNode extends Node {

    @Override
    public void nodeHandle(FlowContext flowContext) {
        //判断流程是否结束
        if(!flowContext.isFlag()){
            System.out.println(flowContext.getMessage());
            if(3== flowContext.getState()){//只有处于已经申请的状态才能领导审核
                System.out.println(flowContext.getMessage() + "," + getNodeName() +"审核通过;");
                //状态流转
                flowContext.setState(0);
                flowContext.setNode(new HrNode());
                flowContext.getNode().nodeHandle(flowContext);
            }
        }else{
            System.out.println("流程结束");
        }
    }

    LeaderNode() {
        this.setNodeName("leader");
    }
}
