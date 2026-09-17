import java.io.*;
import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public ArrayList<Tree> getChildren() {
        return children;
    }
}

class TreeLeaf extends Tree {
    TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {

    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {

    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        // Nothing to do for non-leaf nodes
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long product = 1;
    private static final long MOD = 1000000007;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {

    private int evenDepthNonLeafSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNonLeafSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeafSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {

    static Tree solve() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        Color[] colors = new Color[n + 1];

        for (int i = 1; i <= n; i++) {
            int color = sc.nextInt();

            if (color == 0) {
                colors[i] = Color.RED;
            } else {
                colors[i] = Color.GREEN;
            }
        }

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        return buildTree(1, 0, 0, values, colors, graph);
    }

    static Tree buildTree(
        int node,
        int parent,
        int depth,
        int[] values,
        Color[] colors,
        ArrayList<Integer>[] graph
    ) {

        boolean isLeaf = true;

        for (int child : graph[node]) {
            if (child != parent) {
                isLeaf = false;
                break;
            }
        }

        if (isLeaf) {
            return new TreeLeaf(
                values[node],
                colors[node],
                depth
            );
        }

        TreeNode treeNode = new TreeNode(
            values[node],
            colors[node],
            depth
        );

        for (int child : graph[node]) {
            if (child != parent) {
                Tree childTree = buildTree(
                    child,
                    node,
                    depth + 1,
                    values,
                    colors,
                    graph
                );

                treeNode.addChild(childTree);
            }
        }

        return treeNode;
    }

    public static void main(String[] args) {

        Tree root = solve();

        TreeVis vis1 = new SumInLeavesVisitor();
        TreeVis vis2 = new ProductOfRedNodesVisitor();
        TreeVis vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());
    }
}

Input :
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
Output :
24
40
15
