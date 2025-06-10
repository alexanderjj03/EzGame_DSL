package game;

public class InstructionNode {
    private InstructionType type;
    private int param;
    private int param_x;
    private int param_y;
    private Direction direction;

    public InstructionNode(InstructionType type, int param) {
        this.type = type;
        this.param = param;
    }

    public InstructionNode(InstructionType type, int param_x, int param_y) {
        this.type = type;
        this.param_x = param_x;
        this.param_y = param_y;
    }

    public InstructionNode(InstructionType type, Direction direction) {
        this.type = type;
        this.direction = direction;
    }

    public InstructionType getType() {
        return type;
    }

    public int getParam() {
        return param;
    }

    public int getParam_x() { return param_x; }

    public int getParam_y() { return param_y; }

    public Direction getDirection() {
        return direction;
    }
}
