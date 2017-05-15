package by.IvkoS.database.models.tree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import by.IvkoS.database.services.TreeBranchService;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализующий "создание" дерева для denytree
 */
@Component
public class TreeCreator {

    /**
     * Хранит все ветви дерева
     */
    private List<TreeBranch> allBranches;

    @Autowired
    private TreeBranchService treeBranchService;

    /**
     * Метод возвращает строку для постройки denytree
     *
     * @return строку для denytree
     */
    public String createTree() {
        allBranches = new ArrayList<>();
        boolean firstRootBranch = true;
        allBranches = treeBranchService.getTreeBranchList();
        StringBuffer sb = new StringBuffer();
        sb.delete(0, sb.length());
        sb.append("children: [\n");
        for (int i = 0; i < allBranches.size(); i++) {
            if (allBranches.get(i).getParentId() == 0) {
                if (firstRootBranch == false) sb.append(",\n");
                sb.append("{title: \"" + allBranches.get(i).getText() + "\" , key: \""+ allBranches.get(i).getId()+"\"");
                checkChildrenBranches(sb, allBranches.get(i));
                firstRootBranch = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Метод для проверки дочерних ветвей
     *
     * @param sb     строка в которую записывается само дерево
     * @param branch
     */
    private void checkChildrenBranches(StringBuffer sb, TreeBranch branch) {
        boolean isFolder = false;
        boolean firstBranch = true;
        for (int i = 0; i < allBranches.size(); i++) {
            if (allBranches.get(i).getParentId() == branch.getId()) {
                if (isFolder == false) {
                    sb.append(", isFolder: true,\n");
                    sb.append("children: [\n");
                    isFolder = true;
                }
                if (firstBranch == false) sb.append(",");
                sb.append("{title: \"" + allBranches.get(i).getText() + "\" , key: \""+ allBranches.get(i).getId()+"\"");
                checkChildrenBranches(sb, allBranches.get(i));
                firstBranch = false;
            }
        }
        if (isFolder == true)
            sb.append("]");
        sb.append("}");
    }

}
