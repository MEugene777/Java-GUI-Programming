
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JTree Demo");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root =
                new DefaultMutableTreeNode("University");

        DefaultMutableTreeNode computing =
                new DefaultMutableTreeNode("Computing");

        DefaultMutableTreeNode business =
                new DefaultMutableTreeNode("Business");

        root.add(computing);
        root.add(business);

        computing.add(new DefaultMutableTreeNode("BBIT"));
        computing.add(new DefaultMutableTreeNode("Computer Science"));

        business.add(new DefaultMutableTreeNode("Accounting"));
        business.add(new DefaultMutableTreeNode("Marketing"));

        JTree tree = new JTree(root);

        frame.add(new JScrollPane(tree));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
