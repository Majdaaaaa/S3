import java.util.Stack;

class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class ReversePolishNotation {

    public static Node buildExpressionTree(String[] tokens) {
        Stack<Node> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                Node operatorNode = new Node(token);
                Node operand2 = stack.pop();
                Node operand1 = stack.pop();
                operatorNode.left = operand1;
                operatorNode.right = operand2;
                stack.push(operatorNode);
            } else {
                stack.push(new Node(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Fonction utilitaire pour afficher l'arbre en notation infixée
    public static void printInfixExpression(Node root) {
        if (root != null) {
            if (isOperator(root.value)) {
                System.out.print("(");
            }

            printInfixExpression(root.left);
            System.out.print(root.value);
            printInfixExpression(root.right);

            if (isOperator(root.value)) {
                System.out.print(")");
            }
        }
    }
    static void printTree(Node node, int level) {
        if (node != null) {
            printTree(node.right, level + 1);
            for (int i = 0; i < level; i++)
                System.out.print("\t");
            System.out.println(node.value);
            printTree(node.left, level + 1);
        }
    }

    public static void main(String[] args) {
        String[] ar= {"2","6","*","5","1","-","+" };

        Node root = buildExpressionTree(ar);

        System.out.print("Infix Expression: ");
        printInfixExpression(root);
        System.out.println();
        System.out.println("Tree:");
        printTree(root, 3);
    }
}
