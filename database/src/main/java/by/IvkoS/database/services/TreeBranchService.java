package by.IvkoS.database.services;

import by.IvkoS.database.models.tree.TreeBranch;

import java.util.List;

public interface TreeBranchService {

    TreeBranch addTreeBranch(TreeBranch treeBranch);

    TreeBranch getTreeBranchById(int id);

    TreeBranch removeTreeBranch(TreeBranch treeBranch);

    TreeBranch updateTreeBranch(TreeBranch treeBranch);

    List<TreeBranch> getTreeBranchList();

    TreeBranch removeTreeBranchById(int id);

    void addTreeBranchList (List<TreeBranch> list);

    List getListSatisfyString(String part);
}
