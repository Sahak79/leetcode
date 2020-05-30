package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class ValidateBinarySearchTree {

     private static AtomicBoolean isContinue = new AtomicBoolean(true);

     public static boolean isValidBST(TreeNode root) {
          if(root != null) {
               isValidNode(root.left, null, root.val, isContinue);
               isValidNode(root.right, root.val, null, isContinue);
          }
          return isContinue.get();
     }

     private static void isValidNode(TreeNode root, Integer greaterThen, Integer lessThen, AtomicBoolean isContinue) {
          if (root == null || !isContinue.get()) {
               return;
          }
          if (greaterThen != null && root.val <= greaterThen || lessThen != null && root.val >= lessThen) {
               isContinue.set(false);
               return;
          }

          if (root.left != null) {
               isValidNode(root.left, greaterThen, root.val, isContinue);
          }
          if (root.right != null) {
               isValidNode(root.right, root.val, lessThen, isContinue);
          }
     }

     public static void main(String[] args) {
          /*TreeNode treeNodeRoot3 = new TreeNode(3);
          TreeNode treeNodeL1 = new TreeNode(1);
          TreeNode treeNodeR5 = new TreeNode(5);
          treeNodeRoot3.left = treeNodeL1;
          treeNodeRoot3.right = treeNodeR5;

          TreeNode treeNodeL4 = new TreeNode(4);
          TreeNode treeNodeR6 = new TreeNode(6);
          treeNodeR5.left = treeNodeL4;
          treeNodeR5.right = treeNodeR6;

          TreeNode treeNodeL0 = new TreeNode(0);
          TreeNode treeNodeR2 = new TreeNode(2);
          treeNodeL1.left = treeNodeL0;
          treeNodeL1.right = treeNodeR2;

          TreeNode treeNodeR3 = new TreeNode(3);

          treeNodeR2.right = treeNodeR3;


          System.out.println(isValidBST(treeNodeRoot3));*/



          solition();


     }

     
     public static void solition() {

     }

}

