package cn.atofinon.cloud.freshman.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/19 23:37
 * @Descrition
 */


public class Morris {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    class Solution {
        public void recoverTree(TreeNode root) {
            TreeNode x = null, y = null, pred = null, predecessor = null;

            while (root != null) {
                if (root.left != null) {
                    // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }

                    // 让 predecessor 的右指针指向 root，继续遍历左子树
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    } else {
                        // 说明左子树已经访问完了，我们需要断开链接
                        if (pred != null && root.val < pred.val) {
                            y = root;
                            if (x == null) {
                                x = pred;
                            }
                        }
                        pred = root;

                        predecessor.right = null;
                        root = root.right;
                    }
                } else {
                    // 如果没有左孩子，则直接访问右孩子
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    root = root.right;
                }
            }
            swap(x, y);
        }

        public void swap(TreeNode x, TreeNode y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }


//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//
//        TreeNode cur = root;
//        TreeNode mostRight = null;
//        while (cur != null) {
//            if (cur.left != null) {
//                // 左子树的最右子树
//                mostRight = cur.left;
//                while (mostRight.right != null && mostRight.right != cur) {
//                    mostRight = mostRight.right;
//                }
//                // 最右子树的右子树为空，则最右子树的右子树指向当前节点，并且当前节点左移
//                if (mostRight.right == null) {
//                    mostRight.right = cur;
//                    cur = cur.left;
//                } else {
//                    // 最右子树的右子树指向当前节点，则最右子树指向null，并且当前节点右移
//                    res.add(cur.val);
//                    mostRight.right = null;
//                    cur = cur.right;
//                }
//            } else {
//                res.add(cur.val);
//                cur = cur.right;
//            }
//        }
//        return res;
//    }

//    Deque<TreeNode> deque =new LinkedList<TreeNode>();

    //     while(root!=null || !deque.isEmpty()){
    //         while(root!=null){
    //             deque.push(root);
    //             root=root.left;
    //         }
    //         root=deque.pop();
    //         res.add(root.val);
    //         root=root.right;
    //     }
    //     return res;
}
