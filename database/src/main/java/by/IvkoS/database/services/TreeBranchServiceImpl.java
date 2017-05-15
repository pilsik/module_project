package by.IvkoS.database.services;

import by.IvkoS.database.models.tree.TreeBranch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.IvkoS.database.dao.catalogs.TreeBranchDao;

import java.util.List;

@Service
public class TreeBranchServiceImpl implements TreeBranchService {

    private static final Logger logger = LoggerFactory.getLogger(TreeBranchServiceImpl.class);

    @Autowired
    private TreeBranchDao treeBranchDao;

    @Override
    public TreeBranch addTreeBranch(TreeBranch treeBranch) {
        return this.treeBranchDao.create(treeBranch);
    }

    @Override
    public TreeBranch getTreeBranchById(int id) {
        return this.treeBranchDao.readById(id);
    }

    @Override
    public TreeBranch removeTreeBranch(TreeBranch treeBranch) {
        return this.treeBranchDao.delete(treeBranch);
    }

    @Override
    public TreeBranch updateTreeBranch(TreeBranch treeBranch) {
        return this.treeBranchDao.update(treeBranch);
    }

    @Override
    public List<TreeBranch> getTreeBranchList() {
        return this.treeBranchDao.readList();
    }

    @Override
    public TreeBranch removeTreeBranchById(int id) {
        return this.treeBranchDao.deleteById(id);
    }

    @Override
    public void addTreeBranchList(List<TreeBranch> list) {
        this.treeBranchDao.importCatalogToDB(list);
    }

    @Override
    public List getListSatisfyString(String part) {
        return this.treeBranchDao.getListSatisfyString(part);
    }
}
