package by.IvkoS.database.services;

import by.IvkoS.database.models.tree.TreeBranch;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-db.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class TreeBranchServiceImplTest {

    @Autowired
    TreeBranchService treeBranchService;

    int countRecords;

    @Before
    public void beforeClass() {
        countRecords = treeBranchService.getTreeBranchList().size();
    }

    @Test
    public void addTreeBranch() throws Exception {
        TreeBranch treeBranch = new TreeBranch(100, "test", 2);
        treeBranchService.addTreeBranch(treeBranch);
        assertEquals(treeBranchService.getTreeBranchList().size(), countRecords + 1);
    }

    @Test
    public void getTreeBranchById() throws Exception {
        TreeBranch treeBranch = new TreeBranch(100, "test", 2);
        treeBranchService.addTreeBranch(treeBranch);
        TreeBranch treeBranch100 = treeBranchService.getTreeBranchById(100);
        assertEquals(treeBranch100.getParentId(), treeBranch.getParentId());
        assertEquals(treeBranchService.getTreeBranchList().size(), countRecords + 1);
    }

    @Test
    public void removeTreeBranch() throws Exception {
        TreeBranch treeBranch = new TreeBranch(100, "test", 2);
        treeBranchService.addTreeBranch(treeBranch);
        treeBranchService.removeTreeBranch(treeBranch);
        assertEquals(treeBranchService.getTreeBranchList().size(), countRecords);
    }

    @Test
    public void updateTreeBranch() throws Exception {
        TreeBranch treeBranch = new TreeBranch(100, "test", 2);
        treeBranchService.addTreeBranch(treeBranch);
        TreeBranch treeBranch100 = treeBranchService.getTreeBranchById(treeBranch.getId());
        treeBranch100.setText("test2");
        treeBranchService.updateTreeBranch(treeBranch100);
        assertEquals(treeBranchService.getTreeBranchList().size(), countRecords + 1);
        assertTrue(treeBranchService.getTreeBranchById(100).getText().equals("test2"));
    }

    @Test
    public void getTreeBranchList() throws Exception {
        TreeBranch treeBranch = new TreeBranch(100, "test", 2);
        treeBranchService.addTreeBranch(treeBranch);
        TreeBranch treeBranch2 = new TreeBranch(2, "test2", 100);
        treeBranchService.addTreeBranch(treeBranch2);
        assertEquals(treeBranchService.getTreeBranchList().size(), countRecords + 2);
    }

    @Test
    public void removeTreeBranchById() throws Exception {
        TreeBranch treeBranch = new TreeBranch(100, "test", 2);
        treeBranchService.addTreeBranch(treeBranch);
        treeBranchService.removeTreeBranchById(treeBranch.getId());
        assertEquals(treeBranchService.getTreeBranchList().size(), countRecords);
    }

    @Test
    public void addTreeBranchList() throws Exception {
        TreeBranch treeBranch = new TreeBranch(100, "test", 2);
        TreeBranch treeBranch2 = new TreeBranch(2, "tes2", 100);
        List<TreeBranch> treeBranches = new ArrayList<>();
        treeBranches.add(treeBranch);
        treeBranches.add(treeBranch2);
        treeBranchService.addTreeBranchList(treeBranches);
        assertEquals(treeBranchService.getTreeBranchList().size(), countRecords + 2);
    }

}